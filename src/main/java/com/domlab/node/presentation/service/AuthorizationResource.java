package com.domlab.node.presentation.service;


import com.domlab.node.NodeApplication;
import com.domlab.node.dto.user.ApplicationUser;
import com.domlab.node.integration.mappers.IUserMapper;
import com.domlab.node.integration.repository.model.LogInUser;
import com.domlab.node.integration.repository.service.LogInUserRepository;
import com.tmajoir.lib.core.model.MessageResponse;
import com.tmajor.lib.log.pattern.LogPattern;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.logging.Logger;


@Api("Authorization Service")
@Component
@Path("/auth")
public class AuthorizationResource {

    private static final Logger logger = Logger.getLogger(NodeApplication.APP);
    private final LogInUserRepository repository;
    private BCryptPasswordEncoder encrypt;

    @Autowired
    public AuthorizationResource(BCryptPasswordEncoder encrypt, LogInUserRepository repository) {
        this.encrypt = encrypt;
        this.repository = repository;
    }

    @ApiOperation("sign-up")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/sign-up")
    public Response signUp(@NotNull @ApiParam(required = true) ApplicationUser user) {
        Optional<LogInUser> userId = repository.findById(user.getUserId());
        if (!userId.isPresent()) {
            return Response.status(Response.Status.CONFLICT).entity(new MessageResponse()).build();
        }
        logger.info(LogPattern.applyPattern(null, "Calling sign-in of user", user));
        user.setPassword(encrypt.encode(user.getPassword()));
        repository.save(IUserMapper.INSTANCE.userToLogInUser(user));
        return Response.ok().build();
    }
}
