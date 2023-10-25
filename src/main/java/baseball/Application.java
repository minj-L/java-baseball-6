package baseball;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	
	public static void checkDuplicate(String gamersNum) {
		
	}
    
	public static List<Integer> sringToIntList(String gamersNum) {
		
		List<Integer> numberList = new ArrayList<>();
		
		for (int i = 0; i < gamersNum.length(); i++) {
			numberList.add(gamersNum.charAt(i) - '0');
		}
		
		return numberList;
	}
	
	public static void main(String[] args) {
		
		int ball = 0;
		int strike = 0;
		
    	List<Integer> computer = new ArrayList<>();
    	while (computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
    	
    	System.out.println(computer);
    	
    	System.out.println("숫자 야구 게임을 시작합니다."); 
    	
    	while (true) {
    		ball = 0;
			strike = 0;
    		
    		System.out.print("숫자를 입력해주세요 : ");
    		
    		String gamersNum = Console.readLine();
    		
    		List<Integer> gamersNumList = sringToIntList(gamersNum);
    		
    		for (int j = 0; j < gamersNumList.size(); j++) {
    			
    			boolean isGamersNumExists = computer.contains(gamersNumList.get(j));
    			if (isGamersNumExists == true) {
    				ball += 1;
    			}
    			
    			if (computer.get(j) == gamersNumList.get(j)) {
    				strike += 1;
    			}
    		}
    		
    		while (strike == 3) {
    			System.out.println(strike + "스트라이크");
    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    	    	int reTryOrNot = Integer.parseInt(Console.readLine());
    	    	if (reTryOrNot == 1) {
    	    		continue;
    	    	} else if (reTryOrNot == 2){
    	    		System.out.println("게임 끝!");
    	    		break;
    	    	} else {
    	    		System.out.println("1이나 2만을 선택해 주세요 재시작 : 1 종료 : 2 : ");
    	    	}
    	    }
    		
    	   if (ball != 0 && strike != 0) {
    			System.out.println(ball + "볼 " + strike + "스트라이크"); 
    		} else if (ball != 0) {
    			System.out.println(ball + "볼");
    		} else if (strike != 0){
    			System.out.println(strike + "스트라이크");
    		} else {
    			System.out.println("낫싱");
    		}
    	}
    }
}
