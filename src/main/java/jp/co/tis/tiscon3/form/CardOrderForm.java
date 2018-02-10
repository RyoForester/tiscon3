package jp.co.tis.tiscon3.form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CardOrderForm extends FormBase {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 60)
    private String kanjiName;

    @NotBlank
    @Size(max = 90)
    @Pattern(regexp = "^[ァ-ヶー 　]*$")
    private String kanaName;

    @NotBlank
    @Size(max = 120)
    @Pattern(regexp = "^[a-zA-Z 　]*$")
    private String alphabetName;

    @NotBlank
    @Size(max = 10)
    @Pattern(regexp = "\\d{4}/\\d{1,2}/\\d{1,2}$")
    private String dateOfBirth;

    @NotBlank
    @Size(max = 6)
    private String gender;

    @NotBlank
    @Size(max = 8)
    @Pattern(regexp = "^[0-9]{3}-[0-9]{4}$")
    private String zipCode;

    @NotBlank
    @Size(max = 255)
    private String address;

    @NotBlank
    @Size(max = 13)
    @Pattern(regexp = "^0[0-9]{1,3}-[0-9]{2,4}-[0-9]{4}$")
    public String homePhoneNumber;

    @NotBlank
    @Size(max = 13)
    @Pattern(regexp = "^((070|080|090)-[0-9]{4}-[0-9]{4})?$")
    public String mobilePhoneNumber;

    @NotBlank
    @Size(max = 255)
    @Email
    private String emailAddress;


    @Size(max = 20)
    private String spouse;


    @Size(max = 20)
    private String houseClassification;


    @Size(max = 6)
    @Pattern(regexp = "[0-9]*")
    private String debt;

    @NotBlank
    @Size(max = 120)
    public String job;

    @NotBlank
    @Size(max = 6)
    @Pattern(regexp = "[0-9]*")
    private String income;
    @NotBlank
    @Size(max = 255)
    private String employerName;
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
