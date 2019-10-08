package com.uek.service.inter;

import com.uek.domain.User;

public interface IUserService {
	void register(User user);
	User login(String username , String password);
	
}
