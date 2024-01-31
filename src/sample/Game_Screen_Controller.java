package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game_Screen_Controller implements Initializable {

//    // 2020139 new code scheme
    @FXML
    private AnchorPane mainRoot;
//
    @FXML
    private Button play_button;
//
//    @FXML
//    private Button loadGame_button;
//
//    @FXML
//    void showSavedGames(MouseEvent event) throws Exception{
//        AnchorPane pane= FXMLLoader.load(getClass().getResource("loadGame_Screen.fxml")); // creating new fxml
//        mainRoot.getChildren().setAll(pane);
//    }
//
    @FXML
    void startGame(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Play_Screen.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Play_Screen_Controller controller = fxmlLoader.<Play_Screen_Controller>getController();
        controller.initData(new Data_Record()); //need to remove added just to check
        mainRoot.getChildren().setAll(pane);

    }

    // older code written

//    private Stage stage;
//    private Scene scene;
//    private Parent root;

//    public void switchtoplayscreen(ActionEvent e) throws IOException {
//         root = FXMLLoader.load(getClass().getResource("Play_Screen.fxml"));
//        stage=(Stage)(((Node)e.getSource()).getScene().getWindow());
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }  //commented to see the neweer code works 2020139
    @FXML
    private Button exit_button;
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Game");
        alert.setHeaderText("Closing The Game");
        alert.setContentText("Are you Sure To Continue ?");
        if(alert.showAndWait().get()== ButtonType.OK){
            Stage stage = (Stage) exit_button.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    private ImageView hero_gamepage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate=new TranslateTransition();
        translate.setNode(hero_gamepage);
        translate.setByY(100);
        translate.setFromY(-100);
        translate.setDuration(Duration.millis(600));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setAutoReverse(true);
        translate.play();

    }
}
