package OOD;
/*
 * 만나서 결제
 */
public class Direct {
	   private int total_money; //결제 금액
	   
	   /*
	    * 결제 시작
	    */
	   public void startDirect() {
	      System.out.println("만나서 결제를 선택하셨습니다. ");
	      checkTotalMoney();
	      System.out.println("\n*** 결제 금액에 맞게 돈을 챙겨주세요!! ***");
	   }
	   /*
	    * 총 금액 확인
	    */
	   public void checkTotalMoney() {
	      System.out.println("최종 결제 금액은 "+getTotalMoney()+"입니다.");
	   }
	   
	   /*
	    * 총 금액 설정
	    */
	   public void setTotalMoney(int m) {
	      total_money = m;
	   }
	   /*
	    * 총 금액 리턴
	    */
	   public int getTotalMoney() {
	      return total_money;
	   }
	}
