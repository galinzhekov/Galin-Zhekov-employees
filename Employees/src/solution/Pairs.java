package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pairs {
	private List<Employee> employees;

	public Pairs(List<Employee> employees) {
		super();
		this.employees = employees;
	}
	
	public List<Pair> getAllPairs() {
		AtomicBoolean newPair = new AtomicBoolean(true);
		List<Pair> pairs = new ArrayList<>();
		for (Employee first : this.employees) {
			for (Employee second : this.employees) {
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
}
