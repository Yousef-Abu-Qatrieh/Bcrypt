package com.example.jBCryptrecipe.infrastructure;

import com.example.jBCryptrecipe.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
