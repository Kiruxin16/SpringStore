package ru.gb.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.com.entities.Role;
import ru.gb.com.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.login = :login" )
    Optional<User> findByLogin(String login);


    @Query("select u.roles from User u where u.id = :id")
    List<Role> findAllRolesByUserId(Long id);

    boolean existsByLogin(String login);



}
