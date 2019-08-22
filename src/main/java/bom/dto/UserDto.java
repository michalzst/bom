package bom.dto;

import bom.user.Role;
import bom.user.RoleTypeEnum;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]{2,19}$", message = "Wymagane od 3 do 20 znaków (pierwsza litera duża, reszta małe).")
    private String firstName;

    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]{2,19}$", message = "Wymagane od 3 do 20 znaków (pierwsza litera duża, reszta małe).")
    private String surName;

    @NotBlank(message = "Pole musi zostać wypełnione")
    private String login;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[+=!@#$%&*_?-])[A-Za-z\\d+=!@#$%&*_?-]{6,}$", message = "Hasło musi się składać z: co najmniej sześciu znaków, co najmniej jedna wielka litera, jedna mała litera, jedna cyfra i jeden znak specjalny")
    private String password;

    private RoleTypeEnum roleTypeEnum;

}
