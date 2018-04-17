import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File {
	
	//rewrites files with same name
	//CHANGE: check if file already exists, make sure user wants to overwrite it
	//saves array into file
	public static void save(String saveName, String[] data) throws IOException{
		// have uhh file name to save to in
		String fileName = ("C:\\Simulator\\" + saveName + ".txt");
		// Create a BufferedWriter around a FileWriter.
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        // Write these lines to the file.
        // ... We call newLine to insert a newline character.

        for(int i=0; i<data.length; i++){
        	writer.write(data[i]);
        	if(i != data.length - 1){
        		writer.newLine();
        	}
        }
        writer.close();
	}

	//load contents of file into array
	public static String[] load(String loadName) throws IOException{
		String fileName = ("C:\\Simulator\\" + loadName + ".txt");

		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str=null;
		ArrayList<String> lines = new ArrayList<String>();
		while((str = in.readLine()) != null){
		    lines.add(str);
		}

		return lines.toArray(new String[lines.size()]);
	}

	//creates folder to store save files in C drive,,, maybe change location later but this should be fine
	//does not overwrite folder if it already exists
	public static void createDir() throws IOException {
		Files.createDirectories(Paths.get("C:\\Simulator"));
	}

	//checks if game should be "corrupt"
	public static boolean checkCorrupt() {
		if(Files.exists(Paths.get("C:\\Simulator\\corrupt.txt"))) {
		    return true;
		}else {
			return false;
		}
	}

	//adds corrupts file to directory when gone through bad ending
	@SuppressWarnings("resource")
	public static void makeCorrupt() throws IOException {
		String fileName = ("C:\\Simulator\\corrupt.txt");
		new FileWriter(fileName);
	}

	public static void main(String[] args) throws IOException{
		//method for tests, delete later
	}
}
