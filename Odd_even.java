import java.util.Random;
import java.util.Scanner;

public class Odd_even {
    public static void main(String[] args){
        char again = 'y';

        while (again != 'n') {
            Scanner myscanner = new Scanner(System.in);
            System.out.println("Let's play a game called \"Odds and Evens\"");
            System.out.print("What is your name? ");
            String playername = myscanner.nextLine();
            System.out.print("Hi "+playername+", Which do you want to choose? (O)dds or (E)vens ");
            String useroption = myscanner.next().toLowerCase();
            char options = useroption.charAt(0);
            String option = String.valueOf(options);
            if (option.equals("o")){
                System.out.println(playername+" has picked Odds! The computer will be Evens.");
            }else{
                System.out.println(playername+" has picked Evens! The computer will be Odds.");
                option = "e";
            }
            System.out.println("--------------------------------------------\n");
            Random rand = new Random();
            int computerfinger = rand.nextInt(6);
            System.out.print("how many finger do you put out? ");
            int myfinger = myscanner.nextInt();
            System.out.println("The computer plays "+computerfinger+" \"finger\"");
            System.out.println("--------------------------------------------\n");
            int sum = computerfinger + myfinger;
            System.out.println(myfinger+" + "+computerfinger+" = "+sum);
            String result = "";
            if (sum%2==0){
                System.out.println(sum+" is ...Evens!");
                result = "Evens";
            }else{
                System.out.println(sum+" is ...Odds!");
                result = "Odds";
            }
            if(result.equals("Odds")){
                if(option.equals("o")){
                    System.out.println("That means "+playername+" wins! :)");
                }else {
                    System.out.println("That means The computer wins! :(");
                }
            }else {
                if (option.equals("e")){
                    System.out.println("That means "+playername+" wins! :)");
                }else {
                    System.out.println("That means The computer wins! :(");
                }
            }
            System.out.println("--------------------------------------------\n");
            System.out.print("Do you want to play again? (y/n) ");
            again = myscanner.next().charAt(0);
            System.out.println();
        }



    }
}
