package net.hna.user_management_system.service.impl;

import lombok.AllArgsConstructor;
import net.hna.user_management_system.dto.UserDto;
import net.hna.user_management_system.service.UserService;
import net.hna.user_management_system.entity.User;
import net.hna.user_management_system.exception.ResourceNotFoundException;
import net.hna.user_management_system.mapper.UserMapper;
import net.hna.user_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User saveUser = userRepository.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public List<UserDto> createdUserList(List<UserDto> userDtoList) {
        List<User> userList = userDtoList.stream().map(UserMapper::mapToUser).collect(Collectors.toList());
        List<User> createdUserList = userRepository.saveAll(userList);
        return createdUserList.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with the given :" + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUserById(Long userId, UserDto userDto) {

        User user = userRepository.findById(userId)
                .orElseThrow(()->
                        new ResourceNotFoundException("User is not exists with the given :" + userId));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public String deleteUserById(Long userId) {
        userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User is not exists with the given :" + userId));
        userRepository.deleteById(userId);
        return "Successfully Deleted!";
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }

}
