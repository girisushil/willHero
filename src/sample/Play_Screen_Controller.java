package sample;


import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;


public class Play_Screen_Controller implements Initializable {

//    // 2020139 new code scheme
////    @FXML
////    private AnchorPane anchorPane;  already defined in the scope
    @FXML
    private Label CoinCountLabel;  // newly added to this
    @FXML
    private Button pause_button; //already defined

    private static int CoinCount;
    public static boolean gameStatus;
    private static Label CoinCountDisplay;
    public static ArrayList<Orc> allorcs;
    public static Hero will_hero;
    private static Data_Record d;
    public static int wonGamestat = 0;
    public static double hero_dis_covered = 0;
//
//    public void initialize() throws Exception {
//      // if not worked according to the intial scrren music background then will provid eit the same rtexture of code.
//
//        gameStatus = true;
//        CoinCountDisplay= CoinCountLabel;
//        allorcs = new ArrayList<Orc>();
//        will_hero = new Hero(5);  // randomly provided the jump height
//    }
//
//
    @FXML
    public void initData(Data_Record d) {
        wonGamestat = 0;
        will_hero = d.gethero();
        allorcs = d.getorcs();
        CoinCount=d.getCoinCount();
//        animationTimelines = new ArrayList<Timeline>();
//        LevelMenuController.status = d.getStatus();
//        startAnimations(rand);       need to later check what these are meant for
        CoinCountDisplay.setText(String.valueOf(CoinCount));
        this.d=d;
    }
    @FXML
    void loadPauseMenu(ActionEvent event) throws IOException {  //changed to see if mouse eveent not worked
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pause_menu.fxml"));
        Parent gameMenu = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        Pause_Screen_Controller controller = fxmlLoader.<Pause_Screen_Controller>getController();
        controller.initData(anchorPane,d,CoinCount,will_hero, allorcs);
        stage.show();
    } // COMMENTED TO CHECK IF OLER IS CORRECTLY WORKING OR NOT.

    public static void updateCoinCount(int val) {
        CoinCount+=val;     // will see if any use adding just for help
        getCoinCountLabel().setText(Integer.toString(CoinCount));
    }

    public static Label getCoinCountLabel() {   // will see if of any use.
        return(CoinCountDisplay);
    }
//
//    public void gameLost() throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("End_Screen.fxml"));
//        AnchorPane pane=fxmlLoader.load();
//        Over_Screen_Controller controller = fxmlLoader.<Over_Screen_Controller>getController();
////        controller.initData(levelNumber, false,d);
//        anchorPane.getChildren().setAll(pane);     // now need to see about the end game screen controller
//
//    }
//    public void gameWon() throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("End_Screen.fxml"));
//        AnchorPane pane=fxmlLoader.load();
//        Over_Screen_Controller controller = fxmlLoader.<Over_Screen_Controller>getController();
////        controller.initData(levelNumber, true,d);
//        anchorPane.getChildren().setAll(pane);
//
//    }
//


// old code written here
    @FXML
    private ImageView hero_playscreen;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView gorc1;
    @FXML
    private ImageView island1;
    @FXML
    private ImageView island2;
    @FXML
    private ImageView island3;
    @FXML
    private ImageView island4;
    @FXML
    private ImageView island5;
    @FXML
    private ImageView island6;
    @FXML
    private ImageView island7;
    @FXML
    private ImageView island8;
    @FXML
    private ImageView island9;
    @FXML
    private ImageView island10;
    @FXML
    private ImageView island11;
    @FXML
    private ImageView island12;
    @FXML
    private ImageView island13;

    @FXML
    private ImageView rorc1;
    @FXML
    private ImageView rorc2;
    @FXML
    private ImageView rorc3;
    @FXML
    private ImageView rorc4;
    @FXML
    private ImageView rorc5;
    @FXML
    private ImageView rorc6;
    @FXML
    private ImageView rorc7;
    @FXML
    private ImageView rorc8;
    @FXML
    private ImageView gorc2;
    @FXML
    private ImageView gorc3;
    @FXML
    private ImageView gorc4;
    @FXML
    private ImageView gorc5;
    @FXML
    private ImageView boss_orc;
    @FXML
    private ImageView abyss1;
    @FXML
    private ImageView abyss2;
    @FXML
    private ImageView abyss3;
    @FXML
    private ImageView abyss4;
    @FXML
    private ImageView abyss5;
    @FXML
    private ImageView abyss6;
    @FXML
    private ImageView abyss7;


