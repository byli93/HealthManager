import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	        JFrame ratescreen = new JFrame("Your rating");
	        JPanel rateP = new JPanel();
	        LoggingFunction logfunction = new LoggingFunction();
	        RatingFunction ratefunction = new RatingFunction();
	        String[] intensityLv = {"0","1","2","3","4","5","6","7","8","9","10"};
	        List<Activity> actList = new ArrayList<Activity>(EnumSet.allOf(Activity.class));

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(500, 300, 300, 150);
	        logscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        logscreen.setBounds(500, 300, 900, 600);
	        ratescreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        ratescreen.setBounds(500, 300, 500, 350);
	        
	        

	        JXDatePicker picker = new JXDatePicker();	//calendar
	        picker.setDate(Calendar.getInstance().getTime());
	        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	        
	        JButton dateSelect = new JButton("Select");
	        JButton rate = new JButton("Rate");
	        JButton saveLog = new JButton("Submit");
	        JTextArea[] actTxtArray = new JTextArea[28];
	        JComboBox[] intBoxArray = new JComboBox[28];
	        for(int j = 0; j<actTxtArray.length;j++){
	        	actTxtArray[j] = new JTextArea(actList.get(j).toString(),2,10);
	        	actTxtArray[j].setEditable(false);
	        	actTxtArray[j].setBackground(null);
	        	//actTxtArray[j].setAlignmentX(LEFT_ALIGNMENT);
	        	logP.add(actTxtArray[j]);
	        	intBoxArray[j]= new JComboBox(intensityLv);
	        	//intBoxArray[j].setAlignmentX(RIGHT_ALIGNMENT);
	        	logP.add(intBoxArray[j]);
	        }
	        JTextArea rating = new JTextArea("");
//	        for(int i =0;i<intBoxArray.length;i++){
//	        	
//	        }
	        
	        logP.setLayout(new GridLayout(10,3,3,3));
	        panel.add(picker);		//Calendar button
	        panel.add(dateSelect);	// select button
	        panel.add(rate);
	        frame.getContentPane().add(panel);
	        logP.add(saveLog);		//submit button
	        //logP.add(intBox);
	        rateP.add(rating);
	        logscreen.getContentPane().add(logP);
	        ratescreen.getContentPane().add(rateP);
	        dateSelect.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	              //System.out.println(picker.getDate().toString().substring(0, 10));
	            	
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
	        		//System.out.println(Arrays.toString(activities));
	        		//activities = savedActivity; //make for loop to fill in intensity of activities into this int array
	        		logfunction.log(dateSelected, activities);
	        		logscreen.setVisible(false);
	        		
	        	}
	        	
	        });
	        rate.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		// pick 1 day and evaluate the next 6 days together as a week
	        		dateSelected = picker.getDate();
	        		Date[] dates = new Date[7];
	        		String[] week = new String[7];
	        		dates[0] = dateSelected;
	        		Calendar c = Calendar.getInstance();
	        		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	        		for(int i =1;i<7;i++){
	        			c.setTime(dates[i-1]);
	        			c.add(Calendar.DATE, 1);
	        			dates[i] = c.getTime();
	        			
	        		}
	        		for(int j =0;j<7;j++){
	        			week[j] = dates[j].toString().substring(0, 10);
	        		}
	        		
	        		String result = ratefunction.rating(week);
	        		rating.setText(result);
	        		ratescreen.setVisible(true);
	        	}
	        	
	        });
	        
	        frame.setVisible(true);
	    }

}
