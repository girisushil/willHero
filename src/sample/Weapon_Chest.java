package sample;

import javafx.scene.transform.Translate;

public class Weapon_Chest extends Treasure {
    private Weapon w;
    private String name;
    private boolean if_occupied;

    public Weapon_Chest(String s,Weapon e){
        super(s);
        this.if_occupied=false;
        this.w=e;
    }
    public boolean if_occupied_true(){
        return this.if_occupied;
    }
    public void set_if_occupied(boolean y){
        this.if_occupied=y;
    }
}
