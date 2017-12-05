package com.krishna.spring.security.config;

import com.krishna.spring.security.dao.IUserInfoDAO;
import com.krishna.spring.security.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserInfoDAO iUserInfoDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final UserInfo activeUser = iUserInfoDAO.getActiveUser(s);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(activeUser.getRole());
        UserDetails userDetails = new User(activeUser.getUserName(), activeUser.getPassword(), Collections.singletonList(grantedAuthority));
        return userDetails;
    }
}
