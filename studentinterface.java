import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class studentinterface {

	public JFrame frame;
	private JTextField tfprof;
	private JTextField tfcurs;
	private JTextField tfcnp;
	private JTextField tfgrup;
	private JTextField tfactv;
	private JTextField tfcnp1;
	private JTextField tfgrup2;
	private JTextField tfcnp2;
	private JTextField tfanstudiu;
	private JTextField tfnrore;
	protected String nume_prof;
	protected String nume_curs;
	private int id;
	private JTextField numcurs;
	private JTextField renunt;
	private JTextField textField_1;
	private JTextField textField_2;


	public studentinterface(String Nume) {
		initialize(Nume);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Nume) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Bun venit, "+Nume+"!");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 722, 458);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		
		tabbedPane.addTab("Detalii", null, panel, null);
		panel.setLayout(null);
		JButton btnNewButton_8 = new JButton("Deconectare");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
                Login_interface login = new Login_interface();
           login.frame.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_8.setBounds(65, 35, 109, 29);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Note", null, panel_1, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Inscriere Curs", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Alege cursul:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(7, 39, 123, 38);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Profesorul:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(168, 39, 104, 35);
		panel_3.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Asignare curs");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
				    
			        String cnpp=tfcnp.getText();
			        String curss=tfcurs.getText();
			        String proff=tfprof.getText();
			        System.out.println(cnpp);
			        
			        // String 
			        String query = "call studentRegistration('"+ Nume +"','"+cnpp+"','" +proff+ "','"+curss+"')";
					Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        ResultSet rez = sta.executeQuery(query);
			        nume_prof=proff;
			        nume_curs=curss;

			         } 
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(469, 83, 137, 30);
		panel_3.add(btnNewButton_1);
		
		tfprof = new JTextField();
		tfprof.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfprof.setBounds(167, 85, 120, 27);
		panel_3.add(tfprof);
		tfprof.setColumns(10);
		
		tfcurs = new JTextField();
		tfcurs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfcurs.setBounds(10, 84, 120, 27);
		panel_3.add(tfcurs);
		tfcurs.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("    CNP:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(313, 49, 71, 35);
		panel_3.add(lblNewLabel_2);
		
		tfcnp = new JTextField();
		tfcnp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfcnp.setBounds(313, 86, 120, 27);
		panel_3.add(tfcnp);
		tfcnp.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("An de studiu:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(10, 175, 113, 28);
		panel_3.add(lblNewLabel_8);
		
		tfanstudiu = new JTextField();
		tfanstudiu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfanstudiu.setBounds(10, 213, 96, 27);
		panel_3.add(tfanstudiu);
		tfanstudiu.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Numar ore:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(149, 175, 115, 29);
		panel_3.add(lblNewLabel_9);
		
		tfnrore = new JTextField();
		tfnrore.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfnrore.setBounds(149, 213, 96, 27);
		panel_3.add(tfnrore);
		tfnrore.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Adaugare date");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
	                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
		             Statement st;
		             
		               st=connection.createStatement();
		                String sql="insert into student "+"(anstudiu,nr_ore)" + "values('"+tfanstudiu.getText()+"','"+tfnrore.getText()+"')";
		             
		               st.executeUpdate(sql);
		                JOptionPane.showMessageDialog(null,"Date inserate!");
		      
	                }
	                catch(SQLException e1) {
	                e1.printStackTrace();
	                }
				
			}
		});
		
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_6.setBounds(291, 211, 137, 30);
		panel_3.add(btnNewButton_6);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new EmptyBorder(35, 65, 0, 0));
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
	    
        
        String query = "call showInfoStud('"+ Nume + "')";
		Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rez = sta.executeQuery(query);
        //rez.last();
        //rez.getRow();
        //rez.beforeFirst();

        while (rez.next()) {
        	panel.add(new JLabel("CNP: " + rez.getString("CNP")));
        	panel.add(new JLabel("Nume: " + rez.getString("nume")));
        	panel.add(new JLabel("Prenume: " + rez.getString("prenume")));
        	panel.add(new JLabel("Adresa: " + rez.getString("adresa")));
        	panel.add(new JLabel("Telefon: " +rez.getString("telefon")));
        	panel.add(new JLabel("Email: " + rez.getString("email")));
        	panel.add(new JLabel("IBAN: " + rez.getString("IBAN")));
			
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }


	panel.add(new JLabel());
	panel.add(btnNewButton_8);
	
	String[][] ret = null;
	
	
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "call showNotes('"+ Nume + "')";
	Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez = sta.executeQuery(query);
    rez.last();
    int size = rez.getRow();
    rez.beforeFirst();
    
    ret = new String[size][6];
    int i = 0;
    while (rez.next()) {
    	ret[i][0] = rez.getString("nume_curs");
    	ret[i][1] = rez.getString("nota_curs");
    	ret[i][2] = rez.getString("nota_lab");
    	ret[i][3] = rez.getString("nota_seminar");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead = {"Nume Curs", "Nota Curs", "Nota lab", "Nota Seminar"};
	
	JTable table = new JTable(ret, tableHead);
	JScrollPane scrollPanel = new JScrollPane(table);
	panel_1.add(scrollPanel);
	
	
	
	
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Inscriere grupuri", null, panel_2, null);
	panel_2.setLayout(null);
	
	tfgrup = new JTextField();
	tfgrup.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	tfgrup.setBounds(112, 62, 147, 27);
	panel_2.add(tfgrup);
	tfgrup.setColumns(10);
	
	JLabel lblNewLabel_3 = new JLabel("Grup de activitati:");
	lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_3.setBounds(106, 29, 153, 22);
	panel_2.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("     Activitatea:");
	lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_4.setBounds(92, 100, 129, 27);
	panel_2.add(lblNewLabel_4);
	
	tfactv = new JTextField();
	tfactv.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	tfactv.setBounds(112, 138, 147, 27);
	panel_2.add(tfactv);
	tfactv.setColumns(10);
	
	JLabel lblNewLabel_5 = new JLabel("         CNP:");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_5.setBounds(68, 176, 129, 13);
	panel_2.add(lblNewLabel_5);
	
	tfcnp1 = new JTextField();
	tfcnp1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	tfcnp1.setBounds(112, 200, 147, 27);
	panel_2.add(tfcnp1);
	tfcnp1.setColumns(10);
	
	JButton btnNewButton_2 = new JButton("Asignare activitate");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
			    
		        String cnpp1=tfcnp1.getText();
		        String activitate=tfactv.getText();
		        String grup=tfgrup.getText();
		        System.out.println(cnpp1);
		        
		        // String 
		        String query = "call studentToAGroupActivity('"+ Nume +"','"+cnpp1+"','" +grup+ "','"+activitate+"')";
				Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        ResultSet rez = sta.executeQuery(query);
		        //rez.last();
		        //rez.getRow();
		        //rez.beforeFirst();
		        if (rez.next()) {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Asignare la activitate reusita!");
	                   
	                } else {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Asignare la activitate nereusita!");
	                  
	                }
		       
		         } 
			catch (SQLException sqlException)
			{
		        sqlException.printStackTrace();
		    }
			
			
		}
	});
	btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	btnNewButton_2.setBounds(81, 238, 198, 33);
	panel_2.add(btnNewButton_2);
	
	JLabel lblNewLabel_6 = new JLabel("Grup de studiu:");
	lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_6.setBounds(379, 28, 144, 24);
	panel_2.add(lblNewLabel_6);
	
	tfgrup2 = new JTextField();
	tfgrup2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	tfgrup2.setBounds(379, 62, 147, 27);
	panel_2.add(tfgrup2);
	tfgrup2.setColumns(10);
	
	JLabel lblNewLabel_7 = new JLabel("CNP:");
	lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_7.setBounds(379, 102, 144, 22);
	panel_2.add(lblNewLabel_7);
	
	tfcnp2 = new JTextField();
	tfcnp2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	tfcnp2.setBounds(373, 138, 147, 27);
	panel_2.add(tfcnp2);
	tfcnp2.setColumns(10);
	
	JButton btnNewButton_3 = new JButton("Asignare grup");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
			    
		        String cnp2=tfcnp2.getText();
		       
		        String grup2=tfgrup2.getText();
		        
		        String query = "call studentGroup('"+ Nume +"','"+cnp2+"','" +grup2+"')";
				Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        ResultSet rez = sta.executeQuery(query);
		        
		        if (rez.next()) {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Asignare la grup reusita!");
	                   
	                } else {
	                    JOptionPane.showMessageDialog(new JButton("OK!"), "Asignare la grup nereusita!");
	                  
	                }
		        
		        //rez.last();
		        //rez.getRow();
		        //rez.beforeFirst();

		         } 
			catch (SQLException sqlException)
			{
		        sqlException.printStackTrace();
		    }
			
		}
	});
	btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	btnNewButton_3.setBounds(360, 238, 198, 33);
	panel_2.add(btnNewButton_3);
	
	JPanel panel_4 = new JPanel();
	panel_4.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Orar Student", null, panel_4, null);
	
	
	
   String[][] ret1 = null;
	
	try {
		Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
		String obtin_mat="call obtinidstud('"+Nume+"')";	
		 Statement st=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		 ResultSet rez = st.executeQuery(obtin_mat);
		 rez.next();
		 id=Integer.parseInt(rez.getString("idstudent"));
         } 
	catch (SQLException sqlException)
	{
        sqlException.printStackTrace();
    }
	
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from orar_student where idstudent = '"+ id  + "'";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez1 = stt.executeQuery(query);
    rez1.last();
    int size1 = rez1.getRow();
    rez1.beforeFirst();
    
    ret1 = new String[size1][10];
    int i = 0;
    while (rez1.next()) {
    	ret1[i][0] = rez1.getString("idstudent");
    	ret1[i][1] = rez1.getString("idcurs");
    	ret1[i][2] = rez1.getString("zi_curs");
    	ret1[i][3] = rez1.getString("zi_lab");
    	ret1[i][4] = rez1.getString("zi_sem");
    	ret1[i][5] = rez1.getString("ora_curs");
    	ret1[i][6] = rez1.getString("ora_lab");
    	ret1[i][7] = rez1.getString("ora_sem");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead2 = {"idstudent", "idcurs", "zi_curs","zi_lab","zi_sem","ora_curs","ora_lab","ora_sem"};
	
	JTable table2 = new JTable(ret1, tableHead2);
	JScrollPane scrollPan = new JScrollPane(table2);

	panel_4.setLayout(new BorderLayout());
	panel_4.add(scrollPan);
	

	
	JPanel panel_5 = new JPanel();
	panel_5.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Afisare grupuri", null, panel_5, null);
	
	String[][] ret2=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from grup_studiu ";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez1 = stt.executeQuery(query);
    rez1.last();
    int size1 = rez1.getRow();
    rez1.beforeFirst();
    
    ret2 = new String[size1][15];
    int i = 0;
    while (rez1.next()) {
    	ret2[i][0] = rez1.getString("idgrup");
    	ret2[i][1] = rez1.getString("nume");
    	ret2[i][2] = rez1.getString("nr_max_studenti");
    	ret2[i][3] = rez1.getString("idcurs");
    	ret2[i][4] = rez1.getString("nr_actual_stud");
    	ret2[i][5] = rez1.getString("idprofesor");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead3 = {"idgrup", "nume", "nr_max_studenti","idcurs","nr_actual_stud","idprofesor"};
	
	JTable table3 = new JTable(ret2, tableHead3);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPann = new JScrollPane(table3);
	
    panel_5.setLayout(new BorderLayout());
	panel_5.add(scrollPann);
	

	
	
	JPanel panel_6 = new JPanel();
	panel_6.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Afisare activitati", null, panel_6, null);
	
	String[][] ret3=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from activ_grup ";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez1 = stt.executeQuery(query);
    rez1.last();
    int size1 = rez1.getRow();
    rez1.beforeFirst();
    
    ret3 = new String[size1][15];
    int i = 0;
    while (rez1.next()) {
    	ret3[i][0] = rez1.getString("idactiv_grup");
    	ret3[i][1] = rez1.getString("id_grup_studiu");
    	ret3[i][2] = rez1.getString("nr_min");
    	ret3[i][3] = rez1.getString("data_desf");
    	ret3[i][4] = rez1.getString("ora_desf");
    	ret3[i][5] = rez1.getString("nr_actual");
    	ret3[i][6] = rez1.getString("activ_grupcol");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead4 = {"idactiv_grup", "id_grup_studiu", "nr_min","data_desf","ora_desf","nr_actual","activ_grupcol"};
	
	JTable table4 = new JTable(ret3, tableHead4);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPannn = new JScrollPane(table4);
	
	panel_6.setLayout(new BorderLayout());
	

	panel_6.add(scrollPannn);
	
	JPanel panel_7 = new JPanel();
	panel_7.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Renuntare curs", null, panel_7, null);
	panel_7.setLayout(null);
	
	JLabel lblNewLabel_10 = new JLabel("Nume curs:");
	lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_10.setBounds(32, 52, 121, 26);
	panel_7.add(lblNewLabel_10);
	
	JLabel lblNewLabel_11 = new JLabel("Data renuntarii:");
	lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_11.setBounds(31, 109, 137, 35);
	panel_7.add(lblNewLabel_11);
	
	numcurs = new JTextField();
	numcurs.setBounds(178, 53, 159, 28);
	panel_7.add(numcurs);
	numcurs.setColumns(10);
	
	renunt = new JTextField();
	renunt.setBounds(178, 109, 159, 29);
	panel_7.add(renunt);
	renunt.setColumns(10);
	
	JButton btnNewButton = new JButton("Renuntare");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
			    
		        String num=numcurs.getText();
		       
		        String re=renunt.getText();
		        
		        
		        if(!numcurs.getText().equals("") && !renunt.getText().equals(""))
		        {
		        String query = "call dropCourse('"+ num +"','"+re+"','"+id+"')";
				Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        sta.executeQuery(query);
		        JOptionPane.showMessageDialog(new JButton("OK!"), "Renuntare la grup reusita!");
		        }
		        else {
		        	JOptionPane.showMessageDialog(new JButton("OK!"), "Renuntare la grup nereusita!");
		        }
		        numcurs.setText("");
		        renunt.setText("");
	

		         } 
			catch (SQLException sqlException)
			{
		        sqlException.printStackTrace();
		    }
		}
	});
	btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	btnNewButton.setBounds(178, 160, 159, 35);
	panel_7.add(btnNewButton);
	
	JPanel panel_8 = new JPanel();
	panel_8.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Renuntare grup", null, panel_8, null);
	panel_8.setLayout(null);
	
	JLabel lblNewLabel_13 = new JLabel("CNP:");
	lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_13.setBounds(45, 50, 110, 24);
	panel_8.add(lblNewLabel_13);
	
	JLabel lblNewLabel_14 = new JLabel("Nume grup:");
	lblNewLabel_14.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_14.setBounds(45, 99, 121, 24);
	panel_8.add(lblNewLabel_14);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_1.setBounds(165, 49, 159, 28);
	panel_8.add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_2.setBounds(165, 98, 159, 28);
	panel_8.add(textField_2);
	textField_2.setColumns(10);
	
	JButton btnNewButton_4 = new JButton("Renuntare");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
			    
		        String cnp=textField_1.getText();
		       
		        String grup=textField_2.getText();
		        
		        
		        if(!textField_1.getText().equals("") && !textField_2.getText().equals(""))
		        {
		        String query = "call dropStudyGroup('"+ Nume +"','"+cnp+"','"+grup+"')";
				Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        sta.executeQuery(query);
		        JOptionPane.showMessageDialog(new JButton("OK!"), "Renuntare la grup reusita!");
		        }
		        else {
		        	JOptionPane.showMessageDialog(new JButton("OK!"), "Renuntare la grup nereusita!");
		        }
		        textField_1.setText("");
		        textField_2.setText("");
	

		         } 
			catch (SQLException sqlException)
			{
		        sqlException.printStackTrace();
		    }
		
		}
	});
	btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	btnNewButton_4.setBounds(165, 145, 159, 35);
	panel_8.add(btnNewButton_4);
	
	JPanel panel_9 = new JPanel();
	panel_9.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Afisare cursuri", null, panel_9, null);
	
	String[][] ret4=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from curs ";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez1 = stt.executeQuery(query);
    rez1.last();
    int size1 = rez1.getRow();
    rez1.beforeFirst();
    
    ret4 = new String[size1][15];
    int i = 0;
    while (rez1.next()) {
    	ret4[i][0] = rez1.getString("idcurs");
    	ret4[i][1] = rez1.getString("nume_curs");
    	ret4[i][2] = rez1.getString("descriere");
    	ret4[i][3] = rez1.getString("nr_max_studenti");
    	ret4[i][4] = rez1.getString("nr_actual_studenti");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead5 = {"idcurs", "nume_curs", "descriere","nr_max_studenti","nr_actual_studenti"};
	
	JTable table5 = new JTable(ret4, tableHead5);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPann1 = new JScrollPane(table5);
	
    panel_9.setLayout(new BorderLayout());
	panel_9.add(scrollPann1);

	frame.setBounds(100, 100, 738, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
