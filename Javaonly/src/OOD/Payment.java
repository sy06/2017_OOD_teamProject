package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Payment {
   int choice;
   int price;
   Credit c = new Credit();
   Cash c2 = new Cash();
   Direct d = new Direct();
   Scanner input = new Scanner(System.in);

   public int StartPayment() {
      System.out.println("\n\n��������� �����ϼ���. (1.�ſ�ī�� ���� , 2.������ü ����, 3.������ ����)");
      while (true) {
         try {
            choice = input.nextInt();
            if (choice > 3 || choice < 0)
               throw new Exception();
            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�. �ٽ� �Է��ϼ���.");
         }
      }
      System.out.println();
      return choice;
   }

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

   public boolean CreditChoice() {
      if (c == null) {
         System.out.println("������ �����Ͽ����ϴ�.");
         return false;
      }
      int tmp = 0;
      c.startCredit();
      c.printInputCredit();
      System.out.println("\n\n�Է��Ͻ� ���� ������ �½��ϱ�? (1.Yes , 2.No)");
      while (true) {
         try {
            tmp = input.nextInt();
            if (tmp > 2 || tmp < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      if (tmp == 2) {
         System.out.println("\n������ ����մϴ�.");
         return false;
      }
      System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
      return true;
   }

   public boolean CashChoice() {
      if (c2 == null) {
         System.out.println("������ �����Ͽ����ϴ�.");
         return false;
      }
      int tmp = 0;
      c2.startCash();
      c2.printInputCash();
      System.out.println("\n\n�Է��Ͻ� ���� ������ �½��ϱ�? (1.Yes , 2.No)");
      while (true) {
         try {
            tmp = input.nextInt();
            if (tmp > 2 || tmp < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      if (tmp == 2) {
         System.out.println("\n������ ����մϴ�.");
         return false;
      }
      System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
      return true;
   }

   public boolean DirectChoice() {
      if (d == null) {
         System.out.println("������ �����Ͽ����ϴ�.");
         return false;
      }
      int tmp = 0;
      d.setTotalMoney(price);
      d.startDirect();
      System.out.println("\n\n������ �Ϸ��Ͻðڽ��ϱ�? (1.Yes , 2.No)");
      while (true) {
         try {
            tmp = input.nextInt();
            if (tmp > 2 || tmp < 0)
               throw new Exception();

            break;
         } catch (InputMismatchException ime) {
            input = new Scanner(System.in);
            System.out.println("���ڸ� �Է����ּ���.");
         } catch (Exception e) {
            System.out.println("�ǹٸ� ��ȣ�� �ƴմϴ�.");
         }
      }
      if (tmp == 2) {
         System.out.println("\n������ ����մϴ�.");
         return false;
      }
      System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
      return true;
   }
}