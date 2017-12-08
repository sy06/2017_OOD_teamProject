package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Credit {
   private String bank;
   private long cardNumber;
   private String validDate;
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

   public void startCredit() {
      System.out.println("�ſ�ī�� ������ �����մϴ�. ");
      Scanner scan = new Scanner(System.in);
      System.out.println("\nī�带 �������ּ���. ");
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
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      setBank(possibleBank[bankNum - 1]);
      System.out.println("\nī�� ��ȣ�� �Է����ּ���. (- ����)");
      long cardNum;
      while (true) {
         try {
            cardNum = scan.nextLong();
            if (cardNum < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      setCardNumber(cardNum);
      scan.nextLine();
      System.out.println("\nī���� ��ȿ �Ⱓ�� �Է����ּ���. (4�ڸ�)");
      String validNum = scan.nextLine();
      setValidDate(validNum);
   }

   public void printInputCredit() {
      System.out.println("���� �Է��Ͻ� ������ Ȯ���մϴ�.");
      System.out.println("�Է��Ͻ� ī���� " + getBank() + "�Դϴ�.");
      System.out.println("�Է��Ͻ� ī�� ��ȣ�� " + getCardNumber() + "�Դϴ�.");
      System.out.println("�Է��Ͻ� ī���� ��ȿ �Ⱓ�� " + getValidDate() + "�Դϴ�.");
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
