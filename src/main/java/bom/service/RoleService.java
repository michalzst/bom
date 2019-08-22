package bom.service;

import bom.user.Role;
import bom.user.RoleRepository;
import bom.user.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void createRolesFromEnum(){
        for (RoleTypeEnum r:RoleTypeEnum.values()) {
            Role role = new Role();
            role.setRoleName(r.getRoleName());
            roleRepository.save(role);
        }
    }

    public Role findRoleByRoleName(String roleName){
        return roleRepository.findRoleByRoleName(roleName);
    }


}
