package solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		List<Employee> employees = new ArrayList<Employee>();
		Scanner s = new Scanner(new File("employees"));


		while (s.hasNext()) {
			String[] fields = s.nextLine().split(", ");
			
			int empID = Integer.parseInt(fields[0]);
			int projectID = Integer.parseInt(fields[1]);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateFrom = formatter.parse(fields[2]);
			Date dateTo = new Date();
			if (fields[3].equals("NULL")) {
				long millis=System.currentTimeMillis();  
				dateTo.setTime(millis);
			} else {
				dateTo = formatter.parse(fields[3]);
			}
			Employee employee = new Employee(empID, projectID, dateFrom, dateTo);
			employees.add(employee);
		}
		
		Pair a = new Pair();
		System.out.println(a.coupleEmployees(employees));
	}

}
