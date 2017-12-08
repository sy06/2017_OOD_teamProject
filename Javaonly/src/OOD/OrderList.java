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
		System.out.println("\n�� �ֹ� Ȯ���ϱ⢸\n");
		System.out.println("*****�ֹ��� ���� ***** \n"+"�̸�: "+user.getUserName()+"\n�޴��� ��ȣ: "+user.getUserPhoneNumber()
		+"\n��� �ּ�: "+user.getUserAddress());
		
		System.out.println("\n\n*****�ֹ� ����*****\n"+"�ֹ� ���� : "+storeName+"\n���� ��ȭ��ȣ : "+storeTelephone+"\n�ֹ� ����: "+price+"\n�ֹ� �޴� : ");
		
		for(int i = 0; menuList[i]!=null; i++){
			System.out.println("��   "+menuList[i]);
		}
		
	}
	

}
