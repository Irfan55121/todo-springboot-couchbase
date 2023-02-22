package com.todo.springboot.todospringbootcouchbase.couchbase;

import com.couchbase.client.java.env.ClusterEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class ToDoCouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getBucketName() {
        return "todo_list";
    }

    @Override
    public String getConnectionString() {
        return "127.0.0.1";
    }

    @Override
    public String getPassword() {
        return "123456";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    protected String getScopeName() {
        return "todo_user";
    }
}