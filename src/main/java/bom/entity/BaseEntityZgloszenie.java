package bom.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode
public class BaseEntityZgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dataZgloszenia;
    private String trescZgloszenia;
    private String nazwaKlienta;
    private String ulicaNrDomu;
    private String nrTelefonu;
    private String uwagiOdLogistyki;
    private String statusZgloszenia;
    private String nazwaUzytkownika;
}
