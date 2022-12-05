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
 * @TableName friends
 */
public class Friends implements Serializable {
    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String friendEmail;

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
    public String getFriendEmail() {
        return friendEmail;
    }

    /**
     * 
     */
    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
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
        Friends other = (Friends) that;
        return (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getFriendEmail() == null ? other.getFriendEmail() == null : this.getFriendEmail().equals(other.getFriendEmail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getFriendEmail() == null) ? 0 : getFriendEmail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", email=").append(email);
        sb.append(", friendEmail=").append(friendEmail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}