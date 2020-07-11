import java.io.*;
import java.util.*;

public class WriteContractFile {

	public void createFile (String fn, Contract_List list) {
		
		Contract_List cont_list = list;
		File f = null;
		BufferedWriter writer = null;
		User_Contract cont = null;
		
		try	{
			f = new File(fn);
		}
		catch (NullPointerException e) {
			System.err.println ("File not found.");
		}
		
		try	{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}
		
		try	{
			writer.write("CONTRACT"+"\n"+"{");
		    for (int i=0; i<cont_list.Entries(); i++) {
				cont=cont_list.Cont(i);
				if (cont.getServices().equals("Contract")) 
				 writer.write("\n"+"\t"+"\t"+"MONTHLY USAGE "
				 +"\n"+"\t"+"\t"+"{"
				 +"\n"+"\t"+"\t"+"\t"+"MOBILE "+ cont.getMobile()
				 +"\n"+"\t"+"\t"+"\t"+"FIXED "+ cont.getFixed()
				 +"\n"+"\t"+"\t"+"\t"+"SMS "+ cont.getSMS()
				 +"\n"+"\t"+"\t"+"}");
			    else if (cont.getServices().equals("Card_Contract"))
				 writer.write("\n"+"\t"+"\t"+"MONTHLY USAGE "
				 +"\n"+"\t"+"\t"+"{"
				 +"\n"+"\t"+"\t"+"\t"+"MOBILE "+ cont.getMobile()
				 +"\n"+"\t"+"\t"+"\t"+"FIXED "+ cont.getFixed()
				 +"\n"+"\t"+"\t"+"\t"+"SMS "+ cont.getSMS()
				 +"\n"+"\t"+"\t"+"}");
				else if (cont.getServices().equals("Internet"))
				 writer.write("\n"+"\t"+"\t"+"MONTHLY USAGE "
				 +"\n"+"\t"+"\t"+"{"
				 +"\n"+"\t"+"\t"+"\t"+"DATA "+ cont.getData()
				 +"\n"+"\t"+"\t"+"}");
				writer.write("\n"+"\t"+"\t"+"CONTRACT_NUMBER" + cont.getCode_cont()
				+"\n"+"\t"+"\t"+"SERVICE_NAME "+ cont.getService_Name()
				+"\n"+"\t"+"\t"+"TYPE "+ cont.getServices()
				+"\n"+"\t"+"\t"+"CUSTOMER "+ cont.getCustomer()
				+"\n"+"\t"+"\t"+"PHONE_NUMBER "+ cont.getPhone()
				+"\n"+"\t"+"\t"+"ACTIVATION_DATE "+ cont.getDate()
				+"\n"+"\t"+"\t"+"DISCOUNT "+ cont.getDiscount()
				+"\n"+"}");
				
				
			}
			writer.write("\n"+"}");
		}
		catch (IOException e) {
			System.err.println("Write error!");
		}
		
		try {
			writer.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
}