public class Telephone extends Services{
	
	private int free_speaking_time;/* type declaration for variables used in the code, describing each service of telephone*/
	private int free_SMS;
	private int charge_speaking_time;
	private int charge_SMS;
	
	/* giving each variable services, read in the main Program
super() is used for giving variables of the Services
while, this.free_SMS=free_SMS is used for giving each variable the 
service of the variable typed by the user without having to change the name 
of this variable between relative classes */

	public Telephone(){
	}
	
	
	public Telephone(String name, int pagio, double discount, int free_speaking_time,int free_SMS,int charge_speaking_time,int charge_SMS){
		super(name,pagio,discount);
		this.free_speaking_time=free_speaking_time;
		this.free_SMS=free_SMS;
		this.charge_speaking_time=charge_speaking_time;
		this.charge_SMS=charge_SMS;
	}
	/* Set & Get methods used for giving access to the variables of telephone*/
	public void setFree_speaking_time(int free_speaking_time){
		this.free_speaking_time=free_speaking_time;
	}
	public int getFree_speaking_time(){
		return free_speaking_time;
	}
	public void setFree_SMS(int free_SMS){
		this.free_SMS=free_SMS;
	}
	public int getFree_SMS(){
		return free_SMS;
	}
	public void setCharge_speaking_time(int charge_speaking_time){
		this.charge_speaking_time=charge_speaking_time;
	}
	public int getCharge_speaking_time(){
		return charge_speaking_time;
	}
	public void setCharge_SMS(int charge_SMS){
		this.charge_SMS=charge_SMS;
	}
	public int getCharge_SMS(){
		return charge_SMS;
	}
	/* toString method that returns a string representation of the object.*/
	public String toString(){
		return " " +super.toString()+ " Free speaking time: "+free_speaking_time+ " minutes" +" Free SMS: "+free_SMS+ " Charge speaking time: "+charge_speaking_time+"$/minutes"+ " Charge SMS: "+charge_SMS +"$/SMS";
	}
	
}
	
	
	