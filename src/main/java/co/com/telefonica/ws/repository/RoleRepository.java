package co.com.telefonica.ws.repository;

import co.com.telefonica.ws.models.ERole;
import co.com.telefonica.ws.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
