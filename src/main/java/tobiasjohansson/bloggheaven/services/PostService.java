package tobiasjohansson.bloggheaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobiasjohansson.bloggheaven.exceptions.ResourceNotFoundException;
import tobiasjohansson.bloggheaven.model.Post;
import tobiasjohansson.bloggheaven.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(long id)throws ResourceNotFoundException {
      Post post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "ID", id));
      return post;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(long id) throws ResourceNotFoundException{
        postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("post", "ID", id));
        postRepository.deleteById(id);
    }

    public Post updatePost(long id, Post post)throws ResourceNotFoundException {
        Post updatePost = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "ID", id));

        updatePost.setTitle(post.getTitle());
        updatePost.setBody(post.getBody());

        return postRepository.save(updatePost);
    }
}