package softeng;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Seats extends JFrame {

	private JPanel contentPane;
	private Connection conn = null;
	public static String destination;
	public static String capacity;
	public static Integer remaining;
	public static String seat;
	public static String day;
	public static String time;
	public static String departure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seats frame = new Seats();
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
	public Seats() {
		setTitle("Choose Specific Seat");
		
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

		String[] str = { "Window", "Gallery", "Rest"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(10, 11, 46, 14);
		contentPane.add(lblDay);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(10, 36, 46, 14);
		contentPane.add(lblTime);
		
		JLabel daylbl = new JLabel("");
		daylbl.setBounds(86, 11, 77, 14);
		contentPane.add(daylbl);
		
		JLabel timelbl = new JLabel("");
		timelbl.setBounds(86, 36, 46, 14);
		contentPane.add(timelbl);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 61, 66, 14);
		contentPane.add(lblDestination);
		
		JLabel destlbl = new JLabel("");
		destlbl.setBounds(86, 61, 77, 14);
		contentPane.add(destlbl);

		daylbl.setText(Book.day);
		timelbl.setText(Book.time);
		destlbl.setText(Book.destination);

		day = Book.day;
		time = Book.time;
		destination = Book.destination;
		departure = Book.departure;
		
		JLabel lblPickASeat = new JLabel("Pick a seat");
		lblPickASeat.setBounds(10, 86, 97, 14);
		contentPane.add(lblPickASeat);
		
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(86, 83, 89, 20);
		contentPane.add(comboBox);
		
		JLabel lblChooseSeat = new JLabel("Choose seat");
		lblChooseSeat.setBounds(236, 11, 83, 14);
		contentPane.add(lblChooseSeat);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(329, 8, 77, 20);
		contentPane.add(comboBox_1);
		
		JButton btnBook = new JButton("Book");
		
		JButton btnSet = new JButton("Set");
		
		comboBox_1.setVisible(false);
		btnBook.setVisible(false);
		lblChooseSeat.setVisible(false);
		Integer rem = Book.remaining_seats; //remaining seats from Book

		Integer cap = Integer.parseInt(Book.capacity_total);
		
		remaining =  Book.remaining_seats;
		capacity = Book.capacity_total;
		
		btnBook.setBounds(329, 57, 89, 23);
		contentPane.add(btnBook);
		
		
		btnSet.addMouseListener(new MouseAdapter() {
			//Set button
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				comboBox_1.setVisible(true);
				lblChooseSeat.setVisible(true);
				btnBook.setVisible(true);
				
				Statement stmt = null;
				ResultSet rs = null;
				try
				{
					String id = "";
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM destination_Table WHERE Choosen = '1'" );
					while (rs.next())
					{
						id = rs.getString("ID");
					}
					
					
					String combo = (String) comboBox.getSelectedItem();
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Routes WHERE ID_dest = '" + id + "'");
					while (rs.next())
					{
						if (rs.getString("taken").equals("0"))
						{
							if (combo.equals("Window"))	
							{
								if (rs.getString("X").equals("1"))
								{
									if (!(rs.getString("Y").equals("Q") || rs.getString("Y").equals("L")))
									{
										comboBox_1.addItem(rs.getString("Y") + rs.getString("X"));	
									}
								}
								if (rs.getString("X").equals("4"))
								{
									if (!(rs.getString("Y").equals("Q") || rs.getString("Y").equals("L")))
									{
										comboBox_1.addItem(rs.getString("Y") + rs.getString("X"));	
									}
								}
							}
							else if (combo.equals("Gallery"))
							{
								if (cap.equals(45))
								{	
									if (rs.getString("Y").equals("L"))
									{
										comboBox_1.addItem(rs.getString("Y") + rs.getString("X"));
									}

								}
								else 
								{
									if (rs.getString("Y").equals("Q"))
									{
										comboBox_1.addItem(rs.getString("Y") + rs.getString("X"));		
									}
								}
							}
							else //the choice is rest (not window)
							{
								if (rs.getString("X").equals("2"))
								{
									if (!(rs.getString("Y").equals("Q") || rs.getString("Y").equals("L")))
									{
										comboBox_1.addItem(rs.getString("Y") + rs.getString("X"));
									}
								}
								if (rs.getString("X").equals("3"))
								{
									if (!(rs.getString("Y").equals("Q") || rs.getString("Y").equals("L")))
									{
										comboBox_1.addItem(rs.getString("Y") + rs.getString("X"));	
									}
								}
							}							
						}		
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		btnSet.setBounds(97, 117, 56, 23);
		contentPane.add(btnSet);
		
		
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String combo = (String) comboBox_1.getSelectedItem();
				
				Statement stmt = null;
				ResultSet rs = null;
				try
				{						
					Integer rem2 = 0;
					int remaining;
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Destination_Table");
				
					while (rs.next())
					{
						if (rs.getString("Choosen").equals("1"))
						{
							rem2 = Integer.parseInt(rs.getString("Remaining"));
						}
					}
					remaining = rem2 - 1;
					
					stmt = conn.createStatement();
					String sql = "UPDATE Destination_Table SET Remaining = '" + remaining + "' WHERE Choosen = 1 ";
					stmt.executeUpdate(sql);
					
					String y = combo.substring(0,1);//from combo 'A'
					Integer x = Integer.parseInt(combo.substring(1)); //from combo '1'
					seat = (String) comboBox_1.getSelectedItem();
					
					stmt = conn.createStatement();
					sql = "UPDATE Routes SET taken = '1' WHERE X = '" + x + "' AND Y = '" + y + "' ";
					stmt.executeUpdate(sql);
										
					JOptionPane.showMessageDialog(null, "Reservation Done!");
					
					Show s = new Show();
					s.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
	
	}
}
