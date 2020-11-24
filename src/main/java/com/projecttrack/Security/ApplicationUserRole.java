package com.projecttrack.Security;

//import com.google.common.collect.Sets;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.projecttrack.Security.ApplicationUserPermission.APPLICATION_READ;
import static com.projecttrack.Security.ApplicationUserPermission.ACTIVITYLOG_READ;
import static com.projecttrack.Security.ApplicationUserPermission.USER_READ;
import static com.projecttrack.Security.ApplicationUserPermission.USER_WRITE;


public enum ApplicationUserRole {

    ROLE_ADMIN(Sets.newHashSet(USER_READ,USER_WRITE,ACTIVITYLOG_READ,APPLICATION_READ)),
    ROLE_OIC(Sets.newHashSet(APPLICATION_READ)),
    ROLE_SE(Sets.newHashSet(APPLICATION_READ)),
    ROLE_AC(Sets.newHashSet(APPLICATION_READ)),
    ROLE_DC(Sets.newHashSet(APPLICATION_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority( this.name()));//"ROLE_" +
        return permissions;
    }
}
