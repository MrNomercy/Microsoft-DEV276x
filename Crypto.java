public class Crypto {
    public static void main(String[] args){

        String phrase1 = "This is some \"really\" great. (Text)!?";
        String phrase2 = "ILIKEZOOS";
        String phrase3 = "ILIKEAPPLES";
        String phrase4 = "HITHERE";
        String phrase5 = "THI SIS ARE ALL YGR EAT SEN TEN CEx";
        System.out.println("normalizeText: \nThis is some \"really\" great. (Text)!?");
        System.out.println(normalizeText(phrase1));
        System.out.println("\ncaesarify: \nILIKEZOOS with 1 shift");
        System.out.println(caesarify(phrase2,1));
        System.out.println("ILIKEAPPLES with -1 shift");
        System.out.println(caesarify(phrase3,-1));
        System.out.println("\ngroupify: \nHITHERE with group 2");
        System.out.println(groupify(phrase4,2));
        System.out.println("ILIKEAPPLES with group 5");
        System.out.println(groupify(phrase3,5));
        System.out.println("\nobify: \nILIKEAPPLES");
        System.out.println(obify(phrase3));
        System.out.println("\nencryptString: \nILIKEAPPLES with shift 5 and group 3");
        System.out.println(encryptString(phrase3,5,3));
        System.out.println("\nungroupify: \nTHI SIS ARE ALL YGR EAT SEN TEN CEx");
        System.out.println(ungroupify(phrase5));
        System.out.println();

    }
    public static String normalizeText(String x){
        String result = "";
        for(int i=0;i<x.length();i++){
            String j = String.valueOf(x.charAt(i));
            if(j.equals(" ")||j.equals(".")||j.equals(",")||j.equals(":")||j.equals(";")||j.equals("'")||j.equals("\"")||j.equals("!")||j.equals("?")||j.equals("(")||j.equals(")")){
                result = result;

            }else {
                char y = Character.toUpperCase(x.charAt(i));
                result += y;
            }
        }
        return result;
    }
    public static String obify(String mytext){
        String result = "";
        for(int i=0;i<mytext.length();i++){
            String h = String.valueOf(mytext.charAt(i));
            if(h.equals("A")||h.equals("E")||h.equals("I")||h.equals("O")||h.equals("U")||h.equals("Y")){
                result += "OB"+ h;
            }else {
                result += h;
            }
        }
        return result;
    }
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    public static String caesarify(String mytext,int shift){
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ShiftAlphabet = shiftAlphabet(shift);
        //System.out.println(ShiftAlphabet);
        String result = "";
        for(int i =0;i<mytext.length();i++){
            String x = String.valueOf(mytext.charAt(i));
            int y = Alphabet.indexOf(x);
            char z = ShiftAlphabet.charAt(y);
            result += z;
        }
        return result;
    }
    public static String groupify(String mytext,int mygroup){
        int count = 0;
        String result = "";
        for(int i=0;i<mytext.length();i++){
            if(count<mygroup){
                String x = String.valueOf(mytext.charAt(i));
                result += x;
                count++;
            }else{
                String x = String.valueOf(mytext.charAt(i));
                result = result+" "+x;
                count =1;
            }
        }
        int check = mytext.length();
        while(check%mygroup != 0){
            result += "x";
            check++;
        }
        return result;
    }
    public static String encryptString(String text,int shift,int group){
        String a = normalizeText(text);
        String b = obify(a);
        String c = caesarify(b,shift);
        String result = groupify(c,group);
        return result;
    }
    public static String ungroupify(String text){
        String result = "";
        for(int i=0;i<text.length();i++){
            String t = String.valueOf(text.charAt(i));
            if(t.equals(" ")||t.equals("x")){
                result = result;
            }else {
                result += t;
            }
        }
        return result;

    }

}
