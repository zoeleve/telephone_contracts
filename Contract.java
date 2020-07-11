public class Contract extends Telephone{
	

	/* giving each variable services, read in the main Program
super() is used for giving variables of the Telephone class Services */
	 public Contract(){
	 }
	 
	 public Contract(String name, int pagio,double discount, int free_speaking_time,int free_SMS,int charge_speaking_time,int charge_SMS){
		super(name, pagio, discount, free_speaking_time, free_SMS, charge_speaking_time, charge_SMS);
		
	}
	
}