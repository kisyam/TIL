package test.com.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class MemberMenu {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello Member");

		MemberDAO dao = new MemberDAOimpl();
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
				MemberVO vo = new MemberVO();
				System.out.println("======================");
				System.out.println("1.���̵� �Է��ϼ���");
				System.out.println("======================");
				String id = br.readLine();
				vo.setId(id);
				System.out.println("======================");
				System.out.println("1.��й�ȣ�� �Է��ϼ���");
				System.out.println("======================");
				String pw = br.readLine();
				vo.setPw(pw);
				System.out.println("======================");
				System.out.println("1.�̸��� �Է��ϼ���");
				System.out.println("======================");
				String name = br.readLine();
				vo.setName(name);
				System.out.println("======================");
				System.out.println("1.��ȭ��ȣ�� �Է��ϼ���");
				System.out.println("======================");
				String tel = br.readLine();
				vo.setTel(tel);
				int result = dao.insert(vo);
				if (result == 1)
					System.out.println("�Է¼���");
				else
					System.out.println("�Է½���");
			} else if (menu.equals("2")) {
				System.out.println("======================");
				System.out.println("2.ȸ������ ������");
				System.out.println("======================");
				System.out.println("ȸ����ȣ:");
				String num = br.readLine();
				System.out.println("ȸ�����̵�:");
				String id = br.readLine();
				System.out.println("ȸ����й�ȣ:");
				String pw = br.readLine();
				System.out.println("ȸ���̸�:");
				String name = br.readLine();
				System.out.println("ȸ����ȭ��ȣ:");
				String tel = br.readLine();
				MemberVO vo = new MemberVO();
				vo.setNum(Integer.parseInt(num));
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setTel(tel);

				int result = dao.update(vo);
				if (result == 1)
					System.out.println("��������");
				else
					System.out.println("��������");

			} else if (menu.equals("3")) {
				System.out.println("======================");
				System.out.println("3.ȸ������ ������");
				System.out.println("======================");
				System.out.println("ȸ����ȣ:");
				String num = br.readLine();

				MemberVO vo = new MemberVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				if (result == 1)
					System.out.println("��������");
				else
					System.out.println("��������");

			} else if (menu.equals("4")) {
				System.out.println("======================");
				System.out.println("4.ȸ����ȣ�˻� ������");
				System.out.println("======================");
				System.out.println("ȸ����ȣ:");
				String num = br.readLine();

				MemberVO vo = new MemberVO();
				vo.setNum(Integer.parseInt(num));
				MemberVO vo2 = dao.selectOne(vo);
				if (vo2.getNum() == 0) {
					System.out.println("�ش��ȣ�� ����.");
				} else {
					System.out.print(vo2.getNum() + " | ");
					System.out.print(vo2.getId() + " | ");
					System.out.print(vo2.getPw() + " | ");
					System.out.print(vo2.getName() + " | ");
					System.out.println(vo2.getTel());
				}

			} else if (menu.equals("5")) {
				System.out.println("======================");
				System.out.println("5.��ΰ˻� ������");
				System.out.println("======================");
				System.out.println("�۹�ȣ | ���̵� | ��й�ȣ | �̸� | ��ȭ��ȣ");
				System.out.println("-----------------------------------");
				List<MemberVO> vos = dao.selectAll();
				for (MemberVO x : vos) {
					System.out.print(x.getNum() + " | ");
					System.out.print(x.getId() + " | ");
					System.out.print(x.getPw() + " | ");
					System.out.print(x.getName() + " | ");
					System.out.println(x.getTel());
				}
			} else if (menu.equals("6")) {
				System.out.println("======================");
				System.out.println("6.�˻���˻� ������");
				System.out.println("======================");
				System.out.println("�˻�Ű�� �Է��ϼ���:[name or tel]");
				String searchKey = br.readLine();
				System.out.println("�˻�� �Է��ϼ���:");
				String searchWord = br.readLine();
				System.out.println("-----------------------------------");
				System.out.println("�۹�ȣ | ���̵� | ��й�ȣ | �̸� | ��ȭ��ȣ");
				System.out.println("-----------------------------------");
				List<MemberVO> vos = dao.searchList(searchKey, searchWord);
				for (MemberVO x : vos) {
					System.out.print(x.getNum() + " | ");
					System.out.print(x.getId() + " | ");
					System.out.print(x.getPw() + " | ");
					System.out.print(x.getName() + " | ");
					System.out.println(x.getTel());
				}
			}

			if (menu.equals("x"))
				break;

		} while (bool);

		System.out.println("end main....");

	}// end main

}// end class
