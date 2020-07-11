public class Internet extends Services{
	
	private double free_data;/* type declaration for variables used in the code, describing each service of Internet*/
	private double charge;

	
	/* giving each variable services, read in the main Program
super() is used for giving variables of the Services
while, this.free_data=free_data is used for giving each variable the 
service of the variable typed by the user without having to change the name 
of this variable between relative classes */
	public Internet(){
	}
	
	public Internet(String name,int pagio, double discount, double free_data,double charge){
		super(name,pagio,discount);
		this.free_data=free_data;
		this.charge=charge;
	}
	/* Set & Get methods used for giving access to the variables of Internet*/
	public void setFree_data(double free_data){
		this.free_data=free_data;
	}
	public double getFree_data(){
		return free_data;
	}
	public void setCharge(double charge){
		this.charge=charge;
	}
	public double getCharge(){
		return charge;
	}
	/* toString method that returns a string representation of the object.*/
	public String toString(){
		return super.toString()+ "Free data: "+free_data+ "MB" + " Charge: "+charge+ "$/15 MB";
	}
}
	
	
	
	
	