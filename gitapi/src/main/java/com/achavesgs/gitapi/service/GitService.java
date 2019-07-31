package com.achavesgs.gitapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achavesgs.gitapi.entities.Repository;
import com.achavesgs.gitapi.entities.User;
import com.achavesgs.gitapi.repository.GitRepository;

@Service
public class GitService {
	
	@Autowired
	private GitRepository repository;
	
	public User getUserProfile(String username) {
        return repository.getUserProfile(username);//client.getUserProfile(username);
    }
	
	public List<Repository> getAllRepositories(String username) {
		return repository.getAllRepositories(username);
	}

}
