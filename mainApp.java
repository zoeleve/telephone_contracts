import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*; 
/* 
    LEVESANOU ZOI  4o 3150240
    LEKKAS MICHAIL 4o 3150258
	VASILI SPYRIDOULA 4o 3150252
*/

public class mainApp extends JFrame{
	
	private JMenuItem j1, j2;
	private JButton contract, statistics, search; 
	private JPanel jservices, jstatistics, jcontract; //jcontract=energa symbolaia
	private ReadServiceFile serv_file = new ReadServiceFile(); 
	private ReadContractFile cont_file = new ReadContractFile(); 
	private WriteContractFile write_cont = new WriteContractFile(); 
	private Services_List serv_list = new Services_List(); 
	private Contract_List cont_list = new Contract_List(); 
	
	private File file;
	
	private JList jserv_list, jserv_info, jcont_list; 
    private DefaultListModel serv_listModel, serv_infoModel, cont_listModel; 
	User_Contract cont1; 
	private boolean isContract, found; // 
	
	private String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	private Calendar c = Calendar.getInstance();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	String date2;
	
	private int ans;
	private String in=null;
    private String in1=null;
	private String in2=null;
	private Object in3=null;
	private Object in4=null;
	private double discount1;
	private double price;
	private String strPrice;
	private int code_cont=1006; //code of contract
	
	private ImageIcon img = new ImageIcon("Logo/logo.png");
	
