import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login_interface {

	public JFrame frame;
	private JTextField user;
	private JPasswordField parola;
		private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_interface window = new Login_interface();
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
	public Login_interface() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public String getCampNume(){
        return user.getText();
    }
	

	
    public String getCampParola(){
        return parola.getText();
    }
    
    public void setNume(JTextField nume) {
		this.user = nume;
	}
    
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(100, 100, 559, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterInterface reg=new RegisterInterface();
				frame.dispose();
	            reg.frame.setVisible(true);
	            frame.dispose();
	            
			}
		});
		btnNewButton.setBounds(365, 349, 89, 30);
		frame.getContentPane().add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(getSelectedComboRol().equals("         Student"))
				{
				try {
	                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
	                PreparedStatement st = connection.prepareStatement("Select nume, parola from student where nume=? and parola=?");
	                st.setString(1, getCampNume());
	                st.setString(2, getCampParola());

	                ResultSet rs = st.executeQuery();
	                if (rs.next()) {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Logarea a avut succes!");
	                    studentinterface regg=new studentinterface(getCampNume());
	    	            regg.frame.setVisible(true);
	    	            frame.setVisible(false);
	    	           
	    	            
	                } else {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Username/Parola gresite!");
 		              user.setText("");
 		             parola.setText("");
	                }
	                
	            } catch (SQLException sqlException) {
	                sqlException.printStackTrace();
	            }
			}
				else
					if(getSelectedComboRol().equals("         Profesor"))
					{
					try {
		                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
		                PreparedStatement st = connection.prepareStatement("Select nume, parola from profesor where nume=? and parola=?");
		                st.setString(1, getCampNume());
		                st.setString(2, getCampParola());

		                ResultSet rs = st.executeQuery();
		                if (rs.next()) {
		                    JOptionPane.showMessageDialog(new JButton("OK!"), "Logarea a avut succes!");
		                    profinterface reg2=new profinterface( getCampNume());
		    	            reg2.frame.setVisible(true);
		    	            frame.setVisible(false);
		                } else {
		                    JOptionPane.showMessageDialog(new JButton("OK!"), "Username/Parola gresite!");
		                    user.setText("");
		 		             parola.setText("");
		                }
		                
		            } catch (SQLException sqlException) {
		                sqlException.printStackTrace();
		            }
				}
					else
						if(getSelectedComboRol().equals("    Super Admin"))
						{
						try {
			                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
			                PreparedStatement st = connection.prepareStatement("Select nume, parola from superadmin where nume=? and parola=?");
			                st.setString(1, getCampNume());
			                st.setString(2, getCampParola());

			                ResultSet rs = st.executeQuery();
			                if (rs.next()) {
			                    JOptionPane.showMessageDialog(new JButton("OK!"), "Logarea a avut succes!");
			                    sadmininterface reg4=new sadmininterface(getCampNume());
			    	            reg4.frame.setVisible(true);
			    	            frame.setVisible(false);
			                } else {
			                    JOptionPane.showMessageDialog(new JButton("OK!"), "Username/Parola gresite!");
			                    user.setText("");
			 		             parola.setText("");
			                }
			              
			            } catch (SQLException sqlException) {
			                sqlException.printStackTrace();
			            }
					}
						else
							if(getSelectedComboRol().equals("         Admin"))
							{
							try {
				                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
				                PreparedStatement st = connection.prepareStatement("Select nume, parola from administrator where nume=? and parola=?");
				                st.setString(1, getCampNume());
				                st.setString(2, getCampParola());

				                ResultSet rs = st.executeQuery();
				                if (rs.next()) {
				                    JOptionPane.showMessageDialog(new JButton("OK!"), "Logarea a avut succes!");
				                    admininterface reg3=new admininterface(getCampNume());
				    	            reg3.frame.setVisible(true);
				    	            frame.setVisible(false);
				                } else {
				                    JOptionPane.showMessageDialog(new JButton("OK!"), "Username/Parola gresite!");
				                    user.setText("");
				 		             parola.setText("");
				                }
				                	
				            } catch (SQLException sqlException) {
				                sqlException.printStackTrace();
				            }
						}
				
			}
		});
	
		btnNewButton_1.setBounds(365, 303, 89, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		user = new JTextField();
		user.setBounds(339, 230, 147, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		parola = new JPasswordField();
		parola .setBounds(339, 261, 147, 20);
		frame.getContentPane().add(parola);
		parola .setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(257, 231, 72, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("         Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(223, 263, 106, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(22, 43, 188, 145);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Sebik\\eclipse-workspace\\Proiect\\src\\logout02.png"));
		lblNewLabel_3.setBounds(221, 11, 349, 208);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Select User");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(36, 217, 155, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"         Student", "         Profesor", "         Admin", "    Super Admin"}));
		comboBox.setBounds(22, 244, 128, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(70, 93, 97, 52);
		frame.getContentPane().add(lblNewLabel_5);
	}
	public String getSelectedComboRol(){
	    if(comboBox.getSelectedItem().toString() == null)
	        return "0";
	    return comboBox.getSelectedItem().toString();
	}
}
