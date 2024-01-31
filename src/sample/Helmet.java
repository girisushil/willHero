package sample;

import java.util.ArrayList;

public class Helmet{
    private String name;
    private ArrayList<Weapon> weapon_list;

    public Helmet(){
        this.name="Penguin_helmet";
        weapon_list=new ArrayList<Weapon>();
    }
    public Weapon get_weapon_from_list(int id){
        return weapon_list.get(id);
    }
    public void add_weapon_to_list(Weapon w){
        weapon_list.add(w);
    }

}
