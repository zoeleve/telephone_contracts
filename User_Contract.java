public class User_Contract {
	
	private String services,customer,phone,date,redemption,service_name;
	private int code_cont;/* type declaration for variables used in the code, describing each User Contract*/
	private int sms, mobile, fixed;
	private double data,discount, final_cost;
	
	public User_Contract(){
	}
	
	public User_Contract(String services, String customer, String phone, String date, String redemption,int code_cont, int mobile, int fixed, int sms, double data,String service_name,double discount,double final_cost){
		this.services = services;
		this.customer = customer;
		this.phone = phone;
		this.date = date;
		this.redemption = redemption;
		this.code_cont = code_cont;
		this.mobile = mobile;
		this.fixed = fixed;
		this.sms = sms;
		this.data = data;
		this.service_name=service_name;
		this.discount=discount;
		this.final_cost = final_cost;
	}
	/* Get methods used for giving access to the variables of User Contract*/
	
	
	public void setServices(String services){
		this.services = services;
	}
	
	public String getServices(){
		 return services;
	}
	public void setCustomer(String customer){
		this.customer = customer;
	}
	public String getCustomer(){
		 return customer;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		 return phone;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getDate(){
		 return date;
	}
	public void setRedemption(String redemption){
		this.redemption = redemption;
	}
	public String getRedemption(){
		 return redemption;
	}
	public void setCode_cont(int code_cont){
		this.code_cont = code_cont;
	}
	public int getCode_cont(){
		 return code_cont;
	}
	public void setMobile(int mobile){
		this.mobile = mobile;
	}
	public int getMobile(){
		return mobile;
	}
	public void setFixed(int fixed){
		this.fixed = fixed;
	}
	public int getFixed(){
		return fixed;
	}
	public void setSMS(int sms){
		this.sms = sms;
	}
	public int getSMS(){
		return sms;
	}
	public void setData(double data){
		this.data = data;
	}
	public double getData(){
		return data;
	}
	public void setService_Name(String service_name){
		this.service_name = service_name;
	}
	public String getService_Name(){
		return service_name;
	}
	public void setDiscount(double discount){
		this.discount = discount;
	}
	public double getDiscount(){
		return discount;
	}
	public void setFinal_Cost(double final_cost){
		this.final_cost = final_cost;
	}
	public double getFinal_Cost(){
		return final_cost;
	}
	
	/* toString method that returns a string representation of the object.*/
	public String toString(){
		 return " Name: " +customer+ " Phone: "+phone+" Date: "+date+" Way of redemption: "+redemption + " Code contract: "+code_cont + "Final cost: " + final_cost;
	 }
}