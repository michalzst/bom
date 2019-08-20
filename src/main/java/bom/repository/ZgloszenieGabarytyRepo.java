package bom.repository;

import bom.entity.ZgloszenieGabaryty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZgloszenieGabarytyRepo <T extends ZgloszenieGabaryty> extends JpaRepository<ZgloszenieGabaryty, Long>, QuerydslPredicateExecutor<ZgloszenieGabaryty> {
}
