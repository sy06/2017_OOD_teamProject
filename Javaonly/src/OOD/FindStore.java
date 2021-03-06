package OOD;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 가게 찾는 클래스 
 */
public class FindStore {
   public int category;
   boolean deliverable;
   public Scanner scan = new Scanner(System.in);
   
   public FindStore(boolean delivery){
      /*
       * true = 배달가능, false = 배달 불가능 (현재 true만 구현)
       */
      deliverable = delivery;
   }
   
   public void setCategory(){
      /*
       * 카테고리 분식 or 한식 선택 (추후 추가 가능)
       */   
      int n=0;
      while(true){
         System.out.println("카테고리를 선택하세요\n1. 분식\n2. 한식 "
               + "\n3. 일식&돈까스\n4. 도시락\n5. 족발보쌈\n6. 찜,탕\n7. 패스트푸드\n8. 피자\n9. 치킨\n10. 중국집");
         
         try{
            n = scan.nextInt();
            if(n>10 || n<=0) throw new Exception();
            
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
      
      category = n;
      
   }
   public int getCategory(){
      // 카테고리 번호 리턴
      return category;
   }
}
