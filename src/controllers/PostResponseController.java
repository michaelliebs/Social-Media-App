package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javafx.application.Platform;
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

public class PostResponseController {

    @FXML
    private TextArea postContent;

    @FXML
    private TextArea replyArea;

    @FXML
    private Label dateLabel;
    
    @FXML
    private Button profileBtn;
    
    @FXML
    private Button replyBtn;

    @FXML
    private TilePane tilePane;

    private HomeController homeController;
    private PostResponseController postResponseController;
    @SuppressWarnings("unused")
    private User currentUser;
    private Post post;

    public PostResponseController() {
    }

    public void initialize() {
        currentUser = DataCenter.getInstance().getUserCenter().getCurrentUser();
        Platform.runLater(() -> {
            postResponseController.showResponsesMainContent(post.getResponses());
        });
        postContent.setText(post.getContent());
    }
    
    @FXML
    void replyBtnOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void profileBtnOnAction(ActionEvent event) {
        
    }
    
    public void setPostContent(Post post) {
        this.post = post;
        postContent.setText(post.getContent());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy h:mm:ss aa");
        dateLabel.setText(df.format(post.getPostDate()));
        profileBtn.setText("@" + post.getCreator().getUsername());
    }
    
    public void setPost(Post post) {
        this.post = post;
    }

    public void showResponsesMainContent(LinkedList<Post> responses) {
        MainContentHelper.responsesLatestOneOnBottom(responses, tilePane, homeController);
    }

    public void setPostResponseController(PostResponseController postResponseController) {
        this.postResponseController = postResponseController;
    }
    
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
