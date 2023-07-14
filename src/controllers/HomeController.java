package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.DataCenter;
import model.MainContentHelper;
import model.User;
import model.Utilities;

public class HomeController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button homeBtn;

    @FXML
    private Label label;

    @FXML
    private Button followingBtn;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private Button profileBtn;

    @FXML
    private Button logOutBtn;

    @SuppressWarnings("unused")
    private User currentUser;

    public HomeController() {
    }

    public void initialize() {
        DataCenter.getInstance();
        currentUser = DataCenter.getInstance().getUserCenter().getCurrentUser();
        PostFeedController postFeed = MainContentHelper.loadContent(mainContent, MainContentHelper.PostFeedScene);
        postFeed.showPostsMainContent(DataCenter.getInstance().getPostCenter().getPostList());
        postFeed.setHomeController(this);
    }

    @FXML
    void homeBtnOnAction(ActionEvent event) {
        PostFeedController postFeed = MainContentHelper.loadContent(mainContent, MainContentHelper.PostFeedScene);
        postFeed.showPostsMainContent(DataCenter.getInstance().getPostCenter().getPostList());
        postFeed.setHomeController(this);
    }

    @FXML
    void followingBtnOnAction(ActionEvent event) {
        PostFeedFollowingController postFeedFollowing = MainContentHelper.loadContent(mainContent,
                MainContentHelper.PostFeedFollowingScene);
        postFeedFollowing.setHomeController(this);
    }

    @FXML
    void profileBtnOnAction(ActionEvent event) {
        ProfileController profileController = MainContentHelper.loadContent(mainContent,
                MainContentHelper.ProfileScene);
        profileController.setHomeController(this);
    }

    @FXML
    void logOutBtnOnAction(ActionEvent event) {
        logOut();
        MainContentHelper sceneChange = new MainContentHelper();
        sceneChange.changeScene(MainContentHelper.SignInScene, event);
    }

    public void logOut() {
        currentUser = null;
        Utilities.backupDataCenter();
    }

    public AnchorPane getMainContent() {
        return mainContent;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
}
