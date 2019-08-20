package bom.repository;

import bom.entity.ZgloszenieTrawa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZgloszenieTrawaRepo<T extends ZgloszenieTrawa> extends JpaRepository<ZgloszenieTrawa, Long>, QuerydslPredicateExecutor<ZgloszenieTrawa> {
}
