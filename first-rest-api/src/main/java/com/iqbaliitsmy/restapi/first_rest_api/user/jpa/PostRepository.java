package com.iqbaliitsmy.restapi.first_rest_api.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqbaliitsmy.restapi.first_rest_api.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
