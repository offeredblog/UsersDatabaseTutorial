package com.service;

import com.data.UsersDAO;
import com.service.controllers.UsersController;
import com.service.resources.UsersResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class UsersServiceApplication extends Application<UsersServiceConfiguration> {
    private static final String SQL = "sql";
    public static void main(String[] args) throws Exception {
        new UsersServiceApplication().run(args);
    }
    public void run(UsersServiceConfiguration usersServiceConfiguration, Environment environment) throws Exception {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, usersServiceConfiguration.getDataSourceFactory(), SQL);
        final UsersDAO usersDAO = jdbi.onDemand(UsersDAO.class);
        final UsersController usersController = new UsersController(usersDAO);
        environment.jersey().register(new UsersResource(usersController));
    }
}
