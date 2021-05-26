package com.example.dogram2.controller;

import com.example.dogram2.dto.User;
import com.example.dogram2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/user",produces="application/json; charset=utf-8")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

   @PostMapping("login")
   @ResponseBody
    public int login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
       try {
           return userService.login(user.getId(),user.getPassword(),response,request);
       } catch (Exception e) {
           e.printStackTrace();
           return -1;
       }
   }

    @RequestMapping("join2")
    @ResponseBody
    public int join2(@RequestParam("file") MultipartFile img, HttpServletRequest file, Model model, ModelAndView mv) {
        User user = new User();
        int check = -1;
        try {
            check = userService.checkIdOrEmail(user.getId());
            if(check == 1) return userService.join(img,model,mv,file,user);
        } catch (Exception e) {
            e.printStackTrace();
            check = -1;
        }

        return check;
    }

    @PostMapping("mypage")
    @ResponseBody
    public User myPage(@RequestBody User user,@CookieValue(value="id", required=false) Cookie cookie){
       try{
           Long num = userService.checkCookie(cookie.getValue());
           user.setNum(num);
           if(num != null) return userService.myPage(user);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return user;
    }


}
