package appointmentReminder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;


public class GUI implements ActionListener{
	
	private static JLabel therapistLabel;
	private static JTextField therapistText;
	private static JLabel patientLabel;
	private static JTextField patientText;
	private static JDateChooser dateChooser;
	private static JLabel appointmentDate;
	private static JLabel appointmentTime;
	private static JComboBox<String> timeSelector;
	private static JButton button;
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel createdBy;
	private static JTextField link;
	private static JLabel linkLabel;
	
	public static void main(String[] args) {
		panel = new JPanel();
		frame = new JFrame("Appointment Reminder");
		frame.setSize(370, 370);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);
		
		therapistLabel = new JLabel("Therapist Name");
		therapistLabel.setBounds(10, 20, 100, 25);
		panel.add(therapistLabel);
		
		therapistText = new JTextField(20);
		therapistText.setBounds(175, 20, 165, 25);
		panel.add(therapistText);
		
		patientLabel = new JLabel("Patient Name");
		patientLabel.setBounds(10, 60, 100, 25);
		panel.add(patientLabel);
		
		patientText = new JTextField(20);
		patientText.setBounds(175, 60, 165, 25);
		panel.add(patientText);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(175, 100, 165, 25);
		panel.add(dateChooser);
		
		appointmentDate = DefaultComponentFactory.getInstance().createLabel("Appointment Date");
		appointmentDate.setBounds(10, 100, 125, 25);
		panel.add(appointmentDate);
		
		appointmentTime = new JLabel("Appointment Time");
		appointmentTime.setBounds(10, 140, 125, 25);
		panel.add(appointmentTime);
		
		String[] times = {
				"12:00 am", "1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", 
				"2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm", "11:00 pm"
				};
		timeSelector = new JComboBox<>(times);
		timeSelector.setBounds(175, 140, 165, 25);
		panel.add(timeSelector);
		
		link = new JTextField(20);
		link.setBounds(10, 180, 331, 25);
		panel.add(link);
		
		linkLabel = new JLabel("Session Link");
		linkLabel.setBounds(140, 210, 240, 25);
		panel.add(linkLabel);
		
		button = new JButton("Generate Reminder");
		button.setBounds(105, 250, 150, 50);
		button.addActionListener(new GUI());
		panel.add(button);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		createdBy = new JLabel("Created by: Brandon Johnson");
		createdBy.setBounds(95, 310, 195, 25);
		panel.add(createdBy);
		
		String[] info = DataReader.dataFetcher(); 
		if (info.length != 0) {
			System.out.println("1: " + info[0] + " 2: " + info[1]);
			therapistText.setText(info[0]);
			link.setText(info[1]);
		}
		
		frame.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String therapist = therapistText.getText();
		String patient = patientText.getText();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = dateChooser.getDate();
		String time = timeSelector.getSelectedItem().toString();
		String hyperlink = link.getText();
		
		if (patient.length() != 0) {
			String message1 = (
				"Good morning, " + patient + " this is " + therapist + " from Second Chance Behavioral Health. This is a reminder for our appointment scheduled for " + 
				dateFormat.format(date) + " at " + time + ". To join the session, click the link below. " + "\r\n" + hyperlink + "\r\n" + "\r\n" + 
				"Please reply yes to this message to confirm the appointment or no to reschedule."
			);
			Writer.dataSaver(therapist, hyperlink);
			StringSelection stringSelection = new StringSelection(message1);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			JOptionPane.showMessageDialog(frame, "Reminder Copied!");
		} else {
			String message2 = (
				"Good morning, this is " + therapist + " from Second Chance Behavioral Health. This is a reminder for our appointment scheduled for " + 
				dateFormat.format(date) + " at " + time + ". To join the session, click the link below. " + "\r\n" + hyperlink + "\r\n" + "\r\n" +
				"Please reply yes to this message to confirm the appointment or no to reschedule."
			);
			Writer.dataSaver(therapist, hyperlink);
			StringSelection stringSelection = new StringSelection(message2);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			JOptionPane.showMessageDialog(frame, "Reminder Copied!");
		}	
	}
}
