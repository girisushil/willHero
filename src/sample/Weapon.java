package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.image.ImageView;


public class Weapon extends Game_Objects{
    private String name;
    protected int damage;
    protected boolean if_operating;
    protected TranslateTransition tt;
    ImageView imageView;
    Image im;
    @FXML
    protected ImageView fxcid;


    public Weapon(String s,int dam , ImageView i ,ImageView hero_playscreen){
        this.damage=dam;
        this.if_operating=false;
        this.fxcid = i;
        tt = new TranslateTransition();
    }


    public void use_weapon(AnchorPane ap){
        this.set_operating(false);
        ap.getChildren().add(this.get_imageview());

//        tt.play();
    }
    public void shoot(){
        this.set_operating(true);

        tt.setNode(this.fxcid);
        tt.setDuration(Duration.millis(1000));
        tt.setByX(800);
        tt.setAutoReverse(false);
        tt.setCycleCount(1);
        tt.play();
//        System.out.println(tt.getStatus());
//        sout(tt.getStatus());
    }
    public String get_tt_status(){
        return tt.getStatus().toString();
    }
    public  void  destroy(Game g){
        this.set_operating(false);
        g.remove_weapon(this);
    }
    public void upgrade_weapon(){
        this.damage += 10;
    }

    public ImageView get_imageview(){
        return  this.imageView;
    }
    public int get_damage(){
        return this.damage;
    }
    public boolean collision(ImageView orc , Game g ){
        if(this.imageView.getBoundsInParent().intersects(orc.getBoundsInParent())){
//            System.out.println("collid
//            this.destroy(g);
            return true;
        }
        return false;
    }
    public boolean get_operating(){
        return this.if_operating;
    }
    public void set_operating(boolean b){
//        Image im = new Image(getClass().getResourceAsStream("../IMAGES/rocket.png"));
//        if(b==true)
            this.imageView.setVisible(b);
//        if(b==false) this.fxcid.setImage(null);
        this.if_operating = b;
    }

}
