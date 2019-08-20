package bom.repository;

import bom.entity.ZgloszenieKontenery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZgloszenieKonteneryRepo<T extends ZgloszenieKontenery> extends JpaRepository<ZgloszenieKontenery, Long>, QuerydslPredicateExecutor<ZgloszenieKontenery> {
}
