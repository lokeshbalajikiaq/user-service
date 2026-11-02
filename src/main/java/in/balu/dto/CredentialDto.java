package in.balu.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.balu.models.RoleBasedAuthority;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialDto {

    private Integer credentialId;

    private String username;

    private String password;

    private RoleBasedAuthority roleBasedAuthority;

//    @JsonProperty(user)
//    private UserDto userDto;

}