	public mainApp() {
		
		setResizable(false);
		c.setTime(new Date());
		c.add(Calendar.DATE, 14);
		String date2=sdf.format(c.getTime());
		ServListListener listen1 = new ServListListener(); 
		ServInfoListener listen2 = new ServInfoListener(); 
		setLayout(new BorderLayout());
		setBounds(500, 300, 700, 400);
		setTitle("Mobile Communication Service by 3150240 3150258 3150252");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(img.getImage());
		//menu bar
		
		j1 = new JMenuItem("Load File");
		j2 = new JMenuItem("Save File");
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Files");
		menu.add(j1);
        menu.addSeparator();
		menu.add(j2);
		menubar.add(menu);
		setJMenuBar(menubar);
		//tool bar
		ImageIcon Icon = new ImageIcon("toolbar images/contract.jpg");
		ImageIcon statisticsIcon = new ImageIcon("toolbar images/statistics.jpg");
        ImageIcon searchIcon = new ImageIcon("toolbar images/search.jpg");
		contract = new JButton("Contract", Icon);
		contract.setFocusPainted(false);
		statistics = new JButton("Statistics", statisticsIcon);
		statistics.setFocusPainted(false);
		search = new JButton("Search", searchIcon);
		search.setFocusPainted(false);
		JToolBar bar = new JToolBar();
		bar.add(contract);
		bar.add(statistics);
		bar.add(search);
		add("North", bar);
        contract.setEnabled(false);
		search.setEnabled(false);
		
		//jserv_list 
		jservices = new JPanel();
        serv_listModel=new DefaultListModel();
        serv_listModel.addElement("Contract");
        serv_listModel.addElement("Card Contract");
        serv_listModel.addElement("Internet");
        jserv_list = new JList(serv_listModel);
		jservices.setLayout(new FlowLayout());
		JScrollPane listScroller1 = new JScrollPane(jserv_list);
		listScroller1.setPreferredSize(new Dimension(500, 250));
		jservices.add(listScroller1);
		jserv_list.addMouseListener(listen1);
		
		//jserv_info
		serv_infoModel=new DefaultListModel();
		jserv_info = new JList(serv_infoModel);
		JScrollPane listScroller2 = new JScrollPane(jserv_info);
		listScroller2.setPreferredSize(new Dimension(500, 250));
		jservices.add(listScroller2);
		jserv_info.addMouseListener(listen2);
		
		jcontract = new JPanel();
		
		//jcont_list
		cont_listModel=new DefaultListModel();
		jcont_list = new JList(cont_listModel);
		jcontract.setLayout(new FlowLayout());
		JScrollPane listScroller3 = new JScrollPane(jcont_list);
		listScroller3.setPreferredSize(new Dimension(500, 250));
		jcontract.add(listScroller3);
		
		
		//tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Services", jservices);
		tabs.addTab("Contracts", jcontract);
		add(tabs);
		
		ChangeListener changeListener = new ChangeListener() {
        public void stateChanged(ChangeEvent changeEvent) {
			search.setEnabled(false);

            if (tabs.getSelectedIndex()==0 && jserv_info.getSelectedIndex()!=-1) {
				contract.setEnabled(true);
			}
			if (tabs.getSelectedIndex()==1) {
				contract.setEnabled(false);
				search.setEnabled(true);
				statistics.setEnabled(false);

			}
			if (tabs.getSelectedIndex()==2) {
				contract.setEnabled(false);
				statistics.setEnabled(false);
				
				search.setEnabled(true);
			}
		}
		};
		tabs.addChangeListener(changeListener);
		add(tabs);
		
		//contract listener
        contract.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				cont1=new User_Contract();
				isContract=false;
			    if (jserv_list.getSelectedIndex()==0) {
					discount1=0.20;
                    if (jserv_info.getSelectedIndex()==0) {
                        price=serv_list.Serv(0).getPagio();						
						isContract=true;
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						price=serv_list.Serv(1).getPagio();
					}	
					
				}
				else if (jserv_list.getSelectedIndex()==1) {
					discount1=0.20;
					if (jserv_info.getSelectedIndex()==0) {
                        price=serv_list.Serv(2).getPagio();						
                        isContract=true;
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						price=serv_list.Serv(3).getPagio();
						isContract=true;
					}	
				}
				else if (jserv_list.getSelectedIndex()==2) {
					discount1=0.25;
					if (jserv_info.getSelectedIndex()==0) {
                        price=serv_list.Serv(4).getPagio();						
                        isContract=true;
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						price=serv_list.Serv(5).getPagio();
						isContract=true;
					}	
				}
				else if (jserv_list.getSelectedIndex()==3) {
					discount1=0.25;
					if (jserv_info.getSelectedIndex()==0) {
                        price=serv_list.Serv(6).getPagio();						
                        isContract=true;
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						price=serv_list.Serv(7).getPagio();
						isContract=true;
					}	
				}
				else if (jserv_list.getSelectedIndex()==4) {
					discount1=0.30;
					if (jserv_info.getSelectedIndex()==0) {
                        price=serv_list.Serv(8).getPagio();						
                        isContract=true;
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						price=serv_list.Serv(9).getPagio();
						isContract=true;
					}	
				}
				else if (jserv_list.getSelectedIndex()==5) {
					discount1=0.30;
					if (jserv_info.getSelectedIndex()==0) {
                        price=serv_list.Serv(10).getPagio();						
                        isContract=true;
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						price=serv_list.Serv(11).getPagio();
						isContract=true;
					}	
				}
				if (isContract) {		
  
                    in1= JOptionPane.showInputDialog(null, "Enter customer's name:", "Customer", JOptionPane.PLAIN_MESSAGE);

					while ((in1!=null && in1.length() == 0))  {
						JOptionPane.showMessageDialog(null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE );
						in1 = JOptionPane.showInputDialog(null, "Enter customer's name:", "Customer", JOptionPane.PLAIN_MESSAGE);
						
					}
					if (in1!=null) {
						((User_Contract) cont1).setCustomer(in1);
						in2 = JOptionPane.showInputDialog(null, "Enter customer's phone:", "Phone", JOptionPane.PLAIN_MESSAGE);

					    while (in2!=null && in2.length() ==0) {
							JOptionPane.showMessageDialog(null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE );
						    in2 = JOptionPane.showInputDialog(null, "Enter customer's phone:", "Phone", JOptionPane.PLAIN_MESSAGE);
						    
					    }
					}
					if (in1!=null && in2!=null) {
						((User_Contract) cont1).setPhone(in2);
						in3 = JOptionPane.showInputDialog(null, "Enter date: ", "Date", JOptionPane.PLAIN_MESSAGE, null, null, date);

						while (in3!=null && ((String) in3).length() == 0) {
							JOptionPane.showMessageDialog( null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
						    in3 = JOptionPane.showInputDialog(null, "Enter date of sale:", "Date", JOptionPane.PLAIN_MESSAGE, null, null, date);
						    
					    }
					}
					if (in1!=null && in2!=null && in3!=null) {
						((User_Contract) cont1).setDate((String) in3);
						code_cont+=1;
						((User_Contract) cont1).setFinal_Cost(price-price*discount1);
						strPrice="Final cost is: "+ cont1.getFinal_Cost();
						JOptionPane.showMessageDialog(mainApp.this, strPrice);
						cont_list.storeContract(cont1);
						cont_listModel.addElement("Code of contract: "+code_cont+", Name of contract: "+cont_list.Cont(cont_list.Entries()-1).getService_Name()
						+", Customer: "+cont_list.Cont(cont_list.Entries()-1).getCustomer() +", Phone: "+cont_list.Cont(cont_list.Entries()-1).getPhone()+", Date: "
						+cont_list.Cont(cont_list.Entries()-1).getDate()+", Final price: "+cont_list.Cont(cont_list.Entries()-1).getFinal_Cost());
					}
				}
			}
		});
		
		//search listener
        search.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				found=false;
			    in=JOptionPane.showInputDialog(null, "Enter customer's name:", "Search", JOptionPane.PLAIN_MESSAGE);
                if (in!=null && in.length()>0){
					if (tabs.getSelectedIndex()==1) {
						
				        for (int i=0; i<cont_list.Entries(); i++) {
							if (in.equalsIgnoreCase(cont_list.Cont(i).getCustomer())) {
								jcont_list.setSelectedIndex(i);
								found=true;
							}
						}
						if (found) {
							JOptionPane.showMessageDialog(mainApp.this, "Contract was found and selected!");
						}
						else {
							JOptionPane.showMessageDialog(mainApp.this, "Contract not found!");
						}
						
						
					}
				}
			}
		});
		
		
		//menu listener
		j1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(mainApp.this, "Choose files to load (SERVICE_LIST.txt ,CONTRACT_LIST.txt).");
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				    file = fileChooser.getSelectedFile();
					if (file.getName().equals("SERVICE_LIST.txt")) {
					    serv_file.loadFile("SERVICE_LIST.txt");
						JOptionPane.showMessageDialog(mainApp.this, "Services file loaded.");
						serv_list =serv_file.getServ_List();
						
				    }
					else if (file.getName().equals("CONTRACT_LIST.txt")) {

					    cont_file.loadFile("CONTRACT_LIST.txt");
						JOptionPane.showMessageDialog(mainApp.this, "Contract file loaded.");
						cont_list=cont_file.getCont_List();
					
                        for (int i=0; i<cont_list.Entries(); i++) {
			                cont_listModel.addElement("Code of contract: "+code_cont+", Name of contract: "+cont_list.Cont(cont_list.Entries()-1).getService_Name()
						+", Customer: "+cont_list.Cont(cont_list.Entries()-1).getCustomer() +", Phone: "+cont_list.Cont(cont_list.Entries()-1).getPhone()+", Date: "
						+cont_list.Cont(cont_list.Entries()-1).getDate()+", Final price: "+cont_list.Cont(cont_list.Entries()-1).getFinal_Cost());
                        }
					}
					else 
					    JOptionPane.showMessageDialog(mainApp.this, "Invalid file!");	
				}
			}
		});
		
		j2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(mainApp.this, "Choose files to save (CONTRACT_LIST1.txt).");
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				    file = fileChooser.getSelectedFile();
					if (file.getName().equals("")) {
					    write_cont.createFile("CONTRACT_LIST1.txt", cont_list);
						JOptionPane.showMessageDialog(mainApp.this, "Contract file saved.");
						
					}
					else 
					    JOptionPane.showMessageDialog(mainApp.this, "Choose a valid file!");	
				}
		            
			}
        });
		
		pack();
		setVisible(true);
		
	} //mainApp
	
	//jserv_list listener
    private class ServListListener implements MouseListener {
	public void mouseClicked(MouseEvent event) {
 			
		if (event.getClickCount() ==2) {
			contract.setEnabled(false);
		    if (jserv_list.getSelectedIndex() != -1) {
                serv_infoModel.removeAllElements();	
                if (jserv_list.getSelectedIndex()==0) {
                    for (int i=0; i<serv_list.Entries(); i++) {
			            if (serv_list.Serv(i) instanceof Contract) {
				            serv_infoModel.addElement("Name of contract: "+serv_list.Serv(i).getName()+", Monthly price: "
							+serv_list.Serv(i).getPagio());
					    }
					}
				}
				else if (jserv_list.getSelectedIndex()==1) {
					for (int i=0; i<serv_list.Entries(); i++) {
						if (serv_list.Serv(i) instanceof Card_Contract) {
							serv_infoModel.addElement("Name of card contract: "+serv_list.Serv(i).getName()+", Monthly price: "
							+serv_list.Serv(i).getPagio());
						}
					}
				}
				else if (jserv_list.getSelectedIndex()==2) {
					for (int i=0; i<serv_list.Entries(); i++) {
						if (serv_list.Serv(i) instanceof Internet) {
							serv_infoModel.addElement("Name of internet contract: "+serv_list.Serv(i).getName()+", Monthly price: "
							+serv_list.Serv(i).getPagio());
						}
					}
				}
				
			}
		}
	}
		public void mouseExited(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
	}
	
	//jserv_info listener
	private class ServInfoListener implements MouseListener {
	public void mouseClicked(MouseEvent event) {
		if (jserv_info.getSelectedIndex() != -1) 
			contract.setEnabled(true);
        if (event.getClickCount() ==2) {
		    if (jserv_info.getSelectedIndex() != -1) {
				if (jserv_list.getSelectedIndex()==0) { //contract 1
                    if (jserv_info.getSelectedIndex()==0) {				
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(0).toString(), serv_list.Serv(0).getName(), JOptionPane.INFORMATION_MESSAGE);
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(1).toString(), serv_list.Serv(1).getName(), JOptionPane.INFORMATION_MESSAGE);
					}	
				}
				else if (jserv_list.getSelectedIndex()==1) { //contract 2
					if (jserv_info.getSelectedIndex()==0) {				
                        
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(2).toString(), serv_list.Serv(2).getName(), JOptionPane.INFORMATION_MESSAGE);
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(3).toString(), serv_list.Serv(3).getName(), JOptionPane.INFORMATION_MESSAGE);
					}	
				}
				else if (jserv_list.getSelectedIndex()==2) { //card contract 1
					if (jserv_info.getSelectedIndex()==0) {				
                        
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(4).toString(), serv_list.Serv(4).getName(), JOptionPane.INFORMATION_MESSAGE);
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(5).toString(), serv_list.Serv(5).getName(), JOptionPane.INFORMATION_MESSAGE);
					}	
				}
				else if (jserv_list.getSelectedIndex()==3) { //card contract 2
					if (jserv_info.getSelectedIndex()==0) {				
                        
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(6).toString(), serv_list.Serv(6).getName(), JOptionPane.INFORMATION_MESSAGE);
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(7).toString(), serv_list.Serv(7).getName(), JOptionPane.INFORMATION_MESSAGE);
					}	
				}
				else if (jserv_list.getSelectedIndex()==4) { //internet 1
					if (jserv_info.getSelectedIndex()==0) {				
                        
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(8).toString(), serv_list.Serv(8).getName(), JOptionPane.INFORMATION_MESSAGE);
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(9).toString(), serv_list.Serv(9).getName(), JOptionPane.INFORMATION_MESSAGE);
					}	
				}
				else if (jserv_list.getSelectedIndex()==5) { //internet 2
					if (jserv_info.getSelectedIndex()==0) {				
                        
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(10).toString(), serv_list.Serv(10).getName(), JOptionPane.INFORMATION_MESSAGE);
			        }
					else if (jserv_info.getSelectedIndex()==1) {
						
					    JOptionPane.showMessageDialog(mainApp.this, serv_list.Serv(11).toString(), serv_list.Serv(11).getName(), JOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		}
	}
		public void mouseExited(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
	}
	
	public static void main(String[] args) {
        new mainApp(); 
    }
}
	

