package solution;

import java.util.Date;

public class Employee {
	private int EmpID;
	private int ProjectID;
	private Date DateFrom;
	private Date DateTo;

	public Employee() {
		super();
	}

	public Employee(int empID, int projectID, Date dateFrom, Date dateTo) {
		super();
		EmpID = empID;
		ProjectID = projectID;
		DateFrom = dateFrom;
		DateTo = dateTo;
	}

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}

	public Date getDateFrom() {
		return DateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		DateFrom = dateFrom;
	}

	public Date getDateTo() {
		return DateTo;
	}

	public void setDateTo(Date dateTo) {
		DateTo = dateTo;
	}

	public int compareTo(Object r) {
		return this.getDateFrom().compareTo(((Employee) r).getDateTo());
	}

	public long dateDiff(Object r) {
		long dateDifference = 0;
		if (this.getDateFrom().compareTo(((Employee) r).getDateFrom()) > 0) {
			if (this.getDateTo().compareTo(((Employee) r).getDateTo()) < 0) {
				dateDifference = this.getDateTo().getTime() - this.getDateFrom().getTime();
			} else {
				dateDifference = ((Employee) r).getDateTo().getTime() - this.getDateFrom().getTime();
			}
		} else {
			if (this.getDateTo().compareTo(((Employee) r).getDateTo()) < 0) {
				dateDifference = this.getDateTo().getTime() - ((Employee) r).getDateFrom().getTime();
			} else {
				dateDifference = ((Employee) r).getDateTo().getTime() - ((Employee) r).getDateFrom().getTime();
			}
		}

		return dateDifference;
	}
}
