import java.io.*;
import java.util.*;


public class ReadContractFile{
	private Contract_List cont_list=new Contract_List();
	private static final int n=0;
	private static final double d=0.0;
	private static final String str=" ";
	private User_Contract user_contract; 
	 
	public void loadFile(String data){
		 int counter=1;
		 
		 User_Contract user_contract=null;
		 File f = null;
		 BufferedReader reader = null;
		 user_contract=new User_Contract ();
		 String line;
		 
		try{
			 f = new File(data);
		}
		catch(NullPointerException e){
			 System.err.println("File not found.");
		}
		try{
			  reader = new BufferedReader(new FileReader(f));
        } 
	    catch (FileNotFoundException e) { 
	        System.err.println("Error opening file!");
        }
		try {
            line = reader.readLine();
			if (!line.trim().equals(" ")) {
                if (line.trim().equalsIgnoreCase("CONTRACT_LIST")) {
				    line = reader.readLine();
					
					if (line != null) {
                        if (line.trim().equals("{")) { 
						    line = reader.readLine();

						    while (line != null && !line.startsWith("}")) {
								if (line.trim().toUpperCase().startsWith("CONTRACT")) {
                                    line = reader.readLine();
									
									if (line !=null) {
										if (line.trim().equals("{")) {
											reader.mark(1000);
											while (true) {
												line = reader.readLine();
												if (line.trim().toUpperCase().startsWith("TYPE")) {
													if (line.trim().substring(5).trim().equalsIgnoreCase("Contract")) {
														user_contract.setServices(line.trim().substring(5).trim());
													    reader.reset();
														while (true) {
															line = reader.readLine();
															if (line!=null) {
																if (line.trim().toUpperCase().startsWith("SERVICE_NAME")) { 
																	user_contract.setService_Name(line.trim().substring(13).trim());
																	reader.reset();
																	while (true) {
																		line = reader.readLine();
																		if (line!=null) {
																			if (line.trim().toUpperCase().startsWith("CONTRACT_NUMBER")) { //code
																				user_contract.setCode_cont(Integer.parseInt(line.trim().substring(16).trim()));
																				reader.reset();
																				while (true) { //
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CUSTOMER")) {//customer
																							user_contract.setCustomer(line.trim().substring(9).trim());
																						    break;
																						}
																						if (line.trim().startsWith("}")) {
																							user_contract.setCustomer(str);
																						    break;
																						}
																					}
																				}
																				reader.reset();
																				while (true) { //phone
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("PHONE_NUMBER")) {
																							user_contract.setPhone(line.trim().substring(13).trim());
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							user_contract.setPhone(str);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { // date
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("ACTIVATION_DATE")) {
																						   user_contract.setDate(line.trim().substring(16).trim());
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							user_contract.setDate(str);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //discount
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("DISCOUNT")) {
																							user_contract.setDiscount(Double.parseDouble(line.trim().substring(9).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							user_contract.setDiscount(d);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //monthly usage mobile
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("MONTHLY USAGE")) 
																							line = reader.readLine();
																						if (line.trim().startsWith("{")) {
																							line = reader.readLine();
																							if (line.trim().toUpperCase().startsWith("MOBILE")) {
																								user_contract.setMobile(Integer.parseInt(line.trim().substring(7).trim()));
																								break;
																							}
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //monthly usage fixed
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FIXED")) {
																							user_contract.setFixed(Integer.parseInt(line.trim().substring(6).trim()));
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //monthly usage sms
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("SMS")) {
																							user_contract.setSMS(Integer.parseInt(line.trim().substring(4).trim()));
																							break;
																						}
																						line = reader.readLine();
																						if (line.trim().startsWith("}")) {
																							line = reader.readLine();
																							if (line.trim().startsWith("}"))
																								line = reader.readLine();
																							break;
																						}
																					}
																				}
																				line = reader.readLine();
																				if (line != null) {
                                                                                    if (line.trim().equals("}")) { 
																						cont_list.storeContract(user_contract);
																						break;
																					}
												                                }
                                                                                break;
																			}
																			if (line.trim().startsWith("}")) {
																				System.out.println("Code of contract unknown! It will not be taken into account!");
																				break;
																			}
																		}
																	}
																	break;
																}
																if (line.trim().startsWith("}")) {
																	System.out.println("Name of contract unknown! It will not be taken into account!");
																		
																	break;
																}
																
															}
														}
													}//contract
													else if (line.trim().substring(5).trim().equalsIgnoreCase("CARD_CONTRACT")) { //card_contract
																				user_contract.setServices(line.trim().substring(5).trim());
																				reader.reset();
																				while (true) {
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CONTRACT_NUMBER")) { 
																							user_contract.setCode_cont(Integer.parseInt(line.trim().substring(16).trim()));
																							reader.reset();
																							while (true) {
																								line = reader.readLine();
																								if (line!=null) {
																									if (line.trim().toUpperCase().startsWith("SERVICE_NAME")) { 
																										user_contract.setService_Name(line.trim().substring(13).trim());
																										reader.reset();
																										while (true) { 
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("CUSTOMER")) {//customer
																													user_contract.setCustomer(line.trim().substring(9).trim());
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setCustomer(str);
																													break;
																												}
																											}
																										}
																										reader.reset();
																										while (true) { //phone
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("PHONE_NUMBER")) {
																													user_contract.setPhone(line.trim().substring(13).trim());
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setPhone(str);
																													break;
																												}
																											}	
																										}
																										reader.reset();
																										while (true) { // date
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("ACTIVATION_DATE")) {
																													user_contract.setDate(line.trim().substring(16).trim());
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setDate(str);
																													break;
																												}
																											}	
																										}
																										reader.reset();
																										while (true) { // discount
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("DISCOUNT")) {
																													user_contract.setDiscount(Double.parseDouble(line.trim().substring(9).trim()));
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setDiscount(d);
																													break;
																												}
																											}	
																										}
																										reader.reset();
																										while (true) { //monthly usage mobile
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("MONTHLY USAGE")) 
																													line = reader.readLine();
																												if (line.trim().startsWith("{")) {
																													line = reader.readLine();
																													if (line.trim().toUpperCase().startsWith("MOBILE")) {
																														user_contract.setMobile(Integer.parseInt(line.trim().substring(7).trim()));
																														break;
																													}
																													if (line.trim().startsWith("}")) {
																														user_contract.setMobile(n);
																														break;
																													}
																												}
																											}	
																										}
																										reader.reset();
																										while (true) { //monthly usage fixed
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("FIXED")) {
																													user_contract.setFixed(Integer.parseInt(line.trim().substring(6).trim()));
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																														user_contract.setFixed(n);
																														break;
																												}
																											}
																										}
																										reader.reset();
																										while (true) { //monthly usage sms
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("SMS")) {
																													user_contract.setSMS(Integer.parseInt(line.trim().substring(4).trim()));
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setSMS(n);
																													break;
																												}
																												line = reader.readLine();
																												if (line.trim().startsWith("}")) {
																													line = reader.readLine();
																												if (line.trim().startsWith("}"))
																													line = reader.readLine();
																													break;
																												}
																											}
																										}
																										line = reader.readLine();
																										if (line != null) {
																											if (line.trim().equals("}")) { 
																												cont_list.storeContract(user_contract);
																												break;
																											}
																										}
																										break;
																									}
																									if (line.trim().startsWith("}")) {
																										System.out.println("Code of contract unknown! It will not be taken into account!");
																										break;
																									}
																								}
																							}
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							System.out.println("Name of contract unknown! It will not be taken into account!");
																		
																							break;
																						}
																
																					}
																				}
																			}//card_contract
																			else if (line.trim().substring(5).trim().equalsIgnoreCase("Internet")) { //Internet
																				user_contract.setServices(line.trim().substring(5).trim());
																				reader.reset();
																				while (true) {
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CONTRACT_NUMBER")) { 
																						user_contract.setCode_cont(Integer.parseInt(line.trim().substring(16).trim()));
																							reader.reset();
																							while(true) {
																								line = reader.readLine();
																								if (line!=null) {
																									if (line.trim().toUpperCase().startsWith("SERVICE_NAME")) {
																										user_contract.setService_Name(line.trim().substring(13).trim());
																										reader.reset();
																										while (true) { //customer
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("CUSTOMER")) {
																													user_contract.setCustomer(line.trim().substring(9).trim());
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setCustomer(str);
																													break;
																												}
																											}
																										}
																										reader.reset();
																										while (true) { //phone number
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("PHONE_NUMBER")) {
																													user_contract.setPhone(line.trim().substring(13).trim());
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setPhone(str);
																													break;
																												}
																											}
																											
																										}	
																										reader.reset();
																										while (true) { //activation date
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("ACTIVATION_DATE")) {
																													user_contract.setDate(line.trim().substring(16).trim());
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setDate(str);
																													break;
																												}
																											}
																										}
																										reader.reset();
																										while (true) { //discount
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("DISCOUNT")) {
																													user_contract.setDiscount(Double.parseDouble(line.trim().substring(9).trim()));
																													break;
																												}
																												if (line.trim().startsWith("}")) {
																													user_contract.setDiscount(d);
																													break;
																												}
																											}
																										}
																										reader.reset();
																										while (true) { //monthly usage data
																											line = reader.readLine();
																											if (line!=null) {
																												if (line.trim().toUpperCase().startsWith("MONTHLY USAGE")) 
																													line = reader.readLine();
																												if (line.trim().startsWith("{")) {
																													line = reader.readLine();
																													if (line.trim().toUpperCase().startsWith("DATA")) {
																														user_contract.setData(Double.parseDouble(line.trim().substring(5).trim()));
																														break;
																													}
																													if (line.trim().startsWith("}")) {
																														user_contract.setData(d); 
																														break;
																													}
																													
																												}
																												line = reader.readLine();
																												if (line.trim().startsWith("}")) {
																													line = reader.readLine();
																												if (line.trim().startsWith("}"))
																													line = reader.readLine();
																													break;
																												}
																											}	
																										}
																										line = reader.readLine();
																										if (line != null) {
																											if (line.trim().equals("}")) { 
																												cont_list.storeContract(user_contract);
																												break;
																											}
																										}
																										break;
																									}
																									if (line.trim().startsWith("}")) {
																										System.out.println("Code of contract unknown! It will not be taken into account!");
																										break;
																									}
																								}
																							}
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							System.out.println("Name of contract unknown! It will not be taken into account!");
																		
																							break;
																						}
																
																					}
																				}
																			}//internet
																			else {
														System.out.println("Invalid type!");
														line = reader.readLine();
														while (!line.trim().startsWith("}")) {
															line = reader.readLine();
														}
														break;
													}
													break;
												}
												if (line.trim().startsWith("}")) {
													System.out.println("Type of contract unknown! It will not be taken into account!");
													
													break;
												}
											}
										}
									}	
							    }
								line=reader.readLine();
							}
						}
					}
				}
			}				
		}
		catch (IOException e) {
            System.out.println("Error reading line"+counter+".");
		}
		try {
			reader.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
	public Contract_List getCont_List() {
		return cont_list;
	}	
}

																										
																			 

		 