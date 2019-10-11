import java.util.*;

public class MazeRunner {
    public static Maze myMap = new Maze();
    public static void main(String[] args){

        /* note there is a bug in Maze.java line 298 solution[13][17] = '0'; comment it out
        Maze.java can be download from:
        https://prod-edxapp.edx-cdn.org/assets/courseware/v1/e5059d8cb28344b695e2d466783a4a8b/asset-v1:Microsoft+DEV276x+3T2019+type@asset+block/Maze.java.zip
        */
        intro();
        game();

    }

    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");

        myMap.printMap();
    }

    public static void movesMessage(int count){
        if(count == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }else if (count == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }else if(count == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }else if(count == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.exit(0);
        }
    }

    public static void navigatePit(String move){

        Scanner scan = new Scanner(System.in);
        System.out.print("Watch out! there is a pit ahead, jump it? ");
        String option = scan.next().toUpperCase();
        char useroption = option.charAt(0);
        String jump = String.valueOf(useroption);
        if(jump.equals("Y")){
            myMap.jumpOverPit(move);
            //myMap.printMap();
        }else{
            System.out.println("Sorry, you've fallen into pit of loser, good bye!");
            System.exit(0);
        }

    }

    public static String userMove(){


        Scanner scan = new Scanner(System.in);
        System.out.print("Where you would like to move? (R,L,U,D) ");
        String option = scan.next().toUpperCase();
        char useroption = option.charAt(0);
        String move = String.valueOf(useroption);
        //check the input until true.
        while(!(move.equals("R")||move.equals("L")||move.equals("U")||move.equals("D"))){
            System.out.println("Please re-enter your option.");
            System.out.print("Where you would like to move? (R,L,U,D) ");
            option = scan.next().toUpperCase();
            useroption = option.charAt(0);
            move = String.valueOf(useroption);
        }

        return move;

        //System.out.println("and you did it in "+moves+" moves");
        //System.out.println("Congratulations, you made it out alive!");

    }

    public static void game(){

        int moves = 0;
        while (!myMap.didIWin()){
            String choice = userMove();
            if (choice.equals("R")){
                if (myMap.isThereAPit("R")){
                    navigatePit("R");
                    myMap.printMap();
                }else if(myMap.canIMoveRight()){
                    myMap.moveRight();
                    myMap.printMap();
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    myMap.printMap();
                }
            }else if (choice.equals("L")){
                if (myMap.isThereAPit("L")){
                    navigatePit("L");myMap.printMap();
                }else if(myMap.canIMoveLeft()){
                    myMap.moveLeft();
                    myMap.printMap();
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    myMap.printMap();
                }

            }else if (choice.equals("U")){
                if (myMap.isThereAPit("U")){
                    navigatePit("U");
                    myMap.printMap();
                }else if(myMap.canIMoveUp()){
                    myMap.moveUp();
                    myMap.printMap();
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    myMap.printMap();
                }

            }else if (choice.equals("D")){
                if (myMap.isThereAPit("D")){
                    navigatePit("D");
                    myMap.printMap();
                }else if(myMap.canIMoveDown()){
                    myMap.moveDown();
                    myMap.printMap();
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    myMap.printMap();
                }

            }
            moves++;
            movesMessage(moves);

        }
        System.out.println("Congratulations, you've made it out alive!");
    }
}
