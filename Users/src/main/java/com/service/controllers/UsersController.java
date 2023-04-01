package com.service.controllers;

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

    public UsersController() {}

    public List<UserStored> getAllUsers() {
        return usersList;
    }

    public Optional<UserStored> getUserById(int userId) {
        return usersList
                .stream()
                .filter(userStored -> userStored.getUserId() == userId)
                .findFirst();
    }

    public UserStored createUser(UserInsert userInsert) {
        UserStored userStored = toUserStored(userInsert, usersList.size());
        usersList.add(userStored);
        return userStored;
    }

    public UserStored updateUser(UserUpdate userUpdate) {
        UserStored userStored = toUserStored(userUpdate);

        int toUpdateIndex = usersList.indexOf(
                Iterables.getOnlyElement(
                        usersList
                                .stream()
                                .filter(user -> user.getUserId() == userUpdate.getUserId())
                                .collect(Collectors.toList())
                )
        );

        usersList.set(toUpdateIndex, userStored);
        return userStored;
    }

    public void deleteUser(int userId) {
        int toDeleteIndex = usersList.indexOf(
                Iterables.getOnlyElement(
                        usersList
                                .stream()
                                .filter(user -> user.getUserId() == userId)
                                .collect(Collectors.toList())
                )
        );
        usersList.remove(toDeleteIndex);
    }

    private UserStored toUserStored(UserInsert userInsert, int id) {
        return new UserStored(
                id,
                userInsert.getUserName(),
                userInsert.getFirstName(),
                userInsert.getLastName()
        );
    }

    private UserStored toUserStored(UserUpdate userUpdate) {
        return new UserStored(
                userUpdate.getUserId(),
                userUpdate.getUserName(),
                userUpdate.getFirstName(),
                userUpdate.getLastName()
        );
    }
}
