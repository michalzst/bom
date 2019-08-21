package bom.dtoBuilder;

import bom.dto.UserDto;
import bom.user.Role;
import bom.user.User;
import bom.user.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDtoBuilder {
    private UsersRepository<User> usersRepository;

    public User buildUserEntity(UserDto dto) {
        User user;
        Role role=null;
        if (dto.getId() == null) {
            user = new User();
            role = new Role();
        } else {
            user = usersRepository.getOne(dto.getId());
        }
        user.setFirstName(dto.getFirstName());
        user.setSurName(dto.getSurName());
        user.setLogin(dto.getLogin());
        user.setPasswordHash(dto.getPassword());
        role.setRoleName(dto.getRoleTypeEnum().getRoleName());
        return user;
    }
}
