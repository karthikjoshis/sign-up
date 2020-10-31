package com.soc.round1design.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT u.id FROM user_registration u WHERE u.email_id=:emailId",nativeQuery = true)
    Optional<Integer> findByEmailId(@Param("emailId")String emailId);
}
