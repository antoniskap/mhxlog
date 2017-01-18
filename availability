package softeng;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Availability extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Connection conn = null;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Availability frame = new Availability();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Availability() {
		setTitle("Check Availability");
		
		try
		{
		// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e3) {
			e3.printStackTrace();
		}
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/tickets";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
			connectionPassword);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JButton setbtn = new JButton("Set");
		
		JLabel lblAddDestination = new JLabel("Destination");
		lblAddDestination.setBounds(10, 21, 89, 14);
		contentPane.add(lblAddDestination);
		
		JComboBox combotime = new JComboBox();
		combotime.setBounds(258, 143, 98, 20);
		contentPane.add(combotime);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(154, 187, 74, 14);
		contentPane.add(lblCapacity);
		
		JLabel caplabel = new JLabel("");
		caplabel.setBounds(260, 187, 96, 14);
		contentPane.add(caplabel);
		
		JLabel lblCapacityLeft = new JLabel("Capacity left");
		lblCapacityLeft.setBounds(154, 216, 74, 14);
		contentPane.add(lblCapacityLeft);
		
		JLabel capleftlabel = new JLabel("");
		capleftlabel.setBounds(258, 212, 98, 14);
		contentPane.add(capleftlabel);
		
		JLabel lblNewLabel = new JLabel("Destination");
		lblNewLabel.setBounds(182, 85, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel destinationLabel = new JLabel("");
		destinationLabel.setBounds(258, 85, 98, 14);
		contentPane.add(destinationLabel);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(182, 110, 46, 17);
		contentPane.add(lblDay);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(182, 149, 46, 14);
		contentPane.add(lblTime);
		
		JComboBox comboday = new JComboBox();
		comboday.setBounds(258, 108, 98, 20);
		contentPane.add(comboday);
		
		JLabel lblDeparture = new JLabel("Departure ");
		lblDeparture.setBounds(182, 60, 63, 14);
		contentPane.add(lblDeparture);
		
		
		JLabel label = new JLabel("");
		label.setBounds(258, 60, 96, 14);
		contentPane.add(label);
		
		lblDeparture.setVisible(false);
		lblNewLabel.setVisible(false);
		lblTime.setVisible(false);
		lblDay.setVisible(false);
		combotime.setVisible(false);
		comboday.setVisible(false);
		setbtn.setVisible(false);
		lblCapacity.setVisible(false);
		lblCapacityLeft.setVisible(false);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(335, 17, 89, 23);
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					lblNewLabel.setVisible(false);				
					lblTime.setVisible(false);
					lblDay.setVisible(false);					
					destinationLabel.setVisible(false);
					combotime.setVisible(false);
					comboday.setVisible(false);
					setbtn.setVisible(false);
					
					Statement stmt = null;
					ResultSet rs = null;
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Destination_Table");
					String txt = textField.getText();
					String txt2 = textField_1.getText();
					
					boolean sth = false, sth2 = false;
					String str = "", str2 = "";
					
					comboday.addItem("Choose");
					combotime.addItem("Choose");
					
					while (rs.next())
					{
						String dest = rs.getString("Destination");
						String depa = rs.getString("Departure");
						if (txt.equals(dest) && txt2.equals(depa))
						{
							int cap = Integer.parseInt(rs.getString("Capacity"));
							int rem = Integer.parseInt(rs.getString("Remaining"));
							String day = rs.getString("Day");
							String time = rs.getString("Time");
							
							label.setText(depa);
							destinationLabel.setText(dest);
							combotime.setVisible(true);
							comboday.setVisible(true);
							destinationLabel.setVisible(true);
							lblDeparture.setVisible(true);
							lblNewLabel.setVisible(true);
							lblDay.setVisible(true);
							lblTime.setVisible(true);
							setbtn.setVisible(true);
							
							if (!(str.equals(rs.getString("Day"))))
							{
								comboday.addItem(rs.getString("Day"));
							}
							str = rs.getString("Day");
							
							if (!(str2.equals(rs.getString("Time"))))
							{
								combotime.addItem(rs.getString("Time"));
							}
							str2 = rs.getString("Time");
							
							
							sth = true;
							sth2 = true;
						}
						else
						{
							sth = true;
						}
					}
					if(sth != sth2)
					{
						JOptionPane.showMessageDialog(null, "Wrong destination or departure. Choose again!", "Full",  JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}				
			}

		});
		contentPane.add(btnCheck);
		
		textField = new JTextField();
		textField.setBounds(81, 18, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnMainapp = new JButton("Back");
		btnMainapp.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				MainApp main = new MainApp();
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnMainapp.setBounds(10, 227, 89, 23);
		contentPane.add(btnMainapp);
		
		setbtn.setBounds(367, 142, 57, 23);
		contentPane.add(setbtn);
		
		
		JLabel lblFrom = new JLabel("from");
		lblFrom.setBounds(182, 21, 46, 14);
		contentPane.add(lblFrom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 18, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		setbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{				
				String day = (String) comboday.getSelectedItem();
				String time = (String) combotime.getSelectedItem();
				
				if(day.equals("Choose") || time.equals("Choose"))
				{
					JOptionPane.showMessageDialog(null, "Choose day and time!", "Warning",  JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					lblCapacity.setVisible(true);
					lblCapacityLeft.setVisible(true);
					String txt = textField.getText();
					Statement stmt = null;
					ResultSet rs = null;
					try
					{
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM Destination_Table WHERE Destination = '" + txt + "' AND Day = '" + day + "' AND Time = '" + time + "'");
						while (rs.next())
						{
							caplabel.setText(rs.getString("Capacity"));
							capleftlabel.setText(rs.getString("Remaining"));
						}
						setbtn.setEnabled(false);
						btnCheck.setEnabled(false);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					
				}
				
			}
		});

	}
}
