package com.domlab.node.integration.repository.model;

import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class LogInUser {

    @Id
    @Field
    @NotNull
    @Size(min = 3, max = 25)
    private String userId;

    @Field
    @NotNull
    @Size(min = 8, max = 25)
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
