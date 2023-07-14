package controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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

public class PostFeedFollowingController {

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

    public PostFeedFollowingController() {
    }

    public void initialize() {
        currentUser = DataCenter.getInstance().getUserCenter().getCurrentUser();
        showPostsMainContent(DataCenter.getInstance().getPostCenter().getPostList());
    }

    @FXML
    void postBtnOnAction(ActionEvent event) {
//        if(spellCheck(textArea.getText() ) {
//            
//        }
//        
    /*else*/ if (!textArea.getText().isEmpty()) {
            Post newPost = new Post(textArea.getText(), currentUser);
            DataCenter.getInstance().getPostCenter().addPost(newPost);
            Utilities.backupDataCenter();
            textArea.clear();
        } else {
            errorMessage.setText("The post contents are blank. Try again.");
            textArea.clear();
        }
    }
    
    public static LinkedList<String> spellCheck(String commentText) {
        Set<String> dictionary = new HashSet<String>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("dataFolder/dictionary.txt"));
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.toLowerCase().replaceAll("[^a-z']", "");
                dictionary.add(word);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] words = commentText.split("\\s+");

        LinkedList<String> misspelledWords = new LinkedList<String>();
        for (String w : words) {
            w = w.toLowerCase().replaceAll("[^a-z']", "");
            if (!dictionary.contains(w)) {
                misspelledWords.add(w);
            }
        }

        return misspelledWords;
    }

    public void showPostsMainContent(LinkedList<Post> posts) {
        MainContentHelper.postsMostRecentOnTopFollowing(posts, tilePane, homeController);
    }
    
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
