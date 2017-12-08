package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cash {
   private String bank;
   private long bankNumber;
   private String bankPW;
   String[] possibleBank = new String[8];

   public void initializeBank() {
      possibleBank[0] = "����";
      possibleBank[1] = "KB����";
      possibleBank[2] = "�Ｚ";
      possibleBank[3] = "����";
      possibleBank[4] = "��";
      possibleBank[5] = "�ϳ�";
      possibleBank[6] = "�Ե�";
      possibleBank[7] = "NKä��";
      for (int i = 0; i < possibleBank.length; i = i + 2) {
         for (int j = i; j < i + 2; j++) {
            System.out.print((j + 1) + ". " + possibleBank[j] + "\t");
         }
         System.out.println();
      }
   }

   public void startCash() {
      System.out.println("������ü ������ �����մϴ�. ");
      Scanner scan = new Scanner(System.in);
      System.out.println("\n������ �������ּ���. ");
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
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      setBank(possibleBank[bank - 1]);
      System.out.println("\n���� ��ȣ�� �Է����ּ���. (- ����)");
      long bankNum;
      while (true) {
         try {
            bankNum = scan.nextLong();
            if (bankNum < 0)
               throw new Exception();
            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      setBankNumber(bankNum);
      scan.nextLine();
      System.out.println("\n���� ��й�ȣ�� �Է����ּ���. (4�ڸ�)");
      String bankPassword = scan.nextLine();
      setBankPW(bankPassword);
   }

   public void printInputCash() {
      System.out.println("���� �Է��Ͻ� ������ Ȯ���մϴ�.");
      System.out.println("�Է��Ͻ� ������ " + getBank() + "�Դϴ�.");
      System.out.println("�Է��Ͻ� ���� ��ȣ�� " + getBankNumber() + "�Դϴ�.");
      System.out.println("�Է��Ͻ� ���� ��й�ȣ�� " + getBankPW() + "�Դϴ�.");
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