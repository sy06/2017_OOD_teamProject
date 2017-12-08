package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
   private String Name;
   private int PhoneNumber;
   private String address;
   Payment payment = new Payment();
   Scanner scan = new Scanner(System.in);
  
   public User(){
      Name = "guest";
   }
   public void setUserName(String name){
      Name = name;
   }
   
   public void setPhoneNumber(int number) {
      PhoneNumber = number;
   }
   public void setAddress(String address){
      this.address = address;
   }
   
   public String getUserName(){
      return Name;
   }

   public int getUserPhoneNumber() {
      return PhoneNumber;
   }
   public String getUserAddress(){
      return address;
   }
   
   public void testUser() {
      System.out.println("���� ����� ���ּ���. ");
      System.out.println("�� �̸� : "); setUserName(scan.nextLine());
      System.out.println("�� ��ȭ��ȣ : ");

      while(true) {

      try {
         setPhoneNumber(scan.nextInt()); //scan.nextLine();
         break;
      }
      catch(InputMismatchException ime){
         scan = new Scanner(System.in);
         System.out.print("���ڸ� �Է����ּ���.\n ");
      }
   }
      scan.nextLine();
      System.out.println("�� �ּ� : "); setAddress(scan.nextLine());
   }
}