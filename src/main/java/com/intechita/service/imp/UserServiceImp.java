package com.intechita.service.imp;

import org.springframework.stereotype.Service;

import com.intechita.entity.User;
import com.intechita.repository.UserRepository;
import com.intechita.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
	
	UserRepository userRepository;
	
	@Override
    public User saveUser(User user) {
     User user2 = userRepository.save(user);
     return user2;
    }

	@Override
	public User getUser(long id) {
		User getUser = userRepository.findById(id).get();
		return getUser;
	}

    
}
