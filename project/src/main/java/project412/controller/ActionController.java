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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ActionController {

    @Resource
    GamesMapper gamesMapper;
    @Resource
    UsersMapper usersMapper;


    @GetMapping("searchGame")
    public String searchGame(HttpSession session, Model model, String game, String error) {
        List<Users> users = gamesMapper.selectPlayedGameUsers(game);
        model.addAttribute("users", users);
        session.setAttribute("key", game);
        if (!StringUtils.isEmpty(error)) {
            model.addAttribute("error", error);
        }
        return "GameSearchResult";
    }

    @GetMapping("addFriend")
    public String addFriend(HttpSession session, Model model, String email) {
        System.out.println("add: " + email);
        Users user = (Users) session.getAttribute("user");
        if (user.getEmail().equals(email)) {
            return "redirect:searchGame?game=" + session.getAttribute("key") + "&error=" + "Cannot add yourself as friend.";
        }
        if(usersMapper.selectCount(user.getEmail(), email) == 1){
            return "redirect:searchGame?game=" + session.getAttribute("key") + "&error=" + "You are friends already.";
        }
        usersMapper.addFriend(user.getEmail(), email);
        List<Users> friends = usersMapper.selectFriends(user.getEmail());
        model.addAttribute("friends", friends);
        return "redirect:FriendList.html";
    }

    @GetMapping("removeFriend")
    public String removeFriend(HttpSession session, Model model, String email) {
        System.out.println("remove: " + email);
        Users user = (Users) session.getAttribute("user");
        usersMapper.removeFriend(user.getEmail(), email);
        List<Users> friends = usersMapper.selectFriends(user.getEmail());
        model.addAttribute("friends", friends);
        return "redirect:FriendList.html";
    }

    @GetMapping("addGame")
    public String addGame(HttpSession session, Model model, String gameName) {
        Users user = (Users) session.getAttribute("user");
        List<Games> playedGames = gamesMapper.selectPlayedGames(user.getEmail());
        if (playedGames != null) {
            Set<String> set = playedGames.stream().map(Games::getGameName).collect(Collectors.toSet());
            if (set.contains(gameName)) {
                model.addAttribute("error", gameName + " is already in your game library");
                return "forward:GameLibrary.html";
            }
        }
        gamesMapper.addGame(user.getEmail(), gameName);
        List<Games> games = gamesMapper.selectPlayedGames(user.getEmail());
        model.addAttribute("games", games);
        return "redirect:GameLibrary.html";
    }

    @GetMapping("removeGame")
    public String removeGame(HttpSession session, Model model, String gameName) {
        System.out.println("remove: " + gameName);
        Users user = (Users) session.getAttribute("user");
        gamesMapper.removeGame(user.getEmail(), gameName);
        List<Games> games = gamesMapper.selectPlayedGames(user.getEmail());
        model.addAttribute("games", games);
        return "redirect:GameLibrary.html";
    }
}
