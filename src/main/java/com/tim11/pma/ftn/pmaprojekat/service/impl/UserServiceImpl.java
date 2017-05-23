package com.tim11.pma.ftn.pmaprojekat.service.impl;

import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.repository.UserRepository;
import com.tim11.pma.ftn.pmaprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		if (userRepository.exists(user.getId())) {
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	@Override
	public void remove(User user) {
        if (userRepository.exists(user.getId())) {
            userRepository.delete(user);
        }
	}

	@Override
	public User findUserByFbProfileId(String fbProfileId) {
		return userRepository.findByfbUser_fbProfileId(fbProfileId);
	}
}
