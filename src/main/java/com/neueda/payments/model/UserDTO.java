package com.neueda.payments.model;

public class UserDTO {

    private Long id;
    private String name;
    private UserRole role;
    
    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
    }
    
    public User asUser() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setRole(this.role);
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole userRole) {
        this.role = userRole;
    }
}
