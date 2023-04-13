package com.service.controllers;

import com.data.UsersDAO;
import com.google.common.collect.Iterables;
import com.service.model.UserInsert;
import com.service.model.UserStored;
import com.service.model.UserUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersController {

    private final List<UserStored> usersList = new ArrayList<>();
    private final UsersDAO usersDAO;

    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public List<UserStored> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    public Optional<UserStored> getUserById(int userId) {
        return usersDAO.getById(userId);
    }

    public int createUser(UserInsert userInsert) {
        return usersDAO.createPart(userInsert);
    }

    public void updateUser(UserUpdate userUpdate) {
        usersDAO.updateUser(userUpdate);
    }

    public void deleteUser(int userId) {
        usersDAO.deleteUser(userId);
    }
}
