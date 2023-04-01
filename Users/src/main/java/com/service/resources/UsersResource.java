package com.service.resources;

import com.service.controllers.UsersController;
import com.service.model.UserInsert;
import com.service.model.UserStored;
import com.service.model.UserUpdate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {
    private final UsersController usersController;

    public UsersResource(UsersController usersController) {
        this.usersController = usersController;
    }

    @GET
    public List<UserStored> getAllUsers() {
        return usersController.getAllUsers();
    }

    @GET
    @Path("{userId}")
    public UserStored getUserById(@PathParam("userId") int userId) {
        return usersController
                .getUserById(userId)
                .orElseThrow(NotFoundException::new);
    }

    @POST
    public UserStored createUser(UserInsert userInsert) {
        return usersController.createUser(userInsert);
    }

    @PUT
    public UserStored updateUser(UserUpdate userUpdate) {
        return usersController.updateUser(userUpdate);
    }

    @DELETE
    @Path("{userId}")
    public void deleteUser(@PathParam("userId") int userId) {
        usersController.deleteUser(userId);
    }

}
