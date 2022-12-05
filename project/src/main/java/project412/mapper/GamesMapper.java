/*
CSE 412 Final Project
Due: 12/4/22
Michael Payne
Yue Fang
Jesus Perez
 */
package project412.mapper;

import project412.model.Games;
import project412.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GamesMapper {

    List<Users> selectPlayedGameUsers(@Param("gameName") String gameName);

    List<Games> selectPlayedGames(@Param("email") String email);

    void addGame(@Param("email") String email,@Param("gameName") String gameName);

    void removeGame(@Param("email") String email,@Param("gameName") String gameName);

    List<Games> selectGames();

}




