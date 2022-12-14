package test.com.Score.model;

import java.util.List;

public interface ScoreDAO {

	public int insert(ScoreVO vo);// 메소드 선언만 한거고 내부 로직은 없는 상태이며 오버라이딩을 강제하게된다.

	public int update(ScoreVO vo);

	public int delete(ScoreVO vo);

	public ScoreVO selectOne(ScoreVO vo);

	public List<ScoreVO> selectAll();

	public List<ScoreVO> searchList(String searchKey, String searchWord);

}
