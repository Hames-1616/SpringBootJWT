package Reservation.Backend.services;

import Reservation.Backend.model.user;
import Reservation.Backend.repos.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userDetail implements UserDetailsService {

    @Autowired
    userrepo usr;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final user f = usr.findByName(username).orElseThrow();
        return User.builder()
                .username(f.getUserName())
                .password(f.getPassword())
                .roles(f.getRole())
                .build()
                ;
    }
}
