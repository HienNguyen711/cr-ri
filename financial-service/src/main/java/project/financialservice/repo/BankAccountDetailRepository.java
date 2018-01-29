package project.financialservice.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import project.financialservice.entity.BankAccountDetail;


public interface BankAccountDetailRepository extends JpaRepository<BankAccountDetail, Integer> {
    BankAccountDetail findByUserId(String userId);
}
