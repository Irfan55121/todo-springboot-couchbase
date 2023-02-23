package com.todo.springboot.todospringbootcouchbase.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class User {
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    @Field(value = "id")
    @Id
    private String id;
    @Field(value = "email")
    private String email;
    @Field(value = "update_time")
    private long updatedTime;
    @Field(value = "created_time")
    private long createdTime;

    @Field(value = "password")
    private String password;

    @Field(value = "status")
    private int status = UserStatus.ACTIVE;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", updatedTime=" + updatedTime +
                ", createdTime=" + createdTime +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
