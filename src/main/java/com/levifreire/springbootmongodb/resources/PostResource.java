package com.levifreire.springbootmongodb.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levifreire.springbootmongodb.domain.Post;
import com.levifreire.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	final PostService service;

	public PostResource(PostService postService) {
		service = postService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
