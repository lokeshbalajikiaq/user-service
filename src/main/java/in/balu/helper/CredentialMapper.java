package in.balu.helper;

import in.balu.dto.CredentialDto;
import in.balu.dto.UserDto;
import in.balu.models.Credential;
import in.balu.models.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CredentialMapper {

    CredentialDto toCredentialDto(Credential credential);

    @Mapping(target = "user", ignore = true)
    Credential toCredentialEntity(CredentialDto credentialDto);

    // 3. BIDIRECTIONAL LINK FIXER
    /**
     * MapStruct instantiates child entities but does not automatically link them back
     * to the parent object. This lifecycle hook ensures the DB foreign key side points back perfectly.
     */
    @AfterMapping
    default void establishBidirectionalLinks(UserDto userDto, @MappingTarget User user) {
        if (user != null && user.getCredential() != null) {
            user.getCredential().setUser(user);
        }
    }

}
