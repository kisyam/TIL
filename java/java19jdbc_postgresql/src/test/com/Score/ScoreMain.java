package test.com.Score;

import java.util.List;

import test.com.Score.model.ScoreDAO;
import test.com.Score.model.ScoreDAOimpl;
import test.com.Score.model.ScoreVO;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("ScoreMain...");

		ScoreDAO dao = new ScoreDAOimpl();

		// 1.insert
		ScoreVO vo = new ScoreVO();
		vo.setName("lee");
		vo.setKor(99);
		vo.setEng(88);
		vo.setMath(77);

		int result = dao.insert(vo);
		System.out.println("result" + result);

		// 2.update
		vo.setName("lee22");
		vo.setNum(18);
		vo.setKor(99);
		vo.setEng(88);
		vo.setMath(77);
		result = dao.update(vo);
		System.out.println("result:" + result);// 1
//
		// 3.delete
		vo = new ScoreVO();
		vo.setNum(15);
		result = dao.delete(vo);
		System.out.println("result" + result);

		// 4.selectOne
		vo = new ScoreVO();
		vo.setNum(20);
		ScoreVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);

		// 5.selectAll
		List<ScoreVO> vos = dao.selectAll();
		for (ScoreVO x : vos) {
			System.out.println(x);

		}
//
		// 6.searchList
//		List<ScoreVO> vos2 = dao.searchList("name", "le");
		List<ScoreVO> vos2 = dao.searchList("eng", "80");
		for (ScoreVO x : vos2) {
			System.out.println(x);

		}

	}//end main

}//end class
