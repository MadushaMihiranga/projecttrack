package com.projecttrack.Authentication;

import com.projecttrack.User.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class ApplicationUser implements UserDetails {

    private User user;

    public ApplicationUser(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return user.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getName().toString())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getNonexpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getNonlocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsnonexpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
