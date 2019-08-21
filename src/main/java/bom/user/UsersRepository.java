package bom.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository<T extends User>  extends JpaRepository<T, Long> {
    Optional<T> findByLogin(String login);
    boolean existsByLogin(String login);
}
