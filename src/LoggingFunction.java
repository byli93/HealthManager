import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LoggingFunction {
	//needs calendar
	// get day for input
	// get activity and food
	// save to date
	//stay in same screen after submit log, add button
	public void log(Date date , int[] activities){ // activities is an array containing intensity, each activity is in order to its order number
		//store the info under the specified date
		Path file = Paths.get("./"+ date.toString().substring(0, 10));
		List<String> content = Arrays.asList(Arrays.toString(activities)); 
		try {
			Files.createFile(file);
		} catch (FileAlreadyExistsException x) {
			try {
				Files.write(file, content, Charset.forName("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
