package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Pause_Screen_Controller {
    // 2020139
    @FXML
    private AnchorPane GameMenuRoot;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button Main_menu_button;

    @FXML
    private Button save_button;

    @FXML
    private Button restart_button;

    private Data_Record data;
    public static Hero hero_will ;
    private static int CoinCount;
    private static ArrayList<Orc> all_orcs;

    @FXML
    public void initData(AnchorPane gamePlayRoot,Data_Record d, int sCount, Hero h_will, ArrayList<Orc> orcs){
        this.anchorPane=gamePlayRoot;

        this.data=d;
        CoinCount=sCount;
        hero_will=h_will;
        all_orcs=orcs;
    }

//    @FXML
//    void restartGame(ActionEvent event) throws IOException {
//        Play_Screen_Controller.gameStatus = false;
////        GamePlayController.endAnimations();
//        //System.out.println("restart called");
//        Stage stage = (Stage) restart_button.getScene().getWindow();
//        stage.close();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Play_Screen.fxml"));
//        AnchorPane game=fxmlLoader.load();
//        Play_Screen_Controller controller = fxmlLoader.<Play_Screen_Controller>getController();
//        data=new Data_Record();
//        controller.initData(data);
//
//        anchorPane.getChildren().setAll(game);
//    }

    @FXML
    void saveGame(ActionEvent event) throws IOException {
        Play_Screen_Controller.gameStatus = false;
        data.update_game(CoinCount,hero_will,all_orcs);
        Main.getDatabase().removeData(data);
        data.saveGame();
//        Main.getDatabase().setMaxLevel(levelNumber);

    }

//    @FXML
//    void showMainMenu(ActionEvent event) throws IOException {
//        Play_Screen_Controller.gameStatus = false;
//        //Play_Screen_Controller.endAnimations();
//        AnchorPane pane= FXMLLoader.load(getClass().getResource("Game_Screen.fxml"));
//        anchorPane.getChildren().setAll(pane);
//        Stage stage = (Stage) restart_button.getScene().getWindow();
//        stage.close();
//    }



    // This is old working code to work upon
    public void switch_to_main_menuscreen(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Game_Screen.fxml"));
        Stage stage=(Stage)(((Node)e.getSource()).getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchto_play_againscreen(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Play_Screen.fxml"));
        Stage stage=(Stage)(((Node)e.getSource()).getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    // 2020139 writing new scheme code to save restart and resume data flow


}
