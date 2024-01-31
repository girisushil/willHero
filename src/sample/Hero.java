package sample;

import com.sun.javafx.scene.ImageViewHelper;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.transform.Translate;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;


public class Hero extends Game_Objects {
    private int total_coins;
    private int jump_height;
    //private Weapon weapon;
    private Helmet helmet;
    private int total_score;
    private boolean has_won;
    private boolean lost;



    public Hero(int height){
        this.has_won=false;
        helmet=new Helmet();
        this.jump_height=height;
        this.total_coins=0;
        this.total_score=0;
        this.lost  = false;
    }
    public void jump(TranslateTransition translate_pos , ImageView hero_playscreen){
        translate_pos.setNode(hero_playscreen);
        translate_pos.setDuration(Duration.seconds(1));
        translate_pos.setByY(-100);
        translate_pos.setAutoReverse(true);
        translate_pos.setCycleCount(2);
        translate_pos.play();
//        translate_pos.pause();
    }
    public boolean lost(){
        return this.lost;
    }
    public void set_lost(boolean b){
        this.lost = b;
    }
//    public void destroy(){
//
//    }



TranslateTransition translate_pos = new TranslateTransition();
    TranslateTransition translate_poss = new TranslateTransition();
    public void collision(TranslateTransition tt1 , TranslateTransition gravity , ImageView hero_playscreen , ArrayList<ImageView> islands) {
//        System.out.println(orc_collided.getBoundsInParent().getCenterY());
        boolean check = false;

        for (int i = 0; i < islands.size(); i++) {

            if(hero_playscreen.getBoundsInParent().intersects(islands.get(i).getBoundsInParent())){
                translate_poss.pause();
                translate_pos.setNode(hero_playscreen);
                translate_pos.setDuration(Duration.seconds(1));
                translate_pos.setByY(-120);
                translate_pos.setAutoReverse(true);
                translate_pos.setCycleCount(2);
                translate_pos.play();


                check = true;
//                this.down(new TranslateTransition() , hero_playscreen);
            }
//
        }

        }
        public void collision_ab(ImageView island , TranslateTransition tt1 , TranslateTransition gravity , ImageView hero_playscreen , ArrayList<ImageView> abyss) {
//        System.out.println(orc_collided.getBoundsInParent().getCenterY());
        boolean check = false;

//            if(hero_playscreen.getBoundsInParent().intersects(is.getBoundsInParent()))
            for (int i = 0; i < abyss.size(); i++) {
                if(hero_playscreen.getBoundsInParent().intersects(abyss.get(i).getBoundsInParent())){
//                gravity.pause();
                    if(hero_playscreen.getBoundsInParent().getCenterY() > island.getBoundsInParent().getCenterY()+70){
                        this.set_lost(true);
                    }
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
//    }

    public void collision(TranslateTransition tt , ImageView orc_collided , ImageView hero_playscreen){
        if(hero_playscreen.getBoundsInParent().intersects(orc_collided.getBoundsInParent())) {
//            System.out.println("colll\n");
//            if(hero_playscreen.getBoundsInParent().getCenterY() >)
            tt.setNode(orc_collided);
            tt.setDuration(Duration.millis(125));
            tt.setByX(150);
            tt.setAutoReverse(false);
            tt.setCycleCount(1);
            tt.play();
        }
    }
    // new code added here by 2020139.
    public void setTotal_score(int s){
        this.total_score=s;
    }
    public int getTotal_score(){
        return this.total_score;
    }

}
