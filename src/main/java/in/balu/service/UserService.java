package in.balu.service;

import in.balu.dto.UserDto;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Integer userId);

    UserDto update(Integer userId, UserDto user);

}
