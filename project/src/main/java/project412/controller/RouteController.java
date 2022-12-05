/*
CSE 412 Final Project
Due: 12/4/22
Michael Payne
Yue Fang
Jesus Perez
 */
package project412.controller;

import project412.mapper.GamesMapper;
import project412.mapper.UsersMapper;
import project412.model.Games;
import project412.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RouteController {

    @Resource
    UsersMapper usersMapper;
    @Resource
    GamesMapper gamesMapper;

    @GetMapping("login.html")
    public String toLogin() {
        return "Login";
    }


    @GetMapping("index.html")
    public String index(Model model) {
        model.addAttribute("name", "Bugkit");
        return "Index";
    }

    @GetMapping("FriendList.html")
    public String friendList(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user");
        List<Users> users = usersMapper.selectFriends(user.getEmail());
        model.addAttribute("friends", users);
        return "FriendList";
    }

    @GetMapping("GameLibrary.html")
    public String gameLibrary(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user");
        List<Games> games = gamesMapper.selectPlayedGames(user.getEmail());
        List<Games> allGames = gamesMapper.selectGames();
        model.addAttribute("games", games);
        model.addAttribute("allGames", allGames);
        return "GameLibrary";
    }


}
