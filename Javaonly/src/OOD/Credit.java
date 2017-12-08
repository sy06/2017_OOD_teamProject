package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Credit {
   private String bank;
   private long cardNumber;
   private String validDate;
   String[] possibleBank = new String[8];

   public void initializeBank() {
      possibleBank[0] = "신한";
      possibleBank[1] = "KB국민";
      possibleBank[2] = "삼성";
      possibleBank[3] = "현대";
      possibleBank[4] = "비씨";
      possibleBank[5] = "하나";
      possibleBank[6] = "롯데";
      possibleBank[7] = "NK채움";
      for (int i = 0; i < possibleBank.length; i = i + 2) {
         for (int j = i; j < i + 2; j++) {
            System.out.print((j + 1) + ". " + possibleBank[j] + "\t");
         }
         System.out.println();
      }
   }

   public void startCredit() {
      System.out.println("신용카드 결제를 시작합니다. ");
      Scanner scan = new Scanner(System.in);
      System.out.println("\n카드를 선택해주세요. ");
      initializeBank();
      int bankNum;
      while (true) {
         try {
            bankNum = scan.nextInt();
            if (bankNum > 8 || bankNum < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      setBank(possibleBank[bankNum - 1]);
      System.out.println("\n카드 번호를 입력해주세요. (- 제외)");
      long cardNum;
      while (true) {
         try {
            cardNum = scan.nextLong();
            if (cardNum < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      setCardNumber(cardNum);
      scan.nextLine();
      System.out.println("\n카드의 유효 기간을 입력해주세요. (4자리)");
      String validNum = scan.nextLine();
      setValidDate(validNum);
   }

   public void printInputCredit() {
      System.out.println("현재 입력하신 정보를 확인합니다.");
      System.out.println("입력하신 카드사는 " + getBank() + "입니다.");
      System.out.println("입력하신 카드 번호는 " + getCardNumber() + "입니다.");
      System.out.println("입력하신 카드의 유효 기간은 " + getValidDate() + "입니다.");
   }

   public void setBank(String b) {
      bank = b;
   }

   public String getBank() {
      return bank;
   }

   public void setCardNumber(long c) {
      cardNumber = c;
   }

   public long getCardNumber() {
      return cardNumber;
   }

   public void setValidDate(String v) {
      validDate = v;
   }

   public String getValidDate() {
      return validDate;
   }
}
