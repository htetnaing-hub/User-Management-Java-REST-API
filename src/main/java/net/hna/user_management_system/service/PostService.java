package net.hna.user_management_system.service;

import net.hna.user_management_system.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post);
    List<Post> getAllPost();

}
