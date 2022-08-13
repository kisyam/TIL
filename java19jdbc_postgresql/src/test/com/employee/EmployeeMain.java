package test.com.employee;

import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) {
		System.out.println("Hello Employee");

		// EmployeeVO,EmployeeDAO,EmployeeDAOimpl
		// EmployeeMain, EmployeeMenu
		// num,first_name,last_name,email,int(salary),date(hire_date)
		// golfzon/kosta/hi123456, table : employee

		EmployeeDAO dao = new EmployeeDAOimpl();

		EmployeeVO vo = new EmployeeVO();
		vo.setFirst_name("yeonsu");
		vo.setLast_name("kim");
		vo.setEmail("naver");
		vo.setSalary(10000000);
		
		int result = dao.insert(vo);
		System.out.println(result);

		// 2.update
		vo = new EmployeeVO();
		vo.setNum(1);
		vo.setFirst_name("yeonsu");
		vo.setLast_name("kim");
		vo.setEmail("naver");
		vo.setSalary(100000000);
		result = dao.insert(vo);
		System.out.println(result);

		// 3.delete
		vo = new EmployeeVO();
		vo.setNum(28);
		result = dao.delete(vo);
		System.out.println("result:" + result);

		// 4.selectOne
		vo = new EmployeeVO();
		vo.setNum(10);
		EmployeeVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);

		// 5.selectAll
		List<EmployeeVO> vos = dao.selectAll();
		for (EmployeeVO x : vos) {
			System.out.println(x);
		}

		// 6.searchList
//		List<EmployeeVO> vos2 = dao.searchList("email", "11");
//		List<EmployeeVO> vos2 = dao.searchList("last_name", "lee");
		List<EmployeeVO> vos2 = dao.searchList("first_name", "kim");
		for (EmployeeVO x : vos2) {
			System.out.println(x);
		}

	}// end main

}// end class
