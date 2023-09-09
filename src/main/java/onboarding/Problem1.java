package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1) || crong.size() != 2 || pobi.size() != 2) { // 제한사항
            return -1;
        }
        int pobiLeft = getEachPageMax(pobi.get(0));
        int pobiRight = getEachPageMax(pobi.get(1));
        int crongLeft = getEachPageMax(crong.get(0));
        int crongRight = getEachPageMax(crong.get(1));

        int pobiMax = pobiLeft > pobiRight ? pobiLeft : pobiRight;
        int crongMax = crongLeft > crongRight ?crongLeft : crongRight;

        if(pobiMax > crongMax)
            answer = 1;
        else if(crongMax> pobiMax)
            answer = 2;
        else
            answer = 0;


        return answer;
    }

    private static int getEachPageMax(int pageNum){
        int pageNumPlus = 0;
        int pageNumMul = 1;
        for(int i = pageNum; i > 0; i /= 10){
            pageNumPlus += i % 10;
            pageNumMul *= i % 10;
        }
        return pageNumPlus>pageNumMul? pageNumPlus:pageNumMul;
    }

}