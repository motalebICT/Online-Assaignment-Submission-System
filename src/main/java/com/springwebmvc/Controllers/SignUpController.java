package com.springwebmvc.Controllers;

import com.springwebmvc.Models.User;
import com.springwebmvc.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by motaleb on 7/8/17.
 */
@Controller
public class SignUpController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/signUp")
    public String ShowSignUp(){
        return "signUp";
    }
    @PostMapping("/signUp")
    public String PrcSignUp(ModelMap modelMap,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("tors") String TorS){
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Boolean b = email.matches(EMAIL_REGEX);
        if(b.equals(true)){
            User user=new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setTorS(TorS);
            userRepository.save(user);
            return "Success";
        }
        else {
            modelMap.addAttribute("errormsg","invalid emial address");
            return "signUp";
        }

    }
}
