package tobiasjohansson.bloggheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobiasjohansson.bloggheaven.model.Post;
import tobiasjohansson.bloggheaven.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    // PERMIT ALL
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    // PERMIT ALL
    @GetMapping("posts/{id}")
    public Post getPostById(@PathVariable("id") long id) {
        return postService.getPostById(id);
    }
    // USER CAN DO THIS
    @PostMapping("/newpost")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.CREATED);
    }
    // USER CAN DO THIS
    @PutMapping("/updatepost/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
        return new ResponseEntity<Post>(postService.updatePost(id, post), HttpStatus.OK);
    }
    // USER CAN DO THIS
    @DeleteMapping("/deletepost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<String>("Post was deleted",HttpStatus.OK);

    }
}