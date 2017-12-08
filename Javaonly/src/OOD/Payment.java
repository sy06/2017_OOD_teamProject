package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 결제
 */
public class Payment {
   int choice; //결제 방식 번호
   int price; //결제 가격
   Credit c = new Credit();
   Cash c2 = new Cash();
   Direct d = new Direct();
   Scanner input = new Scanner(System.in);

   /*
    * 결제 방식 선택하기
    */
   public int StartPayment() {
      System.out.println("\n\n결제방식을 선택하세요. (1.신용카드 결제 , 2.계좌이체 결제, 3.만나서 결제)");
      while (true) {
         try {
            choice = input.nextInt();
            if (choice > 3 || choice < 0)
               throw new Exception();
            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다. 다시 입력하세요.");
         }
      }
      System.out.println();
      return choice;
   }

   /*
    * 결제하기 / 1번 = 카드결제 ,2번 = 계좌이체, 3번 = 현금결제
    */
   public void doPayment(int p) {
	   price = p;
      while (true) {
         StartPayment();
         if (choice == 1)
            if (CreditChoice())
               break;
         if (choice == 2)
            if (CashChoice())
               break;
         if (choice == 3)
            if (DirectChoice())
               break;
      }
   }

   /*
    * 카드 선택했을 때 진행
    */
   public boolean CreditChoice() {
      if (c == null) {
         System.out.println("결제에 실패하였습니다.");
         return false;
      }
      int tmp = 0;
      c.startCredit();
      c.printInputCredit();
      System.out.println("\n\n입력하신 결제 정보가 맞습니까? (1.Yes , 2.No)");
      while (true) {
         try {
            tmp = input.nextInt();
            if (tmp > 2 || tmp < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      if (tmp == 2) {
         System.out.println("\n결제를 취소합니다.");
         return false;
      }
      System.out.println("\n결제가 완료되었습니다.");
      return true;
   }
/*
 * 계좌이체 선택했을 때 진행
 */
   public boolean CashChoice() {
      if (c2 == null) {
         System.out.println("결제에 실패하였습니다.");
         return false;
      }
      int tmp = 0;
      c2.startCash();
      c2.printInputCash();
      System.out.println("\n\n입력하신 결제 정보가 맞습니까? (1.Yes , 2.No)");
      while (true) {
         try {
            tmp = input.nextInt();
            if (tmp > 2 || tmp < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      if (tmp == 2) {
         System.out.println("\n결제를 취소합니다.");
         return false;
      }
      System.out.println("\n결제가 완료되었습니다.");
      return true;
   }
/*
 * 만나서 결제 선택했을 때 진행
 */
   public boolean DirectChoice() {
      if (d == null) {
         System.out.println("결제에 실패하였습니다.");
         return false;
      }
      int tmp = 0;
      d.setTotalMoney(price);
      d.startDirect();
      System.out.println("\n\n결제를 완료하시겠습니까? (1.Yes , 2.No)");
      while (true) {
         try {
            tmp = input.nextInt();
            if (tmp > 2 || tmp < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      if (tmp == 2) {
         System.out.println("\n결제를 취소합니다.");
         return false;
      }
      System.out.println("\n결제가 완료되었습니다.");
      return true;
   }
}
