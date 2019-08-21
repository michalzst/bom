package bom.service;

import bom.dto.UserDto;
import bom.dtoBuilder.UserDtoBuilder;
import bom.user.Role;
import bom.user.User;
import bom.user.UsersRepository;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserDtoBuilder userDtoBuilder;

    @Autowired
    private UsersRepository<User> usersRepository;

    public void createNewUser(String firstName, String surName,String login, String password,String role){
        if (!usersRepository.existsByLogin(login)){
            User user = new User();
            Role userRole = new Role();
            userRole.setRoleName(role);
            user.setFirstName(firstName);
            user.setSurName(surName);
            user.setLogin(login);
            user.setPasswordHash(password);
            usersRepository.save(user);
        }
    }

    public void updateUser(UserDto userDto){
        User u = userDtoBuilder.buildUserEntity(userDto);
        usersRepository.save(u);
    }
}

