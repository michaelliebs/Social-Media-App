package model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class UserCenter implements Serializable {
    private static final long serialVersionUID = 1L;
    private User currentUser;
    private TreeMap<String, User> userTree;

    public UserCenter() {
        userTree = new TreeMap<String, User>();
    }

    public void insert(User user) {
        userTree.put(user.getUsername(), user);
    }

    public User removeUser(String username) {
        return userTree.remove(username);
    }

    public User getUser(String username) {
        return userTree.get(username);
    }
    
    public int size() {
        return userTree.size();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static boolean isPasswordValid(String password) {
        boolean isProperLength = false;
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        int passwordLength = 6;
        char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (i > passwordLength) {
                isProperLength = true;
                break;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                isUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                isLowerCase = true;
            } else if (Character.isDigit(ch)) {
                isDigit = true;
                if (password.length() > passwordLength) {
                    isProperLength = true;
                }
                if (isProperLength && isUpperCase && isLowerCase && isDigit == true) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean containsUser(String username) {
        return userTree.containsKey(username);
    }

    public String toString() {
        String str = "";
        for (Map.Entry<String, User> entry : userTree.entrySet()) {
            str += entry.getValue().toString();
        }
        return str;
    }

}
