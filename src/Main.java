import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import org.jdesktop.swingx.JXDatePicker;

public class Main extends JPanel {
	//take input about activities and food consumption - logging function
	//all rating based per week, monthly rating is avg of 4 weeks
	//calculate health rating of the specified period - rating function

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Health Manager");
	        JPanel panel = new JPanel();

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(400, 400, 250, 100);

	        JXDatePicker picker = new JXDatePicker();
	        picker.setDate(Calendar.getInstance().getTime());
	        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	        
	        JButton dateSelect = new JButton("Select");
	        
	        panel.add(picker);
	        frame.getContentPane().add(panel);
	        panel.add(dateSelect);
	        dateSelect.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	              //System.out.println(picker.getDate());
	            	
	            }
	          });

	        frame.setVisible(true);
	    }
	
}
