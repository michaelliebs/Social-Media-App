package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.DataCenter;
import model.MainContentHelper;
import model.User;

public class SignInController {
    @FXML
    private TextField passwordField;

    @FXML
    private Text textArea;

    @FXML
    private TextField usernameField;

    @FXML
    private Button signInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    public void initialize() {
        DataCenter.getInstance();
    }

    @FXML
    void signInBtnOnAction(ActionEvent event) {
        User user = DataCenter.getInstance().getUserCenter().getUser(usernameField.getText());
        if (user != null && user.getPassword().equals(passwordField.getText())) {
            DataCenter.getInstance().getUserCenter().setCurrentUser(user);
            MainContentHelper sceneChange = new MainContentHelper();
            sceneChange.changeScene(MainContentHelper.HomeScene, event);
            clearFields();
        } else {
            textArea.setText("Wrong credentials. Try again.");
            clearFields();
        }
    }

    @FXML
    void signUpBtnOnAction(ActionEvent event) {
        MainContentHelper sceneChange = new MainContentHelper();
        sceneChange.changeScene(MainContentHelper.SignUpScene, event);
    }

    public void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }
}
