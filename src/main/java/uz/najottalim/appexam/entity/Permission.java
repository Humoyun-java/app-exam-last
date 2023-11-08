package uz.najottalim.appexam.entity;

import lombok.Getter;

@Getter
public enum Permission {
    CREATE_STUDENT("CREATE_STUDENT"),
    READ_STUDENT("READ_STUDENT"),
    UPDATE_STUDENT("UPDATE_STUDENT"),
    DELETE_STUDENT("DELETE_STUDENT"),

    CREATE_TEACHER("CREATE_TEACHER"),
    READ_TEACHER("READ_TEACHER"),
    UPDATE_TEACHER("UPDATE_TEACHER"),
    DELETE_TEACHER("DELETE_TEACHER");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

}
