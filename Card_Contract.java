public class Card_Contract extends Telephone {
	

	private int first_monthly_rest; /* type declaration for variables used in the code, describing each Card Contract*/
	
	/* giving each variable services, read in the main Program
super() is used for giving variables of the Telephone class Services
while, this.first_monthly_rest=first_monthly_rest is used for giving each variable the 
service of the variable typed by the user without having to change the name 
of this variable between relative classes */
	public Card_Contract(){
	}
	
	public Card_Contract(String name,int pagio,double discount, int free_speaking_time,int free_SMS,int charge_speaking_time,int charge_SMS,int first_monthly_rest){
		super(name,pagio,discount, free_speaking_time,free_SMS,charge_speaking_time,charge_SMS);
		this.first_monthly_rest=first_monthly_rest;
	}
	/* Set & Get methods used for giving access to the variables of Card Contract*/
	public void setFirst_monthly_rest(int first_monthly_rest){
		this.first_monthly_rest=first_monthly_rest;
	}
	public int getFirst_monthly_rest(){
		return first_monthly_rest;
	}
	/* toString method that returns a string representation of the object.*/
	public String toString(){
		return super.toString()+ "First monthly rest: "+first_monthly_rest +"$";
	}
}