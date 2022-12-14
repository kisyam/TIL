package test.com.Score.model;

import java.util.List;

public interface ScoreDAO {

	public int insert(ScoreVO vo);// �޼ҵ� ���� �ѰŰ� ���� ������ ���� �����̸� �������̵��� �����ϰԵȴ�.

	public int update(ScoreVO vo);

	public int delete(ScoreVO vo);

	public ScoreVO selectOne(ScoreVO vo);

	public List<ScoreVO> selectAll();

	public List<ScoreVO> searchList(String searchKey, String searchWord);

}
