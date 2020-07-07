package com.inventorymanagement.auth;

import com.inventorymanagement.model.UsersMaster;
import com.inventorymanagement.repository.UserRepository;
import com.inventorymanagement.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersMaster usersMaster = userRepo.findByEmail(username);

        if (usersMaster == null) {
            throw new UsernameNotFoundException("User 404");
        }

        Set<? extends GrantedAuthority> grantedAuthorities;

        if (usersMaster.getUserType() == 1) {
            grantedAuthorities = ApplicationUserRole.ADMIN.getGrantedAuthorities();
        } else {
            grantedAuthorities = ApplicationUserRole.USER.getGrantedAuthorities();
        }

        return new UserPrincipal(usersMaster, grantedAuthorities);
    }

}
