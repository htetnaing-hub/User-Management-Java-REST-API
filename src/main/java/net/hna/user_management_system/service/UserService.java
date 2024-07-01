package net.hna.user_management_system.service;

import net.hna.user_management_system.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> createdUserList(List<UserDto> userDtoList);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUserById(Long userId, UserDto userDto);

    String deleteUserById(Long userId);

    void deleteAllUser();

}
