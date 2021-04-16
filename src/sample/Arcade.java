
package sample;


public class Arcade extends Game{

        //constructor
        public Arcade(){

        }

        //option for player to choose select power up
        public boolean playerPowerUps(){

            return false;
        }

        // POWER-UPS
        //player auto-continue a turn once an empty pit is reached
        public void continueTurn(){

        }

        //double all point for single turn
        public void doublePoints(){

        }

        // SPECIAL STONE
        //notify and activate special stoneby 3.33% each
//    public int StoneTriggerProb(){
//
//        return;
//    }

        //reduce pick up point by half and round up if odd number
        public void halfHand(){


        }

        //change player next move to clockwise instead
        public boolean moveAntiClockwise() {

            return false;
        }


        //player next move change to clockwise position
        public void reverseTurn(){

        }

        //player return all current stone to the pit and take the opposite pit/position
        public void switchSides(){

        }







}

