package in.balu.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String contact;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private CredentialDto credentialDto;

}