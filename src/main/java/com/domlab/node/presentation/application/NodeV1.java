package com.domlab.node.presentation.application;


import com.domlab.node.presentation.service.AuthorizationResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("api/v1")
public class NodeV1 extends ResourceConfig {

    public NodeV1() {
        this.register(AuthorizationResource.class);
    }

    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle("Node");
        config.setVersion("v1");
        config.setContact("Domenico Montesanto");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath("api/v1");
        config.setResourcePackage("com.domlab.node.presentation.service");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

    @PostConstruct
    public void init() {
        this.configureSwagger();
    }
}
