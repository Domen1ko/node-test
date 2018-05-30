package com.domlab.node.integration.repository.service;

import com.domlab.node.integration.repository.model.LogInUser;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "userauth")
public interface LogInUserRepository extends CouchbaseRepository<LogInUser, String> {
}
