package com.elmar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.elmar.controller.UserDAO;
import com.elmar.db.Role;
import com.elmar.db.User;

public class UserService implements UserDetailsService {
	
	UserDAO dao = new UserDAO();
	 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query userQ = null;
        User user = null;
        try {
        	user = dao.findUser(username);
            if (userQ == null) {
                throw new UsernameNotFoundException("user not found");
            }
        } catch (Exception e) {
            throw new EntityNotFoundException(e.getCause().getMessage());
        }
        String uname = user.getUserName();
        String password = user.getPassword();
        boolean enabled = user.getEnabled();
        boolean accountNonExpired = Boolean.TRUE;
        boolean credentialsNonExpired = Boolean.TRUE;
        boolean accountNonLocked = Boolean.TRUE;
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Iterator it = user.getRole().iterator(); it.hasNext();) {
            Role role = (Role) it.next();
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(
                uname, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
