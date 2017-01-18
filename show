package softeng;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Show extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show frame = new Show();
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
	public Show() {
		setTitle("Show Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(71, 39, 72, 14);
		contentPane.add(lblDestination);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(71, 64, 46, 14);
		contentPane.add(lblDay);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(71, 89, 46, 14);
		contentPane.add(lblTime);
		
		JLabel lblSeat = new JLabel("Seat");
		lblSeat.setBounds(71, 114, 46, 14);
		contentPane.add(lblSeat);
		
		JLabel lblRemaining = new JLabel("Remaining");
		lblRemaining.setBounds(71, 169, 72, 14);
		contentPane.add(lblRemaining);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{				
				MainApp main = new MainApp();
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnOk.setBounds(335, 227, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(71, 144, 60, 14);
		contentPane.add(lblCapacity);
		
		JLabel destlbl = new JLabel("");
		destlbl.setBounds(157, 39, 82, 14);
		contentPane.add(destlbl);
		
		JLabel daylbl = new JLabel("");
		daylbl.setBounds(157, 64, 82, 14);
		contentPane.add(daylbl);
		
		JLabel timelbl = new JLabel("");
		timelbl.setBounds(157, 89, 82, 14);
		contentPane.add(timelbl);
		
		JLabel seatlbl = new JLabel("");
		seatlbl.setBounds(157, 114, 82, 14);
		contentPane.add(seatlbl);
		
		JLabel caplbl = new JLabel("");
		caplbl.setBounds(157, 144, 82, 14);
		contentPane.add(caplbl);
		
		JLabel remlbl = new JLabel("");
		remlbl.setBounds(157, 169, 72, 14);
		contentPane.add(remlbl);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(71, 11, 72, 14);
		contentPane.add(lblDeparture);
		
		JLabel label = new JLabel("");
		label.setBounds(150, 11, 79, 14);
		contentPane.add(label);
		
		destlbl.setText(Seats.destination);
		daylbl.setText(Seats.day);
		timelbl.setText(Seats.time);
		seatlbl.setText(Seats.seat);
		caplbl.setText(Seats.capacity);
		remlbl.setText(Seats.remaining + "");
		label.setText(Seats.departure);
		
		
	}

}
