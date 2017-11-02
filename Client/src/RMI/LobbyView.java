/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * FXML Controller class
 *
 * @author vulst
 */
public class LobbyView implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView waitingGames;

    @FXML
    private ListView lastPlayedGames;

    @FXML
    private ListView bestPlayers;
    
    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize");
        //achtergrond zetten van het spel
        BackgroundImage myBI = new BackgroundImage(new Image("/Cards/background.jpg", 1200, 800, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        anchor.setBackground(new Background(myBI));
    }

}
