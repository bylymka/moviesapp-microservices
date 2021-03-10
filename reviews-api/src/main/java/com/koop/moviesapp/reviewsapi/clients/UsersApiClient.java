package com.koop.moviesapp.reviewsapi.clients;

import com.koop.moviesapp.reviewsapi.clients.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("users-api/users")
public interface UsersApiClient {
    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable("id") Integer id);
}
