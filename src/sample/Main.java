package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.media.Media;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public class Main extends Application {

    public static MediaPlayer mediaPlayer;
    private static Data_Class currentd; // need to intialize database class 2020139

    @Override
    public void start(Stage primaryStage) throws Exception{
        Music();  //need to comment out when fianl submission done to add music.
        //deserialize(); // 2020139 not to worry about
        Parent root = FXMLLoader.load(getClass().getResource("Game_Screen.fxml"));
        Image game_icon = new Image(getClass().getResourceAsStream("../IMAGES/Game_Icon.png"));
        primaryStage.getIcons().add(game_icon);
        primaryStage.setTitle("WILL HERO");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static Data_Class getDatabase(){  // 2020139
        return currentd;
    }
    public static void serialize() throws IOException {  // 2020139
        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
            out.writeObject(currentd);
        }
        finally {
            out.close();
            System.exit(0);
        }
    }
    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException{  // 2020139
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("database.txt"));
            currentd=(Data_Class) in.readObject();
            in.close();
        }
        catch (FileNotFoundException e){
            currentd=new Data_Class();
        }
        catch (NullPointerException e) {
            currentd=new Data_Class();
        }
    }


    public void Music() {
        URL u = getClass().getResource("../music/backmusic.wav");
        String s = u.toString();
        Media sound = new Media(s);
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
