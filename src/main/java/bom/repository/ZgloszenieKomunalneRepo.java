package bom.repository;

import bom.entity.ZgloszenieKomunalne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZgloszenieKomunalneRepo<T extends ZgloszenieKomunalne> extends JpaRepository<ZgloszenieKomunalne, Long>, QuerydslPredicateExecutor<ZgloszenieKomunalne> {
}
