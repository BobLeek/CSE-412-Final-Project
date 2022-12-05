/*
CSE 412 Final Project
Due: 12/4/22
Michael Payne
Yue Fang
Jesus Perez
 */
package project412.controller;

import project412.mapper.UsersMapper;
import project412.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    UsersMapper usersMapper;


    @PostMapping("login")
    public String login(Model model, HttpSession session, Users users) {
        Users user = usersMapper.selectUser(users.getEmail(), users.getPassword());
        if (user == null) {
            model.addAttribute("error", "Username not exists or password incorrect");
            return "redirect:Login";
        }
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        return "redirect:index.html";
    }

}
