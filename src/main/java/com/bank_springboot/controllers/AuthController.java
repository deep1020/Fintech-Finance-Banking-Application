package com.bank_springboot.controllers;

//import com.demo_bank_v1.helpers.Token;
import com.bank_springboot.mailMessenger.MailMessenger;
import com.bank_springboot.models.User;
import com.bank_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailMessenger mailMessenger;

//    @Autowired
//    private Token generateVerificationToken;

    @GetMapping("/login")
    public ModelAndView getLogin(){
        System.out.println("In Login Page Controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        // Set Token String:
        String token = mailMessenger.generateVerificationToken();
        // Send Token to View:
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
//        getLoginPage.addObject("email", "");
//        getLoginPage.addObject("password", "");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email")String email,
                        @RequestParam("password") String password,
                        @RequestParam("_token")String token,
                        Model model,
                        HttpSession session) throws MessagingException {

        // TODO: VALIDATE INPUT FIELDS / FORM DATA:
        if(email.isEmpty() || email == null || password.isEmpty() || password == null){
            model.addAttribute("error", "Username or Password Cannot be Empty");
            return "login";
        }

        // TODO: CHECK IF EMAIL EXISTS:
        String getEmailInDatabase = userRepository.getUserEmail(email);
        System.out.println("Email: "+getEmailInDatabase);

        // Check If Email Exists:
        if(getEmailInDatabase != null){
            // Get Password In Database:
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);
            // Validate Password:
            if(!BCrypt.checkpw(password, getPasswordInDatabase)){
                model.addAttribute("error", "Incorrect Username or Password");
                return "login";
            }
            // End Of Validate Password.
        }
        else{
            model.addAttribute("error", "Something went wrong please contact support");
            return "error";
        }
        // Check If Email Exists.

        // TODO : CHECK IF USER ACCOUNT IS VERIFIED:
        int verified = userRepository.isVerified(getEmailInDatabase);
        System.out.println(verified);

        // Check If Account is verified:
        if (verified != 1){
            String verificationToken=userRepository.checkToken(getEmailInDatabase);
            System.out.println("Auth Token: "+verificationToken);
            mailMessenger.sendVerificationEmail(getEmailInDatabase,verificationToken);
            String msg = "This Account is not yet Verified, please check email and verify account";
            model.addAttribute("error", msg);
            return "login";
        }

        // TODO: PROCEED TO LOG THE USER IN:
        User user = userRepository.getUserDetails(getEmailInDatabase);

        // Set Session Attributes:
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);
        return "redirect:/app/dashboard";
    }
    // End Of Authentication Method.

//    @GetMapping("/logout")
//    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
//        session.invalidate();
//        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
//        return "redirect:/login";
//    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes){
        HttpSession session=request.getSession(false);
        if(session!=null){
            session.removeAttribute("email");
            session.removeAttribute("password");
            session.invalidate();
            redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        }
        return "redirect:/login?logout=true";
    }
}
