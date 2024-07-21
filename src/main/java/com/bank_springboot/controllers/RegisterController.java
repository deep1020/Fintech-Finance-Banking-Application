package com.bank_springboot.controllers;

import com.bank_springboot.helpers.HTML;
//import com.demo_bank_v1.helpers.Token;
import com.bank_springboot.mailMessenger.MailMessenger;
import com.bank_springboot.models.User;
import com.bank_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailMessenger mailMessenger;

    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In Register Page Controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser")User user,
                                 BindingResult result,
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password) throws MessagingException {
        System.out.println("Hello register");
        ModelAndView registrationPage = new ModelAndView("register");

        // Check For Errors:
        if(result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject("confirm_pass", "The confirm Field is required");
            return registrationPage;
        }
        // Check if email already exists:
        String existingEmail=userRepository.getUserEmail(email);
        if(existingEmail!=null){
            registrationPage.addObject("emailExisted","Email already exists, please try another email");
            return registrationPage;
        }
        // TODO: CHECK FOR PASSWORD MATCH:
        if(!password.equals(confirm_password)){
            registrationPage.addObject("passwordMisMatch", "passwords do not match");
            return registrationPage;
        }

        // TODO: GET TOKEN STRING:
        String token = mailMessenger.generateVerificationToken();

        // TODO: GENERATE RANDOM CODE:
        Random rand = new Random();
        int bound = 123;
        int code = bound * rand.nextInt(bound);

        // TODO: GET EMAIL HTML BODY:
        String emailBody = HTML.htmlEmailTemplate(token, code);
        // TODO: HASH PASSWORD:
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // TODO: REGISTER USER:
        userRepository.registerUser(first_name, last_name, email, hashed_password, token, code);

        // TODO: SEND EMAIL NOTIFICATION:
//        MailMessenger.htmlEmailMessenger("no-reply@somecompany.com", email, "Verify Account", emailBody);
//        MailMessenger.htmlEmailMessenger("deep041999@gmail.com", email, "Verify Account", emailBody);
//        System.out.println("Mail sent");
        // TODO: RETURN TO REGISTER PAGE:
//        String successMessage = "Account Registered Successfully, Please Check your Email and Verify Account!";
        String successMessage = "Account Registered Successfully";
        registrationPage.addObject("success", successMessage);
        return registrationPage;
    }


}
