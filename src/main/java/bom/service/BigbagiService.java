package bom.service;

import bom.entity.StatusZgloszenia;
import bom.entity.ZgloszenieBigbag;
import bom.repository.ZgloszenieBigbagRepo;
import bom.user.User;
import bom.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class BigbagiService {

    @Autowired
    private ZgloszenieBigbagRepo<ZgloszenieBigbag> zgloszenieBigbagRepo;

    public List<ZgloszenieBigbag> findAll(){
        return zgloszenieBigbagRepo.findAll();
    };

    public void createNewZgloszenie(String tresc, String nazwaKlienta, String adres, String telefon, String nrWorka, String nrOswiadczenia ){
        ZgloszenieBigbag zgloszenieBigbag = new ZgloszenieBigbag();
        zgloszenieBigbag.setDataZgloszenia(LocalDateTime.now());
        zgloszenieBigbag.setTrescZgloszenia(tresc);
        zgloszenieBigbag.setNazwaKlienta(nazwaKlienta);
        zgloszenieBigbag.setUlicaNrDomu(adres);
        zgloszenieBigbag.setNrTelefonu(telefon);
        zgloszenieBigbag.setNrWorka(nrWorka);
        zgloszenieBigbag.setNrOswiadczenia(nrOswiadczenia);
        zgloszenieBigbag.setStatusZgloszenia(StatusZgloszenia.STATUS_PRZYJETE);
        zgloszenieBigbag.setNazwaUzytkownika("Komputer");
        zgloszenieBigbagRepo.save(zgloszenieBigbag);
    }
}
