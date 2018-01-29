package project.financialservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.financialservice.entity.ObligationDetails;


public interface ObligationRepository extends JpaRepository<ObligationDetails, Integer> {

    ObligationDetails findByUserId(String userId);
}
