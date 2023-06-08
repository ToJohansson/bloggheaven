package tobiasjohansson.bloggheaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobiasjohansson.bloggheaven.model.Post;
import tobiasjohansson.bloggheaven.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(long id) {
        Optional<Post> opPost = postRepository.findById(id);
        if (opPost.isPresent()) {
            return opPost.get();
        } else
            return null;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(long id, Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post updatePost = optionalPost.get();
            updatePost.setTitle(post.getTitle());
            updatePost.setBody(post.getBody());

            return postRepository.save(updatePost);
        } else
            return null;
    }
}
