package com.data.mappers;

import com.service.model.UserStored;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements RowMapper<UserStored> {
    @Override
    public UserStored map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new UserStored(
                rs.getInt("id"),
                rs.getString("userName"),
                rs.getString("firstName"),
                rs.getString("lastName")
        );
    }
}
