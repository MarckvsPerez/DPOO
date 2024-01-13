package edu.uoc.uocanoid.view;

import edu.uoc.uocanoid.UOCanoid;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * CreditsViewController class related to "credits.fxml".
 *
 * @author David García Solórzano
 * @version 1.0
 */
public class CreditsViewController {

    @FXML
    private Text creditsText;

    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {

        backButton.setOnAction(event -> {
            try {
                UOCanoid.main.goScene("main");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
