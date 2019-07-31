package com.achavesgs.gitapi.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.achavesgs.gitapi.entities.Repository;
import com.achavesgs.gitapi.entities.User;
import com.achavesgs.gitapi.repository.GitRepository;

@Component
public class GitRepositoryImpl implements GitRepository {
	
	RestTemplate rt = new RestTemplate();
	
	public User getUserProfile(String username) {
		
		User user = rt.getForObject("https://api.github.com/users/"+username, User.class);
		
        return user;
    }
	
	public List<Repository> getAllRepositories(String username) {
		 ResponseEntity<List<Repository>> response = 
	                rt.exchange(
	                "https://api.github.com/users/"+username+"/repos",            
	                HttpMethod.GET,
	                null,
	                new ParameterizedTypeReference<List<Repository>>(){ }
	                );
		List<Repository> repositories = response.getBody();
       return repositories;
   }

}
