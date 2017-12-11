package OOD;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 유저 정보
 */
public class User {
   private String Name; //이름
   private String PhoneNumber; //전화번호
   private String address; //주소
   Payment payment = new Payment();
   Scanner scan = new Scanner(System.in);
  
   /*
    * 기본 설정은 "guest"
    */
   public User(){
      Name = "guest";
   }
   /*
    * 유저 이름 설정
    */
   public void setUserName(String name){
      Name = name;
   }
   /*
    * 전화번호 설정
    */
   public void setPhoneNumber(String number) {
      PhoneNumber = number;
   }
   /*
    * 주소 설정
    */
   public void setAddress(String address){
      this.address = address;
   }
   
   /*
    * 유저 이름 리턴
    */
   public String getUserName(){
      return Name;
   }
/*
 * 유저 전화번호 리턴
 */
   public String getUserPhoneNumber() {
      return PhoneNumber;
   }
   /*
    * 유저 주소 리턴
    */
   public String getUserAddress(){
      return address;
   }
   
   /*
    * 유저 등록하기
    */
   public void testUser() {
      System.out.println("유저 등록을 해주세요. ");
      System.out.println("☞ 이름 : "); setUserName(scan.nextLine());
      System.out.println("☞ 전화번호 : ");

      while(true) {

      try {
         setPhoneNumber(scan.nextLine()); //scan.nextLine();
        int n = Integer.parseInt(getUserPhoneNumber());
        if(n/1000000000.0 < 1 || n/1000000000.0 >=2) throw new Exception();
         break;
      }
     catch(Exception e){
      System.out.println("옳바른 번호가 아닙니다.\n");
   }
   }
     
      System.out.println("☞ 주소 : "); setAddress(scan.nextLine());
   }
}
