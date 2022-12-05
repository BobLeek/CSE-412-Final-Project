package project412.mapper;

import project412.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UsersMapper {

    Users selectUser(@Param("email") String email, @Param("password") String password);

    List<Users> selectFriends(@Param("email") String email);

    int selectCount(@Param("email") String email, @Param("friendEmail") String friendEmail);

    void addFriend(@Param("email") String email, @Param("friendEmail") String friendEmail);

    void removeFriend(@Param("email") String email, @Param("friendEmail") String friendEmail);

}




