import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class sadmininterface {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField zic;
	private JTextField zis;
	private JTextField zil;
	private JTextField orac;
	private JTextField oras;
	private JTextField oral;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField numes;
	private JTextField prenumes;
	private JTextField cnps;
	private JTextField parolas;
	private JTextField emails;
	private JTextField ibans;
	private JTextField adresas;
	private JTextField ans;
	private JTextField ores;
	private JTextField contracts;
	private JTextField telefons;
	private JTextField prenumep;
	private JTextField numep;
	private JTextField cnpp;
	private JTextField adresap;
	private JTextField telp;
	private JTextField emailp;
	private JTextField ibanp;
	private JTextField contractp;
	private JTextField passp;
	private JTextField profc;
	private JTextField prenumec;
	private JTextField cursi;
	private JTextField cursa;
	private JTextField descrierec;
	private JTextField maxc;
	private JTextField cursc;
	private JTextField semc;
	private JTextField labc;
	private JTextField grupa;
	private JTextField grupn;
	private JTextField maxg;
	private JTextField act;
	private JTextField prc;
	private JTextField prs;
	private JTextField prl;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public sadmininterface(String nume) {
		initialize(nume);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize(String nume) {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 740, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 724, 502);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Creare Curs", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numele cursului:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 22, 137, 22);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(177, 23, 177, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descriere:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 54, 137, 24);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setBounds(177, 55, 177, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nr. max studenti:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 88, 148, 23);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(177, 91, 177, 22);
		panel.add(textField_2);
		
		zic = new JTextField();
		zic.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		zic.setColumns(10);
		zic.setBounds(177, 129, 177, 22);
		panel.add(zic);
		
		JLabel lblNewLabel_3 = new JLabel("Ziua cursului:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 128, 137, 22);
		panel.add(lblNewLabel_3);
		
		zis = new JTextField();
		zis.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		zis.setColumns(10);
		zis.setBounds(177, 168, 177, 22);
		panel.add(zis);
		
		zil = new JTextField();
		zil.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		zil.setColumns(10);
		zil.setBounds(177, 212, 177, 22);
		panel.add(zil);
		
		JLabel lblNewLabel_4 = new JLabel("Ziua seminarului:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 165, 148, 27);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ziua laboratorului:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 211, 167, 22);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nr ore lab:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(380, 128, 108, 22);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nr ore curs:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(380, 169, 108, 19);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nr ore seminar:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(381, 212, 139, 21);
		panel.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Adaugare curs");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//getSelectedComboRol().equals("         Student");
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("") && !zil.getText().equals("") && !zic.getText().equals("") && !zis.getText().equals("") && !orac.getText().equals("") && !oral.getText().equals("") && !oras.getText().equals("")))
					{
						if((!textField.equals(null) && !textField_1.equals(null) && !textField_2.equals(null) && !zil.equals(null) && !zic.equals(null) && !zis.equals(null)))
						{
					  String query = "call insertcursuri('"+textField.getText()+"','"+textField_1.getText() +"','" +textField_2.getText() + "','"+zil.getText()+"','"+zic.getText() +"','"+zis.getText() +"','"+orac.getText() +"','"+oral.getText() +"','"+oras.getText() +  "')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Cursul a fost inserat cu succes!");
			        //rez.last();
			        //rez.getRow();
			        //rez.beforeFirst();
     
				}}
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Cursul nu poate fi inserat!");
					}
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					zil.setText("");
					zis.setText("");
					zic.setText("");
					orac.setText("");
					oral.setText("");
					oras.setText("");
					
					
				}
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(181, 252, 148, 35);
		panel.add(btnNewButton_1);
		
		orac = new JTextField();
		orac.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		orac.setBounds(519, 129, 67, 19);
		panel.add(orac);
		orac.setColumns(10);
		
		oras = new JTextField();
		oras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		oras.setColumns(10);
		oras.setBounds(519, 171, 67, 19);
		panel.add(oras);
		
		oral = new JTextField();
		oral.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		oral.setColumns(10);
		oral.setBounds(519, 212, 67, 19);
		panel.add(oral);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Update curs", null, panel_5, null);
		panel_5.setLayout(null);
		
		
		
		JLabel lblNewLabel_28_1 = new JLabel("Nume profesor:");
		lblNewLabel_28_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1.setBounds(28, 30, 137, 22);
		panel_5.add(lblNewLabel_28_1);
		
		JLabel lblNewLabel_28_2 = new JLabel("Prenume profesor:");
		lblNewLabel_28_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_2.setBounds(28, 61, 150, 22);
		panel_5.add(lblNewLabel_28_2);
		
		JLabel lblNewLabel_28_1_1 = new JLabel("Numele cursului initial:");
		lblNewLabel_28_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_1.setBounds(28, 100, 213, 22);
		panel_5.add(lblNewLabel_28_1_1);
		
		JLabel lblNewLabel_28_1_2 = new JLabel("Numele cursului actualizat:");
		lblNewLabel_28_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_2.setBounds(28, 133, 231, 24);
		panel_5.add(lblNewLabel_28_1_2);
		
		JLabel lblNewLabel_28_1_3 = new JLabel("Descrierea:");
		lblNewLabel_28_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_3.setBounds(28, 167, 100, 22);
		panel_5.add(lblNewLabel_28_1_3);
		
		JLabel lblNewLabel_28_1_4 = new JLabel("Nr max studenti:");
		lblNewLabel_28_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_4.setBounds(28, 199, 137, 22);
		panel_5.add(lblNewLabel_28_1_4);
		
		JLabel lblNewLabel_28_1_5 = new JLabel("Nr ore curs:");
		lblNewLabel_28_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_5.setBounds(28, 235, 100, 22);
		panel_5.add(lblNewLabel_28_1_5);
		
		JLabel lblNewLabel_28_1_6 = new JLabel("Nr ore seminar:");
		lblNewLabel_28_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_6.setBounds(28, 268, 137, 21);
		panel_5.add(lblNewLabel_28_1_6);
		
		JLabel lblNewLabel_28_1_7 = new JLabel("Nr ore laborator:");
		lblNewLabel_28_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_7.setBounds(28, 300, 159, 21);
		panel_5.add(lblNewLabel_28_1_7);
		
		profc = new JTextField();
		profc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		profc.setColumns(10);
		profc.setBounds(251, 30, 137, 24);
		panel_5.add(profc);
		
		prenumec = new JTextField();
		prenumec.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prenumec.setColumns(10);
		prenumec.setBounds(251, 61, 137, 24);
		panel_5.add(prenumec);
		
		cursi = new JTextField();
		cursi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cursi.setColumns(10);
		cursi.setBounds(251, 100, 137, 23);
		panel_5.add(cursi);
		
		cursa = new JTextField();
		cursa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cursa.setColumns(10);
		cursa.setBounds(251, 133, 137, 25);
		panel_5.add(cursa);
		
		descrierec = new JTextField();
		descrierec.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		descrierec.setColumns(10);
		descrierec.setBounds(251, 168, 137, 22);
		panel_5.add(descrierec);
		
		maxc = new JTextField();
		maxc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		maxc.setColumns(10);
		maxc.setBounds(251, 199, 137, 23);
		panel_5.add(maxc);
		
		cursc = new JTextField();
		cursc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cursc.setColumns(10);
		cursc.setBounds(251, 236, 137, 22);
		panel_5.add(cursc);
		
		semc = new JTextField();
		semc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		semc.setColumns(10);
		semc.setBounds(251, 268, 137, 22);
		panel_5.add(semc);
		
		labc = new JTextField();
		labc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labc.setColumns(10);
		labc.setBounds(251, 300, 137, 22);
		panel_5.add(labc);
		
		JButton btnNewButton_5_1 = new JButton("Modificare date");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!profc.getText().equals("") && !prenumec.getText().equals("") && !cursi.getText().equals("") && !cursa.getText().equals("") && !descrierec.getText().equals("") && !maxc.getText().equals("") && !cursc.getText().equals("") && !semc.getText().equals("") && !labc.getText().equals("")))
					{
						if((!profc.equals(null) && !prenumec.equals(null) && !cursi.equals(null) && !cursa.equals(null) && !descrierec.equals(null) ))
						{
						String query = "call updatecursuri('"+profc.getText() +"','"
						+prenumec.getText() +"','"
								+cursi.getText()+"','"
						+cursa.getText()+"','"
								+  descrierec.getText()+"','"
						+maxc.getText()+"','"
								+cursc.getText()+"','"
						+semc.getText() +"','"
								+labc.getText()+"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Cursul s-a updatat succes!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Cursul un poate fi updatat!");
					}
			      
				}
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }		
				
			}
		});
		btnNewButton_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5_1.setBounds(216, 333, 192, 39);
		panel_5.add(btnNewButton_5_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Update student", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JLabel lblNewLabel_15 = new JLabel("Introduceti datele studentului:");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_15.setBounds(10, 11, 273, 23);
		panel_3.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Nume:");
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_16.setBounds(10, 44, 92, 24);
		panel_3.add(lblNewLabel_16);
		
		numes = new JTextField();
		numes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		numes.setBounds(159, 45, 141, 24);
		panel_3.add(numes);
		numes.setColumns(10);
		
		prenumes = new JTextField();
		prenumes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prenumes.setColumns(10);
		prenumes.setBounds(159, 80, 141, 23);
		panel_3.add(prenumes);
		
		JLabel lblNewLabel_17 = new JLabel("Prenume:");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_17.setBounds(10, 79, 92, 23);
		panel_3.add(lblNewLabel_17);
		
		cnps = new JTextField();
		cnps.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cnps.setColumns(10);
		cnps.setBounds(159, 114, 141, 23);
		panel_3.add(cnps);
		
		JLabel lblNewLabel_18 = new JLabel("CNP:");
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_18.setBounds(10, 112, 77, 24);
		panel_3.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Parola noua:");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_19.setBounds(10, 147, 122, 23);
		panel_3.add(lblNewLabel_19);
		
		parolas = new JTextField();
		parolas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		parolas.setColumns(10);
		parolas.setBounds(159, 148, 141, 23);
		panel_3.add(parolas);
		
		JLabel lblNewLabel_20 = new JLabel("Email nou:");
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_20.setBounds(10, 181, 122, 30);
		panel_3.add(lblNewLabel_20);
		
		emails = new JTextField();
		emails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		emails.setColumns(10);
		emails.setBounds(159, 182, 141, 23);
		panel_3.add(emails);
		
		ibans = new JTextField();
		ibans.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ibans.setColumns(10);
		ibans.setBounds(159, 216, 141, 23);
		panel_3.add(ibans);
		
		JLabel lblNewLabel_21 = new JLabel("IBAN nou:");
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_21.setBounds(10, 214, 92, 24);
		panel_3.add(lblNewLabel_21);
		
		adresas = new JTextField();
		adresas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		adresas.setColumns(10);
		adresas.setBounds(159, 252, 141, 24);
		panel_3.add(adresas);
		
		JLabel lblNewLabel_22 = new JLabel("Adresa noua:");
		lblNewLabel_22.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_22.setBounds(10, 249, 122, 23);
		panel_3.add(lblNewLabel_22);
		
		ans = new JTextField();
		ans.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ans.setColumns(10);
		ans.setBounds(159, 282, 141, 25);
		panel_3.add(ans);
		
		JLabel lblNewLabel_23 = new JLabel("An studiu:");
		lblNewLabel_23.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_23.setBounds(10, 282, 92, 24);
		panel_3.add(lblNewLabel_23);
		
		ores = new JTextField();
		ores.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ores.setColumns(10);
		ores.setBounds(159, 318, 141, 23);
		panel_3.add(ores);
		
		JLabel lblNewLabel_24 = new JLabel("Numar ore:");
		lblNewLabel_24.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_24.setBounds(10, 316, 92, 24);
		panel_3.add(lblNewLabel_24);
		
		contracts = new JTextField();
		contracts.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contracts.setColumns(10);
		contracts.setBounds(159, 351, 141, 24);
		panel_3.add(contracts);
		
		JLabel lblNewLabel_25 = new JLabel("Nr. Contract:");
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_25.setBounds(10, 351, 122, 23);
		panel_3.add(lblNewLabel_25);
		
		JButton btnNewButton_4 = new JButton("Modificare date");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!parolas.getText().equals("") || !cnps.getText().equals("") || !numes.getText().equals("") || !prenumes.getText().equals("") || !adresas.getText().equals("") || !telefons.getText().equals("") || !emails.getText().equals("") || !contracts.getText().equals("") || !ores.getText().equals("") || !ans.getText().equals("")))
					{
						
						if(!parolas.equals(null) && !cnps.equals(null) && !numes.equals(null) && !prenumes.equals(null) && !adresas.equals(null) && !telefons.equals(null) && !emails.equals(null) && !contracts.equals(null) )
						{
						String query = "call updatestudent('"+parolas.getText() +"','"
						+cnps.getText() +"','"
								+numes.getText()+"','"
						+prenumes.getText()+"','"
								+  adresas.getText()+"','"
						+telefons.getText()+"','"
								+emails.getText()+"','"
						+ibans.getText() +"','"
								+contracts.getText()+"','"
						+ans.getText()+"','"
								+ores.getText() +"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Studentul s-a updatat cu succes!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Studentul nu s-a putut updata!");
					}
					parolas.setText("");
					cnps.setText("");
					numes.setText("");
					prenumes.setText("");
					adresas.setText("");
					telefons.setText("");
					emails.setText("");
					ibans.setText("");
					contracts.setText("");
					ans.setText("");
					ores.setText("");
					
			        
			      
				}
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }		
				
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.setBounds(391, 367, 169, 43);
		panel_3.add(btnNewButton_4);
		
		telefons = new JTextField();
		telefons.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		telefons.setColumns(10);
		telefons.setBounds(159, 386, 141, 24);
		panel_3.add(telefons);
		
		JLabel lblNewLabel_26 = new JLabel("Nr tel nou:");
		lblNewLabel_26.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_26.setBounds(10, 384, 85, 24);
		panel_3.add(lblNewLabel_26);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Delete Student", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		
		JLabel lblNewLabel_9 = new JLabel("Nume student:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(34, 24, 125, 60);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Prenume student:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(10, 84, 149, 24);
		panel_2.add(lblNewLabel_10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setBounds(169, 37, 96, 25);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_4.setBounds(169, 83, 96, 25);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(169, 129, 96, 25);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_11 = new JLabel("                 CNP:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(10, 129, 133, 25);
		panel_2.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("Stergere student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!textField_3.getText().equals("") && !textField_4.getText().equals("") && !textField_5.getText().equals("")))
					{
						//JOptionPane.showMessageDialog(new JButton("OK!"), "Studentul nu poate fi sters!");
						if(!textField_3.equals(null) && !textField_4.equals(null) && !textField_5.equals(null))
						{
						String query = "call deletestudent('"+textField_3.getText() +"','"+textField_4.getText() +"','"+textField_5.getText()+"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Studentul s-a sters cu succes!");
			   
			          
				}}
					else {
						JOptionPane.showMessageDialog(new JButton("OK!"), "Studentul nu poate fi sters!");
					}
					textField_3.setText("");
					textField_5.setText("");
					textField_4.setText("");
						
					}
				catch (SQLException sqlException)
				{
			        sqlException.printStackTrace();
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(110, 178, 177, 33);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Delete Profesor", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("     Nume profesor:");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(24, 28, 154, 24);
		panel_1.add(lblNewLabel_12);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_6.setBounds(192, 28, 159, 24);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(192, 72, 159, 24);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(192, 118, 159, 24);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_13 = new JLabel("Prenume profesor:");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(24, 72, 154, 24);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("                    CNP:");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(24, 118, 154, 24);
		panel_1.add(lblNewLabel_14);
		
		JButton btnNewButton_3 = new JButton("Stergere profesor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!textField_6.getText().equals("") && !textField_7.getText().equals("") && !textField_8.getText().equals("")))
						{
						if(!textField_6.equals(null) && !textField_7.equals(null) && !textField_8.equals(null))
							{
						String query = "call deleteprofesor('"+textField_6.getText() +"','"+textField_7.getText() +"','"+textField_8.getText()+"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Profesorul s-a sters cu succes!");
							}
						}
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Profesorul nu poate fi sters!");
					}
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
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
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setBounds(182, 153, 181, 30);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Update profesor", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		JLabel lblNewLabel_27 = new JLabel("Introduceti datele profesorului:");
		lblNewLabel_27.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_27.setBounds(10, 11, 263, 26);
		panel_4.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Numele:");
		lblNewLabel_28.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28.setBounds(10, 47, 100, 22);
		panel_4.add(lblNewLabel_28);
		
		prenumep = new JTextField();
		prenumep.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prenumep.setColumns(10);
		prenumep.setBounds(156, 84, 144, 22);
		panel_4.add(prenumep);
		
		numep = new JTextField();
		numep.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		numep.setColumns(10);
		numep.setBounds(156, 46, 144, 26);
		panel_4.add(numep);
		
		cnpp = new JTextField();
		cnpp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cnpp.setColumns(10);
		cnpp.setBounds(156, 114, 144, 26);
		panel_4.add(cnpp);
		
		adresap = new JTextField();
		adresap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		adresap.setColumns(10);
		adresap.setBounds(156, 148, 144, 26);
		panel_4.add(adresap);
		
		telp = new JTextField();
		telp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		telp.setColumns(10);
		telp.setBounds(156, 185, 144, 26);
		panel_4.add(telp);
		
		JLabel lblNewLabel_29 = new JLabel("Prenume:");
		lblNewLabel_29.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_29.setBounds(10, 79, 100, 26);
		panel_4.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("CNP:");
		lblNewLabel_30.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_30.setBounds(10, 115, 84, 24);
		panel_4.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Adresa noua:");
		lblNewLabel_31.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_31.setBounds(10, 150, 136, 22);
		panel_4.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("Nr Tel nou:");
		lblNewLabel_32.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_32.setBounds(10, 186, 111, 24);
		panel_4.add(lblNewLabel_32);
		
		emailp = new JTextField();
		emailp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		emailp.setColumns(10);
		emailp.setBounds(156, 220, 144, 26);
		panel_4.add(emailp);
		
		ibanp = new JTextField();
		ibanp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ibanp.setColumns(10);
		ibanp.setBounds(156, 255, 144, 26);
		panel_4.add(ibanp);
		
		contractp = new JTextField();
		contractp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contractp.setColumns(10);
		contractp.setBounds(156, 292, 144, 21);
		panel_4.add(contractp);
		
		JLabel lblNewLabel_33 = new JLabel("Email nou:");
		lblNewLabel_33.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_33.setBounds(10, 231, 100, 13);
		panel_4.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("IBAN nou:");
		lblNewLabel_34.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_34.setBounds(10, 265, 100, 13);
		panel_4.add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("Nr Contract nou:");
		lblNewLabel_35.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_35.setBounds(10, 299, 111, 13);
		panel_4.add(lblNewLabel_35);
		
		JButton btnNewButton_5 = new JButton("Modificare date");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!passp.getText().equals("") && !cnpp.getText().equals("") && !numep.getText().equals("") && !prenumep.getText().equals("") && !adresap.getText().equals("") && !telp.getText().equals("") && !emailp.getText().equals("") && !contractp.getText().equals("")))
					{
						
						if(!passp.equals(null) && !cnpp.equals(null) && !numep.equals(null) && !prenumep.equals(null) && !adresap.equals(null) && !telp.equals(null) && !emailp.equals(null) && !contractp.equals(null))
	
						{String query = "call updateprofesor('"+passp.getText() +"','"
								+cnpp.getText() +"','"
										+numep.getText()+"','"
								+prenumep.getText()+"','"
										+  adresap.getText()+"','"
								+telp.getText()+"','"
										+emailp.getText()+"','"
								+ibanp.getText() +"','"
										+contractp.getText()+"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Profesorul s-a updatat cu succes!");
			        
						}
					}
					else
					{
						 JOptionPane.showMessageDialog(new JButton("OK!"), "Profesorul nu s-a putut updata!");
					}
					passp.setText("");
					cnpp.setText("");
					numep.setText("");
					prenumep.setText("");
					adresap.setText("");
					telp.setText("");
					emailp.setText("");
					ibanp.setText("");
					contractp.setText("");
					
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
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5.setBounds(141, 357, 178, 38);
		panel_4.add(btnNewButton_5);
		
		passp = new JTextField();
		passp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passp.setColumns(10);
		passp.setBounds(156, 324, 144, 22);
		panel_4.add(passp);
		
		JLabel lblNewLabel_36 = new JLabel("Parola noua:");
		lblNewLabel_36.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_36.setBounds(10, 322, 100, 24);
		panel_4.add(lblNewLabel_36);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Update Grup", null, panel_6, null);
		panel_6.setLayout(null);
		
		
		JLabel lblNewLabel_37 = new JLabel("Introduceti datele:");
		lblNewLabel_37.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_37.setBounds(31, 33, 165, 25);
		panel_6.add(lblNewLabel_37);
		
		JLabel lblNewLabel_28_1_8 = new JLabel("Numele grupului actual:");
		lblNewLabel_28_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_8.setBounds(31, 69, 212, 25);
		panel_6.add(lblNewLabel_28_1_8);
		
		JLabel lblNewLabel_28_1_9 = new JLabel("Numele nou :");
		lblNewLabel_28_1_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_9.setBounds(31, 89, 185, 52);
		panel_6.add(lblNewLabel_28_1_9);
		
		JLabel lblNewLabel_28_1_10 = new JLabel("Nr max studenti:");
		lblNewLabel_28_1_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_10.setBounds(31, 128, 144, 45);
		panel_6.add(lblNewLabel_28_1_10);
		
		grupa = new JTextField();
		grupa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		grupa.setColumns(10);
		grupa.setBounds(253, 72, 115, 24);
		panel_6.add(grupa);
		
		grupn = new JTextField();
		grupn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		grupn.setColumns(10);
		grupn.setBounds(253, 105, 115, 24);
		panel_6.add(grupn);
		
		maxg = new JTextField();
		maxg.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		maxg.setColumns(10);
		maxg.setBounds(253, 139, 115, 24);
		panel_6.add(maxg);
		
		JButton btnNewButton_5_1_1 = new JButton("Modificare date");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!grupa.getText().equals("")  && !grupa.equals(null))){
						String query = "call updategrup_studiu('"+grupa.getText() +"','"
						+grupn.getText() +"','"
						+maxg.getText()+"')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Grupul s-a updatat cu succes!");
					}
					else
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Grupul nu se poate updata!");
					}
					grupa.setText("");
					grupn.setText("");
					maxg.setText("");
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
		btnNewButton_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5_1_1.setBounds(220, 179, 165, 29);
		panel_6.add(btnNewButton_5_1_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Update Procente", null, panel_7, null);
		panel_7.setLayout(null);
		
		
		JLabel lblNewLabel_28_1_8_1 = new JLabel("Introduceti datele:");
		lblNewLabel_28_1_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_28_1_8_1.setBounds(24, 34, 188, 22);
		panel_7.add(lblNewLabel_28_1_8_1);
		
		JLabel lblNewLabel_28_1_8_2 = new JLabel("Numele cursului:");
		lblNewLabel_28_1_8_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_8_2.setBounds(24, 66, 151, 22);
		panel_7.add(lblNewLabel_28_1_8_2);
		
		JLabel lblNewLabel_28_1_8_4 = new JLabel("Noul procent curs:");
		lblNewLabel_28_1_8_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_8_4.setBounds(24, 100, 151, 22);
		panel_7.add(lblNewLabel_28_1_8_4);
		
		JLabel lblNewLabel_28_1_8_5 = new JLabel("Noul procent seminar:");
		lblNewLabel_28_1_8_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_8_5.setBounds(24, 133, 188, 22);
		panel_7.add(lblNewLabel_28_1_8_5);
		
		JLabel lblNewLabel_28_1_8_6 = new JLabel("Noul procent lab:");
		lblNewLabel_28_1_8_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_28_1_8_6.setBounds(24, 166, 151, 22);
		panel_7.add(lblNewLabel_28_1_8_6);
		
		act = new JTextField();
		act.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		act.setColumns(10);
		act.setBounds(222, 66, 145, 24);
		panel_7.add(act);
		
		prc = new JTextField();
		prc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prc.setColumns(10);
		prc.setBounds(222, 100, 145, 24);
		panel_7.add(prc);
		
		prs = new JTextField();
		prs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prs.setColumns(10);
		prs.setBounds(222, 133, 145, 24);
		panel_7.add(prs);
		
		prl = new JTextField();
		prl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		prl.setColumns(10);
		prl.setBounds(222, 166, 145, 24);
		panel_7.add(prl);
		
		JButton btnNewButton_5_1_1_1 = new JButton("Modificare date");
		btnNewButton_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
					
					if((!act.getText().equals("") && !prc.getText().equals("") && !prs.getText().equals("") && prl.getText().equals("")) )
					{
						if(!act.equals(null))
					
					{
						
					String query = "call updateactivitati('"+act.getText() +"','"+prc.getText() +"','"+prs.getText()+ "','"+prl.getText()+ "')";
			        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			        sta.executeQuery(query);
			        JOptionPane.showMessageDialog(new JButton("OK!"), "Activitatea s-a updatat cu succes!");
	
					}
					}
					else
						
					{
						JOptionPane.showMessageDialog(new JButton("OK!"), "Activitatea nu se poate updata!");
					}
					act.setText("");
					prc.setText("");
					prs.setText("");
					prl.setText("");
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
		btnNewButton_5_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5_1_1_1.setBounds(209, 201, 174, 38);
		panel_7.add(btnNewButton_5_1_1_1);
		
		
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
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Detalii superadmin", null, panel_8, null);
		
		
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		panel_8.setBorder(new EmptyBorder(35, 65, 0, 0));
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
	    
        
        String query = "call showInfoSuperAdmin('"+ nume + "')";
		Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rez = sta.executeQuery(query);
        //rez.last();
        //rez.getRow();
        //rez.beforeFirst();

        while (rez.next()) {
        	panel_8.add(new JLabel("CNP: " + rez.getString("CNP")));
        	panel_8.add(new JLabel("Nume: " + rez.getString("nume")));
        	panel_8.add(new JLabel("Prenume: " + rez.getString("prenume")));
        	panel_8.add(new JLabel("Adresa: " + rez.getString("adresa")));
        	panel_8.add(new JLabel("Telefon: " +rez.getString("telefon")));
        	panel_8.add(new JLabel("Email: " + rez.getString("email")));
        	panel_8.add(new JLabel("IBAN: " + rez.getString("IBAN")));
			
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
	panel_8.add(new JLabel());
	panel_8.add(btnNewButton_);
	
	JPanel panel_9 = new JPanel();
	panel_9.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Lista studenti", null, panel_9, null);
	
	
	String[][] ret9=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from student";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez9 = stt.executeQuery(query);
    rez9.last();
    int size9 = rez9.getRow();
    rez9.beforeFirst();
    
    ret9 = new String[size9][15];
    int i = 0;
    while (rez9.next()) {
    	
    	ret9[i][0] = rez9.getString("idstudent");
     	ret9[i][1] = rez9.getString("parola");
    	ret9[i][2] = rez9.getString("cnp");
    	ret9[i][3] = rez9.getString("nume");
    	ret9[i][4] = rez9.getString("prenume");
    	ret9[i][5] = rez9.getString("adresa");
    	ret9[i][6] = rez9.getString("telefon");
    	ret9[i][7] = rez9.getString("email");
    	ret9[i][8] = rez9.getString("anstudiu");
    	ret9[i][9] = rez9.getString("nr_ore");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead9 = {"idstudent", "parola", "cnp","nume","prenume","adresa","telefon","email","an_studiu","nr_ore"};
	
	JTable table9 = new JTable(ret9, tableHead9);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPannn9 = new JScrollPane(table9);
	
	panel_9.setLayout(new BorderLayout());
	panel_9.add(scrollPannn9);
	

	
	JPanel panel_10 = new JPanel();
	panel_10.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Lista profesori", null, panel_10, null);
	
	String[][] ret10=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from profesor";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez10 = stt.executeQuery(query);
    rez10.last();
    int size10 = rez10.getRow();
    rez10.beforeFirst();
    
    ret10 = new String[size10][15];
    int i = 0;
    while (rez10.next()) {
    	
    	ret10[i][0] = rez10.getString("idprofesor");
     	ret10[i][1] = rez10.getString("parola");
    	ret10[i][2] = rez10.getString("cnp");
    	ret10[i][3] = rez10.getString("nume");
    	ret10[i][4] = rez10.getString("prenume");
    	ret10[i][5] = rez10.getString("adresa");
    	ret10[i][6] = rez10.getString("telefon");
    	ret10[i][7] = rez10.getString("email");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead10 = {"idstudent", "parola", "cnp","nume","prenume","adresa","telefon","email"};
	
	JTable table10 = new JTable(ret10, tableHead10);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPannn10 = new JScrollPane(table10);
	
	panel_10.setLayout(new BorderLayout());
	panel_10.add(scrollPannn10);
	
	JPanel panel_11 = new JPanel();
	panel_11.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Delete curs", null, panel_11, null);
	panel_11.setLayout(null);
	
	JLabel lblNewLabel_38 = new JLabel("Nume curs:");
	lblNewLabel_38.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_38.setBounds(41, 49, 98, 24);
	panel_11.add(lblNewLabel_38);
	
	JLabel lblNewLabel_39 = new JLabel("Nume profesor:");
	lblNewLabel_39.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_39.setBounds(41, 99, 128, 24);
	panel_11.add(lblNewLabel_39);
	
	JLabel lblNewLabel_40 = new JLabel("Prenume profesor:");
	lblNewLabel_40.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_40.setBounds(41, 147, 152, 24);
	panel_11.add(lblNewLabel_40);
	
	textField_9 = new JTextField();
	textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_9.setBounds(209, 147, 152, 24);
	panel_11.add(textField_9);
	textField_9.setColumns(10);
	
	textField_10 = new JTextField();
	textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_10.setColumns(10);
	textField_10.setBounds(209, 99, 152, 24);
	panel_11.add(textField_10);
	
	textField_11 = new JTextField();
	textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_11.setColumns(10);
	textField_11.setBounds(209, 49, 152, 24);
	panel_11.add(textField_11);
	
	JButton btnNewButton = new JButton("Stergere curs");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
				
				if((!textField_9.getText().equals("") && !textField_10.getText().equals("") && !textField_11.getText().equals("")))
					{
					if(!textField_9.equals(null) && !textField_10.equals(null) && !textField_11.equals(null))
						{
					String query = "call deletecurs('"+textField_11.getText() +"','"+textField_10.getText() +"','"+textField_9.getText()+"')";
		        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        sta.executeQuery(query);
		        JOptionPane.showMessageDialog(new JButton("OK!"), "Cursul s-a sters cu succes!");
						}
					}
				else
				{
					JOptionPane.showMessageDialog(new JButton("OK!"), "Cursul nu poate fi sters!");
				}
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
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
	btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	btnNewButton.setBounds(209, 193, 152, 33);
	panel_11.add(btnNewButton);
	
	JPanel panel_12 = new JPanel();
	panel_12.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Delete admin", null, panel_12, null);
	panel_12.setLayout(null);
	
	JLabel lblNewLabel_43 = new JLabel("Nume administrator:");
	lblNewLabel_43.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_43.setBounds(50, 64, 173, 24);
	panel_12.add(lblNewLabel_43);
	
	JLabel lblNewLabel_42 = new JLabel("Prenume administrator:");
	lblNewLabel_42.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_42.setBounds(32, 114, 191, 24);
	panel_12.add(lblNewLabel_42);
	
	JLabel lblNewLabel_41 = new JLabel("CNP:");
	lblNewLabel_41.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblNewLabel_41.setBounds(167, 169, 46, 14);
	panel_12.add(lblNewLabel_41);
	
	textField_12 = new JTextField();
	textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_12.setColumns(10);
	textField_12.setBounds(241, 64, 159, 24);
	panel_12.add(textField_12);
	
	textField_13 = new JTextField();
	textField_13.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_13.setColumns(10);
	textField_13.setBounds(241, 115, 159, 24);
	panel_12.add(textField_13);
	
	textField_14 = new JTextField();
	textField_14.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	textField_14.setColumns(10);
	textField_14.setBounds(241, 165, 159, 24);
	panel_12.add(textField_14);
	
	JButton btnNewButton_3_1 = new JButton("Stergere administrator");
	btnNewButton_3_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/proiect", "root", "0741033605sebiK!");
				
				if((!textField_12.getText().equals("") && !textField_13.getText().equals("") && !textField_14.getText().equals("")))
				{
					if(!textField_12.equals(null) && !textField_13.equals(null) && !textField_14.equals(null))
					{
					String query = "call deleteadmin('"+textField_12.getText() +"','"+textField_13.getText() +"','"+textField_14.getText()+"')";
		        Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        sta.executeQuery(query);
		        JOptionPane.showMessageDialog(new JButton("OK!"), "Admin-ul s-a sters cu succes!");
		   
		          
			}}
				else {
					JOptionPane.showMessageDialog(new JButton("OK!"), "Admin-ul nu poate fi sters!");
				}
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
					
				}
			catch (SQLException sqlException)
			{
		        sqlException.printStackTrace();
		    }
		}
	});
	btnNewButton_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	btnNewButton_3_1.setBounds(215, 210, 216, 33);
	panel_12.add(btnNewButton_3_1);
	
	
	JPanel panel_13 = new JPanel();
	panel_13.setBackground(new Color(173, 216, 230));
	tabbedPane.addTab("Lista admini", null, panel_13, null);
	
	String[][] ret11=null;
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "0741033605sebiK!");
    
    
    String query = "select * from administrator";
	Statement stt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez10 = stt.executeQuery(query);
    rez10.last();
    int size10 = rez10.getRow();
    rez10.beforeFirst();
    
    ret11 = new String[size10][15];
    int i = 0;
    while (rez10.next()) {
    	
    	ret11[i][0] = rez10.getString("idadmin");
     	ret11[i][1] = rez10.getString("parola");
    	ret11[i][2] = rez10.getString("cnp");
    	ret11[i][3] = rez10.getString("nume");
    	ret11[i][4] = rez10.getString("prenume");
    	ret11[i][5] = rez10.getString("adresa");
    	ret11[i][6] = rez10.getString("telefon");
    	ret11[i][7] = rez10.getString("email");
    	i++;
    }
} catch (SQLException sqlException) {
    sqlException.printStackTrace();
}
	
	String[] tableHead11 = {"idadmin", "parola", "cnp","nume","prenume","adresa","telefon","email"};
	
	JTable table11 = new JTable(ret11, tableHead11);
	 //table3.getColumnModel().getColumn(3).setPreferredWidth(100);
	JScrollPane scrollPannn11 = new JScrollPane(table11);
	
	panel_13.setLayout(new BorderLayout());
	panel_13.add(scrollPannn11);
		
	}
}
