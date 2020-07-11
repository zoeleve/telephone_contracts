public class Services{
	
	String name;  /* type declaration for variables used in the code, describing each Service*/
	int pagio;
	double discount;
	
	/*this.name=name is used for giving each variable the 
service of the variable typed by the user without having to change the name 
of this variable between relative classes */

	public Services(){
	}

	public Services(String name, int pagio, double discount){
		this.name=name;
		this.pagio=pagio;
		this.discount=discount;
	}
	/* Set & Get methods used for giving access to the variables of Services*/
	public void setDiscount(double discount){
		this.discount=discount;
	}
	public double getDiscount(){
		return discount;
	}
	 public void setName(String name){
		 this.name=name;
	 }
	 public String getName(){
		 return name;
	 }
	 public void setPagio(int pagio){
		 this.pagio=pagio;
	 }
	 public int getPagio(){
		 return pagio;
	 }
	 /* toString method that returns a string representation of the object.*/
	 public String toString(){
		 return "Name: " +name+ " Pagio: "+pagio + "$";
	 }
}