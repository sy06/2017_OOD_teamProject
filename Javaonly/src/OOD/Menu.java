package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 가게 이름 입력받아서 해당 가게 메뉴 출력 
 */
public class Menu {
   public String cate;
   public String storeName;
   public int price;
   public String[] menuList;
   public String total[] = new String[100];
   public Scanner scan = new Scanner(System.in);
   
   public int menuCount;
   
   public Menu(String name, String c){ //가게 입력받기, delivery에 getName 있음.
      cate = c;
      storeName = name;
      menuCount = 0;
      menuList = new String[100];
   }
   
   public void printMenu(){ //가게에 따른 메뉴 출력
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
         System.out.println("메뉴: ");
         int index=1;
         for(int j = 0; menuList[j]!=null; j+=2){
            System.out.println(index+"."+menuList[j]+"\n가격: "+menuList[j+1]); index++;
            menuCount++;
         }
               
      } catch(IOException e){System.out.println(e);}
         
      }
   public int selectMenu(){ //출력/저장된 메뉴 가지고 선택하기 
      int n=0;
      int tcount = 0;
      
      n = scannerException(menuCount); //n은 옳바른 숫자인가? 검사
      
      total[tcount++] = menuList[2*(n-1)];
      
      price += Integer.parseInt(menuList[2*(n-1)+1]);
      
      System.out.print("선택메뉴 : ");
      
      for(int i = 0; total[i]!=null;i++){
         System.out.print(i+1+"."+total[i]+" ");
      }
      System.out.println("\n가격: "+price);
      
      System.out.println("더 선택하시겠습니까?\n1.Yes    2.NO    3.Menu_Cancel");
      n = scannerException(3);
      
      while(n==1 || n==3){ //1. 선택 이나 3.삭제 를 눌렀을 경우 
         if(n==3){
            System.out.println("삭제할 메뉴번호를 선택해주세요. " );
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
            System.out.println("메뉴: ");
         
            for(int j = 0; menuList[j]!=null; j+=2){
               System.out.println(n+"."+menuList[j]+" 가격: "+menuList[j+1]); 
               n++; 
            }
         
            n = scannerException(menuCount);
            total[tcount++] = menuList[2*(n-1)];
         
            price += Integer.parseInt(menuList[2*(n-1)+1]);
            
         }
      
         System.out.print("선택메뉴 : ");
         
         for(int i = 0; total[i]!=null;i++){
            System.out.print(i+1+"."+total[i]+" ");
         }
         
         System.out.println("\n가격: "+price);
         System.out.println("더 선택하시겠습니까?\n1.Yes    2.NO     3.Menu_Cancel");
         n = scannerException(3);
         
      }
      
      return price;
   }
   /*
    * 메뉴 선택이나 메뉴 추가, 삭제할때 숫자 범위 검사용 함수
    */
   public int scannerException(int m){
      int n=0;
      
      while(true){
         try{
            n = scan.nextInt();
            if(n > m || n<=0) throw new Exception(); //메뉴 선택 번호 exception
            break;
         }
         catch(InputMismatchException ime){ //문자를 입력했을 때
            scan = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.\n ");
         }
         catch(Exception e){ //메뉴 번호를 초과했을 때
            System.out.println("옳바른 번호가 아닙니다.\n");   
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
