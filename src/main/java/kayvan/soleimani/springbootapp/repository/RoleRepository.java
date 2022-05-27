package kayvan.soleimani.springbootapp.repository;

import kayvan.soleimani.springbootapp.models.EnumRole;
import kayvan.soleimani.springbootapp.models.Role;
import kayvan.soleimani.springbootapp.models.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(EnumRole name);
}
