package com.tim11.pma.ftn.pmaprojekat.controller;

import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user){
		User newUser = userService.save(user);
		return newUser;
	}

	@RequestMapping(path = "/fbProfileId/{fbProfileId}", method = RequestMethod.GET)
	public User getUserByProfileId(@PathVariable String fbProfileId) {
		return userService.findUserByFbProfileId(fbProfileId);
	}
}
