package in.balu.service;

import in.balu.dto.UserDto;
import in.balu.helper.UserMapper;
import in.balu.models.Credential;
import in.balu.models.User;
import in.balu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {

        User user = userMapper.toUserEntity(userDto);

        Credential credential = user.getCredential();

        // ToDO: we are providing original password in DB but we need to store in encoded password.


        // BiDirectional
        credential.setUser(user);

        User dbUser = userRepository.save(user);

        return userMapper.toUserDto(dbUser);

    }

    @Override
    public UserDto findById(Integer userId) {

        return userRepository.findById(userId)
                .map(userMapper :: toUserDto)
//                .map(user -> userMapper.toUserDto(user))
                .orElseThrow(() -> new RuntimeException("User not found in DB"));
    }

    @Override
    public UserDto update(Integer userId, UserDto user) {
        return null;
    }
}