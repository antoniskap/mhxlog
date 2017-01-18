package softeng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MainApp extends JFrame {

	private JPanel contentPane;
	private boolean auth = false;
	private Integer temp;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setTitle("Main Application");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton BookRadio = new JRadioButton("Book ticket");
		buttonGroup.add(BookRadio);
		BookRadio.setBounds(18, 40, 109, 23);
		contentPane.add(BookRadio);
		BookRadio.setSelected(true);
		
		JRadioButton AvailabilityRadio = new JRadioButton("Check availability");
		buttonGroup.add(AvailabilityRadio);
		AvailabilityRadio.setBounds(18, 79, 134, 23);
		contentPane.add(AvailabilityRadio);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(232, 83, 176, 133);
		contentPane.add(label);
		
		JRadioButton UpdateRadio = new JRadioButton("Update routes");
		buttonGroup.add(UpdateRadio);
		UpdateRadio.setBounds(18, 117, 109, 23);
		contentPane.add(UpdateRadio);
		
		JLabel lblNoNewAnnouncement_1 = new JLabel("No new announcement");
		lblNoNewAnnouncement_1.setBounds(257, 49, 151, 14);
		contentPane.add(lblNoNewAnnouncement_1);
		
		JRadioButton announceRadio = new JRadioButton("New announcement");
		buttonGroup.add(announceRadio);
		announceRadio.setBounds(18, 151, 151, 23);
		contentPane.add(announceRadio);

		new MainTickets();
		if (MainTickets.usr.equals("Cashier"))
		{
			announceRadio.setVisible(false);
			UpdateRadio.setVisible(false);
		}		
		
		Connection conn = null;
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
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Announcement_Table");
			temp = 0;
			String a = null;
			boolean auth = false;
			while (rs.next())
			{
				if (temp < Integer.parseInt(rs.getString("ID")))
				{
					temp = Integer.parseInt(rs.getString("ID"));
					a = rs.getString("Text");
					auth = true;
				}
			}
			if (auth)
			{
				lblNoNewAnnouncement_1.setVisible(false);
				label.setVisible(true);
				label.setText(a);
			}
			
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}				
		
		
		JButton btnOK = new JButton("OK");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (BookRadio.isSelected())
				{
					Book b = new Book();
					b.setVisible(true);
					setVisible(false);
				}
				else if (AvailabilityRadio.isSelected())
				{
					Availability a = new Availability();
					a.setVisible(true);
					setVisible(false);
				}
				else if (UpdateRadio.isSelected())
				{	
					Update u = new Update();
					u.setVisible(true);
					setVisible(false);	
				}
				else if (announceRadio.isSelected())
				{
					Announcement a = new Announcement();
					a.setVisible(true);
					setVisible(false);	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Choose from options!", "Warning",  JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnOK.setBounds(31, 192, 89, 23);
		contentPane.add(btnOK);
		
		JLabel lblAnnouncements = new JLabel("Announcements");
		lblAnnouncements.setBounds(274, 25, 134, 14);
		contentPane.add(lblAnnouncements);

	}	
}
