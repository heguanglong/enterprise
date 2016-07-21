package com.qiye.dao;

import java.util.List;

import com.qiye.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	public User getByName(String name);
	public List<String> listAllEmail();
}