    @FXML
    private ImageView w1;

    private Game game = new Game();
    private ArrayList<ImageView> islands = new ArrayList<>();
    private ArrayList<ImageView> abyss = new ArrayList<>();

    private TranslateTransition translate_position = new TranslateTransition();
    private TranslateTransition translate_pos = new TranslateTransition();
    TranslateTransition gravity = new TranslateTransition();
    TranslateTransition gravity1 = new TranslateTransition();
    TranslateTransition gravity_new = new TranslateTransition();
    private Hero hero = new Hero(4);
//    private Green_Orc green_orc = new Green_Orc(4,new Coin(5),4,5);
//    private Green_Orc red_orc = new Green_Orc(4,new Coin(5),4,5);
//    private ArrayList<Gravity> gravities = new ArrayList<Gravity>();


    AnimationTimer at = new AnimationTimer() {
        @Override
        public void handle(long time) {


            for (int i = 0; i < game.get_orc_list().size(); i++) {
                hero.collision(translate_position , game.get_orc_list().get(i).get_fxcid() , hero_playscreen);
            }

//            hero.collision(translate_position , rorc1 , hero_playscreen);

            hero.collision(translate_pos , gravity1 , hero_playscreen , islands);
            hero.collision_ab(island1 ,translate_pos , gravity1 , hero_playscreen , abyss);
            if(hero.lost() == true){
//                hero.destroy();
                hero_playscreen.setVisible(false);
                return;

            }


            for (int j = 0; j < game.get_weapon_list().size(); j++) {
                for (int i = 0; i < game.get_orc_list().size(); i++) {
// changed to check something
                    if(game.get_weapon_list().get(j).collision(game.get_orc_list().get(i).get_fxcid() , game)){
                        game.get_orc_list().get(i).damage(game.get_weapon_list().get(j).get_damage());
                        if(game.get_orc_list().get(i).get_health() <= 0){
                            game.get_orc_list().get(i).destroy(game );
                            i-=2;
                        }
                        game.get_weapon_list().get(j).destroy(game);
                        j-=2;

                    }


                    if(game.get_weapon_list().get(j).get_tt_status().equals("STOPPED")){
                        game.get_weapon_list().get(j).destroy(game);
                    }

//                    game.get_weapon_list().remove(0);

                }
            }


//            gravity1.play();
//            System.out.println(islands.get(0).getLayoutX());
//            System.out.println(hero_playscreen.getBoundsInParent().getCenterX());
            for (int i = 0; i < game.get_orc_list().size(); i++) {
//                gravity.setNode(game.get_orc_list().get(i));
//                hero.collision(translate_pos , gravity1 , hero_playscreen , islands);
//                hero.collision_ab(translate_pos,gravity1, hero_playscreen , abyss);
                game.get_orc_list().get(i).collision(game.get_orc_list().get(i).get_tt() , game.get_orc_list().get(i).get_fxcid() , islands);
                game.get_orc_list().get(i).collision_ab(game.get_orc_list().get(i).get_tt() ,gravity1, game.get_orc_list().get(i).get_fxcid() , abyss);
//                red_orc.collision(gravity_new , game.get_orc_list().get(1) , islands);
            }

//            if(hero_playscreen.getBoundsInParent().intersects(gorc1.getBoundsInParent())) {
//                System.out.println("colll\n");
//            }
        }
    };

//    @FXML
//    private Button pause_button;
//    public void switchtopausescreen(ActionEvent e) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Pause_Menu.fxml"));
//        Stage stage=(Stage)(((Node)e.getSource()).getScene().getWindow());
//        Scene scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }  //commented to check something older correct code before adding serialization

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* new code added here* by 2020139*/
        gameStatus = true;  // NEW CODE ADDED
        CoinCountDisplay= CoinCountLabel; // NEW CODE ADDED
        allorcs = new ArrayList<Orc>();  // NEW CODE ADDED
        will_hero = new Hero(5);  // randomly provided the jump height NEW CODE ADDED
        Hero h=new Hero(20);
        AtomicInteger step_counter= new AtomicInteger();
        System.out.println(gorc1.getLayoutY());
        System.out.println(island4.getLayoutY());

//        abyss.add(abyss1);
        islands.add(island1);
        islands.add(island2);
        islands.add(island3);
        islands.add(island4);
        islands.add(island5);
        islands.add(island6);
        islands.add(island7);
        islands.add(island8);
        islands.add(island9);
        islands.add(island10);
        islands.add(island11);
        islands.add(island12);
        islands.add(island13);

