package com.example.jBCryptrecipe.infrastructure;

import com.example.jBCryptrecipe.domain.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPost,Long> {
    UserPost findUserByUsername(String username);
}
