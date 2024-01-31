package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.util.ArrayList;

public class Green_Orc extends Orc implements Collision{
    private TranslateTransition tt;
    @FXML
    private ImageView fxcid;
    public Green_Orc(int h,Coin c,int coll_dis,int height,ImageView i){
        super(h,c,coll_dis,height,i);
//        this.fxcid=i;
//        tt = new TranslateTransition();
//        tt.setNode(i);
//        tt.setDuration(Duration.seconds(1));
//        tt.setByY(150);
//        tt.setAutoReverse(false);
//        tt.setCycleCount(1);
    }

//    public TranslateTransition get_tt(){
//        return this.tt;
//    }
//    public ImageView get_fxcid(){
//        return this.fxcid;
//    }


//    public void collision(TranslateTransition tt , ImageView orc_collided , ArrayList<ImageView> islands){
////        System.out.println(orc_collided.getBoundsInParent().getCenterY());
//        boolean check = false;
////        tt.setNode(orc_collided);
//        for (int i = 0; i < islands.size(); i++) {
//            if(orc_collided.getBoundsInParent().intersects(islands.get(i).getBoundsInParent())) {
////                c_collided.getBoundsInParent().getCenterY() - islands.get(i).getBoundsInParent().getCenterY()) - orc_collided.getBoundsInParent().getHeight()/2 - islands.get(i).getBoundsInParent().getHeight()/2) < 0){
//                    tt.pause();
//
//                    check = true;
////                }
////
//            }
//
//        }
//        if(check == false) {
//                    tt.play();
//                }

//        if(orc_collided.getBoundsInParent().intersects(islands.get(0).getBoundsInParent())) {
//                tt.pause();
//                System.out.println("colll\n");
//            }
////            else {
////                tt.play();
////            }
//        else if(orc_collided.getBoundsInParent().intersects(islands.get(1).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(2).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(3).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(4).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(5).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        } if(orc_collided.getBoundsInParent().intersects(islands.get(6).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(7).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(8).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }
//        if(orc_collided.getBoundsInParent().intersects(islands.get(9).getBoundsInParent())) {
//            tt.pause();
//            System.out.println("colll\n");
//        }
//        else {
//            tt.play();
//        }








//    }
}
