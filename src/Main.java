import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class Main extends JPanel {
	//take input about activities and food consumption - logging function
	//all rating based per week, monthly rating is avg of 4 weeks
	//calculate health rating of the specified period - rating function

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("JXPicker Example");
	        JPanel panel = new JPanel();

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(400, 400, 250, 100);

	        JXDatePicker picker = new JXDatePicker();
	        picker.setDate(Calendar.getInstance().getTime());
	        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

	        panel.add(picker);
	        frame.getContentPane().add(panel);

	        frame.setVisible(true);
	    }
	
}
