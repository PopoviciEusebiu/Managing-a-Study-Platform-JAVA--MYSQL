import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class profinterface {

	public JFrame frame;
	private JTextField tfcursp;
	private JTextField tfdom;
	private JTextField tforemin;
	private JTextField tforemax;
	private JTextField pcurs;
	private JTextField plab;
	private JTextField psem;
	private JTextField tfmat;
	public String verificareCurs;
	private JTextField tftf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField numess;
	private JTextField prenumess;
	private JTextField numecurs;
	private JTextField notacurs;
	private JTextField notaseminar;
	private JTextField notalab;
	private String nume_gr;
	private int id;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public profinterface(String nume) {
		initialize(nume);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nume) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 532, 405);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Cursuri", null, panel, null);
		
		JPanel topPanel = new JPanel(new GridLayout(2, 5));
		topPanel.setBackground(new Color(173, 216, 230));
		
		JLabel lblNewLabel = new JLabel("Curs:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		tfcursp = new JTextField();
		tfcursp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfcursp.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("Domeniul:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		tfdom = new JTextField();
		tfdom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfdom.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("Nr. minim ore:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		tforemin = new JTextField();
		tforemin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tforemin.setColumns(5);
		
		JLabel lblNewLabel_3 = new JLabel("Nr. maxim ore:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		tforemax = new JTextField();
		tforemax.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tforemax.setColumns(5);
		
		JButton btnNewButton_ = new JButton("Deconectare");
		btnNewButton_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
                Login_interface login = new Login_interface();
           login.frame.setVisible(true);
			}
		});
		btnNewButton_.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_.setBounds(466, 311, 138, 33);
	
	
		JButton btnNewButton_1 = new JButton("Asignare");
		
	
         
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					//String obtin_mat="call obtinmaterie('"+nume+"')";	
					 //Statement st=connection.createStatement();
					 //ResultSet rez = st.executeQuery(obtin_mat);
					 //String x=rez.getString(tfcursp.getText());
					 //System.out.println(x);
			        
			        if (!tfcursp.getText().equals("") || !tforemin.getText().equals("") || !tforemax.getText().equals("") || !tfdom.getText().equals(""))
			        {
			        	String query = "call insertinformatii_profesor('"+tfcursp.getText() +"','"+ nume+"','"+tforemin.getText() +"','" +tforemax.getText() + "','"+tfdom.getText() +"')";
						Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				       sta.executeQuery(query);
				      
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Profesorul a fost adaugat la curs cu succes!");
	                   
	                } else {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Profesorul nu a fost putut adauga la curs, reincercati!");
	                  
	                }
			        tfcursp.setText("");
			        tforemin.setText("");
			        tforemax.setText("");
			        tfdom.setText("");

			         } 
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		topPanel.add(lblNewLabel);
		topPanel.add(lblNewLabel_1);
		topPanel.add(lblNewLabel_2);
		topPanel.add(lblNewLabel_3);
		topPanel.add(new JLabel());
		
		topPanel.add(tfcursp);
		topPanel.add(tfdom);
		topPanel.add(tforemin);
		topPanel.add(tforemax);
		topPanel.add(btnNewButton_1);
		
		String[][] ret = null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
			String obtin_mat="call obtinidprof('"+nume+"')";	
			 Statement st=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 ResultSet rez = st.executeQuery(obtin_mat);
			 rez.next();
			 id=Integer.parseInt(rez.getString("idprofesor"));
	         } 
		catch (SQLException sqlException)
		{
	        sqlException.printStackTrace();
	    }

		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
	    
	    
	    String query = "select * from info_profesor where idprofesor = '"+ id  + "'";
		Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    ResultSet rez = sta.executeQuery(query);
	    rez.last();
	    int size = rez.getRow();
	    rez.beforeFirst();
	    
	    ret = new String[size][5];
	    int i = 0;
	    while (rez.next()) {
	    	ret[i][0] = rez.getString("idprofesor");
	    	ret[i][1] = rez.getString("idcurs");
	    	ret[i][2] = rez.getString("departament");
	    	i++;
	    }
	} catch (SQLException sqlException) {
	    sqlException.printStackTrace();
	}
		
		String[] tableHead = {"idprofesor", "idcurs", "departament"};
		
		JTable table2 = new JTable(ret, tableHead);
		JScrollPane scrollPanel = new JScrollPane(table2);
		
		JPanel botPanel = new JPanel();
		botPanel.add(scrollPanel);
		
		panel.add(topPanel);
		panel.add(botPanel);
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Creare Grup", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Nume grup:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 31, 96, 22);
		panel_4.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(145, 31, 120, 23);
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(145, 77, 120, 23);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(145, 127, 120, 23);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(145, 177, 120, 23);
		panel_4.add(textField_3);
		
		JLabel lblNewLabel_10 = new JLabel("Nr max stud:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(10, 77, 111, 23);
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cursul:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(10, 127, 96, 23);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Nume prof:");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(10, 177, 96, 23);
		panel_4.add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(145, 224, 120, 23);
		panel_4.add(textField_4);
		
		JLabel lblNewLabel_13 = new JLabel("Prenume prof:");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(10, 223, 126, 25);
		panel_4.add(lblNewLabel_13);
		
		JButton btnNewButton_4 = new JButton("Creare Grup");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					if (!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals("") || !textField_4.getText().equals("")) {
						String query = "call creategrup_studiu('"+textField.getText() +"','"+textField_1.getText() +"','" +textField_2.getText() + "','"+textField_3.getText()   + "','"+textField_4.getText() +"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        nume_gr=textField.getText();
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Grupul s-a creat cu succes!");
					}
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Grupul nu poate fi creat!");
					}
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        textField_4.setText("");
				}
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
				
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_4.setBounds(129, 265, 161, 31);
		panel_4.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Selectie procente", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Procent Curs:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 83, 115, 24);
		panel_1.add(lblNewLabel_4);
		
		pcurs = new JTextField();
		pcurs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pcurs.setBounds(160, 78, 124, 27);
		panel_1.add(pcurs);
		pcurs.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Procent Lab :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 117, 115, 24);
		panel_1.add(lblNewLabel_5);
		
		plab = new JTextField();
		plab.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		plab.setBounds(160, 115, 124, 29);
		panel_1.add(plab);
		plab.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Procent seminar:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 151, 141, 24);
		panel_1.add(lblNewLabel_6);
		
		psem = new JTextField();
		psem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		psem.setBounds(160, 154, 124, 24);
		panel_1.add(psem);
		psem.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Materie:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 39, 100, 34);
		panel_1.add(lblNewLabel_7);
		
		tfmat = new JTextField();
		tfmat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfmat.setBounds(161, 44, 123, 24);
		panel_1.add(tfmat);
		tfmat.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Adaugare procente");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if (!tfmat.getText().equals("") && !pcurs.getText().equals("") && !psem.getText().equals("") && !plab.getText().equals("")) {

								if ( (Integer.parseInt(pcurs.getText())+Integer.parseInt(psem.getText())+Integer.parseInt(plab.getText()))==100 ) {
								String query = "call addProcente('"+tfmat.getText() +"','"+pcurs.getText() +"','" +psem.getText() + "','"+plab.getText() +"')";
					        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					        sta.executeQuery(query);
					        JOptionPane.showMessageDialog(new JButton("OK!"), "Procente adaugate cu succes!");
						
							}
					}

							 else {
			                    JOptionPane.showMessageDialog(new JButton("OK!"), "Procentele nu au fost adaugate!");
			                }
						
				
				
					 tfmat.setText("");
					 pcurs.setText("");
					 psem.setText("");
					 plab.setText("");
				}
	
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_2.setBounds(130, 200, 185, 34);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Adaugare note", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8_1 = new JLabel("Nume student:");
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_1.setBounds(10, 29, 118, 30);
		panel_5.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Prenume student:");
		lblNewLabel_8_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_2.setBounds(10, 69, 141, 30);
		panel_5.add(lblNewLabel_8_2);
		
		numess = new JTextField();
		numess.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		numess.setColumns(10);
		numess.setBounds(157, 29, 123, 24);
		panel_5.add(numess);
		
		prenumess = new JTextField();
		prenumess.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prenumess.setColumns(10);
		prenumess.setBounds(157, 69, 123, 24);
		panel_5.add(prenumess);
		
		numecurs = new JTextField();
		numecurs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		numecurs.setColumns(10);
		numecurs.setBounds(157, 108, 123, 24);
		panel_5.add(numecurs);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Nume curs:");
		lblNewLabel_8_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_2_1.setBounds(10, 99, 141, 40);
		panel_5.add(lblNewLabel_8_2_1);
		
		notacurs = new JTextField();
		notacurs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		notacurs.setColumns(10);
		notacurs.setBounds(157, 148, 123, 24);
		panel_5.add(notacurs);
		
		notaseminar = new JTextField();
		notaseminar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		notaseminar.setColumns(10);
		notaseminar.setBounds(157, 187, 123, 24);
		panel_5.add(notaseminar);
		
		notalab = new JTextField();
		notalab.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		notalab.setColumns(10);
		notalab.setBounds(157, 227, 123, 24);
		panel_5.add(notalab);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Nota curs:");
		lblNewLabel_8_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_2_1_1.setBounds(10, 137, 141, 53);
		panel_5.add(lblNewLabel_8_2_1_1);
		
		JLabel lblNewLabel_8_2_1_2 = new JLabel("Nota seminar:");
		lblNewLabel_8_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_2_1_2.setBounds(10, 171, 141, 62);
		panel_5.add(lblNewLabel_8_2_1_2);
		
		JLabel lblNewLabel_8_2_1_3 = new JLabel("Nota lab:");
		lblNewLabel_8_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_2_1_3.setBounds(10, 200, 141, 77);
		panel_5.add(lblNewLabel_8_2_1_3);
		
		JButton btnNewButton_2_1 = new JButton("Adaugare note");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					 if (!numess.getText().equals("") || !prenumess.getText().equals("") || numecurs.getText().equals("") || notaseminar.getText().equals("") ||!notalab.getText().equals("")||!notacurs.getText().equals("")) {
						 String query = "call addGrades('"+numess.getText() +"','"+prenumess.getText() +"','" +numecurs.getText() + "','"+nume  + "','"+notaseminar.getText() + "','"+notalab.getText() + "','"+notacurs.getText() +  "')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Note adaugate cu succes!"); 
			         }
					 else {
						 JOptionPane.showMessageDialog(new JButton("OK!"), "Notele nu pot fi adaugate!"); 
					 }
					 
					 numess.setText("");
	                    prenumess.setText("");
	                    numecurs.setText("");
	                    notaseminar.setText("");
	                    notalab.setText("");
	                    notacurs.setText("");
	                    
				}


				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
				
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(124, 271, 185, 34);
		panel_5.add(btnNewButton_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Grup", null, panel_2, null);
		tabbedPane.setBackgroundAt(4, new Color(255, 255, 255));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nume grup:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(20, 78, 101, 29);
		panel_2.add(lblNewLabel_8);
		
		tftf = new JTextField();
		tftf.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tftf.setBounds(131, 78, 121, 30);
		panel_2.add(tftf);
		tftf.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Adaugare la grup");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if(!(tftf.getText()=="") &&  !tftf.getText().equals(null) ) {
						String query = "call addTeacherToGroup('"+tftf.getText() +"','" + nume +"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Profesor adaugat cu succes!");
			        tftf.setText("");
			        }
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Grupul nu exista!");
						tftf.setText("");
					}
			 
			        
			      
				}
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_3.setBounds(105, 126, 171, 30);
		panel_2.add(btnNewButton_3);
		
		JLabel lblNewLabel_14 = new JLabel("Alegeti grupul de studiu unde doriti sa adaugati profesorul:");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_14.setBounds(10, 22, 507, 45);
		panel_2.add(lblNewLabel_14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Detalii prof", null, panel_3, null);
		
		
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.setBorder(new EmptyBorder(35, 65, 0, 0));
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
	    
        
        String query = "call showInfoProf('"+ nume + "')";
		Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rez = sta.executeQuery(query);
        //rez.last();
        //rez.getRow();
        //rez.beforeFirst();

        while (rez.next()) {
        	panel_3.add(new JLabel("CNP: " + rez.getString("CNP")));
        	panel_3.add(new JLabel("Nume: " + rez.getString("nume")));
        	panel_3.add(new JLabel("Prenume: " + rez.getString("prenume")));
        	panel_3.add(new JLabel("Adresa: " + rez.getString("adresa")));
        	panel_3.add(new JLabel("Telefon: " +rez.getString("telefon")));
        	panel_3.add(new JLabel("Email: " + rez.getString("email")));
        	panel_3.add(new JLabel("IBAN: " + rez.getString("IBAN")));
			
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
	panel_3.add(new JLabel());
	panel_3.add(btnNewButton_);
	
	JPanel panel_6 = new JPanel();
	panel_6.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Sugestii participanti", null, panel_6, null);
	
	String[][] ret9=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select idstudent,nume,prenume,cnp from student order by rand() limit 3";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez9 = stt.executeQuery(query);
    rez9.last();
    int size9 = rez9.getRow();
    rez9.beforeFirst();
    
    ret9 = new String[size9][4];
    int i = 0;
    while (rez9.next()) {
    	
    	ret9[i][0] = rez9.getString("idstudent");
     	ret9[i][1] = rez9.getString("nume");
    	ret9[i][2] = rez9.getString("prenume");
    	ret9[i][3] = rez9.getString("cnp");  	
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead9 = {"idstudent", "nume", "prenume","cnp"};
	
	JTable table9 = new JTable(ret9, tableHead9);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPannn9 = new JScrollPane(table9);
	
	panel_6.setLayout(new BorderLayout());
	panel_6.add(scrollPannn9);
		

		
		frame.setBounds(100, 100, 546, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
