import java.util.ArrayList;
public class Contract_List {
	private ArrayList<User_Contract>  list= new ArrayList<User_Contract>();  //arrayList containing all the available user contract
	public void storeContract( User_Contract contract) {
	    list.add(contract);
	}
	
	public void printContract() { //view (print) available contract
		
		for (int i=0; i<list.size(); i++) {
			String str=list.get(i).toString();
			System.out.println(str);
		}
	}
	
	public int Entries(){
		return list.size();
	}
	
	public User_Contract Cont(int i) {
		return list.get(i);
	}
}