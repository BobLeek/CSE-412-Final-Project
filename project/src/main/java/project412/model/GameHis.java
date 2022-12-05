/*
CSE 412 Final Project
Due: 12/4/22
Michael Payne
Yue Fang
Jesus Perez
 */
package project412.model;

import java.io.Serializable;

/**
 * 
 * @TableName game_his
 */
public class GameHis implements Serializable {
    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String gameName;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * 
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GameHis other = (GameHis) that;
        return (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getGameName() == null ? other.getGameName() == null : this.getGameName().equals(other.getGameName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getGameName() == null) ? 0 : getGameName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", email=").append(email);
        sb.append(", gameName=").append(gameName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}