package net.hna.user_management_system.mapper;

import net.hna.user_management_system.dto.PostDto;
import net.hna.user_management_system.entity.Post;

public class PostMapper {

    public static PostDto mapToPostDto(Post post){
        return new PostDto(
                post.getId(),
                post.getDescription(),
                post.getStatus(),
                post.getUser()
        );
    }

    public static Post mapToPost(PostDto postDto){
        return new Post(
                postDto.getId(),
                postDto.getDescription(),
                postDto.getStatus(),
                postDto.getUser()
        );
    }

}
