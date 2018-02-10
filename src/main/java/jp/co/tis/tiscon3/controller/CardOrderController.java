package jp.co.tis.tiscon3.controller;

import enkan.component.BeansConverter;
import enkan.component.doma2.DomaProvider;
import enkan.data.HttpResponse;
import jp.co.tis.tiscon3.dao.CardOrderDao;
import jp.co.tis.tiscon3.entity.CardOrder;
import jp.co.tis.tiscon3.form.CardOrderForm;
import kotowari.component.TemplateEngine;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;

import static enkan.util.HttpResponseUtils.RedirectStatusCode.SEE_OTHER;
import static kotowari.routing.UrlRewriter.redirect;

/**
 * カード申し込みに関するcontrollerクラス.
 *
 * @author hirano
 */
public class CardOrderController {

    @Inject
    private TemplateEngine templateEngine;

    @Inject
    private DomaProvider daoProvider;

    @Inject
    private BeansConverter beans;

    private CardOrderDao cardOrderDao;

    @PostConstruct
    public void init() {
        cardOrderDao = daoProvider.getDao(CardOrderDao.class);
    }

    /**
     * 本人登録ページを表示します.
     *
     * @return 本人登録ページresponse
     */
    public HttpResponse inputUser() {
        return templateEngine.render("cardOrder/user", "form", new CardOrderForm());
    }

    /**
     * お勤め先登録ページを表示します.
     *
     * @return お勤め先登録ページresponse
     */
    public HttpResponse inputJob(CardOrderForm form) {
        
        if (form.hasErrors()) {
            if(form.homePhoneNumber.equals("")&&form.mobilePhoneNumber.equals("")){
                String phone_error = "error";
                return templateEngine.render("cardOrder/user", "form", form,"phone_error",phone_error);
            }
            return templateEngine.render("cardOrder/user", "form", form);
        }
        // エラーを出したくないので強制的にエラーを消す.
        form.setErrors(null);
        System.out.println(form.homePhoneNumber);
        if(form.homePhoneNumber.equals("")&&form.mobilePhoneNumber.equals("")){
            String phone_error = "error";
            return templateEngine.render("cardOrder/user", "form", form,"phone_error",phone_error);
        }
        if (form.job.equals("他無職")||form.job.equals("学生"))
        { CardOrder cardOrder = beans.createFrom(form, CardOrder.class);

            cardOrderDao.insert(cardOrder);

            return redirect(getClass(), "completed", SEE_OTHER);


        }
        else
            {
            return templateEngine.render("cardOrder/job", "form", form);
        }

    }

    /**
     * 本人登録ページに戻ります.
     *
     * @return 本人登録ページresponse
     */
    public HttpResponse modifyUser(CardOrderForm form) {
        // エラーを出したくないので強制的にエラーを消す.
        form.setErrors(null);

        return templateEngine.render("cardOrder/user", "form", form);
    }

    /**
     * カード申し込み情報をDatabaseに登録します.
     *
     * @return 完了ページへのリダイレクトresponse
     */
    @Transactional
    public HttpResponse create(CardOrderForm form) {
        if (form.hasErrors()) {
            return templateEngine.render("cardOrder/user", "form", form);
        }
        if(form.homePhoneNumber.equals("")){
            String xx_error = "error";
            return templateEngine.render("cardOrder/user", "form", form ,"xx_error",xx_error);
        }
        CardOrder cardOrder = beans.createFrom(form, CardOrder.class);

        cardOrderDao.insert(cardOrder);

        return redirect(getClass(), "completed", SEE_OTHER);
    }

    /**
     * 完了ページを表示します.
     *
     * @return 完了ページresponse
     */
    public HttpResponse completed() {
        return templateEngine.render("cardOrder/completed");
    }

}
