package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * ���� �̸� �Է¹޾Ƽ� �ش� ���� �޴� ��� 
 */
public class Menu {
	public String cate;
	public String storeName;
	public int price;
	public String[] menuList;
	public String total[] = new String[100];
	public Scanner scan = new Scanner(System.in);
	
	public int menuCount;
	
	public Menu(String name, String c){ //���� �Է¹ޱ�, delivery�� getName ����.
		cate = c;
		storeName = name;
		menuCount = 0;
		menuList = new String[100];
	}
	
	public void printMenu(){ //���Կ� ���� �޴� ���
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\"+cate+"\\"+storeName+".txt"));
			String line = in.readLine();
			int i = 0;
			
			while(line !=null){
				StringTokenizer parser = new StringTokenizer(line," ");		
				
				while(parser.hasMoreTokens()){	
					String word = parser.nextToken().toUpperCase();
					menuList[i] = word;	
				}                        
				line = in.readLine(); i++;
				
			}
			in.close();
			System.out.println("�޴�: ");
			int index=1;
			for(int j = 0; menuList[j]!=null; j+=2){
				System.out.println(index+"."+menuList[j]+"\n����: "+menuList[j+1]); index++;
				menuCount++;
			}
					
		} catch(IOException e){System.out.println(e);}
			
		}
	public int selectMenu(){ //���/����� �޴� ������ �����ϱ� 
		int n=0;
		int tcount = 0;
		
		n = scannerException(menuCount); //n�� �ǹٸ� �����ΰ�? �˻�
		
		total[tcount++] = menuList[2*(n-1)];
		
		price += Integer.parseInt(menuList[2*(n-1)+1]);
		
		System.out.print("���ø޴� : ");
		
		for(int i = 0; total[i]!=null;i++){
			System.out.print(i+1+"."+total[i]+" ");
		}
		System.out.println("\n����: "+price);
		
		System.out.println("�� �����Ͻðڽ��ϱ�?\n1.Yes    2.NO    3.Menu_Cancel");
		n = scannerException(3);
		
		while(n==1 || n==3){ //1. ���� �̳� 3.���� �� ������ ��� 
			if(n==3){
				System.out.println("������ �޴���ȣ�� �������ּ���. " );
				n = scannerException(tcount);
				
				String tmp = total[n-1];
				total[n-1]=null;
				System.arraycopy(total, n, total, n-1, total.length-n-1); tcount--;
				
				for(int i = 0; menuList[i]!=null; i+=2){
					if(tmp.equals(menuList[i])){ 
						price -= Integer.parseInt(menuList[i+1]);
						break;
					}
				}
			}
				
			else{
				System.out.println("�޴�: ");
			
				for(int j = 0; menuList[j]!=null; j+=2){
					System.out.println(n+"."+menuList[j]+" ����: "+menuList[j+1]); 
					n++; 
				}
			
				n = scannerException(menuCount);
				total[tcount++] = menuList[2*(n-1)];
			
				price += Integer.parseInt(menuList[2*(n-1)+1]);
				
			}
		
			System.out.print("���ø޴� : ");
			
			for(int i = 0; total[i]!=null;i++){
				System.out.print(i+1+"."+total[i]+" ");
			}
			
			System.out.println("\n����: "+price);
			System.out.println("�� �����Ͻðڽ��ϱ�?\n1.Yes    2.NO     3.Menu_Cancel");
			n = scannerException(3);
			
		}
		
		return price;
	}
	/*
	 * �޴� �����̳� �޴� �߰�, �����Ҷ� ���� ���� �˻�� �Լ�
	 */
	public int scannerException(int m){
		int n=0;
		
		while(true){
			try{
				n = scan.nextInt();
				if(n > m) throw new Exception(); //�޴� ���� ��ȣ exception
				break;
			}
			catch(InputMismatchException ime){ //���ڸ� �Է����� ��
				scan = new Scanner(System.in);
				System.out.println("���ڸ� �Է����ּ���.\n ");
			}
			catch(Exception e){ //�޴� ��ȣ�� �ʰ����� ��
				System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.\n");	
			}
		}
		
		return n;
		
	}
	public String[] getTotalList(){
		return total;
	}
	public int getPrice(){
		return price;
	}
	public String getStoreName(){
		return storeName;
	}
}

