package com.domlab.node.integration.mappers;

import com.domlab.node.dto.user.ApplicationUser;
import com.domlab.node.integration.repository.model.LogInUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    LogInUser userToLogInUser(ApplicationUser user);
}
