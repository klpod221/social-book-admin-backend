package com.socialbook.admin.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "email")
    @Email
    private String email;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "created_at")
    private String createdAt;

    @NotBlank
    @Column(name = "is_active")
    private Integer isActive;

    public UserModel() {
    }

    public UserModel(Long id, String firstName, String lastName, String email, String username, String password,
            String avatarUrl, String createdAt, Integer isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // public String getPassword() {
    // return this.password;
    // }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public UserModel id(Long id) {
        setId(id);
        return this;
    }

    public UserModel firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserModel lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserModel email(String email) {
        setEmail(email);
        return this;
    }

    public UserModel username(String username) {
        setUsername(username);
        return this;
    }

    public UserModel password(String password) {
        setPassword(password);
        return this;
    }

    public UserModel avatarUrl(String avatarUrl) {
        setAvatarUrl(avatarUrl);
        return this;
    }

    public UserModel createdAt(String createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public UserModel isActive(Integer isActive) {
        setIsActive(isActive);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", email='" + getEmail() + "'" +
                ", username='" + getUsername() + "'" +
                ", avatarUrl='" + getAvatarUrl() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", isActive='" + getIsActive() + "'" +
                "}";
    }

}
