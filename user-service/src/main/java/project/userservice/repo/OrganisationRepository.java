package project.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.userservice.entity.Address;
import project.userservice.entity.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
    Organisation findByUserId(String userId);


}
