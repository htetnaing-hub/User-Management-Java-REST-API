package net.hna.user_management_system.controller;

import lombok.RequiredArgsConstructor;
import net.hna.user_management_system.dto.UserDto;
import net.hna.user_management_system.entity.User;
import net.hna.user_management_system.service.PostService;
import net.hna.user_management_system.service.UserService;
import net.hna.user_management_system.entity.Post;
import net.hna.user_management_system.exception.ResourceNotFoundException;
import net.hna.user_management_system.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    //Create a post by a employee
    @PostMapping("/{employeeId}/post")
    public ResponseEntity<Post> createPost(@PathVariable("employeeId") Long employeeId, @RequestBody Post post){
        UserDto userDto = userService.getUserById(employeeId);
        User user = UserMapper.mapToUser(userDto);
        if (user == null) {
            throw new ResourceNotFoundException("Employee does not exist with the given ID:{" + employeeId + "}.");
        }
        post.setUser(user);
        Post savePost = postService.createPost(post);
        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }

    @GetMapping("/all-post")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> postList = postService.getAllPost();
        return ResponseEntity.ok(postList);
    }

}
