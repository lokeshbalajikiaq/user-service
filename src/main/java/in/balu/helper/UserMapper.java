package in.balu.helper;

import in.balu.dto.UserDto;
import in.balu.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "email", target = "emailAddress")
    @Mapping(source = "phone", target = "contact")
    @Mapping(source = "credential", target = "credentialDto")
    UserDto toUserDto(User user);

    @Mapping(source = "emailAddress", target = "email")
    @Mapping(source = "contact", target = "phone")
    @Mapping(source = "credentialDto", target = "credential")
    User toUserEntity(UserDto userDto);

}
