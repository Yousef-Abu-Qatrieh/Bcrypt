package com.example.jBCryptrecipe.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
//@JsonIgnoreProperties({"user"})
@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Post {
    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NonNull
    private String textContent;
    @ManyToOne
    UserPost userPost;
}
