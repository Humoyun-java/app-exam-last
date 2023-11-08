package uz.najottalim.appexam.entity;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum Role {
    ADMIN(Set.of(Permission.values())),
    TEACHER(Set.of(Permission.CREATE_STUDENT, Permission.READ_STUDENT, Permission.UPDATE_TEACHER)),
    STUDENT(Set.of(Permission.READ_STUDENT,
            Permission.UPDATE_STUDENT));


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
