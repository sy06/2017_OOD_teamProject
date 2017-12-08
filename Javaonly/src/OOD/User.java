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
      System.out.println("유저 등록을 해주세요. ");
      System.out.println("☞ 이름 : "); setUserName(scan.nextLine());
      System.out.println("☞ 전화번호 : ");

      while(true) {

      try {
         setPhoneNumber(scan.nextInt()); //scan.nextLine();
         break;
      }
      catch(InputMismatchException ime){
         scan = new Scanner(System.in);
         System.out.print("숫자만 입력해주세요.\n ");
      }
   }
      scan.nextLine();
      System.out.println("☞ 주소 : "); setAddress(scan.nextLine());
   }
}