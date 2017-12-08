package OOD;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int n=0;
		
		while(true){
			try{
		
			System.out.println("��ȣ�� �������ּ���. ");
			System.out.println("1. ��� \n2. ������ ��õ �޴�\n3. ����");
			
			n = scan.nextInt();
			if(n>3) throw new Exception();
			
			break;
		}
			catch(InputMismatchException ime){
				System.out.println("���ڸ� �Է����ּ���.\n ");
			}
			catch(Exception e){
				System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.\n");
				
			}
		}
		
		if(n==1){
			User user = new User();
			user.testUser();
		
			OrderList orderlist = new OrderList(user);
		
			FindStore f = new FindStore(true); 
			f.setCategory();
		
			Delivery d = new Delivery(f.getCategory());
			d.order(orderlist);
			if(orderlist.getPrice() != 0) 
			orderlist.print();
			else 
				System.out.println("�ֹ��� �޴��� �����Ƿ� �����մϴ�.");
		/*
		 * 1. �Ĵ�ã�� (FindStore)
		 * 2. Category���ϱ� (FindStore�� ����Ǿ� �ֽ��ϴ�.)
		 * 3. ��� ��Ű�� (���� ��� ��ɸ� ����)
		 * 4. d.order�� �ֹ��ϱ�
		 */
		
			user.payment.doPayment(orderlist.getPrice());
			scan.close();
		}
	
		else if(n==2){
			TodayMenu t = new TodayMenu();
			t.SelectCategory();
			
			t.print();
		}
		else if(n==3){
			System.exit(0);
		}
	
}
}

