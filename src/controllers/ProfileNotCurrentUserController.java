package controllers;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import model.DataCenter;
import model.MainContentHelper;
import model.Post;
import model.User;

public class ProfileNotCurrentUserController {

    @FXML
    private Button followBtn;

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
    private User profileUser;
    private HomeController homeController;
    
    public ProfileNotCurrentUserController() {
    }
    
    public void initialize() {
        currentUser = DataCenter.getInstance().getUserCenter().getCurrentUser();
        showPostsMainContent(profileUser.getUserPosts());
    }

  @FXML
  void followBtnOnAction(ActionEvent event) {
      profileUser.getFollowing().put(profileUser.getUsername(), profileUser);
  }
  
  public void showPostsMainContent(LinkedList<Post> posts) {
      profileLabel.setText("@" + currentUser.getUsername());
      followersLabel.setText("Followers: " + currentUser.getFollowers().size());
      followingLabel.setText("Following: " + currentUser.getFollowing().size());
      MainContentHelper.postsMostRecentOnTop(posts, tilePane, homeController);
  }
  
  public void setPostCreator(User profileUser) {
      this.profileUser = profileUser;
  }
    
    public void setProfileUser(User profileUser) {
        this.profileUser = profileUser;
    }
    
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

}
