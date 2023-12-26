package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.rest.users.specification.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * UsersMapper - Mapper abstract class
 * Created on: 2023-12-26
 *
 * @author Łukasz Wodniak
 */

@Mapper
public abstract class UsersMapper {

    public static UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    public abstract EmployeeDto map(final User user);

    public abstract List<EmployeeDto> map(final List<User> users);
}
