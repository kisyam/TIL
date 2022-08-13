package test.com.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

public class BoardMain {

	public static void main(String[] args) {
		System.out.println("Hello Board");

		// BoardVO - num,title,content,writer,wdate
		// BoardDAO - interface(입력,수정,삭제,올검색,하나검색,검색어검색)
		// BoardDAOimpl - BoardDAO상속받아구현
		// BoardMain - 객체생성,함수호출,출력...
		
		BoardDAO dao = new BoardDAOimpl();
		// 1.insert
		BoardVO vo = new BoardVO();
		vo.setTitle("java");
		vo.setContent("hello jdbc");
		vo.setWriter("yang");
		int result = dao.insert(vo);
		System.out.println(result);

		// 2.update
		vo = new BoardVO();
		vo.setNum(33);
		vo.setTitle("title44");
		vo.setContent("content44");
		vo.setWriter("kim44");
		result = dao.update(vo);
		System.out.println("result:" + result);// 1

		// 3.delete
		vo = new BoardVO();
		vo.setNum(1);
		result = dao.delete(vo);
		System.out.println("result:" + result);// 1

		// 4.selectOne
		vo = new BoardVO();
		vo.setNum(10);
		BoardVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);

		// 5.selectAll
		List<BoardVO> vos = dao.selectAll();
		for (BoardVO x : vos) {
			System.out.println(x);
		}

		// 6.searchList
//		List<BoardVO> vos2 = dao.searchList("writer", "ki");
//		List<BoardVO> vos2 = dao.searchList("content", "co");
		List<BoardVO> vos2 = dao.searchList("title", "ti");
		for (BoardVO x : vos2) {
			System.out.println(x);
		}

	}// end main

}// end class
