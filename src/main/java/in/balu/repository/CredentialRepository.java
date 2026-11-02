package in.balu.repository;

import in.balu.models.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

    Optional<Credential> findByUsername(String username);

    Optional<Credential> findByUsernameAndPassword(String username, String password);

}
