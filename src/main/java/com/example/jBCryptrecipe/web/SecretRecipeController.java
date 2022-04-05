package com.example.jBCryptrecipe.web;

import com.example.jBCryptrecipe.domain.Post;
import com.example.jBCryptrecipe.domain.UserPost;
import com.example.jBCryptrecipe.infrastructure.PostRepository;
import com.example.jBCryptrecipe.infrastructure.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SecretRecipeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @GetMapping("/")
    public String homePage()
    {
        return "Index";
    }
    @GetMapping("/login")
    String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView loginUser(String username, String password) {
        UserPost userPost = userRepository.findUserByUsername(username);

        if ((userPost == null) || (!BCrypt.checkpw(password, userPost.getPassword()))) {
            return new RedirectView("/login");
        }

        return new RedirectView("/");
    }
    @GetMapping("/signup")
    String getSignupUser(){
        return "signup";

    }
    @PostMapping("/signup")
    public RedirectView signUpNewUser(Model model, String username, String password)
    {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
       UserPost newUserPost = new UserPost(username, hashedPassword);

        userRepository.save(newUserPost);
        return new RedirectView("/login");
    }

    @PostMapping("/post")
    RedirectView addNewPost(@ModelAttribute Post post){;

        postRepository.save(post);
        return new RedirectView("/post");
}
    @GetMapping("/post")
    String getPost(Model model){
        model.addAttribute("myPostList" , postRepository.findAll());
        return "Index";
    }

}
