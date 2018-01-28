package project.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.userservice.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    UserDetail findByUserId(String userId);

    UserDetail findBySecurityId(String securityId);

}
