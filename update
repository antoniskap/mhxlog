package softeng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField destinationText;
	private JTextField remainingText;
	private JTextField deldestText;
	private Connection conn = null;
	private Integer id = 1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Update() {
		setTitle("Insert New Route Or Delete");

		String[] day = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		String[] time = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
		String[] available_cap = {"45", "65"};
		
		
		//action performed to combo box
		//JComboBox cb = (JComboBox)e.getSource();
		//String petName = (String)cb.getSelectedItem();
		
		try
		{
		// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e1) {
			e1.printStackTrace();
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
		
		destinationText = new JTextField();
		destinationText.setBounds(128, 36, 86, 20);
		contentPane.add(destinationText);
		destinationText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Destination");
		lblNewLabel.setBounds(25, 39, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Capacity");
		lblNewLabel_1.setBounds(25, 97, 69, 14);
		contentPane.add(lblNewLabel_1);		
		
		textField = new JTextField();
		textField.setBounds(128, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboday = new JComboBox(day);
		comboday.setBounds(128, 149, 86, 20);
		contentPane.add(comboday);
		
		JComboBox combotime = new JComboBox(time);
		combotime.setBounds(128, 180, 86, 20);
		contentPane.add(combotime);
		
		JComboBox comboBox = new JComboBox(available_cap);
		comboBox.setBounds(128, 96, 86, 17);
		contentPane.add(comboBox);
		
		JButton update = new JButton("Update");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{				

				Statement stmt = null;
				ResultSet rs = null;
				
				String dest = destinationText.getText();
				String depa = textField.getText();
				String cap = (String) comboBox.getSelectedItem();
				String rem = remainingText.getText();
				boolean auth = false, auth2 = false;
				try 
				{
				     Integer.parseInt(cap);
						if (rem.isEmpty())
						{
							rem = cap;
						}
						else
						{
							Integer.parseInt(rem);
						}
						auth = true;
						if (Integer.parseInt(cap) < Integer.parseInt(rem))
						{
							JOptionPane.showMessageDialog(null, "Remaining seats cannot be more than capacity!", "Warning",  JOptionPane.WARNING_MESSAGE);
							auth2 = false;
						}
						else
							auth2 = true;
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wrong input!", "Warning",  JOptionPane.WARNING_MESSAGE);
				}
		
				
				if (auth && auth2)
				{
					try
					{
						if (!dest.isEmpty() && !cap.isEmpty() && !depa.isEmpty())
						{	
							try
							{
								stmt = conn.createStatement();
								rs = stmt.executeQuery("SELECT * FROM Destination_Table");
								while (rs.next())
								{
									id = Integer.parseInt(rs.getString("ID"));
								}

							}
							catch (Exception e1)
							{
								e1.printStackTrace();
							}
							id++;
							String day = (String) comboday.getSelectedItem();
							String time = (String) combotime.getSelectedItem();
							
							stmt = conn.createStatement();
							String sql = "INSERT INTO Destination_Table (Destination, Departure, Capacity, Remaining, Day, Time, Choosen, ID) VALUES ('" + dest + "', '" + depa + "', '" + cap + "', '" + rem + "', '" + day + "', '" + time + "', '0', '" + id + "' )";
							stmt.executeUpdate(sql);
		
							JOptionPane.showMessageDialog(null, "Destination added!");
							routes_table();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Add all the information!", "Warning",  JOptionPane.WARNING_MESSAGE);
						}
					}
					catch (Exception e11)
					{
						e11.printStackTrace();
					}
				}
				else if (auth2)
				{
					
				}
			}

			private void routes_table() 
			{
				Statement stmt = null;
				ResultSet rs = null;
				try 
				{
					Integer id_r = 1;
					try
					{
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM Routes");
						while (rs.next())
						{
							id_r = Integer.parseInt(rs.getString("ID"));
						}

					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
					if (id_r.equals(null))
					{
						id_r = 1;
					}
					Integer capacity = Integer.parseInt((String) comboBox.getSelectedItem());
					int a = 0;

					if (capacity.equals(45))
					{
						String[] temp = {"A", "B", "C", "D", "E", "F", "H", "I", "J", "K"};

						for (int i=1;i<=10;i++)
						{
							for (int j=1;j<=4;j++)
							{
								stmt = conn.createStatement();
								String sql = "INSERT INTO Routes (ID, X, Y, ID_dest, taken) VALUES ('" + id_r + "', '" + j + "', '" + temp[a] + "', '" + id + "', '0' )";
								stmt.executeUpdate(sql);
							}
							a++;
						}
						
						for (int i=1;i<=5;i++)
						{
							stmt = conn.createStatement();
							String sql = "INSERT INTO Routes (ID, X, Y, ID_dest, taken) VALUES ('" + id_r + "', '" + i + "', 'L', '" + id + "', '0' )";
							stmt.executeUpdate(sql);
						}
						
					}
					else 
					{
						String[] temp = {"A", "B", "C", "D", "E", "F", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
						for (int i=1;i<=15;i++)
						{
							for (int j=1;j<=4;j++)
							{
								stmt = conn.createStatement();
								String sql = "INSERT INTO Routes (ID, X, Y, ID_dest, taken) VALUES ('" + id_r + "', '" + j + "', '" + temp[a] + "', '" + id + "', '0' )";
								stmt.executeUpdate(sql);
							}
							a++;
						}
						for (int i=1;i<=5;i++)
						{
							stmt = conn.createStatement();
							String sql = "INSERT INTO Routes (ID, X, Y, ID_dest, taken) VALUES ('" + id_r + "', '" + i + "', 'Q', '" + id + "', '0' )";
							stmt.executeUpdate(sql);
						}
					}
					
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}

			
		});
		update.setBounds(128, 227, 89, 23);
		contentPane.add(update);
		
		JLabel lblAddSpecifics = new JLabel("Add specifics");
		lblAddSpecifics.setBounds(132, 11, 82, 14);
		contentPane.add(lblAddSpecifics);
		
		JLabel lblRemainingSeats = new JLabel("Remaining seats");
		lblRemainingSeats.setBounds(25, 124, 126, 14);
		contentPane.add(lblRemainingSeats);
		
		remainingText = new JTextField();
		remainingText.setBounds(128, 118, 86, 20);
		contentPane.add(remainingText);
		remainingText.setColumns(10);
		
		JLabel lblRemoveDestination = new JLabel("Remove destination");
		lblRemoveDestination.setBounds(282, 11, 142, 14);
		contentPane.add(lblRemoveDestination);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Statement stmt = null;
				ResultSet rs = null;
				
				String dest = deldestText.getText();

				try
				{
					boolean b = false;
					
										
					if (!dest.isEmpty())
					{
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM Destination_Table");
						boolean aa = true;
						while (rs.next())
						{
							if (aa)
							{
								if (dest.equals(rs.getString("Destination")))
								{
									aa = false;
									b = true;
									Object[] options = {"Yes", "No"};
									Integer n = JOptionPane.showOptionDialog(null, "Would you like to delete destination?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
									if (n.equals(0))
									{
										stmt = conn.createStatement();
										String sql = "DELETE FROM Destination_Table WHERE Destination = '" + dest + "'";
										stmt.executeUpdate(sql);
										
										stmt = conn.createStatement();
										String sql2 = "DELETE FROM Routes WHERE ID_dest = '" + rs.getString("ID") + "'";
										stmt.executeUpdate(sql2);
										JOptionPane.showMessageDialog(null, "Destination delete!");
									}
								}
							}
						}
						if (!b)
						{
							JOptionPane.showMessageDialog(null, "Wrong destination!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No destination given! Try again.", "Error",  JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (Exception e11)
				{
					e11.printStackTrace();
				}				
			}
		});
		btnRemove.setBounds(338, 98, 89, 23);
		contentPane.add(btnRemove);
		
		deldestText = new JTextField();
		deldestText.setBounds(338, 35, 86, 20);
		contentPane.add(deldestText);
		deldestText.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(264, 38, 76, 14);
		contentPane.add(lblDestination);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp main = new MainApp();
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(5, 238, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Day");
		lblDate.setBounds(25, 150, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(25, 183, 46, 14);
		contentPane.add(lblTime);		
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(25, 72, 69, 14);
		contentPane.add(lblDeparture);


	}
}
