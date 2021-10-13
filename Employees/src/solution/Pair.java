package solution;

import java.util.concurrent.TimeUnit;

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
				+ TimeUnit.MILLISECONDS.toDays(timeTogether) + " days]\n";
	}

	@Override
	public int compareTo(Object o) {
		if (this.timeTogether == ((Pair) o).getTimeTogether()) {
			return 0;
		} else if (this.timeTogether < ((Pair) o).getTimeTogether()) {
			return 1;
		} else {
			return -1;
		}
	}
}
