package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * 오늘의 메뉴
 */
public class TodayMenu {
	private String T_store[]; //오늘의 가게
	private String T_category; //오늘의 카테고리
	
	/*
	 * 가게 리스트 초기화
	 */
	public TodayMenu(){
		T_store = new String[100];	
	}
	
	/*
	 * 사용자가 원하는 카테고리 선택
	 */
	public void SelectCategory(){ 
		Scanner scan = new Scanner(System.in);
		int n=0;
		
		System.out.println("***** 먹고싶은 음식 종류를 선택해주세요. *****");
		
		while(true){
			System.out.println("1. 분식\n2. 한식 \n3. 일식&돈까스\n4. 도시락\n5. "
					+ "족발보쌈\n6. 찜,탕\n7. 패스트푸드\n8. 피자\n9. 치킨\n10. 중국집");
			
			try{
				n = scan.nextInt();
				if(n>10) throw new Exception();
				
				break;
			}
			catch(InputMismatchException ime){
				scan = new Scanner(System.in);
				System.out.println("숫자만 입력해주세요.\n ");
			}
			catch(Exception e){
				System.out.println("옳바른 번호가 아닙니다.\n");	
			}	
		}
		
		if(n==1) T_category = "분식";
		else if(n==2) T_category = "한식";
		else if(n==3) T_category = "일식&돈까스";
		else if(n==4) T_category = "도시락"; else if(n==5) T_category = "족발보쌈";
		else if(n==6) T_category = "찜,탕"; else if(n==7) T_category = "패스트푸드";
		else if(n==8) T_category = "피자"; else if(n==9) T_category = "치킨";
		else if(n==10) T_category = "중국집";
	}
	
	/*
	 * 카테고리 내의 랜덤가게 선정
	 */
	public void RandomStore(){ 
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\오늘의메뉴\\"+T_category+".txt"));
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
	/*
	 * 선택된 오늘의 추천 식당 프린트
	 */
	public void print(){ 
		RandomStore();
		
		Random random = new Random();
		int n = random.nextInt(2);
		System.out.println("-------------------오늘의 추천 식당-------------------");
		System.out.println(T_store[2*(n)]+"\n전화번호 : "+T_store[2*(n)+1]);
		System.out.println("------------------------------------------------");
	
	}


}
