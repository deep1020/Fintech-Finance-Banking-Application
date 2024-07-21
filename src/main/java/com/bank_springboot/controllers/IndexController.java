package com.bank_springboot.controllers;

import com.bank_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In Index Page Controller");
        return getIndexPage;
    }


    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        getErrorPage.addObject("PageTitle", "Errors");
        System.out.println("In Error Page Controller");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token")String token){
        // Set View:
        ModelAndView getVerifyPage;

        // Get Token from Database:
        String dbToken = userRepository.checkEmail(token);
        System.out.println("Index Token: "+dbToken);
        // Check If Token Is Valid:
        if(dbToken == null){
            getVerifyPage  = new ModelAndView("error");
            getVerifyPage.addObject("error", "Invalid or expired verification token");
            return getVerifyPage;
        }
        else{
            userRepository.verifyAccount(dbToken);
            getVerifyPage = new ModelAndView("login");
            getVerifyPage.addObject("success", "Account Verified Successfully, Please proceed to Log In!");
            System.out.println("In Verify Account - Index Controller");
            return getVerifyPage;
        }
        // End Of Check If Token Is Valid.
//        System.out.println("Code: "+code);
        // Update and Verify Account:

    }
    // End Of User Account Verification.


}
