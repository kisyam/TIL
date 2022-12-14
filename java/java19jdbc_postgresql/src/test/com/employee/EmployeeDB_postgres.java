package test.com.employee;

public interface EmployeeDB_postgres {

	String DRIVER_NAME = "org.postgresql.Driver";
	String URL = "jdbc:postgresql://localhost:5432/golfzon";
	String USER = "kosta";;
	String PASSWORD = "hi123456";

	String SQL_SELECT_ALL = "select * from employee order by num desc";

	String SQL_INSERT = "INSERT INTO public.employee(num, first_name, last_name, email,salary,hire_date) VALUES (nextval('seq_employee'),?,?,?,?,?)";
	String SQL_UPDATE = "update employee set first_name=?,last_name=?,email=?,salary=?,hire_date=? where num=?";
	String SQL_DELETE = "delete from employee where num=?";
	String SQL_SELECT_ONE = "select * from employee where num=?";
	String SQL_SEARCH_LIST_FIRST_NAME = "select * from employee where first_name like ? order by num desc";
	String SQL_SEARCH_LIST_LAST_NAME = "select * from employee where last_name like ? order by num desc";
	String SQL_SEARCH_LIST_EMAIL = "select * from employee where email like ? order by num desc";
	String SQL_SEARCH_LIST_SALARY = "select * from employee where title >= ? order by num desc";
	String SQL_SEARCH_LIST_HIRE_DATE = "select * from employee where title >= ? order by num desc";

}
