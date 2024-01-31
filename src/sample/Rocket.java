package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Rocket extends Weapon {
    private final int dam = 10;
//    private TranslateTransition tt;
//    ImageView imageView;
//    Image im;
//    @FXML
//    private ImageView fxcid;

    public Rocket(String s, ImageView i , ImageView hero_playscreen) {
        super(s,10,i,hero_playscreen);

        im = new Image(getClass().getResourceAsStream("../IMAGES/rocket.png"));
        imageView = new ImageView(im);
        imageView.setImage(im);
        imageView.setFitHeight(40);
        imageView.setFitWidth(20);
        imageView.setRotate(90);
        imageView.setLayoutX(hero_playscreen.getBoundsInParent().getCenterX());
        imageView.setLayoutY(hero_playscreen.getBoundsInParent().getCenterY() - 24);

        fxcid = imageView;

    }

    public void shoot(){
        this.set_operating(true);
//        tt = new TranslateTransition();
        tt.setNode(this.fxcid);
        tt.setDuration(Duration.millis(1000));
        tt.setByX(800);
        tt.setAutoReverse(false);
        tt.setCycleCount(1);
        tt.play();
//        System.out.println(tt.getStatus());
//        sout(tt.getStatus());
    }
}
