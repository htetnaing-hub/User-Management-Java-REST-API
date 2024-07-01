package net.hna.user_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import net.hna.user_management_system.entity.Post;
import net.hna.user_management_system.repository.PostRepository;
import net.hna.user_management_system.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
}
