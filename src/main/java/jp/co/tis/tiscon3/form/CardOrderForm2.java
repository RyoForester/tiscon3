package jp.co.tis.tiscon3.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CardOrderForm2 extends FormBase {

    private static final long serialVersionUID = 1L;



    //jobページの項目

    @NotBlank
    @Size(max = 255)
    public String employerName;

    @NotBlank
    @Size(max = 8)
    @Pattern(regexp = "^([0-9]{3}-[0-9]{4})?$")
    private String employerZipCode;
    @NotBlank
    @Size(max = 255)
    private String employerAddress;

    @NotBlank
    @Size(max = 13)
    @Pattern(regexp = "^(0[0-9]{1,3}-[0-9]{2,4}-[0-9]{4})?$")
    private String employerPhoneNumber;
    @NotBlank
    @Size(max = 255)
    private String industryType;
    @NotBlank
    @Size(max = 6)
    @Pattern(regexp = "[0-9]*")
    private String capital;
    @NotBlank
    @Size(max = 255)
    @Pattern(regexp = "[0-9]*")
    private String companySize;

    @NotBlank
    @Size(max = 255)
    private String position;

    @NotBlank
    @Size(max = 255)
    private String department;
    @NotBlank
    @Size(max = 6)
    @Pattern(regexp = "[0-9]*")
    private String employeeLength;

}
