package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem5 {
    enum Money{
        FIFTY_THOUSAND(50000), TEN_THOUSAND(10000), FIVE_THOUSAND(5000), ONE_THOUSAND(1000),
        FIVE_HUNDRED(500), ONE_HUNDRED(100), FIFTY(50), TEN(10);
        int value;
        Money(int value){
            this.value = value;
        }

    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(); //new ArrayList<Integer>(9);
        int[] moneyType = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for(int i = 0; i < moneyType.length; i++){
            int moneyNum = money / moneyType[i];
            money -= moneyType[i] * moneyNum; // %= moneyType[i];
            answer.add(moneyNum);
        }
        answer.add(money);

        return answer;
    }

}
