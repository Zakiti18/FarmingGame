/*
* FarmingGame.java
* Phillip Ball
* 05/06/2019
* 
*/

// imports
import java.util.*; // used for Random and Scanner

public class FarmingGame{
   
   // fields
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // utilities throughout the class
   private Random gen;
   private Scanner kb;
   // time
   private int time;
   private int day;
   private int year;
   private int timesPlanted; // every time the user plants 3 crops time increases by 1
   // building the farm
   private char[][] plot;
   private int weather;
   // inventory
   private int money;
   private String[] seedInventory;
   private int[] seedNumber;
   private String[] itemInventory;
   private int[] itemNumber;
   // crop growth
   private boolean watered;
   private int timesWatered;
   private int smallGrowth;
   private int mediumGrowth;
   private int bigGrowth;
   // puzzle bar
   private boolean play;
   private int timeSpender;
   private boolean bet;
   private int prizeMoney;
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // constructor method
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   public FarmingGame(){
      // sets the date and time
      this.time = 6;
      this.day = 1;
      this.year = 1;
      // sets up the Random generator and the Scanner keyboard input
      this.gen = new Random();
      this.kb = new Scanner(System.in);
      
      // the player's plot on the farm
      // total spots for planting 107
      this.plot = new char[6][];
      plot[0] = new char[]{'~','~','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','~','~'};
      plot[1] = new char[]{'~','~','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','~','~'};
      plot[2] = new char[]{'~','~','(','W','W',')','_','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','~','~'};
      plot[3] = new char[]{'~','~','|','W','W','W','W','|','_','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','~','~'};
      plot[4] = new char[]{'~','~','|','W','W','W','W','W','W','|','_','O','O','O','O','O','O','O','O','O','O','O','O','O','O','~','~'};
      plot[5] = new char[]{'~','~','(','W','W','W','W','W','W','W','W',')','O','O','O','O','O','O','O','O','O','O','O','O','O','~','~'};
      
      // the player's inventory
      this.money = 100;
      
      this.seedInventory = new String[9];
      this.seedNumber = new int[9];
      seedInventory[0] = "(T) Turnip seed(s)";
      seedInventory[1] = "(K) Kale seed(s)";
      seedInventory[2] = "(C) Cauliflower seed(s)";
      seedInventory[3] = "(M) Melon seed(s)";
      seedInventory[4] = "(R) Radish seed(s)";
      seedInventory[5] = "(B) Blueberry seed(s)";
      seedInventory[6] = "(P) Pumpkin seed(s)";
      seedInventory[7] = "(G) Grape seed(s)";
      seedInventory[8] = "(E) Eggplant seed(s)";
      
      this.itemInventory = new String[9];
      this.itemNumber = new int[9];
      itemInventory[0] = "Turnip(s)";
      itemInventory[1] = "Kale(s)";
      itemInventory[2] = "Cauliflower(s)";
      itemInventory[3] = "Melon(s)";
      itemInventory[4] = "Radish(s)";
      itemInventory[5] = "Blueberry(s)";
      itemInventory[6] = "Pumpkin(s)";
      itemInventory[7] = "Grape(s)";
      itemInventory[8] = "Eggplant(s)";
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // builds the farm
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   public void buildFarm(){
      dayNight(); // changes depending on time/new day
      System.out.println("          /    \\           ");
      System.out.println("       ''''''''''''        ");
      System.out.println("        |        |         ");
      System.out.println("        |   DD   |         ");
      System.out.println("        | + DD + |         ");
      System.out.println("        |   DD   |         ");
      System.out.println("       -----==-----    ___ ");
      System.out.println("       ||   ==   ||   |___|");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println(plot[0]);
      System.out.println(plot[1]);
      System.out.println(plot[2]);
      System.out.println(plot[3]);
      System.out.println(plot[4]);
      System.out.println(plot[5]);
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }
   
   // decides what to show moon or sun, depending on what time it is
   public void dayNight(){
      if(this.time > 5 && this.time < 19){
         if(this.weather == 1){ // rain
            System.out.println("   \\ /    ||       (XXXX)  ");
            System.out.println("  - O -   ||/\\      |  |   ");
            System.out.println("   / \\    ||  \\      |  |   ");
            this.watered = true;
         }
         else if(this.weather == 2){ // cloudy
            System.out.println("   \\ /    ||        (XXX)  ");
            System.out.println("  - O -   ||/\\        (XXX)");
            System.out.println("   / \\    ||  \\   (XXX)    ");
         }
         else{ // clear
            System.out.println("   \\ /    ||               ");
            System.out.println("  - O -   ||/\\             ");
            System.out.println("   / \\    ||  \\            ");
         }
      }
      else { // night
         System.out.println("   /'>    ||        +    + ");
         System.out.println("  |       ||/\\   +    +    ");
         System.out.println("   \\,>    ||  \\    +     + ");
      }
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // time
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // resets the time to the morning and changes the day
   public void sleep(){
      this.weather = this.gen.nextInt(4); // randomly chooses the weather at the start of the day
      this.timesPlanted = 0; // resets the number of times the user planted something
      this.time = 6;
      this.day++;
      buildFarm();
   }
   
   // resets the day to 1 and changes to the next year
   public void nextYearCheck(){
      if(this.day >= 91){
         this.year++;
         this.day = 1;
      }
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // planting crops
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   public void plant(){
      if(availiblePlotSpot()){
         getSeedInventory();
         System.out.println("Type the number next to the seed you wish to plant or type 10 to leave.");
         int answer = kb.nextInt();
         if(answer == 1){
            if(seedNumber[0] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(1);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'T';
               System.out.println("You planted a Turnip seed");
               buildFarm();
            }
         }
         else if(answer == 2){
            if(seedNumber[1] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(2);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'K';
               System.out.println("You planted a Kale seed");
               buildFarm();
            }
         }
         else if(answer == 3){
            if(seedNumber[2] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(3);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'C';
               System.out.println("You planted a Cauliflower seed");
               buildFarm();
            }
         }
         else if(answer == 4){
            if(seedNumber[3] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(4);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'M';
               System.out.println("You planted a Melon seed");
               buildFarm();
            }
         }
         else if(answer == 5){
            if(seedNumber[4] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(5);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'R';
               System.out.println("You planted a Radish seed");
               buildFarm();
            }
         }
         else if(answer == 6){
            if(seedNumber[5] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(6);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'B';
               System.out.println("You planted a Blueberry seed");
               buildFarm();
            }
         }
         else if(answer == 7){
            if(seedNumber[6] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(7);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'P';
               System.out.println("You planted a Pumpkin seed");
               buildFarm();
            }
         }
         else if(answer == 8){
            if(seedNumber[7] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(8);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'G';
               System.out.println("You planted a Grape seed");
               buildFarm();
            }
         }
         else if(answer == 9){
            if(seedNumber[8] <= 0){
               System.out.println("You don't have any of those seeds");
               buildFarm();
            }
            else{
               removeSeed(9);
               timesPlanted++;
               if(timesPlanted == 3){
                  timesPlanted = 0;
                  time++;
               }
               plot[availiblePlotRow()][availiblePlotColumn()] = 'E';
               System.out.println("You planted a Eggplant seed");
               buildFarm();
            }
         }
         else{
            System.out.println("You chose not to plant anything");
            buildFarm();
         }
      }
      else{
         System.out.println("There's no availible spots for planting");
         buildFarm();
      }
   }
   
   // removes items from the player's inventory after planting a seed
   public void removeSeed(int item){
      if(item == 1){
         seedNumber[0]--;
      }
      else if(item == 2){
         seedNumber[1]--;
      }
      else if(item == 3){
         seedNumber[2]--;
      }
      else if(item == 4){
         seedNumber[3]--;
      }
      else if(item == 5){
         seedNumber[4]--;
      }
      else if(item == 6){
         seedNumber[5]--;
      }
      else if(item == 7){
         seedNumber[6]--;
      }
      else if(item == 8){
         seedNumber[7]--;
      }
      else{
         seedNumber[8]--;
      }
   }
   
   // checks each spot in the farm plot. returns true if there's at least 1 spot, otherwise returns false
   public boolean availiblePlotSpot(){
      int i = 0;
      int i2 = 2;
      while(i < plot.length){
         while(i < (plot[i].length - 4)){
            if(plot[i][i2] == 'O'){
               return true;
            }
            else{
               i2++;;
            }
         }
         i++;
      }
      return false;
   }
   
   // returns the first open column on the farm to plant something
   public int availiblePlotColumn(){
      int i = 0;
      int i2 = 2;
      while(i < plot.length){
         while(i < (plot[i].length - 4)){
            if(plot[i][i2] == 'O'){
               return i2;
            }
            else{
               i2++;;
            }
         }
         i++;
      }
      return -1;
   }
   
   // returns the first open row on the farm to plant something
   public int availiblePlotRow(){
      int i = 0;
      int i2 = 2;
      while(i < plot.length){
         while(i < (plot[i].length - 4)){
            if(plot[i][i2] == 'O'){
               return i;
            }
            else{
               i2++;;
            }
         }
         i++;
      }
      return -1;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // crop growth
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   public void water(){
      System.out.println("Type '1' to water small plants (T), (M) and (P). There are " + smallWatered() + " not watered.");
      System.out.println("Type '2' to water medium plants (K), (R) and (G). There are " + mediumWatered() + " not watered.");
      System.out.println("Type '3' to water big plants (C), (B) and (E). There are " + bigWatered() + " not watered.");
      System.out.println("Type '4' to leave.");
      int answer = kb.nextInt();
      
      if(answer == 1){ // water "small" plants (T), (M) and (P)
         
      }
      else if(answer == 2){ // water "medium" plants (K), (R) and (G)
         
      }
      else if(answer == 3){ // water "big" plants (C), (B) and (E)
         
      }
      else{
         buildFarm();
      }
   }
   
   // returns the number of plants not watered
   public int smallWatered(){
      return 0;
   }
   
   public int mediumWatered(){
      return 0;
   }
   
   public int bigWatered(){
      return 0;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // the shop
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // allows the player to buy and sell from and to the shop owner
   public void buildShop(){
      System.out.println("     /\\_________           ");
      System.out.println("    /VVVVVVVVVVV\\          ");
      System.out.println("   /             \\         ");
      System.out.println("  /  \\__     __/  \\       ");
      System.out.println("  |  (  )   (  )  |    What ");
      System.out.println("  |       |       |    can  ");
      System.out.println("  |       C       |    I do ");
      System.out.println("   \\   \\____/    /     for");
      System.out.println("    \\___     ___/      you?");
      System.out.println("      | \\___/ |            ");
      System.out.println("      |       |             ");
      System.out.println("      |   )   |             ");
      
      System.out.println(); // space for niceness
      
      System.out.println("Type '1' to buy\nType '2' to sell\nType '3' to leave.");
      int answer = kb.nextInt();
      if(answer == 1){ // shows what the player can buy
         System.out.println("Your money: " + getMoney());
         System.out.println(shopInventory());
         System.out.println("Type '1', '2', '3' or '4' respectfully to purchase or leave.");
         answer = kb.nextInt();
         if(answer == 1){ // adds item of choice to player's inventory
            if(money < 10){
               System.out.println("You don't have enough money");
               buildShop();
            }
            else{
               buy(1);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 2){
            if(money < 20){
               System.out.println("You don't have enough money");
               buildShop();
            }
            else{
               buy(2);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 3){
            if(money < 30){
               System.out.println("You don't have enough money");
               buildShop();
            }
            else{
               buy(3);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else{
            buildShop();
         }
      }
      else if(answer == 2){ // shows what the player can sell
         getItemInventory();
         System.out.println("Type the number next to the item you wish to sell or type 10 to leave.");
         answer = kb.nextInt();
         if(answer == 1){ // removes item of choice from player's inventory
            if(itemNumber[0] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(1);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 2){
            if(itemNumber[1] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(2);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 3){
            if(itemNumber[2] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(3);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 4){
            if(itemNumber[3] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(4);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 5){
            if(itemNumber[4] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(5);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 6){
            if(itemNumber[5] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(6);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 7){
            if(itemNumber[6] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(7);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 8){
            if(itemNumber[7] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(8);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else if(answer == 9){
            if(itemNumber[8] <= 0){
               System.out.println("You're out of that item!");
               buildShop();
            }
            else{
               sell(9);
               System.out.println("Thank you!");
               buildShop();
            }
         }
         else{
            buildShop();
         }
      }
      else if(answer == 3){ // leaves the shop and goes back to the farm
         System.out.println("Have a good day!");
         time++;
         buildFarm();
      }
      else{ // miss type catch
         System.out.println("that's not an answer");
         buildShop();
      }
   }
   
   // changes the shop's inventory depending on the time of year
   public String shopInventory(){
      if(this.day <= 30){
         return "1: Turnip Seed $10\n2: Kale Seed $20\n3: Cauliflower Seed $30\n4: Leave";
      }
      else if(this.day > 30 && this.day <= 60){
         return "1: Melon Seed $10\n2: Radish Seed $20\n3: Blueberry Seed $30\n4: Leave";
      }
      else{
         return "1: Pumpkin Seed $10\n2: Grape Seed $20\n3: Eggplant Seed $30\n4: Leave";
      }
   }
   
   // adds items to the player's inventory when buying from the shop
   public void buy(int item){
      if(this.day <= 30){ // changes with time of year
         if(item == 1){
            seedNumber[0]++;
            this.money -= 10;
         }
         else if(item == 2){
            seedNumber[1]++;
            this.money -= 20;
         }
         else{
            seedNumber[2]++;
            this.money -= 30;
         }
      }
      else if(this.day > 30 && this.day <= 60){ // changes with time of year
         if(item == 1){
            seedNumber[3]++;
            this.money -= 10;
         }
         else if(item == 2){
            seedNumber[4]++;
            this.money -= 20;
         }
         else{
            seedNumber[5]++;
            this.money -= 30;
         }
      }
      else{ // changes with time of year
         if(item == 1){
            seedNumber[6]++;
            this.money -= 10;
         }
         else if(item == 2){
            seedNumber[7]++;
            this.money -= 20;
         }
         else{
            seedNumber[8]++;
            this.money -= 30;
         }
      }
   }
   
   // removes items from the player's inventory while selling to the shop
   public void sell(int item){
      if(item == 1){
         itemNumber[0]--;
         this.money += 20;
      }
      else if(item == 2){
         itemNumber[1]--;
         this.money += 40;
      }
      else if(item == 3){
         itemNumber[2]--;
         this.money += 60;
      }
      else if(item == 4){
         itemNumber[3]--;
         this.money += 20;
      }
      else if(item == 5){
         itemNumber[4]--;
         this.money += 40;
      }
      else if(item == 6){
         itemNumber[5]--;
         this.money += 60;
      }
      else if(item == 7){
         itemNumber[6]--;
         this.money += 20;
      }
      else if(item == 8){
         itemNumber[7]--;
         this.money += 40;
      }
      else{
         itemNumber[8]--;
         this.money += 60;
      }
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // getters
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // prints out the player's inventory of seeds
   public void getSeedInventory(){
      int i = 0;
      System.out.println("Seeds inventory");
      while(i < seedInventory.length){
         System.out.println((i + 1) + ": " + seedInventory[i] + ": " + seedNumber[i] + ".");
         i++;
      }
   }
   
   // prints out the player's inventory of grown crops
   public void getItemInventory(){
      int i = 0;
      System.out.println("Grown crops inventory");
      while(i < itemInventory.length){
         System.out.println((i + 1) + ": " + itemInventory[i] + ": " + itemNumber[i] + ".");
         i++;
      }
   }
   
   public int getMoney(){
      return this.money;
   }
   
   public int getTime(){
      return this.time;
   }
   
   public int getDay(){
      return this.day;
   }
   
   public int getYear(){
      return this.year;
   }
   
   public int getTimesPlanted(){
      return this.timesPlanted;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // the puzzle bar
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   public void buildPuzzleBar(){
      System.out.println("     _____________            ");
      System.out.println("     |~~~~~~~~~~~|            ");
      System.out.println("     |~~~~~~~~~~~|            ");
      System.out.println("  ___|___________|___  Welcome");
      System.out.println("    |  ~       ~  |    to the ");
      System.out.println("    |  O   (   O  |    Puzzle ");
      System.out.println("    |    ____/    |    Bar!   ");
      System.out.println("    |_____________|           ");
      System.out.println("        |     |               ");
      if(time >= 21){
         System.out.println("Sorry bud but it's getting late and I gotta close up shop. Hope to see ya soon!");
         this.time++;
         buildFarm();
      }
      System.out.println("What would you like to play with ol'Hershel?");
      
      System.out.println();
      
      System.out.println("Type '1' to play Tree Traversal\nType '2' to leave");
      int answer = kb.nextInt();
      
      if(answer == 1){ // if they want to play Tree Traversal
         // explains how to play
         System.out.println("Alright, I'll tell ya how to play real quick");
         System.out.println("I'll shuffle up a deck of cards, each card has a letter from the alphabet.");
         System.out.println("Then I'll put cards on the table in a stack, so you can see the order of each letter.");
         System.out.println("Finally I'll ask you to tell me what the tree would look like in one of three orders.");
         System.out.println("The three orders are 'Pre-order', 'In-order' and 'Post-order'.");
         System.out.println("The way to traverse each order of tree is:");
         System.out.println("Pre-order: DLR (or Data, Left, Right), that's the letter then to the left, etc.");
         System.out.println("In-order: LDR (or Left, Data, Right), that's to the left then the letter, etc.");
         System.out.println("Post-order: LRD (or Left, Right, Data), that's to the left, the right, then the letter.");
         System.out.println("Once the game starts, I'll let you know when you get a letter wrong or right.");
         
         System.out.println("So, wanna play?");
         System.out.println("Type '1' to play\nType '2' to look at other games");
         answer = kb.nextInt();
         if(answer == 1){
            this.play = true;
            this.time++;
            System.out.println("Would you like to bet some buckaroos or just play for fun?");
            System.out.println("Type '1' to bet ($10's the minimum bet)\nType '2' to not bet");
            answer = kb.nextInt();
            // betting option
            if(answer == 1){
               if(this.money < 10){
                  System.out.println("You don't seem to have the cash. We can play for fun or wait till next time though.");
                  buildPuzzleBar();
               }
               else{
                  this.bet = true;
                  System.out.println("Sounds good, how much you wanna bet? Remember the minimum is $10");
                  answer = kb.nextInt();
                  if(answer < 10){
                     System.out.println("Alright bud, I don't think your taking this very seriously. Maybe you should come back later.");
                     buildPuzzleBar();
                  }
                  else{
                     prizeMoney = answer * 2;
                     this.money -= answer;
                     System.out.println("Also. if you get one wrong your prize money will lower. Good luck!");
                     TreeTraversal();
                  }
               }
            }
            else{
               System.out.println("Understandable, for fun it is!");
               TreeTraversal();
            }
         }
         else{ // if they change their mind about playing
            buildPuzzleBar();
         }
      }
      else{ // if they want to leave
         System.out.println("Have a good one bud!");
         this.time++;
         buildFarm();
      }
   }
   
   // Tree Traversal (minigame)
   public void TreeTraversal(){
      LinkedList<String> alphabet = new LinkedList<String>(); // holds the alphabet before being randomly moved to a tree
      alphabet.add("A");
      alphabet.add("B");
      alphabet.add("C");
      alphabet.add("D");
      alphabet.add("E");
      alphabet.add("F");
      alphabet.add("G");
      alphabet.add("H");
      alphabet.add("I");
      alphabet.add("J");
      alphabet.add("K");
      alphabet.add("L");
      alphabet.add("M");
      alphabet.add("N");
      alphabet.add("O");
      alphabet.add("P");
      alphabet.add("Q");
      alphabet.add("R");
      alphabet.add("S");
      alphabet.add("T");
      alphabet.add("U");
      alphabet.add("V");
      alphabet.add("W");
      alphabet.add("X");
      alphabet.add("Y");
      alphabet.add("Z");
      
      LinkedList<String> randAlphabet = new LinkedList<String>(); // shows order the letters were randomized
      StringSearchTree barkeepTree = new StringSearchTree(); // holds the goal
      int i = 26;
      while(alphabet.size() > 0){ // randomly moves the alphabet form the list to the tree
         int randLetter = this.gen.nextInt(i); // chooses the letter in the list to move to the tree
         i--;
         barkeepTree.put(alphabet.get(randLetter));
         randAlphabet.add(alphabet.get(randLetter));
         alphabet.remove(randLetter);
      }
      System.out.println("The order of how the alphabet was randomized: " + randAlphabet);
      
      LinkedList<String> orderWanted = new LinkedList<String>();
      int randOrder = this.gen.nextInt(3); // pre, in or post
      if(randOrder == 0){
         System.out.println("Alright, I want you to add one letter at a time. The order is Pre-order (DLR)");
         while(i <= 25){
            orderWanted.add("" + barkeepTree.returnPreOrder().charAt(i));
            i++;
         }
      }
      else if(randOrder == 1){
         System.out.println("Alright, I want you to add one letter at a time. The order is In-order (LDR)");
         while(i <= 25){
            orderWanted.add("" + barkeepTree.returnInOrder().charAt(i));
            i++;
         }
      }
      else{
         System.out.println("Alright, I want you to add one letter at a time. The order is Post-order (LRD)");
         while(i <= 25){
            orderWanted.add("" + barkeepTree.returnPostOrder().charAt(i));
            i++;
         }
      }
      
      LinkedList<String> playerTree = new LinkedList<String>();
      Scanner kb2 = new Scanner(System.in); // had to make a new scanner for some reason
      while(play){
         String answer = kb2.nextLine();
         if(answer.equals("")){
            System.out.println("You didn't even give an answer, come on try again!");
         }
         else{
            answer = answer.substring(0, 1).toUpperCase();
            if(!barkeepTree.containsKey(answer)){
               System.out.println("Uh... Thats not a letter of the alphabet bud, try again.");
            }
            else if(playerTree.contains(answer)){
               System.out.println("You already guessed that letter, try again.");
            }
            else{
               if(answer.equals(orderWanted.get(0))){
                  System.out.println("You got it bud, that's right!");
                  playerTree.add(answer);
                  orderWanted.remove(0);
               }
               else{
                  if(bet){
                     System.out.println("Oof, that's not quite right, that'll take a bit of the prize away. Keep on trying bud!");
                     if(this.prizeMoney > 0){
                        this.prizeMoney--;
                     }
                  }
                  else{
                     System.out.println("Oof, that's not quite right. Keep on trying bud!");
                  }
               }
               if(orderWanted.size() == 0){
                  this.play = false;
               }
            }
         }
      }
      money += this.prizeMoney;
      System.out.println("Good game! I hope you enjoyed it. Oh, and here's what your tree looks like:");
      System.out.println("Tilt your head to the left for it to make sense. this table's a little odd.");
      barkeepTree.printSideways();
      System.out.println("Or see this cause it's easier on the neck.");
      System.out.println(playerTree);
      if(bet){
         System.out.println("Oh one more thing, the prize money you earned is " + this.prizeMoney);
      }
      buildPuzzleBar();
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
}