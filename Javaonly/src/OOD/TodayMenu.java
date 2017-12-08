package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TodayMenu {
	private String T_store[];
	private String T_category;
	
	public TodayMenu(){
		T_store = new String[100];	
	}
	public void SelectCategory(){ //ī�װ� �����ϱ�
		Scanner scan = new Scanner(System.in);
		int n=0;
		
		System.out.println("***** �԰���� ���� ������ �������ּ���. *****");
		
		while(true){
			System.out.println("1. �н�\n2. �ѽ� \n3. �Ͻ�&���\n4. ���ö�\n5. "
					+ "���ߺ���\n6. ��,��\n7. �н�ƮǪ��\n8. ����\n9. ġŲ\n10. �߱���");
			
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
		
		if(n==1) T_category = "�н�";
		else if(n==2) T_category = "�ѽ�";
		else if(n==3) T_category = "�Ͻ�&���";
		else if(n==4) T_category = "���ö�"; else if(n==5) T_category = "���ߺ���";
		else if(n==6) T_category = "��,��"; else if(n==7) T_category = "�н�ƮǪ��";
		else if(n==8) T_category = "����"; else if(n==9) T_category = "ġŲ";
		else if(n==10) T_category = "�߱���";
	}
	public void RandomStore(){ //���� ����
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\�����Ǹ޴�\\"+T_category+".txt"));
			String line = in.readLine();
			int i = 0;
		
			while(line !=null){
				StringTokenizer parser = new StringTokenizer(line," ");

			
				while(parser.hasMoreTokens()){	
					String word = parser.nextToken().toUpperCase();
					T_store[i] = word;
				}                        
				line = in.readLine(); i++;
			
			}
			in.close();
		
		} catch(IOException e){System.out.println(e);}
	}
	public void print(){ //����Ʈ
		RandomStore();
		
		Random random = new Random();
		int n = random.nextInt(2);
		System.out.println("-------------------������ ��õ �Ĵ�-------------------");
		System.out.println(T_store[2*(n)]+"\n��ȭ��ȣ : "+T_store[2*(n)+1]);
		System.out.println("------------------------------------------------");
	
	}


}
