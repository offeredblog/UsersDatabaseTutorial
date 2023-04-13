package com.data;

import com.data.mappers.UsersMapper;
import com.service.model.UserInsert;
import com.service.model.UserStored;
import com.service.model.UserUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterRowMapper(UsersMapper.class)
public interface UsersDAO {
    @SqlQuery("select * from users;")
    public List<UserStored> getAllUsers();

    @SqlQuery("select * from users where id = :id")
    public Optional<UserStored> getById(@Bind("id") final int id);

    @SqlUpdate("insert into users(userName, firstName, lastName) values(:userName, :firstName, :lastName)")
    public int createPart(@BindBean final UserInsert userInsert);

    @SqlUpdate(
            "update users set userName = :userName, " +
            "firstName = :firstName, " +
            "lastName = :lastName " +
            "where id = :userId"
    )
    void updateUser(@BindBean final UserUpdate userUpdate);

    @SqlUpdate("delete from users where id = :id")
    void deleteUser(@Bind("id") final int id);
}
