import java.util.Scanner;
public class Trip_planner {
    public static void main(String[] args){

        intro();
        budget();
        time();
        distance();

    }
    public static double two_decimalplace(double num){
        double result = 0;
        result = num*100;
        result = (int)result;
        result = result/100;
        return result;
    }

    public static void intro(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you "+name+", Where are you travelling to? ");
        String country = input.nextLine();
        System.out.println("Great! "+country+" sounds like a great trip");
        System.out.println("⋆⋆⋆⋆⋆⋆⋆⋆⋆⋆⋆\n");
    }

    public static void budget(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many "+currency+" are there in 1 USD? ");
        double convert = input.nextDouble();
        //convert = (int)(convert*100)/100;
        System.out.println();

        int hours = days*24;
        int minutes = days*1440;
        System.out.println("if you are travelling for "+days+" days that is the same as "+hours+" hours or "+minutes+" minutes");
        double dailyexpenseUSD = money/(double)days;
        dailyexpenseUSD = two_decimalplace(dailyexpenseUSD);
        System.out.println("If you are going to spend $"+money+" USD that means per day you can spend up to $"+dailyexpenseUSD+" USD");
        double moneyconvert = money*convert;
        moneyconvert = two_decimalplace(moneyconvert);
        double dailyexpense_convert = moneyconvert/days;
        dailyexpense_convert = two_decimalplace(dailyexpense_convert);
        System.out.println("Your total budget in "+currency+" is "+moneyconvert+" "+currency+", which per day is "+dailyexpense_convert+" "+currency);
        System.out.println("⋆⋆⋆⋆⋆⋆⋆⋆⋆⋆⋆\n");

    }

    public static void time(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int time = input.nextInt();
        System.out.println("That means that when it is midnight at home it will be "+time+":00 in your travel destination");
        time = time+12;
        int con_time = 0;
        if (time>24) {
            con_time = time%24;
        }else {
            con_time = time;
        }
        System.out.println("and when it is noon at home it will be "+con_time+":00" );
        System.out.println("⋆⋆⋆⋆⋆⋆⋆⋆⋆⋆⋆\n");

    }

    public static void distance(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        int km2 = input.nextInt();
        double miles2 = km2*0.38610;
        miles2 = two_decimalplace(miles2);
        System.out.print("In miles2 that is "+miles2);

    }


}
