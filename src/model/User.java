package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.TreeMap;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;
    private LinkedList<User> followers;
    private TreeMap<String, User> following;
    private LinkedList<Post> userPosts;

    public User(String username, String password, String email) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        followers = new LinkedList<User>();
        following = new TreeMap<String, User>();
        userPosts = new LinkedList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(LinkedList<Post> userPosts) {
        this.userPosts = userPosts;
    }

    public void displayPosts() {
        System.out.println(userPosts.toString() + " ");
    }

    public LinkedList<User> getFollowers() {
        return followers;
    }

    public TreeMap<String, User> getFollowing() {
        return following;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", email=" + email + "]";
    }
}
