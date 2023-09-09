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
        
        int fiftyThousand = money / Money.FIFTY_THOUSAND.value;
        money -= Money.FIFTY_THOUSAND.value * fiftyThousand;
        answer.add(fiftyThousand);

        int tenThousand = money / Money.TEN_THOUSAND.value;
        money -= Money.TEN_THOUSAND.value * tenThousand;
        answer.add(tenThousand);

        int fiveThousand = money / Money.FIVE_THOUSAND.value;
        money -= Money.FIVE_THOUSAND.value * fiveThousand;
        answer.add(fiveThousand);

        int thousand = money / Money.ONE_THOUSAND.value;
        money -= Money.ONE_THOUSAND.value * thousand;
        answer.add(thousand);

        int fiveHundred = money / Money.FIVE_HUNDRED.value;
        money -= Money.FIVE_HUNDRED.value * fiveHundred;
        answer.add(fiveHundred);

        int hundred = money / Money.ONE_HUNDRED.value;
        money -= Money.ONE_HUNDRED.value * hundred;
        answer.add(hundred);

        int fifty = money / Money.FIFTY.value;
        money -= Money.FIFTY.value * fifty;
        answer.add(fifty);

        int ten = money / Money.TEN.value;
        money -= Money.TEN.value * ten;
        answer.add(ten);
        answer.add(money);

        return answer;
    }

}
