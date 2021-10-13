package solution;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		Reader reader = new Reader();
		List<Employee> employees = new ArrayList<>(reader.readFile("employees"));
		Pairs pairs = new Pairs(employees);
		List<Pair> listPairs = new ArrayList<>(pairs.getPairsWithMostDays());

		if (listPairs.size() > 0) {
			System.out.println(listPairs);
		} else {
			System.out.println("There are no pairs");
		}

	}

}
