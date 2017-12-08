package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 카테고리 받아서 가게 출력, 가게 선택, 메뉴 선택까지 가능 
 */
public class Delivery {
	public String[] category = {"분식", "한식", "일식&돈까스", "도시락", "족발보쌈", 
			"찜,탕", "패스트푸드", "피자", "치킨", "중국집"};; //카테고리
	public int categoryNumber;
	public int totalPrice;
	public String storeTelephone;
	String[] store = new String[50]; //가게 종류(ex 혜인, 수정, 수연이네)

	public Delivery(int number){ //number = 카테고리 번호 입력 (findstore에 getcategory 있음)
		categoryNumber = number;
		totalPrice = 0;
	}
	
	public void printStore(){		//카테고리에 따른 식당 출력 
	
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
			System.out.println(j+"."+store[i]+"\n전화번호 : "+store[i+1]);
			j++;
		}
	}
	
	public String selectStore(){ //식당 선택, 식당 출력 이후에 사용 바람.
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
				System.out.println("숫자만 입력해주세요.\n ");
				printStore();
			}
			catch(Exception e){
				System.out.println("옳바른 번호가 아닙니다.\n");
				printStore();
			}
		}
		storeTelephone = store[2*(n-1)+1];
		return store[2*(n-1)];
	}
	
	public void order(OrderList orderlist){ //주문, (가게출력 -> 메뉴객체 생성 -> 메뉴 프린트 )		
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
