package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 3; i <= number; i++){
            answer += check369(String.valueOf(i));
        }
        return answer;
    }
    public static int check369(String integer){
        String change369ToA = integer.replace("3", "").replace("6", "").replace("9", "");
        return integer.length() - change369ToA.length();
    }

}
