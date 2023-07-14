package controllers;

import java.util.LinkedList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import model.DataCenter;
import model.MainContentHelper;
import model.Post;
import model.User;

public class ProfileController {

    @FXML
    private Label followersLabel;

    @FXML
    private Label followingLabel;

    @FXML
    private Label profileLabel;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;

    private User currentUser;
    private HomeController homeController;

    public ProfileController() {
    }

    public void initialize() {
        currentUser = DataCenter.getInstance().getUserCenter().getCurrentUser();
        showPostsMainContent(currentUser.getUserPosts());
    }

    public void showPostsMainContent(LinkedList<Post> posts) {
        profileLabel.setText("@" + currentUser.getUsername());
        followersLabel.setText("Followers: " + currentUser.getFollowers().size());
        followingLabel.setText("Following: " + currentUser.getFollowing().size());
        MainContentHelper.postsMostRecentOnTop(posts, tilePane, homeController);
    }

    public void setProfileUser(User profileUser) {
        this.currentUser = DataCenter.getInstance().getUserCenter().getUser(profileUser.getUsername());
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

}
