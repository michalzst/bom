package bom.service;

import bom.dto.UserDto;
import bom.dtoBuilder.UserDtoBuilder;
import bom.user.*;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDtoBuilder userDtoBuilder;

    @Autowired
    private UsersRepository<User> usersRepository;

    public void addNewUser(UserDto userDto){
        if (usersRepository.existsByUsername(userDto.getUsername())) {
            throw new UserExistsException("Użytkownik z loginem: " + userDto.getUsername() + " juz istnieje w bazie danych");
        } else {
            User user = new User();
            user.setFirstName(userDto.getFirstName().trim());
            user.setSurName(userDto.getSurName().trim());
            user.setUsername(userDto.getUsername().trim());
            user.setPasswordHash(passwordEncoder.encode(userDto.getPassword().trim()));
            addUserRole(user,userDto.getRoleTypeEnum());
        }
    }

    public void updateUser(UserDto userDto){
        User u = userDtoBuilder.buildUserEntity(userDto);
        usersRepository.save(u);
    }

    private void addUserRole(User user,RoleTypeEnum roleTypeEnum) {
        Role roleUser = Optional.ofNullable(roleRepository.findRoleByRoleName(roleTypeEnum.getRoleName()))
                .orElseGet(() -> roleRepository.save(new Role(roleTypeEnum.getRoleName())));
        user.setRoles(Sets.newHashSet(roleUser));
        usersRepository.save(user);
    }
}

