package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pair implements Comparable<Object> {
	private int firstEmployee;
	private int secondEmployee;
	private long timeTogether;
	
	
	
	public Pair() {
		super();
	}
	public Pair(int firstEmployee, int secondEmployee, long timeTogether) {
		super();
		this.firstEmployee = firstEmployee;
		this.secondEmployee = secondEmployee;
		this.timeTogether = timeTogether;
	}
	public int getFirstEmployee() {
		return firstEmployee;
	}
	public void setFirstEmployee(int firstEmployee) {
		this.firstEmployee = firstEmployee;
	}
	public int getSecondEmployee() {
		return secondEmployee;
	}
	public void setSecondEmployee(int secondEmployee) {
		this.secondEmployee = secondEmployee;
	}
	public long getTimeTogether() {
		return timeTogether;
	}
	public void setTimeTogether(long timeTogether) {
		this.timeTogether = timeTogether;
	}
	
	@Override
	public String toString() {
		return "Pair [firstEmployee=" + firstEmployee + ", secondEmployee=" + secondEmployee + ", timeTogether="
				+ timeTogether + "]";
	}
	
	public List<Pair> coupleEmployees(List<Employee> allEmployees) {
		AtomicBoolean newPair = new AtomicBoolean(true);
		List<Pair> pairs = new ArrayList<>();
		for (Employee first : allEmployees) {
			for (Employee second : allEmployees) {
				if (first.getEmpID() == second.getEmpID()) {
					continue;
				}
				if (first.getProjectID() != second.getProjectID()) {
					continue;
				}
				if (first.compareTo(second) > 0 || second.compareTo(first) > 0) {
					continue;
				}
				pairs.forEach(pair -> {
					if ((pair.getFirstEmployee() == first.getEmpID() && pair.getSecondEmployee() == second.getEmpID()) ||
							(pair.getFirstEmployee() == second.getEmpID() && pair.getSecondEmployee() == first.getEmpID())) {
						pair.setTimeTogether(pair.getTimeTogether() + first.dateDiff(second));
						newPair.set(false);
					}
				});
				
				if (newPair.get()) {
					Pair pair = new Pair(first.getEmpID(), second.getEmpID(), first.dateDiff(second));
					pairs.add(pair);
				}
			}
			
		}
		
		Collections.sort(pairs);
		
		return pairs;
	}
	
	@Override
	public int compareTo(Object o) {
		if (this.timeTogether == ((Pair)o).getTimeTogether()) {
			return 0;
		} else if(this.timeTogether > ((Pair)o).getTimeTogether()) {
			return 1; 
		} else {
			return -1;
		}
	}
}
