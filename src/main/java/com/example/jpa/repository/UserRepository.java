package com.example.jpa.repository;

import com.example.jpa.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //extends로 jpaRepository가 있으므로 없어도됨.
public interface UserRepository extends JpaRepository<User, Long> { //Long=Id(PK)

}
