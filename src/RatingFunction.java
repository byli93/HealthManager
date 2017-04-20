import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
	public String rating(String[] dates){
		List<Activity> actList = new ArrayList<Activity>(EnumSet.allOf(Activity.class));
		String line;
		double[] dailyscores = new double[dates.length];
		double total = 0;
		double finalscore = 50;
		int cheatmeals = 0;
		int gym = 0;
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
					if(j == 21 && Integer.parseUnsignedInt(intense[j])<0){
						cheatmeals += 1;
					}
				}
			} catch(NoSuchFileException e){
				return "Log for" + dates[i] + "not found";
			}catch (IOException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int k =0;k<scores.length;k++){
				dayscore += scores[k];
			}
			dailyscores[i] = dayscore;
			dayscore = 0;
		}
		for(int l =0;l<dailyscores.length;l++){
			total += dailyscores[l];
		}
		finalscore = total/dailyscores.length;
		if(cheatmeals < 1){
			finalscore -= 18;
		}
		if(gym < 3){
			finalscore += 10;
			if(gym <4){
				finalscore += (gym-4)*2;
			}
		}
		return "Your score is" + Double.toString(finalscore);
	}

	
}

