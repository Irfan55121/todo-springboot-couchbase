package com.todo.springboot.todospringbootcouchbase.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Todo {

    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    @Id
    @JsonProperty(value = "todo_id")
    private String todo_id;
    @JsonProperty(value = "created_time")
    private long created_time;
    @JsonProperty(value = "updated_time")
    private long updated_time;
    @JsonProperty(value = "todo_title")
    private String todo_title;
    @JsonProperty(value = "user_id")
    private String user_id;


    public String getTodo_id() {
        return this.todo_id;
    }

    public void setTodo_id(String todo_id) {
        this.todo_id = todo_id;
    }

    public long getCreated_time() {
        return this.created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public long getUpdated_time() {
        return this.updated_time;
    }

    public void setUpdated_time(long updated_time) {
        this.updated_time = updated_time;
    }

    public String getTodo_title() {
        return this.todo_title;
    }

    public void setTodo_title(String todo_title) {
        this.todo_title = todo_title;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "{" +
                " todo_id='" + getTodo_id() + "'" +
                ", created_time='" + getCreated_time() + "'" +
                ", updated_time='" + getUpdated_time() + "'" +
                ", todo_title='" + getTodo_title() + "'" +
                ", user_id='" + getUser_id() + "'" +
                "}";
    }

}
