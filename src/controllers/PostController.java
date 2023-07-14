package controllers;

// import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
// import javafx.scene.layout.AnchorPane;
// import javafx.stage.Stage;
// import model.DataCenter;
// import model.MainContentHelper;
import model.Post;

public class PostController {

    @FXML
    private TextArea postContent;

    @FXML
    private Button profileBtn;

    @FXML
    private Button replyBtn;

    @FXML
    private Label dateLabel;

    @SuppressWarnings("unused")
    private HomeController homeController;

    public PostController() {
    }

    // @FXML
    // void profileBtnOnAction(ActionEvent event) { // acts as follow button
    //     DataCenter.getInstance().getUserCenter().getCurrentUser().getFollowing()
    //             .put(post.getCreator().getUsername(), post.getCreator());
    //     post.getCreator().getFollowers().add(DataCenter.getInstance().getUserCenter().getCurrentUser());
    //     if (DataCenter.getInstance().getUserCenter().getCurrentUser().getFollowing()
    //             .containsKey(DataCenter.getInstance().getUserCenter().getCurrentUser().getUsername())) { // if current user follows themself
    //         DataCenter.getInstance().getUserCenter().getCurrentUser().getFollowing()
    //                 .remove(DataCenter.getInstance().getUserCenter().getCurrentUser().getUsername());
    //         DataCenter.getInstance().getUserCenter().getCurrentUser().getFollowers()
    //                 .remove(DataCenter.getInstance().getUserCenter().getCurrentUser());
    //     }
    // }

    @FXML
    void profileBtnOnAction(ActionEvent event) {
        // PostFeedController postFeed = MainContentHelper.loadContent(mainContent, MainContentHelper.PostFeedScene);
        // postFeed.showPostsMainContent(DataCenter.getInstance().getPostCenter().getPostList());
        // postFeed.setHomeController(this);
    }

    @FXML
    void replyBtnOnAction(ActionEvent event) {
//        PostResponseController postResponseController = MainContentHelper.loadContent(homeController.getMainContent(),
//                MainContentHelper.PostResponseScene);
//        postResponseController.setPostContent(post);
//        postResponseController.setHomeController(homeController);
    }

    public void setPostContent(Post post) {
        postContent.setText(post.getContent());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy h:mm:ss aa");
        dateLabel.setText(df.format(post.getPostDate()));
        profileBtn.setText("@" + post.getCreator().getUsername());
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
