/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.formKTM136;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author eunannana
 */
@Controller
public class myController {
    
    @RequestMapping("/nextpage")
    public String next(
            @RequestParam(value = "thename") String itsname,
            @RequestParam(value = "thenim") String itsnim,
            @RequestParam(value = "thedate") @DateTimeFormat(pattern="yyyy-MM-dd") Date itsdate,
            @RequestParam(value = "thedegree") String itsdegree,
            @RequestParam(value = "thedepartment") String itsdepartment,
            @RequestParam(value = "theyear") String itsyear,
            @RequestParam(value = "themail") String itsmail,
            @RequestParam(value = "thepicture") MultipartFile itspicture,
     Model courier) 
            throws IOException{
         SimpleDateFormat newdate = new SimpleDateFormat("dd MMMMMMM yyyy");
        
        String myDate = newdate.format(itsdate);
        String theimg = Base64.encodeBase64String(itspicture.getBytes());
        String itsimg = "data:image/png;base64,".concat(theimg);
        
        courier.addAttribute("package1", itsname);
        courier.addAttribute("package2", itsnim);
        courier.addAttribute("package3", myDate);
        courier.addAttribute("package4", itsdegree);
        courier.addAttribute("package5", itsdepartment);
        courier.addAttribute("package6", itsyear);
        courier.addAttribute("package7", itsmail);
        courier.addAttribute("package8", itsimg);
        
        return "viewpage";
    }
    
    }
    