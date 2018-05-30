package com.domlab.node.integration.service;


import com.domlab.node.dto.user.ApplicationUser;
import com.domlab.node.integration.database.DB;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        ApplicationUser usr = DB.pop(user);
        if (usr == null) {
            throw new UsernameNotFoundException(user);
        }
        return new User(usr.getUserId(), usr.getPassword(), Collections.emptyList());

    }


}
