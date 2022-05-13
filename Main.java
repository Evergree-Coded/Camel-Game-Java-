import java.util.Random;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    // Default Values
    int milesTraveled = 0;
    int thirst = 0;
    int camelFatigue = 0;
    int nativesTraveled = -20;
    int canteen = 3;
    boolean stillPlaying = true;

    while(stillPlaying){
      // Menu
      System.out.println("A) Drink from your canteen");
      System.out.println("B) Ahead at Moderate Speed");
      System.out.println("C) Ahead at Full Speed");
      System.out.println("D) Stop for the night");
      System.out.println("E) Status Check");
      System.out.println("Q) Quit");
      System.out.println("Choose an option from above: ");
      String userChoice = scan.nextLine(); // take in user input

      int nativesDistance = rand.nextInt(8) + 7;
      
      if(userChoice.equalsIgnoreCase("a")){
        if(canteen == 0){
          System.out.println("You have no canteens left");
        }
        else{
          canteen--;
          thirst = 0;
        }
      }
      if(userChoice.equalsIgnoreCase("b")){
        //milesTraveled += 8*Math.random() + 5;
        milesTraveled += rand.nextInt(8) + 5; //MIN: 5+ 0 = 5 MAX:7 + 5 = 12
        System.out.println("You have traveled: " + milesTraveled);
        thirst++;
        camelFatigue++;
        nativesTraveled += nativesDistance;
      }
      if(userChoice.equalsIgnoreCase("c")){
        milesTraveled += rand.nextInt(11)+ 10;
        System.out.println("You have traveled: " + milesTraveled);
        thirst++;
        camelFatigue += rand.nextInt(3) + 1; 
        nativesTraveled += nativesDistance;
      }
      if(userChoice.equalsIgnoreCase("d")){
        camelFatigue = 0;
        System.out.println("The Camel Fatigue value: " +  camelFatigue);
        nativesTraveled += nativesDistance;
      }
      if(userChoice.equalsIgnoreCase("e")){
        System.out.println("Miles Traveled " + milesTraveled);
        System.out.println("You have " + canteen + " canteens");
        System.out.println("Camel Fatigue: "+ camelFatigue);
        System.out.println("The natives are " + (milesTraveled - nativesTraveled) + " miles behind you");
      }
      if(userChoice.equalsIgnoreCase("q")){
        stillPlaying = false;
      }
      
      if(milesTraveled >= 200){
        stillPlaying = false;
        System.out.println("You won!");
      }

      if(thirst >= 4 && thirst <= 6){
        System.out.println("You are thirsty!");
      }

      if(thirst > 6){
        System.out.println("Died of dehydration! You Lose");
        stillPlaying = false;
      }
      
      if(camelFatigue >= 5 && camelFatigue <= 8){
        System.out.println("The camel is getting tired!");
      }

      if(camelFatigue > 8){
        stillPlaying = false;
        System.out.println("Your camel dead. You lose!");
      }

      if(milesTraveled - nativesTraveled <= 15){
        System.out.println("The natives are within 15 miles of you.");
      }

      if(milesTraveled <= nativesTraveled){
        System.out.println("You got caught by the natives.");
        stillPlaying = false;
      }
      
    }
    System.out.println("You traveled " + milesTraveled + " miles.");
  }
}