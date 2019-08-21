package bom.user;

import lombok.Getter;

@Getter
public enum RoleTypeEnum {
    BOM("ROLE_BOM"), ADMIN("ROLE_ADMIN"),LOGISTYKA("ROLE_LOGISTYKA");

    private String roleName;

    RoleTypeEnum(String roleName) {
        this.roleName = roleName;
    }
}
