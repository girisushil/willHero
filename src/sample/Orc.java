package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public  abstract class Orc extends Game_Objects {
    private int health;
    private boolean if_operating;
    private Coin coins;
    private int collide_distance;
    private int jump_height;
    private Hero hero; // for addition of money to its bank and pushing him back;
    private TranslateTransition tt;
    private TranslateTransition jump;
    @FXML
    private ImageView fxcid;

    public Orc(int h,Coin c,int coll_dis,int height,ImageView i){
        this.coins=c;
        this.collide_distance=coll_dis;
        this.health=h;
        this.jump_height=height;
        this.fxcid=i;
        this.set_operating(true);


        tt = new TranslateTransition();
        tt.setNode(i);
        tt.setDuration(Duration.seconds(1));
        tt.setByY(150);
        tt.setAutoReverse(false);
        tt.setCycleCount(1);


    }

    public TranslateTransition get_tt(){
        return this.tt;
    }
    public ImageView get_fxcid(){
        return this.fxcid;
    }

    public void  damage(int damage){
        this.health -= damage;
    }
    public int get_health(){
        return this.health;
    }
    public  void destroy(Game g ){
        this.set_operating(false);
        g.remove_orc(this);
    }
    public void set_operating(boolean b ){
//        Image im = new Image(getClass().getResourceAsStream("../IMAGES/rocket.png"));
//        if(b==true)
        this.fxcid.setVisible(b);
//        if(b==false) this.fxcid.setImage(null);
        this.if_operating = b;
    }
    TranslateTransition translate_pos = new TranslateTransition();
    TranslateTransition translate_poss = new TranslateTransition();
    public void jump(TranslateTransition translate_pos , ImageView hero_playscreen){
        translate_pos.setNode(hero_playscreen);
        translate_pos.setDuration(Duration.seconds(1));
        translate_pos.setByY(-100);
        translate_pos.setAutoReverse(true);
        translate_pos.setCycleCount(2);
        translate_pos.play();
//        translate_pos.pause();
    }

    public void collision_ab(TranslateTransition tt1 , TranslateTransition gravity , ImageView hero_playscreen , ArrayList<ImageView> abyss) {
//        System.out.println(orc_collided.getBoundsInParent().getCenterY());
        boolean check = false;


        for (int i = 0; i < abyss.size(); i++) {
            if(hero_playscreen.getBoundsInParent().intersects(abyss.get(i).getBoundsInParent())){
//                gravity.pause();
                translate_pos.pause();
                translate_poss.setNode(hero_playscreen);
                translate_poss.setDuration(Duration.seconds(1));
                translate_poss.setByY(100);
                translate_poss.setAutoReverse(false);
                translate_poss.setCycleCount(2);

                translate_poss.play();


                check = true;
//
            }
        }


    }

    public void collision(TranslateTransition tt , ImageView orc_collided , ArrayList<ImageView> islands) {
//        System.out.println(orc_collided.getBoundsInParent().getCenterY());
        boolean check = false;

        for (int i = 0; i < islands.size(); i++) {

            if (orc_collided.getBoundsInParent().intersects(islands.get(i).getBoundsInParent())) {
                translate_poss.pause();
                translate_pos.setNode(orc_collided);
                translate_pos.setDuration(Duration.seconds(1));
                translate_pos.setByY(-120);
                translate_pos.setAutoReverse(true);
                translate_pos.setCycleCount(2);
                translate_pos.play();


                check = true;
//                this.down(new TranslateTransition() , hero_playscreen);
            }
        }}

    public void orc_jump(){

    }
    public boolean if_on_platform(){
    // add code here
        return false;
    }
    public void killed(){
        // enter code here
    }
    public void reduce_health(){
        // enter code here
    }


}

