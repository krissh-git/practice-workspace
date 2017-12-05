package com.krishna.spring.security.dao;

import com.krishna.spring.security.entity.UserInfo;

public interface IUserInfoDAO {

    UserInfo getActiveUser(String userName);
}
