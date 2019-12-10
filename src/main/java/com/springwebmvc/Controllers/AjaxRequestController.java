package com.springwebmvc.Controllers;

import com.springwebmvc.Models.SubmissionInfo;
import com.springwebmvc.Repositories.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by motaleb on 7/26/17.
 */
@Controller
public class AjaxRequestController {
    @Autowired
    SubmissionRepository repository;
    @PostMapping("/Ajax")
    public @ResponseBody List<SubmissionInfo> handleAjax(@RequestParam("folderName") String folderName){
        List<SubmissionInfo> list=new ArrayList<>();
        list.addAll(repository.findAllByFolderName(folderName));

        return list;


    }
}
