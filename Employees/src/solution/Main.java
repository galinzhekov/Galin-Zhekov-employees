package solution;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		Reader reader = new Reader();
		List<Employee> employees = new ArrayList<Employee>(reader.readFile("employees"));
		Pairs pairs = new Pairs(employees);
		if (pairs.getAllPairs().size() > 0) {
			System.out.println(pairs.getAllPairs().get(0));
		} else {
			System.out.println("There are no pairs");
		}
		
	}

}
