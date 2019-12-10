package com.springwebmvc.Controllers;

import com.springwebmvc.Models.Folders;
import com.springwebmvc.Models.User;
import com.springwebmvc.Repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by motaleb on 7/20/17.
 */
@Controller
public class FolderController {
    @Autowired
    FolderRepository folderRepository;


    @GetMapping("/newFolder")
    public String showFolderForm(HttpSession session ,RedirectAttributes redirectAttributes){
        User user= (User) session.getAttribute("user");
        if(user.getTorS().equals("Teacher")){
            return "newFolder";
        }
        else
        {
            redirectAttributes.addFlashAttribute("message",
                    "You must have to be teacher to be able to create a folder");
            return "redirect:/uploadStatus";
        }

    }
    @PostMapping("/newFolder")
    public String  prcNewFolder(
            @RequestParam("newFolder") String folderName
            ,HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user.getTorS().equals("Teacher")){
            Folders folders = new Folders();
            folders.setFolderName(folderName);
            folders.setCreatedBy(user);
            folderRepository.save(folders);
        }
return "Success";

    }
}
