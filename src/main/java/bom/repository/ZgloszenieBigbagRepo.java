package bom.repository;

import bom.entity.ZgloszenieBigbag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ZgloszenieBigbagRepo <T extends ZgloszenieBigbag> extends JpaRepository<ZgloszenieBigbag, Long>, QuerydslPredicateExecutor<ZgloszenieBigbag> {
    @Query("SELECT z FROM ZgloszenieBigbag z where (z.id)=?1")
    ZgloszenieBigbag findZgloszenieBigbagFromId(Long id);

    @Query("SELECT z FROM ZgloszenieBigbag z where (z.dataZgloszenia)=?1")
    ZgloszenieBigbag findZgloszenieBigbagFromDataZgloszenia(String dataZgloszenia);


    @Query("SELECT z FROM ZgloszenieBigbag z where (z.nrWorka)=?1")
    ZgloszenieBigbag findZgloszenieBigbagByNrWorka (String nrWorka);

    @Query("SELECT z FROM ZgloszenieBigbag z where (z.nrOswiadczenia)=?1")
    ZgloszenieBigbag findZgloszenieBigbagByNrOswiadczenia (String nrOswiadczenia);
}
