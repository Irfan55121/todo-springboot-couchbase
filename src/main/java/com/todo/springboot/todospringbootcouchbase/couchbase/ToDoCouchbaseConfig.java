package com.todo.springboot.todospringbootcouchbase.couchbase;

import com.couchbase.client.core.env.TimeoutConfig;
import com.couchbase.client.java.env.ClusterEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.time.Duration;

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

    @Override
    protected void configureEnvironment(ClusterEnvironment.Builder builder) {
        builder.timeoutConfig(TimeoutConfig.kvDurableTimeout(Duration.ofMinutes(5))
                .queryTimeout(Duration.ofMinutes(5)));
        super.configureEnvironment(builder);
    }
}