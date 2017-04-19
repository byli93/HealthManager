import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class RatingFunction {
	//identify week of evaluation
	// get info from log
	// get rating from list
	// do general calculation for rating
	// if consume cheat meals more than once this week -18 points
	// if went to gym at least 4 times +10, +2 extra ,each time after 4
	public void rating(String[] dates){
		List<Activity> actList = new ArrayList<Activity>(EnumSet.allOf(Activity.class));
		String line;
		double[] dailyscores = new double[dates.length];
		for(int i=0;i<dates.length;i++){
			String path = "./" + dates[i]; 
			Path file = Paths.get(path);
			double[] scores = new double[28];
			double dayscore = 0;
			try {
				List<String> lines = Files.readAllLines(file);
				line = lines.toString();
				line = line.substring(0, line.length() -1);
				String[] intense = line.split(",");
				for(int j=0;j<line.length();j++){
					scores[j] = Integer.parseUnsignedInt(intense[j]) * actList.get(j).rating();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int k =0;k<scores.length;k++){
				dayscore += scores[k];
			}
			dailyscores[i] = dayscore;
			dayscore = 0;
		}
		
	}

	
}

