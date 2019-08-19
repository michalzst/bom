package bom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ZgloszenieBigbag extends BaseEntityZgloszenie {
    private String nrWorka;
    private String nrOswiadczenia;
}
