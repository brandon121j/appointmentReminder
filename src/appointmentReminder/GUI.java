package appointmentReminder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Therapist Name");
		label.setBounds(10, 20, 100, 25);
		panel.add(label);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		frame.setVisible(true);
	}

}
