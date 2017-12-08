package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 계좌이체 결제 
 */
public class Cash {
   private String bank; //계좌 은행
   private long bankNumber; // 계좌 번호
   private String bankPW; //계좌 비밀번호
   String[] possibleBank = new String[8]; //결제 가능한 은행들

   public void initializeBank() { //결제 가능 은행 초기화
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
/*
 * 결제 시작, 정보 입력 단계
 */
   public void startCash() {
	   
      System.out.println("계좌이체 결제를 시작합니다. ");
      Scanner scan = new Scanner(System.in);
      System.out.println("\n은행을 선택해주세요. ");
      initializeBank(); //은행 선택
      int bank;
      while (true) { //은행 선택 항목 / 잘못된 숫자, 문자 입력시 재시도
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
      setBank(possibleBank[bank - 1]); //사용자의 계좌 은행을 입력받은 bank로 설정
      
      System.out.println("\n계좌 번호를 입력해주세요. (- 제외)");
      long bankNum;
      
      while (true) { //계좌번호 입력란 / 잘못된 숫자, 문자 입력시 재시도
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
      setBankNumber(bankNum); //사용자의 계좌번호 설정
      
      scan.nextLine();
      System.out.println("\n계좌 비밀번호를 입력해주세요. (4자리)");
      String bankPassword = scan.nextLine();
      setBankPW(bankPassword); //계좌번호의 비밀번호
   }
/*
 * 입력한 모든 정보 출력 / 은행, 계좌번호, 계좌 비밀번호 
 */
   public void printInputCash() { 
      System.out.println("현재 입력하신 정보를 확인합니다.");
      System.out.println("입력하신 은행은 " + getBank() + "입니다.");
      System.out.println("입력하신 계좌 번호는 " + getBankNumber() + "입니다.");
      System.out.println("입력하신 계좌 비밀번호는 " + getBankPW() + "입니다.");
   }
/*
 * 사용자 은행 설정
 */
   public void setBank(String b) {
      bank = b;
   }
/*
 * 사용자 은행 리턴
 */
   public String getBank() {
      return bank;
   }
/*
 * 사용자 계좌번호 설정
 */
   public void setBankNumber(long b) {
      bankNumber = b;
   }
/*
 * 계좌번호 리턴
 */
   public long getBankNumber() {
      return bankNumber;
   }
/*
 * 계좌 비밀번호 설정
 */
   public void setBankPW(String b) {
      bankPW = b;
   }
/*
 * 계좌 비밀번호 리턴
 */
   public String getBankPW() {
      return bankPW;
   }
}
   }
}
