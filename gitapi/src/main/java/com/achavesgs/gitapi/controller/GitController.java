package com.achavesgs.gitapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.achavesgs.gitapi.entities.Repository;
import com.achavesgs.gitapi.entities.User;
import com.achavesgs.gitapi.service.GitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/users")
@Api(value = "Github API")
public class GitController {
	@Autowired
	private GitService service;
	
	@ApiOperation(value = "Find user profile detail")
	@GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserProfile(@PathVariable String username) {
		User user = service.getUserProfile(username);
		

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		 
		return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	@ApiOperation(value = "List user repositories")
	@RequestMapping(value = "/{username}/repos", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRepositories(@RequestParam(value="username") String username) {
		List<Repository> repositories = service.getAllRepositories(username);
		
		if (repositories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		 
		return new ResponseEntity<List<Repository>>(repositories, HttpStatus.OK);
    }

}
