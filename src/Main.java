import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import org.jdesktop.swingx.JXDatePicker;


public class Main extends JPanel {
	//take input about activities and food consumption - logging function
	//all rating based per week, monthly rating is avg of 4 weeks
	//calculate health rating of the specified period - rating function
	private static Date dateSelected;
	private static int[] activities;
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Health Manager");
	        JPanel panel = new JPanel();
	        JFrame logscreen = new JFrame("Activity tracker");
	        JPanel logP = new JPanel();
	        LoggingFunction logfunction = new LoggingFunction();

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(500, 300, 300, 150);
	        logscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        logscreen.setBounds(500, 300, 600, 400);

	        JXDatePicker picker = new JXDatePicker();
	        picker.setDate(Calendar.getInstance().getTime());
	        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	        
	        JButton dateSelect = new JButton("Select");
	        JButton saveLog = new JButton("Submit");
	        
	        panel.add(picker);
	        panel.add(dateSelect);
	        frame.getContentPane().add(panel);
	        logP.add(saveLog);
	        dateSelect.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	              //System.out.println(picker.getDate());
	            	
	            	logscreen.setVisible(true);
	            	activities = new int[28];
	            	dateSelected = picker.getDate();
	            }
	          });
	        saveLog.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		activities = savedActivity; //make for loop to fill in intensity of activities into this int array
	        		logscreen.setVisible(false);
	        	}
	        	
	        });
	        frame.setVisible(true);
	    }

}
