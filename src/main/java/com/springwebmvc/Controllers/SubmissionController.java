package com.springwebmvc.Controllers;

import com.springwebmvc.Models.SubmissionInfo;
import com.springwebmvc.Models.User;
import com.springwebmvc.Repositories.FolderRepository;
import com.springwebmvc.Repositories.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by motaleb  on 7/8/17.
 */
@Controller
public class SubmissionController {
    private static String UPLOADED_FOLDER = "/home/momin/Uploads/";
    @Autowired
    SubmissionRepository submissionRepository;
    @Autowired
    FolderRepository folderRepository;
    @GetMapping("/Submit")
    public String ShowSubmit(HttpServletRequest request){
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        if(user!=null&&user.getTorS().equals("Student")) {
            return "Submit";
        }
        else
            return "/";
    }
    @PostMapping("/Submit")
    public String PrcSubmission( RedirectAttributes redirectAttributes,
                              @RequestParam("AorL") String AorS,
                              @RequestParam("Name") String Name,
                              @RequestParam("Number") int Number,
                              @RequestParam("CourseTitle") String CourseTitle,
                              @RequestParam("CourseCode") String CourseCode,
                              @RequestParam("StudentName") String StudentName,
                              @RequestParam("StudentId") String StudentId,
                              @RequestParam("Dept") String Dept,
                              @RequestParam("folderName") String folderName,
                              @RequestParam("pDate") String pDate,
                              @RequestParam("file") MultipartFile file){
        SubmissionInfo submissionInfo=new SubmissionInfo();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate=LocalDate.now();
        if (folderRepository.exists(folderName)){
            submissionInfo.setAorL(AorS);
            submissionInfo.setName(Name);
            submissionInfo.setNumber(Number);
            submissionInfo.setCourseTitle(CourseTitle);
            submissionInfo.setCourseCode(CourseCode);
            submissionInfo.setStudentName(StudentName);
            submissionInfo.setStudentId(StudentId);
            submissionInfo.setDept(Dept);
            submissionInfo.setpDate(pDate);
            submissionInfo.setsDate(dtf.format(localDate));
            submissionInfo.setFolderName(folderName);
            submissionInfo.setFileName(file.getOriginalFilename());
            submissionRepository.save(submissionInfo);


            if (file.isEmpty()&&!file.getContentType().equals(".pdf")) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:uploadStatus";
            }

            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);

                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "redirect:/uploadStatus";
    }
    @GetMapping("/uploadStatus")
    public String UploadStatus(){
        return "uploadStatus";
    }


}

