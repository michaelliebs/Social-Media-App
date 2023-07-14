package controllers;

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.HashSet;
import java.util.LinkedList;
// import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import model.DataCenter;
import model.MainContentHelper;
import model.Post;
import model.User;
import model.Utilities;

public class PostFeedController {

    @FXML
    private TilePane tilePane;

    @FXML
    private Button postBtn;

    @FXML
    private TextArea textArea;

    @FXML
    private Label errorMessage;

    private HomeController homeController;
    private User currentUser;

    public PostFeedController() {
    }

    public void initialize() {
        currentUser = DataCenter.getInstance().getUserCenter().getCurrentUser();
    }

    @FXML
    void postBtnOnAction(ActionEvent event) {
        if (!textArea.getText().isEmpty()) {
            Post newPost = new Post(textArea.getText(), currentUser);
            DataCenter.getInstance().getPostCenter().addPost(newPost);
            currentUser.getUserPosts().add(newPost);
            Utilities.backupDataCenter();
            textArea.clear();
            errorMessage.setText("");

        } else {
            errorMessage.setText("The post contents are blank. Try again.");
            textArea.clear();
        }
    }

    public void showPostsMainContent(LinkedList<Post> posts) {
        MainContentHelper.postsMostRecentOnTop(posts, tilePane, homeController);
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
