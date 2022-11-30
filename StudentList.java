import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String getLineFromFile() throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.textFile)));
		String line = bufferedReader.readLine();
		return line;
	}

	public static BufferedWriter getLineBufferedWriter() throws Exception {
		return new BufferedWriter(new FileWriter(Constants.textFile, false));
	}
	
	public static void main(String[] argument) {
//		Check arguments

		if(argument[0].equals(Constants.allStudents)) {
			System.out.println(Constants.loadingData);
			try {
				String students[] = getLineFromFile().split(Constants.spliting);
				for(String j : students) {
					System.out.println(j);
				}
			}
			catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);
		}
		else if(argument[0].equals(Constants.randomStudent)) {
			System.out.println(Constants.loadingData);
			try {
				String students[] = getLineFromFile().split(Constants.spliting);
				System.out.println(students[new Random().nextInt(students.length)].trim());
			}
			catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);
		}
		else if(argument[0].contains(Constants.addition)) {
			System.out.println(Constants.loadingData);
			try {
				String previousContent = getLineFromFile();
				BufferedWriter bufferedWriter = getLineBufferedWriter();
				bufferedWriter.write(previousContent);
				bufferedWriter.write(Constants.spliting + " " +argument[0].substring(1)+Constants.listLastUp+new SimpleDateFormat(Constants.datePattern).format(new Date()));
				bufferedWriter.close();
			}
			catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);
		}
		else if(argument[0].contains(Constants.search)) {
			System.out.println(Constants.loadingData);
			try {
				String students[] = getLineFromFile().split(Constants.spliting);
				boolean done = false;
				String newStudent = argument[0].substring(1);
				for(int index = 0; index<students.length && !done; index++) {
					if(students[index].trim().equals(argument[0].substring(1))) {
						System.out.println(Constants.found);
						done=true;
					}
				}
			}
			catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);
		}
		else if(argument[0].contains(Constants.words)) {
			System.out.println(Constants.loadingData);
			try {
				char array[] = getLineFromFile().toCharArray();
				boolean in_word = false;
				int count=0;
				for(char c:array) {
					if(c ==' ')
					{
						if (!in_word) {
							count++; in_word =true;
						}
						else {
							in_word=false;
						}
					}
				}
				System.out.println(count +Constants.wordsFound);
			}
			catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);
		}
		else {
			System.err.println(Constants.wrongArgument);
			System.err.println(Constants.exiting);
			System.exit(1);
		}
	}
}