package com.springwebmvc.Controllers;

import com.springwebmvc.Models.Folders;
import com.springwebmvc.Models.SubmissionInfo;
import com.springwebmvc.Models.User;
import com.springwebmvc.Repositories.FolderRepository;
import com.springwebmvc.Repositories.SubmissionRepository;
import com.springwebmvc.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by motaleb  on 7/8/17.
 */
@Controller
public class LoginController {
    @Autowired
    SubmissionRepository submissionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;

    //displays login form
    @GetMapping("/")
    public String ShowLogin(){
        return "login";
    }

    //processing login
    @PostMapping("/")
    public String PrcLogin(HttpSession session, Model model,ModelMap modelMap,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password){
        User user=userRepository.findOne(email);
        String SavedEmail=user.getEmail();
        String SavedPassword=user.getPassword();
        String ViewName=user.getTorS();

        if(SavedEmail.equals(email)&&SavedPassword.equals(password)){
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            if(ViewName.equals("Teacher")){
                List<Folders> createdFolders=folderRepository.findAllByCreatedBy(user);
                List<SubmissionInfo> list = new ArrayList<>();

                for(Folders folders : createdFolders){
                    if(submissionRepository.findAllByFolderName(folders.getFolderName())!=null){
                        list.addAll(submissionRepository.findAllByFolderName(folders.getFolderName()));
                    }

                }
                model.addAttribute("folders",createdFolders);
                model.addAttribute("info",list);

            }
            return ViewName;
        }
        else{
            String msg="something went wrong please try with Correct credentials";
            modelMap.addAttribute("errormsg",msg);
            return "login";
        }

    }
    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/getpdf/{href}")
    public ResponseEntity<byte[]> getPDF1(@PathVariable("href") String path) throws IOException {

        Path pdfPath = Paths.get("/home/momin/Uploads/"+path+".pdf");
        byte[] pdf1Bytes = Files.readAllBytes(pdfPath);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "pdf1.pdf";

        headers.add("content-disposition", "inline;filename=" + filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdf1Bytes, headers, HttpStatus.OK);
        return response;
    }
}
