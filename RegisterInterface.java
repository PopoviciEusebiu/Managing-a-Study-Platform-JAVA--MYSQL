import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegisterInterface {

	JFrame frame;
	private JTextField nume;
	public JTextField prenume;
	private JTextField telefon;
	private JTextField adresa;
	private JTextField iban;
	private JTextField contract;
	private JTextField CNP;
	private JTextField email;
	private JComboBox comboBox;
	private JTextField parola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterInterface window = new RegisterInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterInterface() {
		initialize();
	}
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.setBounds(100, 100, 489, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select user:\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 166, 14);
		frame.getContentPane().add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"         Student", "         Profesor", "         Admin", "    Super Admin"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
      
		
		
		comboBox.setBounds(128, 10, 128, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("            Nume:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(71, 85, 112, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("       Prenume:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(71, 130, 112, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("            CNP:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(71, 169, 112, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("         Adresa:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(71, 211, 128, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		nume = new JTextField();
		nume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nume.setBounds(203, 83, 220, 20);
		frame.getContentPane().add(nume);
		nume.setColumns(10);
		
		prenume = new JTextField();
		prenume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prenume.setBounds(203, 128, 220, 20);
		frame.getContentPane().add(prenume);
		prenume.setColumns(10);
		
		CNP = new JTextField();
		CNP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		CNP.setBounds(203, 167, 220, 20);
		frame.getContentPane().add(CNP);
		CNP.setColumns(10);
		
		adresa = new JTextField();
		adresa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		adresa.setBounds(203, 209, 220, 20);
		frame.getContentPane().add(adresa);
		adresa.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("        Telefon:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(71, 258, 112, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		telefon = new JTextField();
		telefon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		telefon.setBounds(203, 256, 220, 20);
		frame.getContentPane().add(telefon);
		telefon.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("          Email:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(71, 300, 105, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		email.setBounds(203, 298, 220, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("          IBAN:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(71, 344, 105, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		iban = new JTextField();
		iban.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		iban.setBounds(203, 342, 220, 20);
		frame.getContentPane().add(iban);
		iban.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nr_Contract:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(71, 382, 105, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		contract = new JTextField();
		contract.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contract.setBounds(203, 380, 220, 20);
		frame.getContentPane().add(contract);
		contract.setColumns(10);

		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nume = getCampNume();
				String prenume=getCampPrenume();
				String cnp=getCampCnp();
				String adresa=getCampAdresa();
				String telefon=getCampTel();
				String iban=getCampIban();
				String email=getCampEmail();
				String contract=getCampContract();
	            String parola = getCampParola();
	            
	            
	            if(nume.equals("")|| prenume.equals("")|| cnp.equals("")|| adresa.equals("")||telefon.equals("")||iban.equals("")||email.equals("")||contract.equals("")||parola.equals(""))
	            {
	            	  JOptionPane.showMessageDialog(null,"Date incomplete!");
	            	  
	            }
	            else {
	            if(getSelectedComboRol().equals("         Student")){
	                try {
	                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
		             Statement st;
		            
		               st=connection.createStatement();
		                String sql="insert into student "+"(parola,cnp,nume,prenume,adresa,telefon,email,IBAN,nr_contact)" + "values('"+parola+"','"+cnp+"','"+nume+"','"+prenume+"','"+adresa+"','"+telefon+"','"+email+"','"+iban+"','"+contract+"')";
		             
		               st.executeUpdate(sql);
		                JOptionPane.showMessageDialog(null,"Autentificare reusita!");
		            
		                connection.close();
		                frame.dispose();
 		                Login_interface login = new Login_interface();
 		           login.frame.setVisible(true);
		                
		                
	                }
	                catch(SQLException e1) {
	                e1.printStackTrace();
	                }
	            }
	            else
	            	if(getSelectedComboRol().equals("         Profesor"))
	            	{
	            		 try {
	 	                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
	 		             Statement st;
	 		            
	 		               st=connection.createStatement();
	 		                String sql="insert into profesor "+"(parola,cnp,nume,prenume,adresa,telefon,email,IBAN,nr_contact)" + "values('"+parola+"','"+cnp+"','"+nume+"','"+prenume+"','"+adresa+"','"+telefon+"','"+email+"','"+iban+"','"+contract+"')";
	 		             
	 		               st.executeUpdate(sql);
	 		                JOptionPane.showMessageDialog(null,"Autentificare reusita!"); 		                
	 		                connection.close();
	 		                frame.dispose();
	 		                Login_interface login = new Login_interface();
	 		           login.frame.setVisible(true);
	  		                
	 	                }
	 	                catch(SQLException e1) {
	 	                e1.printStackTrace();
	 	                }
	            	}
	            	else
		            	if(getSelectedComboRol().equals("         Admin"))
		            	{
		            		 try {
		 	                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
		 		             Statement st;
		 		            
		 		               st=connection.createStatement();
		 		                String sql="insert into administrator "+"(parola,cnp,nume,prenume,adresa,telefon,email,IBAN,nr_contact)" + "values('"+parola+"','"+cnp+"','"+nume+"','"+prenume+"','"+adresa+"','"+telefon+"','"+email+"','"+iban+"','"+contract+"')";
		 		             
		 		               st.executeUpdate(sql);
		 		                JOptionPane.showMessageDialog(null,"Autentificare reusita!");
		 		            
		 		                connection.close();
		 		               frame.dispose();
		 		                Login_interface login = new Login_interface();
		 		           login.frame.setVisible(true);
		 		                
		 		                
		 	                }
		 	                catch(SQLException e1) {
		 	                e1.printStackTrace();
		 	                }
		            	}
		            	else
		            	
		    	            	if(getSelectedComboRol().equals("    Super Admin"))
		    	            	{
		    	            		 try {
		    	 	                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
		    	 		             Statement st;
		    	 		            
		    	 		               st=connection.createStatement();
		    	 		               
		    	 		                String sql="insert into superadmin "+"(parola,cnp,nume,prenume,adresa,telefon,email,IBAN,nr_contact)" + "values('"+parola+"','"+cnp+"','"+nume+"','"+prenume+"','"+adresa+"','"+telefon+"','"+email+"','"+iban+"','"+contract+"')";
		    	 		             
		    	 		               st.executeUpdate(sql);
		    	 		                JOptionPane.showMessageDialog(null,"Autentificare reusita!");
		    	 		                connection.close();
		    	 		               frame.dispose();
		   	 		                Login_interface login = new Login_interface();
		   	 		           login.frame.setVisible(true);
         
		    	 	                }
		    	 	                catch(SQLException e1) {
		    	 	                e1.printStackTrace();
		    	 	                }
		    	            	}
	            
			}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(310, 452, 87, 22);
		frame.getContentPane().add(btnNewButton);
		
		parola = new JTextField();
		parola.setBounds(203, 421, 220, 20);
		frame.getContentPane().add(parola);
		parola.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("       Parola:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(81, 422, 95, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
	                Login_interface login = new Login_interface();
	           login.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(213, 453, 87, 22);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Introduceti datele:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel_10.setBounds(213, 43, 184, 24);
		frame.getContentPane().add(lblNewLabel_10);
	}
	
	public String getSelectedComboRol(){
	    if(comboBox.getSelectedItem().toString() == null)
	        return "0";
	    return comboBox.getSelectedItem().toString();
	}
	
	 public String getCampNume(){
	        return nume.getText();
	    }
	    public String getCampParola(){
	        return parola.getText();
	    }
	    public String getCampPrenume(){
	        return prenume.getText();
	    }
	    public String getCampCnp(){
	        return CNP.getText();
	    }
	    public String getCampAdresa(){
	        return adresa.getText();
	    }
	    public String getCampEmail(){
	        return email.getText();
	    }
	    public String getCampIban(){
	        return iban.getText();
	    }
	    public String getCampTel(){
	        return telefon.getText();
	    }
	    public String getCampContract(){
	        return contract.getText();
	    }


		public void setTelefon(JTextField telefon) {
			this.telefon = telefon;
		}


		public void setNume(JTextField nume) {
			this.nume = nume;
		}


		public void setPrenume(JTextField prenume) {
			this.prenume = prenume;
		}

		public void setAdresa(JTextField adresa) {
			this.adresa = adresa;
		}


		public void setIban(JTextField iban) {
			this.iban = iban;
		}


		public void setContract(JTextField contract) {
			this.contract = contract;
		}


		public void setCNP(JTextField cNP) {
			this.CNP = cNP;
		}


		public void setEmail(JTextField email) {
			this.email = email;
		}

		public void setParola(JTextField parola) {
			this.parola = parola;
		}
}

