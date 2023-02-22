package com.todo.springboot.todospringbootcouchbase.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class TodoItem {

    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    @Field(value = "todo_item_id")
    @Id
    private String todoItemId;

    @Field(value = "todo_id")
    private String todoId; //ToDo: not working with todo_id from postMan
    @Field(value = "created_time")
    private long createdTime;
    @Field(value = "updated_time")
    private long updatedTime;
    @Field(value = "completed_status")
    private boolean completedStatus;
    @Field(value = "todo_item_title")
    private String todoItemTitle;


    public String getTodoItemId() {
        return this.todoItemId;
    }

    public void setTodoItemId(String todoItemId) {
        this.todoItemId = todoItemId;
    }

    public String getTodoId() {
        return this.todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public boolean isCompletedStatus() {
        return this.completedStatus;
    }

    public boolean getCompletedStatus() {
        return this.completedStatus;
    }

    public void setCompletedStatus(boolean completedStatus) {
        this.completedStatus = completedStatus;
    }

    public String getTodoItemTitle() {
        return this.todoItemTitle;
    }

    public void setTodoItemTitle(String todoItemTitle) {
        this.todoItemTitle = todoItemTitle;
    }

    @Override
    public String toString() {
        return "{" +
                " todoItemId='" + getTodoItemId() + "'" +
                ", todoId='" + getTodoId() + "'" +
                ", createdTime='" + getCreatedTime() + "'" +
                ", updatedTime='" + getUpdatedTime() + "'" +
                ", completedStatus='" + isCompletedStatus() + "'" +
                ", todoItemTitle='" + getTodoItemTitle() + "'" +
                "}";
    }

}
