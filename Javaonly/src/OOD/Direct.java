package OOD;

public class Direct {
	   private int choice;
	   private int total_money;
	   
	   public void startDirect() {
	      System.out.println("������ ������ �����ϼ̽��ϴ�. ");
	      checkTotalMoney();
	      System.out.println("\n*** ���� �ݾ׿� �°� ���� ì���ּ���!! ***");
	   }
	   
	   public void checkTotalMoney() {
	      System.out.println("���� ���� �ݾ��� "+getTotalMoney()+"�Դϴ�.");
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
