import java.util.ArrayList;
import java.util.Scanner;

public class LabEleven {
	private static Scanner scnr;
	private static ArrayList<Movie> movieNames = new ArrayList<>();
	
	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		boolean keepGoing;
		String userCategory;
		fillMovieInfo();
		System.out.println("Welcome to the Movie List Application!");
		do {
			System.out.println("What category are you interested in?");
			userCategory = scnr.nextLine();
			getMovies(userCategory);
			keepGoing = getYesOrNo(scnr, "Continue (y/n)?");
		}while(keepGoing);
		System.out.println("Goodbye!");
		scnr.close();
	}
	
	//fill array with movie and info
	public static void fillMovieInfo() {
		for (int i = 1; i <= 100; i++) {
			movieNames.add(MovieIO.getMovie(i));
		}
	}
	
	//prints movies that match the users chosen category
	public static void getMovies(String userCategory) {
		for (Movie movie : movieNames) {
			if(movie.getCategory().contentEquals(userCategory)) {
				System.out.println(movie.getTitle());
			}
		}	
	}
	
	public static boolean getYesOrNo(Scanner scnr, String prompt) { //getYesOrNo from day 6 validation examples
		System.out.print(prompt);
		String input = scnr.nextLine().toLowerCase().trim(); //added a trim in case the user accidentally puts a space before their answer
		boolean isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		while (!isValid) { // keep looping as long as they enter something invalid
			System.out.println();
			System.out.println("Oops. Please enter yes or no.");
			System.out.println();
			System.out.print(prompt);
			input = scnr.nextLine().toLowerCase();
			isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		}
		return input.startsWith("y");
	}
}
