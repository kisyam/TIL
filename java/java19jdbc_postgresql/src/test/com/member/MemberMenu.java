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
			System.out.println("1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색");
			System.out.println("종료시 x입력[계속하려면 아무키]:");
			System.out.println("===========================");
			System.out.println("메뉴를 선택하세요:");
			menu = br.readLine();

			if (menu.equals("1")) {
				MemberVO vo = new MemberVO();
				System.out.println("======================");
				System.out.println("1.아이디를 입력하세요");
				System.out.println("======================");
				String id = br.readLine();
				vo.setId(id);
				System.out.println("======================");
				System.out.println("1.비밀번호를 입력하세요");
				System.out.println("======================");
				String pw = br.readLine();
				vo.setPw(pw);
				System.out.println("======================");
				System.out.println("1.이름을 입력하세요");
				System.out.println("======================");
				String name = br.readLine();
				vo.setName(name);
				System.out.println("======================");
				System.out.println("1.전화번호를 입력하세요");
				System.out.println("======================");
				String tel = br.readLine();
				vo.setTel(tel);
				int result = dao.insert(vo);
				if (result == 1)
					System.out.println("입력성공");
				else
					System.out.println("입력실패");
			} else if (menu.equals("2")) {
				System.out.println("======================");
				System.out.println("2.회원수정 페이지");
				System.out.println("======================");
				System.out.println("회원번호:");
				String num = br.readLine();
				System.out.println("회원아이디:");
				String id = br.readLine();
				System.out.println("회원비밀번호:");
				String pw = br.readLine();
				System.out.println("회원이름:");
				String name = br.readLine();
				System.out.println("회원전화번호:");
				String tel = br.readLine();
				MemberVO vo = new MemberVO();
				vo.setNum(Integer.parseInt(num));
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setTel(tel);

				int result = dao.update(vo);
				if (result == 1)
					System.out.println("수정성공");
				else
					System.out.println("수정실패");

			} else if (menu.equals("3")) {
				System.out.println("======================");
				System.out.println("3.회원삭제 페이지");
				System.out.println("======================");
				System.out.println("회원번호:");
				String num = br.readLine();

				MemberVO vo = new MemberVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				if (result == 1)
					System.out.println("삭제성공");
				else
					System.out.println("삭제실패");

			} else if (menu.equals("4")) {
				System.out.println("======================");
				System.out.println("4.회원번호검색 페이지");
				System.out.println("======================");
				System.out.println("회원번호:");
				String num = br.readLine();

				MemberVO vo = new MemberVO();
				vo.setNum(Integer.parseInt(num));
				MemberVO vo2 = dao.selectOne(vo);
				if (vo2.getNum() == 0) {
					System.out.println("해당번호글 없음.");
				} else {
					System.out.print(vo2.getNum() + " | ");
					System.out.print(vo2.getId() + " | ");
					System.out.print(vo2.getPw() + " | ");
					System.out.print(vo2.getName() + " | ");
					System.out.println(vo2.getTel());
				}

			} else if (menu.equals("5")) {
				System.out.println("======================");
				System.out.println("5.모두검색 페이지");
				System.out.println("======================");
				System.out.println("글번호 | 아이디 | 비밀번호 | 이름 | 전화번호");
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
				System.out.println("6.검색어검색 페이지");
				System.out.println("======================");
				System.out.println("검색키를 입력하세요:[name or tel]");
				String searchKey = br.readLine();
				System.out.println("검색어를 입력하세요:");
				String searchWord = br.readLine();
				System.out.println("-----------------------------------");
				System.out.println("글번호 | 아이디 | 비밀번호 | 이름 | 전화번호");
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
