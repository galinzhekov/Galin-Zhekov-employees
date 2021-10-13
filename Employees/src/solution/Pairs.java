package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pairs {
	private List<Employee> employees;
	private List<Pair> pairs;

	public Pairs(List<Employee> employees) {
		super();
		this.employees = employees;
		this.pairs = new ArrayList<>();
		getAllPairs();
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	private List<Pair> getAllPairs() {
		AtomicBoolean newPair = new AtomicBoolean(true);
		for (Employee first : employees) {
			for (Employee second : employees) {
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
					if ((pair.getFirstEmployee() == first.getEmpID()
							&& pair.getSecondEmployee() == second.getEmpID())) {
						pair.setTimeTogether(pair.getTimeTogether() + first.dateDiff(second));
						newPair.set(false);
					}
					if (pair.getFirstEmployee() == second.getEmpID() && pair.getSecondEmployee() == first.getEmpID()) {
						newPair.set(false);
					}
				});

				if (newPair.get()) {
					Pair pair = new Pair(first.getEmpID(), second.getEmpID(), first.dateDiff(second));
					pairs.add(pair);
				}

				newPair.set(true);
			}

		}

		Collections.sort(pairs);

		return pairs;
	}

	public List<Pair> getPairsWithMostDays() {
		if (pairs.size() == 0) {
			return pairs;
		}

		long timeTogether = pairs.get(0).getTimeTogether();
		List<Pair> newPairs = new ArrayList<>();

		for (Pair pair : pairs) {
			if (pair.getTimeTogether() < timeTogether) {
				break;
			}
			newPairs.add(pair);
		}

		return newPairs;
	}
}
