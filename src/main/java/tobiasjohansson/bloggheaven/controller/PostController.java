package tobiasjohansson.bloggheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tobiasjohansson.bloggheaven.model.Post;
import tobiasjohansson.bloggheaven.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("posts/{id}")
    public Post getPostById(@PathVariable("id")long id){
        return postService.getPostById(id);
    }
    @PostMapping("/newpost")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
    @PutMapping("/updatepost/{id}")
    public Post updatePost(@PathVariable("id")long id, @RequestBody Post post){
        return postService.updatePost(id,post);
    }

    @DeleteMapping("/deletepost/{id}")
    public void deletePost(@PathVariable("id")long id){
        postService.deletePost(id);
    }
}
