package uz.ilmnajot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByEmail(String email);


}
