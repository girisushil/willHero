package sample;

public abstract class Game_Objects implements Collision{
    private Coordinate coordinates;
    private static int id=0;
    private String color;

    public Game_Objects(){
        id++;
    }
    public void setCoordinates(Coordinate s){
        this.coordinates=s;
    }
    public Coordinate getCoordinates(){
        return this.coordinates;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else
            return false;
    }


}
