package OOD;

public class OrderList {
	public User user;
	public int price;
	public String storeName;
	public String[] menuList;
	public String storeTelephone;
	
	public OrderList(User user){
		this.user = user;
	}
	
	public int getPrice(){
		return price;
	}
	public String getStore(){
		return storeName;
	}
	public String[] getMenuList(){
		return menuList;
	}
	public String getStoreTelephone(){
		return storeTelephone;
	}
	public void setPrice(int p){
		price = p;
	}
	public void setStore(String store){
		storeName = store;
	}
	public void setMenuList(String[] m){
		menuList = m;
	}
	public void setStoreTelephone(String tel){
		storeTelephone = tel;
	}
	
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