        abyss.add(abyss1);
        abyss.add(abyss2);
        abyss.add(abyss3);
        abyss.add(abyss4);
        abyss.add(abyss5);
        abyss.add(abyss6);
        abyss.add(abyss7);
//        abyss.add(abyss);

        game.add_orc(new Green_Orc(10,new Coin(5),4,5,gorc1));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc1));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc2));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc3));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc4));
        game.add_orc(new Green_Orc(10,new Coin(5),4,5,gorc2));
        game.add_orc(new Green_Orc(10,new Coin(5),4,5,gorc3));
        game.add_orc(new Green_Orc(10,new Coin(5),4,5,gorc4));
        game.add_orc(new Green_Orc(10,new Coin(5),4,5,gorc5));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc5));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc6));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc7));
        game.add_orc(new Red_Orc(10,new Coin(5),4,5,rorc8));
        game.add_orc(new Boss_Orc(10,new Coin(5),4,5,boss_orc));




//        imageView.setLayoutX(hero_playscreen.getLayoutX());
//        imageView.setLayoutY(hero_playscreen.getLayoutY());
//        island1.setLayoutX(220);

//        anchorPane.getChildren().add(game.get_weapon_list().get(0).get_imageview());

//        w1.setDisable(true);
//        w1.setImage(null);
//        game.get_weapon_list().get(0).set_operating(true);

//        TranslateTransition translate_pos = new TranslateTransition();
        TranslateTransition translate_pos_x = new TranslateTransition();
        TranslateTransition translate_pos1_x = new TranslateTransition();
        TranslateTransition translate_pos2 = new TranslateTransition();
        TranslateTransition anchorpane = new TranslateTransition();


        at.start();



        gravity1.setNode(hero_playscreen);
        gravity1.setDuration(Duration.seconds(5));
        gravity1.setByY(100);
        gravity1.setAutoReverse(false);
        gravity1.setCycleCount(1);



//        int i = 0;
        // handling OnClick event
        anchorPane.addEventFilter(MouseEvent.MOUSE_CLICKED, key_event->{
            translate_pos.pause();
//            i++;
            if(game.get_weapon_list().size() <= 1){
                game.add_weapon(new Rocket("tknife" , w1 , hero_playscreen));
                game.get_weapon_list().get(game.get_weapon_list().size()-1).use_weapon(anchorPane);
                game.get_weapon_list().get(game.get_weapon_list().size()-1).shoot();
//            i++;
            }

//            i++;

            anchorpane.setNode(anchorPane);
            anchorpane.setDuration(Duration.millis(100));
            anchorpane.setByX(-60);
            anchorpane.play();

            translate_pos_x.setNode(hero_playscreen);
            translate_pos_x.setDuration(Duration.millis(10));
            translate_pos_x.setByX(60);
            translate_pos_x.play();

            translate_pos1_x.setNode(pause_button);
            translate_pos1_x.setDuration(Duration.millis(100));
            translate_pos1_x.setByX(60);
            translate_pos1_x.play();

            translate_pos.play();
            // added code by 2020139
            step_counter.getAndIncrement();

        });
    }

}
