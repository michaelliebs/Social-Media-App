package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.DataCenter;
import model.User;
import model.UserCenter;
import model.Utilities;
import model.MainContentHelper;

public class SignUpController {
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Text textArea;

    @FXML
    private TextField usernameField;

    @FXML
    private Button backBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    public void initialize() {
    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        MainContentHelper sceneChange = new MainContentHelper();
        sceneChange.changeScene(MainContentHelper.SignInScene, event);
    }

    @FXML
    void signUpBtnOnAction(ActionEvent event) {
        if (DataCenter.getInstance().getUserCenter().containsUser(usernameField.getText())
                || !UserCenter.isPasswordValid(passwordField.getText())) {
            clearFields();
            textArea.setText("Something went wrong. Try again.");
        } else {
            DataCenter.getInstance().getUserCenter()
                    .insert(new User(usernameField.getText(), passwordField.getText(), emailField.getText()));
            Utilities.backupDataCenter();
            clearFields();
            MainContentHelper sceneChange = new MainContentHelper();
            sceneChange.changeScene(MainContentHelper.SignInScene, event);
        }
    }

    public void clearFields() {
        usernameField.clear();
        passwordField.clear();
        emailField.clear();
    }
}
