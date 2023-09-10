package onboarding;

public class Problem4 {
    private static final int CAPITAL_ADD = Integer.valueOf('A') + Integer.valueOf('Z');//이거도 static이여야 함
    private static final int SMALL_LETTER_ADD = Integer.valueOf('a') + Integer.valueOf('z');

    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++){
            answer += transferString(word.charAt(i));
        }
        return answer;
    }
    public static boolean checkCapital(char alphabet){
        if (Character.isUpperCase(alphabet)) {
            return true;
        }
        return false;
    }

    public static boolean checkBlank(char blank){
        if(blank == ' '){
            return true;
        }
        return false;
    }

    public static String transferString(char alphabet){
        if(checkBlank(alphabet)){
            return " ";
        }

        if(checkCapital(alphabet)){
            return Character.toString(CAPITAL_ADD - Integer.valueOf(alphabet));
        }
        return Character.toString(SMALL_LETTER_ADD - Integer.valueOf(alphabet));
    }
}
