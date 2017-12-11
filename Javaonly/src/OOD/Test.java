package OOD;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
   public static void main(String args[]){
      Scanner scan = new Scanner(System.in);
      int n=0;
      
      while(true){
         try{
      
         System.out.println("번호를 선택해주세요. ");
         System.out.println("1. 배달 \n2. 오늘의 추천 메뉴\n3. 종료");
         
         n = scan.nextInt();
         if(n>3 || n<=0) throw new Exception();
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
      
      if(n==1){
         User user = new User();
         user.testUser();
      
         OrderList orderlist = new OrderList(user);
      
         FindStore f = new FindStore(true); 
         f.setCategory();
      
         Delivery d = new Delivery(f.getCategory());
         d.order(orderlist);
         if(orderlist.getPrice() != 0){
        	   orderlist.print();
        	   user.payment.doPayment(orderlist.getPrice());
         }
        
         else 
            System.out.println("주문한 메뉴가 없으므로 종료합니다.");
      /*
       * 1. 식당찾기 (FindStore)
       * 2. Category정하기 (FindStore에 내장되어 있습니다.)
       * 3. 배달 시키기 (현재 배달 기능만 구현)
       * 4. d.order로 주문하기
       */
      
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
