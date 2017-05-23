package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.model.User;


/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
public interface UserService {

	/**
	 *
	 * @param user
	 *          User to save
	 * @return
	 *          New user
	 */
	User save(User user);

	/**
	 * Updates a user. If user does not exist returns null and does not save user.
	 *
	 * @param user
	 *          User to update
	 * @return
	 *          New user or null if user doesn't exist
	 */
	User update(User user);

	void remove(User user);

	User findUserByFbProfileId(String fbProfileId);
}
