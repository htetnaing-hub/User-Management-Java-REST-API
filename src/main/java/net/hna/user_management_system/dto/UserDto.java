package net.hna.user_management_system.dto;

import lombok.*;
import net.hna.user_management_system.entity.Post;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Post> postList;
}
