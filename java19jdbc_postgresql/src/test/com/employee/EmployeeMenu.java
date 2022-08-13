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
			System.out.println("1.�Է� 2.���� 3.���� 4.��ȣ�˻� 5.��ΰ˻� 6.Ű����˻�");
			System.out.println("����� x�Է�[����Ϸ��� �ƹ�Ű]:");
			System.out.println("===========================");
			System.out.println("�޴��� �����ϼ���:");
			menu = br.readLine();

			if (menu.equals("1")) {
				System.out.println("======================");
				System.out.println("1.�Է� ������");
				System.out.println("======================");
				System.out.println("�̸��Է�");
				String first_name = br.readLine();
				System.out.println("���Է�");
				String last_name = br.readLine();
				System.out.println("�̸����Է�");
				String email = br.readLine();
				System.out.println("�����Է�");
				String salary = br.readLine();
				EmployeeVO vo = new EmployeeVO();
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setEmail(email);
				vo.setSalary(Integer.parseInt(salary));
				int result = dao.insert(vo);
				if (result == 1)
					System.out.println("�Է¼���");
				else
					System.out.println("�Է½���");

			} else if (menu.equals("2")) {
				System.out.println("======================");
				System.out.println("2.���� ������");
				System.out.println("======================");
				System.out.println("��ȣ:");
				String num = br.readLine();
				System.out.println("�̸�:");
				String first_name = br.readLine();
				System.out.println("��:");
				String last_name = br.readLine();
				System.out.println("�̸���:");
				String email = br.readLine();
				System.out.println("����:");
				String salary = br.readLine();
				EmployeeVO vo = new EmployeeVO();
				vo.setNum(Integer.parseInt(num));
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setEmail(email);
				vo.setSalary(Integer.parseInt(salary));

				int result = dao.update(vo);
				if (result == 1)
					System.out.println("��������");
				else
					System.out.println("��������");

			} else if (menu.equals("3")) {
				System.out.println("======================");
				System.out.println("3.�ۻ��� ������");
				System.out.println("======================");
				System.out.println("�۹�ȣ:");
				String num = br.readLine();

				EmployeeVO vo = new EmployeeVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				if (result == 1)
					System.out.println("��������");
				else
					System.out.println("��������");

			} else if (menu.equals("4")) {
				System.out.println("======================");
				System.out.println("4.��ȣ�˻� ������");
				System.out.println("======================");
				System.out.println("�۹�ȣ:");
				String num = br.readLine();

				EmployeeVO vo = new EmployeeVO();
				vo.setNum(Integer.parseInt(num));
				EmployeeVO vo2 = dao.selectOne(vo);
				if (vo2.getNum() == 0) {
					System.out.println("�ش��ȣ�� ����.");
				} else {
					System.out.print(vo.getNum() + " | ");
					System.out.print(vo2.getFirst_name() + " | ");
					System.out.print(vo2.getLast_name() + " | ");
					System.out.print(vo2.getEmail() + " | ");
					System.out.println(vo2.getSalary());
				}

			} else if (menu.equals("5")) {
				System.out.println("======================");
				System.out.println("5.��ΰ˻� ������");
				System.out.println("======================");
				System.out.println("�۹�ȣ | �̸� | �� | �̸��� | ���� | �ٹ�����");
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
				System.out.println("6.�˻���˻� ������");
				System.out.println("======================");
				System.out.println("�˻�Ű�� �Է��ϼ���:[first_name or last_name or email or salary or hire_date]");
				String searchKey = br.readLine();
				System.out.println("�˻�� �Է��ϼ���:");
				String searchWord = br.readLine();
				System.out.println("-----------------------------------");
				System.out.println("�۹�ȣ | �̸� | �� | �̸��� | ���� | �ٹ�����");
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
