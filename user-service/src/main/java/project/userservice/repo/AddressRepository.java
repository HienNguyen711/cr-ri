package project.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.userservice.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByUserId(String userId);
}
