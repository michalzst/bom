package bom.dtoBuilder;

import bom.dto.UserDto;
import bom.user.Role;
import bom.user.User;
import bom.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDtoBuilder {
    @Autowired
    private UsersRepository<User> usersRepository;

    public User buildUserEntity(UserDto dto) {
        User user;
        if (dto.getId() == null) {
            user = new User();
        } else {
            user = usersRepository.getOne(dto.getId());
        }
        user.setFirstName(dto.getFirstName());
        user.setSurName(dto.getSurName());
        user.setLogin(dto.getLogin());
        user.setPasswordHash(dto.getPassword());

        return user;
    }
}
