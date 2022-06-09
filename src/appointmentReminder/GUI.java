package appointmentReminder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Appointment Reminder");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel therapistLabel = new JLabel("Therapist Name");
		therapistLabel.setBounds(10, 20, 100, 25);
		panel.add(therapistLabel);
		
		JTextField therapistText = new JTextField(20);
		therapistText.setBounds(175, 20, 165, 25);
		panel.add(therapistText);
		
		JLabel patientLabel = new JLabel("Patient Name");
		patientLabel.setBounds(10, 60, 100, 25);
		panel.add(patientLabel);
		
		JTextField patientText = new JTextField(20);
		patientText.setBounds(175, 60, 165, 25);
		panel.add(patientText);
		
		
		frame.setVisible(true);
	}

}
