package hello;

public class Seat {

    private int id;

    private int pick;

    public Seat(int id,int pick){
        this.id = id;
        this.pick = pick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }
}
