package bom.user;

import lombok.Getter;

@Getter
public enum RoleTypeEnum {
    BOM("ROLE_BOM"), ADMIN("ROLE_ADMIN"),LOGISTYKA("ROLE_LOGISTYKA"),FAKTUROWANIE("ROLE_FAKTUROWANIE");

    private String roleName;

    RoleTypeEnum(String roleName) {
        this.roleName = roleName;
    }
}
