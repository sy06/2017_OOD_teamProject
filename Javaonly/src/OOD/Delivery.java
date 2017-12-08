package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * ī�װ� �޾Ƽ� ���� ���, ���� ����, �޴� ���ñ��� ���� 
 */
public class Delivery {
	public String[] category = {"�н�", "�ѽ�", "�Ͻ�&���", "���ö�", "���ߺ���", 
			"��,��", "�н�ƮǪ��", "����", "ġŲ", "�߱���"};; //ī�װ�
	public int categoryNumber;
	public int totalPrice;
	public String storeTelephone;
	String[] store = new String[50]; //���� ����(ex ����, ����, �����̳�)

	public Delivery(int number){ //number = ī�װ� ��ȣ �Է� (findstore�� getcategory ����)
		categoryNumber = number;
		totalPrice = 0;
	}
	
	public void printStore(){		//ī�װ��� ���� �Ĵ� ��� 
	
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\"+category[categoryNumber-1]+"\\"+category[categoryNumber-1]+".txt"));
			String line = in.readLine();
			int i = 0;
		
			while(line !=null){
				StringTokenizer parser = new StringTokenizer(line," ");

			
				while(parser.hasMoreTokens()){	
					String word = parser.nextToken().toUpperCase();
					store[i] = word;
				}                        
				line = in.readLine(); i++;
			
			}
			in.close();
		
		} catch(IOException e){System.out.println(e);}
	
		for(int i=0, j=1; store[i]!=null; i+=2){
			System.out.println(j+"."+store[i]+"\n��ȭ��ȣ : "+store[i+1]);
			j++;
		}
	}
	
	public String selectStore(){ //�Ĵ� ����, �Ĵ� ��� ���Ŀ� ��� �ٶ�.
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while(true){
			try{
				n = scan.nextInt();
				if(store[2*(n-1)]==null) throw new Exception();
				
				break;
			}
			catch(InputMismatchException ime){
				scan = new Scanner(System.in);
				System.out.println("���ڸ� �Է����ּ���.\n ");
				printStore();
			}
			catch(Exception e){
				System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.\n");
				printStore();
			}
		}
		storeTelephone = store[2*(n-1)+1];
		return store[2*(n-1)];
	}
	
	public void order(OrderList orderlist){ //�ֹ�, (������� -> �޴���ü ���� -> �޴� ����Ʈ )		
		printStore();
		
		Menu m = new Menu(selectStore(), category[categoryNumber-1]);
		m.printMenu();
		totalPrice = m.selectMenu();
		
		orderlist.setPrice(totalPrice);
		orderlist.setMenuList(m.getTotalList());
		orderlist.setStore(m.getStoreName());
		orderlist.setStoreTelephone(getStoreTelephone());
	}
	public String getStoreTelephone(){
		return storeTelephone;
	}
}
