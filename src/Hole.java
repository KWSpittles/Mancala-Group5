package sample;
public class Hole {

    private int pitValue;

    public Hole() {
        this.pitValue = 0;
    }

    public Hole(int stones) {
        this.pitValue = stones;
    }

//    public Hole(int value) {
//        this.pitValue = value;
//    }
    public int getPitValue(){
        return pitValue;
    }

    public void setPitValue(int value){
        this.pitValue = value;
    }

    public void incrementPitValueX(int value){
        this.pitValue += value;
    }

    public void incrementPitValue(){
        this.pitValue += 1;
    }

    public void clearPitValue(){
        this.pitValue = 0;
    }


}
