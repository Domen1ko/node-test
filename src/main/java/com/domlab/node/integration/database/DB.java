package com.domlab.node.integration.database;

import com.domlab.node.dto.user.ApplicationUser;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DB {

    private static final Map<String, ApplicationUser> users = new ConcurrentHashMap<>();

    public static void push(ApplicationUser user) {
        users.put(user.getUserId().toUpperCase(), user);
    }

    public static ApplicationUser pop(@NotNull String user) {
        return users.get(user.toUpperCase());
    }
}
