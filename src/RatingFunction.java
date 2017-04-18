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
		int[] intensity = new int[28];
		for(int i=0;i<dates.length;i++){
			String path = "./" + dates[i]; 
			Path file = Paths.get(path);
			try {
				List<String> lines = Files.readAllLines(file);
				line = lines.toString();
				line = line.substring(0, line.length() -1);
				String[] intense = line.split(",");
				for(int j=0;j<line.length();j++){
					intensity[j] = Integer.parseUnsignedInt(intense[j]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}

