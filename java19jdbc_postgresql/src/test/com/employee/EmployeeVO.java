package test.com.employee;

import java.sql.Date;
import java.util.Objects;

public class EmployeeVO {

	private int num;
	private String first_name;
	private String last_name;
	private String email;
	private int salary;
	private Date hire_date;

	public EmployeeVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeVO [num=" + num + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", salary=" + salary + ", hire_date=" + hire_date + "]";
	}

	public EmployeeVO(int num, String first_name, String last_name, String email, int salary, Date hire_date) {
		super();
		this.num = num;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.salary = salary;
		this.hire_date = hire_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, first_name, hire_date, last_name, num, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name)
				&& Objects.equals(hire_date, other.hire_date) && Objects.equals(last_name, other.last_name)
				&& num == other.num && salary == other.salary;
	}

}
