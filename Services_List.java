import java.util.ArrayList;
public class Services_List {
	private ArrayList<Services>  list= new ArrayList<Services>(); //arrayList containing all the available services  
	private String str;
	public void storeServices(Services services) {
	    list.add(services);
	}
	
	public void showContract() { //view (print) available contract
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) instanceof Contract){
				str=list.get(i).toString();
				System.out.println(str);
			}
		}
	}
	public void showCard_Contract() { //view(print) available card contract
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) instanceof Card_Contract){
				str=list.get(i).toString();
				System.out.println(str);
			}
		}
	}
	public void showInternet() { //view (print) available internet contract
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) instanceof Internet){
				str=list.get(i).toString();
				System.out.println(str);
			}	
		}
	}
	public int Entries(){ 
		return list.size();
	}
	
	public Services Serv(int i) {
		return list.get(i);
	}
}
	