package OOD;

/*
 * 최종 주문 리스트
 */
public class OrderList {
	public User user; //유저
	public int price; //총 가격
	public String storeName; //식당 이름
	public String[] menuList; //주문한 메뉴들
	public String storeTelephone; //가게 전화번호
	
	/*
	 * User의 orderList생성
	 */
	public OrderList(User user){
		this.user = user;
	}
	
	/*
	 * 가격 리턴
	 */
	public int getPrice(){
		return price;
	}
	/*
	 * 가게 이름 리턴
	 */
	public String getStore(){
		return storeName;
	}
	/*
	 * 메뉴 리스트 리턴
	 */
	public String[] getMenuList(){
		return menuList;
	}
	/*
	 * 가게 전화번호 리턴
	 */
	public String getStoreTelephone(){
		return storeTelephone;
	}
	/*
	 * 최종 가격 설정
	 */
	public void setPrice(int p){
		price = p;
	}
	/*
	 * 가게  설정
	 */
	public void setStore(String store){
		storeName = store;
	}
	/*
	 * menulist설정
	 */
	public void setMenuList(String[] m){
		menuList = m;
	}
	/*
	 * 가게 전화번호 설정
	 */
	public void setStoreTelephone(String tel){
		storeTelephone = tel;
	}
	/*
	 * 주문 print
	 */
	public void print(){
		System.out.println("\n▶ 주문 확인하기◀\n");
		System.out.println("*****주문자 정보 ***** \n"+"이름: "+user.getUserName()+"\n휴대폰 번호: "+user.getUserPhoneNumber()
		+"\n배달 주소: "+user.getUserAddress());
		
		System.out.println("\n\n*****주문 정보*****\n"+"주문 가게 : "+storeName+"\n가게 전화번호 : "+storeTelephone+"\n주문 가격: "+price+"\n주문 메뉴 : ");
		
		for(int i = 0; menuList[i]!=null; i++){
			System.out.println("☞   "+menuList[i]);
		}
		
	}
	

}

