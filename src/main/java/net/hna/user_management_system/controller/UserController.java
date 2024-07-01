package net.hna.user_management_system.controller;

import lombok.AllArgsConstructor;
import net.hna.user_management_system.dto.UserDto;
import net.hna.user_management_system.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    //Build Add User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto saveUser = userService.createUser(userDto);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    //Build Add User List REST API
    @PostMapping("/list")
    public ResponseEntity<List<UserDto>> createUserList(@RequestBody List<UserDto> userDtoList){
        List<UserDto> createdUserDtoList = userService.createdUserList(userDtoList);
        return ResponseEntity.ok(createdUserDtoList);
    }

    //Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    //Build Get User REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        //return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.FOUND);
        return ResponseEntity.ok(userDto);
    }

    //Build Update User By Id REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable("id") Long userId,
                                                      @RequestBody UserDto userDto) {
        UserDto updateUser = userService.updateUserById(userId, userDto);
        return ResponseEntity.ok(updateUser);
    }

    //Build Delete All User REST API
    @DeleteMapping
    public String deleteAllUser(){
        userService.deleteAllUser();
        return "All User Are Successfully Deleted!";
    }

    //Build Delete User By Id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userService.deleteUserById(userId));
    }
}
