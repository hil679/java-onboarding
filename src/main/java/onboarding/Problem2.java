package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = checkDuplication(cryptogram);

        return answer;
    }
    public static String checkDuplication(String cryptogram){
        Stack<Character> finalCryptogram = new Stack<>();
        char prevChar = cryptogram.charAt(0);
        finalCryptogram.push(prevChar);//처음은 무조건 들어가니까 비교 하나 줄임

        for(int i = 1; i < cryptogram.length(); i++){
            char c = cryptogram.charAt(i);//비교할 문자 하나
            //prev 문자와 같거나 stack peek와 같으면 중복이다.
            if(prevChar != c && (finalCryptogram.empty() || finalCryptogram.peek() != c)){
                finalCryptogram.push(c);
            } else {
                if (finalCryptogram.peek() == c) {//peek와  같으면 peek도 중복이니까 peek값 pop
                    finalCryptogram.pop();
                }
                //나머지 prev와 같고 stack에 없는 값은 그냥 pass(aaa이렇게 3연속 중복일 때)
            }
            prevChar = c;
        }

        String ans ="";
        for(char str: finalCryptogram)
            ans += String.valueOf(str);
        
        return ans;
    }
}
