package projects.healthcentre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpInputDto {
    @Length(min = 2)
    private String firstName;

    @Length(min = 3)
    private String lastNam;

    @Email
    private String email;

    @Length(min = 10)
    private String password;

    @Length(min = 10)
    private String confirmPassword;

}
