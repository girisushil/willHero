package sample;


import javafx.scene.image.ImageView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game{

    private User user;
    private int High_Score_Till;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private long SerialUID;
    private ArrayList<Orc> orc_list;
    private ArrayList<Weapon> weapon_in_game;
    private ArrayList<Platform> platforms;
    private ArrayList<Treasure> treasure_list;

    public Game(){
        // intialize data here
        orc_list=new ArrayList<>();
        weapon_in_game = new ArrayList<>();

    }


//    public void serialize(Data_Save ds){
//        ds.saveGame(this);
//    }
    public void enter_screen(){
// write code here
    }
    public void play(){
// write code here
    }
    public int view_igh_score(){
        return 0; // need to wtrite code here temp code written here
    }
    public void pause(){
        // write code here
    }
    public void resume(){
        //write code here
    }
    public void restart(){
        // write code here
    }
    public void load_game(){
        // write code here
    }
    public void exit_to_main_menu(){
        // write code here
    }

    public  ArrayList<Orc> get_orc_list(){
        return this.orc_list;
    }
    public  ArrayList<Weapon> get_weapon_list(){
        return this.weapon_in_game;
    }

    public void add_orc(Orc o ){
        orc_list.add(o);
    }

    public void add_weapon(Weapon w){weapon_in_game.add(w);}

    public void remove_weapon(Weapon w){
        this.weapon_in_game.remove(w);
    }
    public void remove_orc(Orc o){
        this.weapon_in_game.remove(o);
    }


}
