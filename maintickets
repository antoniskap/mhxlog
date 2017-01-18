package softeng;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MainTickets extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	private JPasswordField PasswordText;
	public static String usr = null;
	public String psw;
	private String sql;
	private char [] pass;
	private JLabel Label;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private Connection conn = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTickets frame = new MainTickets();
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
	public MainTickets() {
		setTitle("Login Form");
	
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
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setBounds(140, 48, 109, 23);
		contentPane.add(rdbtnAdmin);
		rdbtnAdmin.setSelected(true);
		
		JRadioButton rdbtnCashier = new JRadioButton("Cashier");
		buttonGroup.add(rdbtnCashier);
		rdbtnCashier.setBounds(140, 83, 109, 23);
		contentPane.add(rdbtnCashier);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{				
				if (rdbtnAdmin.isSelected())
				{
					usr = rdbtnAdmin.getText(); //retrieve username given
				}
				else if (rdbtnCashier.isSelected())
				{
					usr = rdbtnCashier.getText(); //retrieve username given
				}
				
				
				pass = PasswordText.getPassword(); //retrieve password given
				psw = java.lang.String.valueOf(pass); //convert char to string
				boolean auth = false; //authentication boolean
				
				Statement stmt = null;
				ResultSet rs = null;
				try
				{
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Login_Table");
					
					while (rs.next())
					{
						String username = rs.getString("Username");
						String password = rs.getString("Password");

						//clear last login
						stmt = conn.createStatement();
						sql = "UPDATE Login_Table SET ID=0 WHERE Username = '" + username + "'";
						stmt.executeUpdate(sql);
					
											
						if (username.equals(usr) && password.equals(psw))
						{
							auth = true;
							sql = "UPDATE Login_Table SET ID=1 WHERE Username = '" + usr + "'";
							stmt.executeUpdate(sql);
							stmt.close();
						}
						else
						{
							Label.setText("Authentication Failed! Try again!");
						}
						
					}
				
				
					if (auth)
					{
						MainApp main = new MainApp();
						main.setVisible(true);
						setVisible(false);
					}
				}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
		
		});
		btnLogin.setBounds(139, 177, 89, 23);
		contentPane.add(btnLogin);
		
		PasswordText = new JPasswordField();
		PasswordText.setBounds(142, 133, 86, 23);
		contentPane.add(PasswordText);		
		
		Label = new JLabel("");
		Label.setBounds(129, 197, 225, 29);
		contentPane.add(Label);
		
		lblUsername = new JLabel("Choose Username");
		lblUsername.setBounds(141, 27, 108, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(54, 137, 67, 14);
		contentPane.add(lblPassword);		
	}
}
