import java.io.*;
import java.util.*;


public class ReadServiceFile{
	private Services_List serv_list=new Services_List();
	private static final int n=0;
	private static final double d=0.0;
	private static final String str=" ";
	 
	public void loadFile(String data){
		 int counter=1;
		 
		 
		 File f = null;
		 BufferedReader reader = null;
		 Contract serv1 = null;
		 Card_Contract serv2 = null;
		 Internet serv3 = null;
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
                if (line.trim().equalsIgnoreCase("SERVICE_LIST")) {
				    line = reader.readLine();

                    if (line != null) {
                        if (line.trim().equals("{")) { 
						    line = reader.readLine();

						    while (line != null && !line.startsWith("}")) {
								if (line.trim().toUpperCase().startsWith("SERVICE")) {
                                    line = reader.readLine();
										
									if (line !=null) {
										if (line.trim().equals("{")) {
											reader.mark(1000);
											while (true) {
												line = reader.readLine();
												if (line.trim().toUpperCase().startsWith("TYPE")) {
													if (line.trim().substring(5).trim().equalsIgnoreCase("Contract")) {
														serv1=new Contract();
														reader.reset();
														while (true) {
															line = reader.readLine();
															if (line!=null) {
																if (line.trim().toUpperCase().startsWith("SERVICE_NAME")) { 
																	((Services) serv1).setName(line.trim().substring(13).trim());
																	reader.reset();
																	while (true) {
																		line = reader.readLine();
																		if (line!=null) {
																			if (line.trim().toUpperCase().startsWith("MONTHLY_PRICE")) { //Pagio
																				((Services) serv1).setPagio(Integer.parseInt(line.trim().substring(14).trim()));
																				reader.reset();
																				while (true) { //FREE_SPEAKING_TIME
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FREE_SPEAKING_TIME")) {
																							((Contract) serv1).setFree_speaking_time(Integer.parseInt(line.trim().substring(19).trim()));
																						    break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Contract) serv1).setFree_speaking_time(n);
																						    break;
																						}
																					}
																				}
																				reader.reset();
																				while (true) { //FREE_SMS
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FREE_SMS")) {
																							((Contract) serv1).setFree_SMS(Integer.parseInt(line.trim().substring(9).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Contract) serv1).setFree_SMS(n);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { // CHARGE_SPEAKING_TIME
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CHARGE_SPEAKING_TIME")) {
																						   ((Contract) serv1).setCharge_speaking_time(Integer.parseInt(line.trim().substring(21).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Contract)serv1).setCharge_speaking_time(n);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //CHARGE_SMS
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CHARGE_SMS")) {
																							((Contract) serv1).setCharge_SMS(Integer.parseInt(line.trim().substring(11).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Contract) serv1).setCharge_SMS(n);
																							break;
																						}
																					}	
																				}
																				line = reader.readLine();
                                                                                if (line != null) {
                                                                                    if (line.trim().equals("}")) { 
																						serv_list.storeServices(serv1);
																						break;
																					}
												                                }
                                                                                break;
																			}
																			if (line.trim().startsWith("}")) {
																				System.out.println("Monthly price of service unknown! It will not be taken into account!");
																				break;
																			}
																		}
																	}
																	break;
																}
																if (line.trim().startsWith("}")) {
																	System.out.println("Name of service unknown! It will not be taken into account!");
																		
																	break;
																}
																
															}
														}
													}//contract
													else if (line.trim().substring(5).trim().equalsIgnoreCase("Card_Contract")) {
														serv2=new Card_Contract();
														reader.reset();
														while (true) {
															line = reader.readLine();
															if (line!=null) {
																if (line.trim().toUpperCase().startsWith("SERVICE_NAME")) { 
																	((Services) serv2).setName(line.trim().substring(13).trim());
																	reader.reset();
																	while(true) {
																		line = reader.readLine();
																		if (line!=null) {
																			if (line.trim().toUpperCase().startsWith("MONTHLY_PRICE")) {//Pagio
																				((Services) serv2).setPagio(Integer.parseInt(line.trim().substring(14).trim()));
																				reader.reset();
																				while (true) { // FREE_SPEAKING_TIME
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FREE_SPEAKING_TIME")) {
																						    ((Card_Contract) serv2).setFree_speaking_time(Integer.parseInt(line.trim().substring(19).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																						    ((Card_Contract) serv2).setFree_speaking_time(n);
																							break;
																						}
																					}
																			    }
																				reader.reset();
																				while (true) { //FREE_SMS
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FREE_SMS")) {
																							((Card_Contract) serv2).setFree_SMS(Integer.parseInt(line.trim().substring(9).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Card_Contract) serv2).setFree_SMS(n);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //CHARGE_SPEAKING_TIME
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CHARGE_SPEAKING_TIME")) {
																							((Card_Contract) serv2).setCharge_speaking_time(Integer.parseInt(line.trim().substring(21).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Card_Contract) serv2).setCharge_speaking_time(n);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //CHARGE_SMS
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CHARGE_SMS")) {
																							((Card_Contract) serv2).setCharge_SMS(Integer.parseInt(line.trim().substring(11).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Card_Contract) serv2).setCharge_SMS(n);
																							break;
																						}
																					}	
																				}
																				reader.reset();
																				while (true) { //FIRST_MONTHLY_REST
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FIRST_MONTHLY_REST")) {
																							((Card_Contract) serv2).setFirst_monthly_rest(Integer.parseInt(line.trim().substring(19).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Card_Contract) serv2).setFirst_monthly_rest(n);
																							break;
																						}
																					}	
																				}
																				line = reader.readLine();
																				if (line != null) {
                                                                                    if (line.trim().equals("}")){
																						serv_list.storeServices(serv2);
																					}
																					break;
												                                }
																				break;
																			}//pagio
																			if (line.trim().startsWith("}")) {
																				System.out.println("Monthly price of service unknown! It will not be taken into account!");
																					
																				break;
																			}
																			
																		}
																	}
																	break;
																}//service name
																if (line.trim().startsWith("}")) {
																	System.out.println("Name of service unknown! It will not be taken into account!");
																		
																	break;
																}
															}
														}
													}//Card_Contract
													else if (line.trim().substring(5).trim().equalsIgnoreCase("Internet")) {
														serv3 = new Internet();
														reader.reset();
														while (true) {
															line = reader.readLine();
															if (line!=null) {
																if (line.trim().toUpperCase().startsWith("SERVICE_NAME")) { 
																	((Services) serv3).setName(line.trim().substring(13).trim());
																	reader.reset();
																	while(true) {
																		line = reader.readLine();
																		if (line!=null) {
																			if (line.trim().toUpperCase().startsWith("MONTHLY_PRICE")) {
																				((Services) serv3).setPagio(Integer.parseInt(line.trim().substring(14).trim()));
																				reader.reset();
																				while (true) { // FREE_DATA
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("FREE_DATA")) {
																							((Internet) serv3).setFree_data(Double.parseDouble(line.trim().substring(10).trim()));
																						    break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Internet) serv3).setFree_data(d);
																							break;
																						}
																					}
																				}
																				reader.reset();
																				while (true) { //CHARGE
																					line = reader.readLine();
																					if (line!=null) {
																						if (line.trim().toUpperCase().startsWith("CHARGE")) {
																							((Internet) serv3).setCharge(Double.parseDouble(line.trim().substring(7).trim()));
																							break;
																						}
																						if (line.trim().startsWith("}")) {
																							((Internet) serv3).setCharge(d);
																							break;
																						}
																					}	
																				}
																				line = reader.readLine();
                                                                                if (line != null) {
                                                                                    if (line.trim().equals("}")) 
																						serv_list.storeServices(serv3);
																					break;
												                                }
																				break;
																			}//pagio
																			if (line.trim().startsWith("}")) {
																				System.out.println("Monthly price of service unknown! It will not be taken into account!");
																				
																				break;
																			}
																			
																		}
																	}
																	break;
																}//name
																if (line.trim().startsWith("}")) {
																	System.out.println("Name of service unknown! It will not be taken into account!");
																		
																	break;
																}
															}
														}
													}//Internet
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
													System.out.println("Type of service unknown! It will not be taken into account!");
													
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
	public Services_List getServ_List() {
		return serv_list;
	}	
}



