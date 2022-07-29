package com.levifreire.springbootmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.levifreire.springbootmongodb.domain.Post;
import com.levifreire.springbootmongodb.repository.PostRepository;
import com.levifreire.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	final PostRepository repo;

	public PostService(PostRepository postRepository) {
		repo = postRepository;
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

}
