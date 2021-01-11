/*
* FarmingGameMain.java
* Phillip Ball
* 05/06/2019
* This class uses another, together they make up a game.
*/

// imports
import java.util.*; // for Scanner

public class FarmingGameMain{
   
   public static void main(String[] args){
      
      boolean play = true; // needed to make the game run
      
      Scanner kb = new Scanner(System.in); // gets user input
      FarmingGame farm = new FarmingGame(); // makes an object of the class with most of the game in it
      
      farm.buildFarm(); // builds the user's farm
      
      // starts the game
      while(play){
         farm.nextYearCheck(); // checks if the year needs to be changed
         
         if(farm.getTime() == 23){ // warns the user of the time
            System.out.println("You have 1 hour before you crash from exhaustion");
            System.out.println("You can plant " + (2 - farm.getTimesPlanted()) + " times before passing out");
         }
         if(farm.getTime() >= 24){ // the user passes out
            farm.sleep();
         }
         
         // gives the user choices of what to do
         System.out.println("What would you like to do?");
         System.out.println("Current Time: " + farm.getTime() + ", current day: " + farm.getDay() + ", current year: " + farm.getYear());
         System.out.println("1: Plant seeds.\n2: Go to the Shop.\n3: Check inventory.\n4: Go to bed.\n5: Go to Puzzle Bar\n6: Quit.");
         System.out.println("Type '1', '2', '3', '4', '5' or '6' respectfully once decided");
         int input = kb.nextInt();
         if(input == 1){ // plant crops
            farm.plant();
         }
         else if(input == 2){ // goes to the shop
            if(farm.getTime() >= 19){
               System.out.println("It's to late to go to the Shop.");
            }
            else{
               farm.buildShop();
            }
         }
         else if(input == 3){ // shows the inventory
            System.out.println("Your money: " + farm.getMoney());
            System.out.println();
            farm.getSeedInventory();
            System.out.println();
            farm.getItemInventory();
            System.out.println();
         }
         else if(input == 4){ // go to sleep and start the next day
            farm.sleep();
         }
         else if(input == 5){ // go the the Puzzle Bar
            if(farm.getTime() >= 21){
               System.out.println("It's to late to go to the Puzzle Bar.");
            }
            else{
               farm.buildPuzzleBar();
            }
         }
         else{ // quit the game
            play = false;
         }
      }
   }
}