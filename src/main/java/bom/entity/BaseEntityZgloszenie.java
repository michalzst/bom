package bom.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode
public class BaseEntityZgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dataZgloszenia;
    private String trescZgloszenia;
    private String nazwaKlienta;
    private String ulicaNrDomu;
    private String nrTelefonu;
    private String uwagiOdLogistyki;
    @Enumerated(EnumType.STRING)
    private StatusZgloszenia statusZgloszenia;
    private String nazwaUzytkownika;
}
