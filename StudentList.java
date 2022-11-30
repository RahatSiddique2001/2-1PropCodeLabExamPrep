import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] argument) {
//		Check arguments

		if(argument[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String students[] = line.split(", ");
				for(String j : students) {
					System.out.println(j);
				}
			}
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
		else if(argument[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String students[] = line.split(", ");
				Random random = new Random();
				int variable = random.nextInt(students.length);
				System.out.println(students[variable]);
			}
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");			
		}
		else if(argument[0].contains("+")) {
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
				String newStudent = argument[0].substring(1);
				Date date = new Date();
				String dateFormatPattern = "yyyy/mm/dd hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
				String formatDate= dateFormat.format(date);
				bufferedWriter.write(", "+newStudent+"\nList last updated on "+formatDate);
				bufferedWriter.close();
			}
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");	
		}
		else if(argument[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String students[] = line.split(",");
				boolean done = false;
				String newStudent = argument[0].substring(1);
				for(int index = 0; index<students.length && !done; index++) {
					if(students[index].equals(newStudent)) {
						System.out.println("We found it!");
						done=true;
					}
				}
			}
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");				
		}
		else if(argument[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				char array[] = line.toCharArray();
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
				System.out.println(count +" word(s) found ");
			}
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");				
		}
		else {
			System.err.println("Wrong argument");
			System.err.println("Exiting program");
			System.exit(1);
		}
	}
}