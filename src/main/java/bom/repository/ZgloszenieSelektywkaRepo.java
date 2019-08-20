package bom.repository;

import bom.entity.ZgloszenieSelektywka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZgloszenieSelektywkaRepo <T extends ZgloszenieSelektywka> extends JpaRepository<ZgloszenieSelektywka, Long>, QuerydslPredicateExecutor<ZgloszenieSelektywka> {
}
