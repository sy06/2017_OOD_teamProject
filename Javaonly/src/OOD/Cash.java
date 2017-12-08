package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cash {
   private String bank;
   private long bankNumber;
   private String bankPW;
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

   public void startCash() {
      System.out.println("계좌이체 결제를 시작합니다. ");
      Scanner scan = new Scanner(System.in);
      System.out.println("\n은행을 선택해주세요. ");
      initializeBank();
      int bank;
      while (true) {
         try {
            bank = scan.nextInt();
            if (bank > 8 || bank < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      setBank(possibleBank[bank - 1]);
      System.out.println("\n계좌 번호를 입력해주세요. (- 제외)");
      long bankNum;
      while (true) {
         try {
            bankNum = scan.nextLong();
            if (bankNum < 0)
               throw new Exception();
            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요.");
         } catch (Exception e) {
            System.out.println("옳바른 번호가 아닙니다.");
         }
      }
      setBankNumber(bankNum);
      scan.nextLine();
      System.out.println("\n계좌 비밀번호를 입력해주세요. (4자리)");
      String bankPassword = scan.nextLine();
      setBankPW(bankPassword);
   }

   public void printInputCash() {
      System.out.println("현재 입력하신 정보를 확인합니다.");
      System.out.println("입력하신 은행은 " + getBank() + "입니다.");
      System.out.println("입력하신 계좌 번호는 " + getBankNumber() + "입니다.");
      System.out.println("입력하신 계좌 비밀번호는 " + getBankPW() + "입니다.");
   }

   public void setBank(String b) {
      bank = b;
   }

   public String getBank() {
      return bank;
   }

   public void setBankNumber(long b) {
      bankNumber = b;
   }

   public long getBankNumber() {
      return bankNumber;
   }

   public void setBankPW(String b) {
      bankPW = b;
   }

   public String getBankPW() {
      return bankPW;
   }
}