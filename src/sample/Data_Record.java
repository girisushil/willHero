package sample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data_Record implements Serializable {
    private static final long serialVersionUID=42L; // 2020139
    private static int id=0;
    private int gameId;
    private int CoinCount;
    private Hero hero_will;
    private ArrayList<Orc> every_orc;
    private String TimeStamp;

    public Data_Record(){
        id++;
        this.gameId=id;
        this.CoinCount=0;
        this.every_orc = new ArrayList<Orc>();
    }
    public void update_game( int coins,Hero h,ArrayList<Orc> orcs) {
        this.CoinCount = coins;
        this.every_orc = orcs;
        this.hero_will=h;
    }
    public int getCoinCount() {
        return this.CoinCount;
    }
    public String geTimeStamp() {
        return this.TimeStamp;
    }
    public ArrayList<Orc> getorcs() {
        return this.every_orc;
    }
    public Hero gethero() {    // instead of apla
        return this.hero_will;
    }

    public void saveGame(){
        Main.getDatabase().getDatabaseFiles().add(this);
        try{
            Main.serialize();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
