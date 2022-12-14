package test.com.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class EmployeeMenu {

	public static void main(String[] args) throws IOException {

		System.out.println("Hello Employee");
		EmployeeDAO dao = new EmployeeDAOimpl();
		Reader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);

		boolean bool = true;
		String menu = "y";
		do {
			System.out.println("===========================");
			System.out.println("1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색");
			System.out.println("종료시 x입력[계속하려면 아무키]:");
			System.out.println("===========================");
			System.out.println("메뉴를 선택하세요:");
			menu = br.readLine();

			if (menu.equals("1")) {
				System.out.println("======================");
				System.out.println("1.입력 페이지");
				System.out.println("======================");
				System.out.println("이름입력");
				String first_name = br.readLine();
				System.out.println("성입력");
				String last_name = br.readLine();
				System.out.println("이메일입력");
				String email = br.readLine();
				System.out.println("연봉입력");
				String salary = br.readLine();
				EmployeeVO vo = new EmployeeVO();
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setEmail(email);
				vo.setSalary(Integer.parseInt(salary));
				int result = dao.insert(vo);
				if (result == 1)
					System.out.println("입력성공");
				else
					System.out.println("입력실패");

			} else if (menu.equals("2")) {
				System.out.println("======================");
				System.out.println("2.수정 페이지");
				System.out.println("======================");
				System.out.println("번호:");
				String num = br.readLine();
				System.out.println("이름:");
				String first_name = br.readLine();
				System.out.println("성:");
				String last_name = br.readLine();
				System.out.println("이메일:");
				String email = br.readLine();
				System.out.println("연봉:");
				String salary = br.readLine();
				EmployeeVO vo = new EmployeeVO();
				vo.setNum(Integer.parseInt(num));
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setEmail(email);
				vo.setSalary(Integer.parseInt(salary));

				int result = dao.update(vo);
				if (result == 1)
					System.out.println("수정성공");
				else
					System.out.println("수정실패");

			} else if (menu.equals("3")) {
				System.out.println("======================");
				System.out.println("3.글삭제 페이지");
				System.out.println("======================");
				System.out.println("글번호:");
				String num = br.readLine();

				EmployeeVO vo = new EmployeeVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				if (result == 1)
					System.out.println("삭제성공");
				else
					System.out.println("삭제실패");

			} else if (menu.equals("4")) {
				System.out.println("======================");
				System.out.println("4.번호검색 페이지");
				System.out.println("======================");
				System.out.println("글번호:");
				String num = br.readLine();

				EmployeeVO vo = new EmployeeVO();
				vo.setNum(Integer.parseInt(num));
				EmployeeVO vo2 = dao.selectOne(vo);
				if (vo2.getNum() == 0) {
					System.out.println("해당번호글 없음.");
				} else {
					System.out.print(vo.getNum() + " | ");
					System.out.print(vo2.getFirst_name() + " | ");
					System.out.print(vo2.getLast_name() + " | ");
					System.out.print(vo2.getEmail() + " | ");
					System.out.println(vo2.getSalary());
				}

			} else if (menu.equals("5")) {
				System.out.println("======================");
				System.out.println("5.모두검색 페이지");
				System.out.println("======================");
				System.out.println("글번호 | 이름 | 성 | 이메일 | 연봉 | 근무일자");
				System.out.println("-----------------------------------");
				List<EmployeeVO> vos = dao.selectAll();
				for (EmployeeVO x : vos) {
					System.out.print(x.getNum() + " | ");
					System.out.print(x.getFirst_name() + " | ");
					System.out.print(x.getLast_name() + " | ");
					System.out.print(x.getEmail() + " | ");
					System.out.println(x.getSalary());
				}
			} else if (menu.equals("6")) {
				System.out.println("======================");
				System.out.println("6.검색어검색 페이지");
				System.out.println("======================");
				System.out.println("검색키를 입력하세요:[first_name or last_name or email or salary or hire_date]");
				String searchKey = br.readLine();
				System.out.println("검색어를 입력하세요:");
				String searchWord = br.readLine();
				System.out.println("-----------------------------------");
				System.out.println("글번호 | 이름 | 성 | 이메일 | 연봉 | 근무일자");
				System.out.println("-----------------------------------");
				List<EmployeeVO> vos = dao.searchList(searchKey, searchWord);
				for (EmployeeVO x : vos) {
					System.out.print(x.getNum() + " | ");
					System.out.print(x.getFirst_name() + " | ");
					System.out.print(x.getLast_name() + " | ");
					System.out.print(x.getEmail() + " | ");
					System.out.println(x.getSalary());
				}
			}

			if (menu.equals("x"))
				break;
		} while (bool);

		System.out.println("end main....");

	}// end main

}// end class
