package com.tim11.pma.ftn.pmaprojekat.repository;

import com.tim11.pma.ftn.pmaprojekat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByfbUser_fbProfileId(String fbProfileId);
}
