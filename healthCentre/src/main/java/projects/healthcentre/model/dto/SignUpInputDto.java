package projects.healthcentre.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class SignUpInputDto {
    private String firstName;
    private String lastNam;
    private String email;
    private String password;
    private String confirmPassword;

    public SignUpInputDto() {
    }

    @Length(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Length(min = 3)
    public String getLastNam() {
        return lastNam;
    }


    public void setLastNam(String lastNam) {
        this.lastNam = lastNam;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min = 10)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
