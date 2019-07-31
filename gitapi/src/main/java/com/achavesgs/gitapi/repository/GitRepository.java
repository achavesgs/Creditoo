package com.achavesgs.gitapi.repository;

import java.util.List;

import com.achavesgs.gitapi.entities.Repository;
import com.achavesgs.gitapi.entities.User;

public interface GitRepository {

	public User getUserProfile(String username);
	public List<Repository> getAllRepositories(String username);
}
