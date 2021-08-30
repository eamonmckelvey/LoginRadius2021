package com.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    LoginRadiusService service;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(){

        // Instead of using the default LoginRadius loginscreen i send the initial request to my actual login
        String redirectUrl = "https://eamonsapp.hub.loginradius.com/auth.aspx";
        return "redirect:" + redirectUrl;
      
    }

    @RequestMapping(value="/user", method=RequestMethod.GET)
    @ResponseBody
    public String getUserProfile(HttpServletRequest request){
            String result = service.getUserProfile(request);
            System.out.println("UserController.getUserProfile::" + result);
            return result;

    }

//     @RequestMapping(value="/minimal", method=RequestMethod.GET)
//     public String minimal(){
//         return "index";
//     }

//     @RequestMapping(value="/loginscreen", method=RequestMethod.GET)
//     public String loginScreen(){
//         return "loginscreen";
//     }

    @RequestMapping(value="/emailverification", method=RequestMethod.GET)
    public String emailverification(){
        return "emailverification";
    }

    @RequestMapping(value="/resetpassword", method=RequestMethod.GET)
    public String resetpassword(){
        return "resetpassword";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request){
            String result = service.login(request);
            System.out.println("LoginController.login::" + result);
            return result;
    }

//    @RequestMapping(value="/mfa", method=RequestMethod.POST)
//     @ResponseBody
//     public String mfaLogin(HttpServletRequest request){

//             String result = service.mfaLogin(request);
//             System.out.println("LoginController.mfaLogin::" + result);
//             return result;
//     }

//     @RequestMapping(value="/mfa/verify", method=RequestMethod.PUT)
//     @ResponseBody
//     public String mfaVerify(HttpServletRequest request){
      
//             String result = service.mfaVerify(request);
//             System.out.println("LoginController.mfaVerify::" + result);
//             return result;
//     }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request){
            String result = service.register(request);
            System.out.println("LoginController.register::" + result);
            return result;

    }

    @RequestMapping(value="/email/verify", method=RequestMethod.GET)
    @ResponseBody
    public String emailVerify(HttpServletRequest request){
      
            String result = service.emailVerify(request);
            System.out.println("LoginController.emailVerify::" + result);
            return result;
    }
   
//     @RequestMapping(value="/passwordless", method=RequestMethod.GET)
//     @ResponseBody
//     public String passwordlessLogin(HttpServletRequest request){
 
//             String result = service.passwordlessLogin(request);
//             System.out.println("LoginController.passwordlessLogin::" + result);
//             return result;
//     }
 
//     @RequestMapping(value="/passwordless/verify", method=RequestMethod.GET)
//     @ResponseBody
//     public String passwordlessVerify(HttpServletRequest request){
       
//             String result = service.passwordlessVerify(request);
//             System.out.println("LoginController.passwordlessVerify::" + result);
//             return result;
//     }

    @RequestMapping(value="/password/forgot", method=RequestMethod.POST)
    @ResponseBody
    public String forgotPassword(HttpServletRequest request){
       
            String result = service.forgotPassword(request);
            System.out.println("LoginController.forgotPassword::" + result);
            return result;
       
    }

    @RequestMapping(value="/password/reset", method=RequestMethod.PUT)
    @ResponseBody
    public String resetPassword(HttpServletRequest request){
       
            String result = service.resetPassword(request);
            System.out.println("LoginController.resetPassword::" + result);
            return result;
       
    }
}
