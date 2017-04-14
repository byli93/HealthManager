import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
	        String[] intensityLv = {"0","1","2","3","4","5","6","7","8","9","10"};

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(500, 300, 300, 150);
	        logscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        logscreen.setBounds(500, 300, 900, 600);

	        JXDatePicker picker = new JXDatePicker();
	        picker.setDate(Calendar.getInstance().getTime());
	        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	        
	        JButton dateSelect = new JButton("Select");
	        JButton saveLog = new JButton("Submit");
	        JComboBox[] intBoxArray = new JComboBox[28];
	        for(int i =0;i<28;i++){
	        	intBoxArray[i]= new JComboBox(intensityLv);
	        	logP.add(intBoxArray[i]);
	        }
	        
	        
	        panel.add(picker);		//calender button
	        panel.add(dateSelect);	// select button
	        frame.getContentPane().add(panel);
	        logP.add(saveLog);		//submit button
	        //logP.add(intBox);
	        logscreen.getContentPane().add(logP);
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
	        		for(int i =0;i<28;i++){
	    	        	activities[i] = intBoxArray[i].getSelectedIndex();
	    	        }
	        		System.out.println(Arrays.toString(activities));
	        		//activities = savedActivity; //make for loop to fill in intensity of activities into this int array
	        		logscreen.setVisible(false);
	        	}
	        	
	        });
	        frame.setVisible(true);
	    }

}
