package com.service;

import com.service.controllers.UsersController;
import com.service.resources.UsersResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UsersServiceApplication extends Application<UsersServiceConfiguration> {
    private final UsersController usersController = new UsersController();

    public static void main(String[] args) throws Exception {
        new UsersServiceApplication().run(args);
    }
    public void run(UsersServiceConfiguration usersServiceConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new UsersResource(usersController));
    }
}
