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
 * @TableName games
 */
public class Games implements Serializable {
    private String gameName;
    private String gameInfo;

    private static final long serialVersionUID = 1L;
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public String getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(String gameInfo) {
        this.gameInfo = gameInfo;
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
        Games other = (Games) that;
        return (this.getGameName() == null ? other.getGameName() == null : this.getGameName().equals(other.getGameName()))
            && (this.getGameInfo() == null ? other.getGameInfo() == null : this.getGameInfo().equals(other.getGameInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGameName() == null) ? 0 : getGameName().hashCode());
        result = prime * result + ((getGameInfo() == null) ? 0 : getGameInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gameName=").append(gameName);
        sb.append(", gameInfo=").append(gameInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}