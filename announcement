package softeng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Announcement extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Announcement frame = new Announcement();
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
	public Announcement() {
		setTitle("New Announcement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPost = new JButton("Post");
		btnPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				String txt = textField.getText();
				if (!txt.isEmpty())
				{
					int len = txt.length();
					if (len < 200)
					{
						try
						{
						// Load the JDBC driver
							Class.forName("com.mysql.jdbc.Driver").newInstance();
						}
						catch (Exception e1) {
							e1.printStackTrace();
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
							conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

							stmt = conn.createStatement();
							rs = stmt.executeQuery("SELECT * FROM Announcement_Table");
							int temp = 0;
							while (rs.next())
							{
								if (temp < Integer.parseInt(rs.getString("ID")))
								{
									temp = Integer.parseInt(rs.getString("ID"));
								}
							}
							
							temp++;
							stmt = conn.createStatement();
							String sql = "INSERT INTO Announcement_Table VALUES ('" + txt + "' , '" + temp + "')";
							stmt.executeUpdate(sql);
						}
						catch (Exception e11)
						{
							e11.printStackTrace();
						}						
						JOptionPane.showMessageDialog(null, "Announcement complete!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Reduce length. Under 200 characters. You have: "+ len + "!", "Warning",  JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter text!", "Warning",  JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnPost.setBounds(158, 182, 89, 23);
		contentPane.add(btnPost);
		
		textField = new JTextField();
		textField.setBounds(64, 32, 316, 108);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp main = new MainApp();
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
