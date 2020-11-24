package com.projecttrack.Security;

public enum ApplicationUserPermission {
/*    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write"),*/
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    APPLICATION_READ("application:read"),
    ACTIVITYLOG_READ("activitylog:read");


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
