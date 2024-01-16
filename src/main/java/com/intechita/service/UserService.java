package com.intechita.service;

import com.intechita.entity.User;

public interface UserService{

	User saveUser(User user);
	User getUser(long id);

}
