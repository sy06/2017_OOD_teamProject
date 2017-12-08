package OOD;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * ���� ã�� Ŭ���� 
 */
public class FindStore {
	public int category;
	boolean deliverable;
	public Scanner scan = new Scanner(System.in);
	
	public FindStore(boolean delivery){
		/*
		 * true = ��ް���, false = ��� �Ұ��� (���� true�� ����)
		 */
		deliverable = delivery;
	}
	
	public void setCategory(){
		/*
		 * ī�װ� �н� or �ѽ� ���� (���� �߰� ����)
		 */	
		int n=0;
		while(true){
			System.out.println("ī�װ��� �����ϼ���\n1. �н�\n2. �ѽ� "
					+ "\n3. �Ͻ�&���\n4. ���ö�\n5. ���ߺ���\n6. ��,��\n7. �н�ƮǪ��\n8. ����\n9. ġŲ\n10. �߱���");
			
			try{
				n = scan.nextInt();
				if(n>10) throw new Exception();
				
				break;
			}
			catch(InputMismatchException ime){
				scan = new Scanner(System.in);
				System.out.println("���ڸ� �Է����ּ���.\n ");
			}
			catch(Exception e){
				System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.\n");
				
			}
			
		}
		
		category = n;
		
	}
	public int getCategory(){
		// ī�װ� ��ȣ ����
		return category;
	}
}
