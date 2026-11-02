package in.balu.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleBasedAuthority {

//    USER, ADMIN

    ROLE_USER("USER"),

    ROLE_ADMIN("ADMIN");

    private final String role;

//    private RoleBasedAuthority(String role) {
//        this.role = role;
//    }
//
//    public String getRole() {
//        return role;
//    }

}