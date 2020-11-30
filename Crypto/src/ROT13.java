import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private Character cs;
    private Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        cs = 'a';
        cf = 'n';
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String answer = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ((ch >= 'a') && ch <= 'm') {
                ch += 13;
            } else if ((ch >= 'A') && ch <= 'M') {
                ch += 13;
            } else if ((ch >= 'n') && ch <= 'z') {
                ch -= 13;
            } else if ((ch >= 'N') && ch <= 'Z') {
                ch -= 13;
            }
            answer = answer + ch;
        }
        return answer;
    }

    public String encrypt(String text) {
        String answer = crypt(text);
        return answer;
    }

    public String decrypt(String text) {
        String answer = crypt(text);
        return answer;
    }

    public static String rotate(String s, Character c) {
        int startIndex = 0;
        String answer = "";
        char[] stringS = s.toCharArray();
        //get starting index
        for (int i=0; i<stringS.length; i++){
            if (stringS[i] == c){
                startIndex = i;
            }
        }
        //fill first half of string with last bit of array
        for (int i=startIndex; i<stringS.length; i++){
            answer = answer + stringS[i];
        }
        //fill last half of string with first bit of array
        for (int i=0; i<startIndex; i++){
            answer = answer + stringS[i];
        }
        return answer;
    }

}
