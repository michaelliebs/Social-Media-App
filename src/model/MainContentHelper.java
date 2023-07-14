package model;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import controllers.HomeController;
import controllers.PostController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainContentHelper {
    public static final String SignInScene = "/views/SignIn.fxml";
    public static final String SignUpScene = "/views/SignUp.fxml";
    public static final String HomeScene = "/views/Home.fxml";
    public static final String NewPostScene = "/views/NewPost.fxml";
    public static final String PostFeedScene = "/views/PostFeed.fxml";
    public static final String PostResponseScene = "/views/PostResponse.fxml";
    public static final String PostFeedFollowingScene = "/views/PostFeedFollowing.fxml";
    public static final String ProfileScene = "/views/Profile.fxml";
    public static final String ProfileNotCurrentUserScene = "/views/ProfileNotCurrentUser.fxml";

    public void changeScene(String fileName, ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(fileName));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showPosts(Post post, TilePane tilePane, HomeController homeController) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Utilities.class.getResource("/views/Post.fxml"));
            AnchorPane ap = fxmlLoader.load();
            PostController pc = fxmlLoader.getController();
            pc.setPostContent(post);
            pc.setHomeController(homeController);
            tilePane.getChildren().add(ap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void postsMostRecentOnTop(LinkedList<Post> posts, TilePane tilePane, HomeController homeController) {
        Iterator<Post> postItr = posts.descendingIterator();
        while (postItr.hasNext()) {
            Post post = postItr.next();
            showPosts(post, tilePane, homeController);
        }
    }

    public static void postsMostRecentOnTopFollowingPosts(LinkedList<Post> posts, TilePane tilePane,
            HomeController homeController) {
        Iterator<Post> itr = posts.descendingIterator();
        while (itr.hasNext()) {
            Post post = itr.next();
            if (DataCenter.getInstance().getUserCenter().getCurrentUser().getFollowing()
                    .get(post.getCreator().getUsername()) != null) {
                showPosts(post, tilePane, homeController);
            }
        }
    }

    public static void postsMostRecentOnTopFollowing(LinkedList<Post> posts, TilePane tilePane,
            HomeController homeController) {
        Iterator<Post> itr = posts.descendingIterator();
        while (itr.hasNext()) {
            Post post = itr.next();
            if (DataCenter.getInstance().getUserCenter().getCurrentUser().getFollowing()
                    .get(post.getCreator().getUsername()) != null) {
                showPosts(post, tilePane, homeController);
            }
        }
    }

    public static void responsesLatestOneOnBottom(LinkedList<Post> responses, TilePane tilePane,
            HomeController homeController) {
        Iterator<Post> responseItr = responses.iterator();
        while (responseItr.hasNext()) {
            if (responses == null) {
                break;
            }
            Post response = responseItr.next();
            showPosts(response, tilePane, homeController);
        }
    }

    public static <T> T loadContent(AnchorPane mainContent, String fileName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainContentHelper.class.getResource(fileName));
            AnchorPane ap = fxmlLoader.load();
            mainContent.getChildren().clear();
            mainContent.getChildren().add(ap);
            return fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
