package br.isaaclyra.workshopmongo.resources;

import br.isaaclyra.workshopmongo.domain.Post;
import br.isaaclyra.workshopmongo.domain.User;
import br.isaaclyra.workshopmongo.dto.UserDTO;
import br.isaaclyra.workshopmongo.services.PostService;
import br.isaaclyra.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private PostService postService;

    @Autowired
    PostResource(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findByID(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
