package softeng;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int rem;
	private String txt, txt2;
	private String [] dest = new String[10];
	private String [] depa = new String[10];
	private int i,d,z;
	private String [] time2 = new String[100];
	public static String day, time, destination, capacity_total, number_tickets, departure;
	public static Integer remaining_seats;
	private Connection conn = null;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
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
	public Book() {
		setTitle("Book a Seat ");
		
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
		
		DB_zero();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(168, 152, 84, 14);
		contentPane.add(label);
		
		JComboBox comboday = new JComboBox();
		comboday.setBounds(168, 76, 84, 20);
		contentPane.add(comboday);
		
		JComboBox combotime = new JComboBox();
		combotime.setBounds(168, 117, 84, 20);
		contentPane.add(combotime);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(110, 79, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(110, 120, 46, 14);
		contentPane.add(lblTime);
		
		JLabel lblFrom = new JLabel("from");
		lblFrom.setBounds(206, 14, 46, 14);
		contentPane.add(lblFrom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 11, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		
		JLabel lblAvailableSeats = new JLabel("Available seats");
		lblAvailableSeats.setBounds(65, 152, 93, 14);
		contentPane.add(lblAvailableSeats);
		comboday.setVisible(false);
		combotime.setVisible(false);
		lblDate.setVisible(false);
		lblTime.setVisible(false);
		lblAvailableSeats.setVisible(false);
				
		JButton bookbutton = new JButton("OK");
		
		bookbutton.setBounds(163, 194, 89, 23);
		contentPane.add(bookbutton);
		
		
		JButton btnSet = new JButton("Set");
		btnSet.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				btnSet.setEnabled(false);
				//Second Set
				
				Statement stmt = null;
				ResultSet rs = null;
				try
				{
					String day_f = (String) comboday.getSelectedItem();
					String time_f = (String) combotime.getSelectedItem();
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Destination_Table");
					String str = "";
					Integer rem2 = 0;
					lblTime.setVisible(true);
					while (rs.next())
					{
						if (rs.getString("Day").equals(day_f) && rs.getString("Time").equals(time_f))
						{
							rem2 = Integer.parseInt(rs.getString("Remaining"));
						}
					}			
					stmt = conn.createStatement();
					String sql = "UPDATE Destination_Table SET Choosen = '1' WHERE Destination = '" + dest[d] + "' AND Departure = '" + depa[d] + "' AND Day = '" + day_f + "' AND Time = '" + time_f + "'";
					stmt.executeUpdate(sql);					

					lblAvailableSeats.setVisible(true);
					if (rem2 > 1)
					{						
						label.setText(String.valueOf(rem2));
						bookbutton.setVisible(true);
					}
					else
					{
						label.setText("0");
					}
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnSet.setBounds(274, 116, 89, 23);
		contentPane.add(btnSet);
		
		btnSet.setVisible(false);
		
		JButton btnBook = new JButton("Set");
		btnBook.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				btnBook.setEnabled(false);
				combotime.setVisible(true);
				btnSet.setVisible(true);
				String q = (String) comboday.getSelectedItem();
				
				try
				{
				// Load the JDBC driver
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				}
				catch (Exception e3) {
					e3.printStackTrace();
				}
				
				Statement stmt = null;
				ResultSet rs = null;
				try
				{

					String txt2 = textField_1.getText();
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Destination_Table WHERE Destination = '" + txt + "' AND Departure = '" + txt2 + "' AND Day = '" + q + "'");
					String str = "";
					lblTime.setVisible(true);
					while (rs.next())
					{
						if (!(str.equals(rs.getString("Time"))))
						{
							combotime.addItem(rs.getString("Time"));
							str = rs.getString("Time");
						}
						capacity_total = rs.getString("Capacity");
					}	

				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}				
			}
		});
		btnBook.setBounds(274, 75, 89, 23);
		contentPane.add(btnBook);
		btnBook.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(111, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter destination");
		lblNewLabel.setBounds(10, 14, 109, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCheck = new JButton("Check");

		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				btnCheck.setEnabled(false);
				
				Statement stmt = null;
				ResultSet rs = null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://localhost:3306/tickets";
					String connectionUser = "root";
					String connectionPassword = "";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					
					txt = textField.getText();
					txt2 = textField_1.getText();
					
					boolean sth = false, sth2 = false;
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Destination_Table");
					z=0;
					i=0;
					boolean a = true;
					String str = "";
					while (rs.next())
					{
						dest[i] = rs.getString("Destination");
						depa[i] = rs.getString("Departure");
						
						if (txt.equals(dest[i]) && txt2.equals(depa[i]))
						{
							comboday.setVisible(true);
							btnBook.setVisible(true);
							lblDate.setVisible(true);
							
							rem = Integer.parseInt(rs.getString("Remaining"));	
							time2[z] = rs.getString("Time");
							
							if (!(str.equals(rs.getString("Day"))))
							{
								comboday.addItem(rs.getString("Day"));
							}
							str = rs.getString("Day");
							if (rem > 0)
							{
								if (rem < 10)
								{
									JOptionPane.showMessageDialog(null, "Limited capacity!", "Warning",  JOptionPane.WARNING_MESSAGE);
								}
								d=i;
								
							}
							else
							{
								
								if (a)
								{
									btnBook.setVisible(false);
									JOptionPane.showMessageDialog(null, "No more room! Choose another destination!", "Full",  JOptionPane.ERROR_MESSAGE);								
									a = false;
								}
							}
							sth= true;
							sth2=true;
							z++;
						}
						else
						{
							sth = true;
						}
						
						i++;
					}
					if(sth != sth2)
					{
						JOptionPane.showMessageDialog(null, "Wrong destination. Choose again!", "Full",  JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnCheck.setBounds(345, 10, 89, 23);
		contentPane.add(btnCheck);
		
		bookbutton.setVisible(false);
		bookbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				day = (String) comboday.getSelectedItem();
				time = (String) combotime.getSelectedItem();
				destination = textField.getText();
				remaining_seats = Integer.parseInt(label.getText());
				remaining_seats--;
				
				Statement stmt = null;
				ResultSet rs = null;
				try 
				{
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Destination_Table WHERE Choosen = '1'");
					while (rs.next())
					{
						capacity_total = rs.getString("Capacity");
						departure = rs.getString("Departure");
					}
				}
				catch (Exception e1)
				{
					
				}
				Seats seats = new Seats();
				seats.setVisible(true);
				setVisible(false);

			}
		});
		
		
		
		JButton btnMainapp = new JButton("Back");
		btnMainapp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp main = new MainApp();
				main.setVisible(true);
				setVisible(false);
				
			}
		});
		btnMainapp.setBounds(10, 227, 89, 23);
		contentPane.add(btnMainapp);				
		

		
	}

	private void DB_zero() {
		try
		{
			Statement stmt = null;
						
			stmt = conn.createStatement();
			String sql = "UPDATE Destination_Table SET Choosen = '0'";
			stmt.executeUpdate(sql);								
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
}
