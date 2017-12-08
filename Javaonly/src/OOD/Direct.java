package OOD;

public class Direct {
	   private int choice;
	   private int total_money;
	   
	   public void startDirect() {
	      System.out.println("만나서 결제를 선택하셨습니다. ");
	      checkTotalMoney();
	      System.out.println("\n*** 결제 금액에 맞게 돈을 챙겨주세요!! ***");
	   }
	   
	   public void checkTotalMoney() {
	      System.out.println("최종 결제 금액은 "+getTotalMoney()+"입니다.");
	   }
	   
	   public void setChoice(int c) {
	      choice =c;
	   }
	   public int getChoice() {
	      return choice;
	   }
	   public void setTotalMoney(int m) {
	      total_money = m;
	   }
	   public int getTotalMoney() {
	      return total_money;
	   }
	}
