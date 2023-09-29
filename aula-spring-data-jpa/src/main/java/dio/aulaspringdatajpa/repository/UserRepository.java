package dio.aulaspringdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.aulaspringdatajpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
