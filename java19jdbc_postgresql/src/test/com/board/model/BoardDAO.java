package test.com.board.model;

import java.util.List;

public interface BoardDAO {
	
	public int insert(BoardVO vo);
	public int update(BoardVO vo);
	public int delete(BoardVO vo);
	public BoardVO selectOne(BoardVO vo);
	public List<BoardVO> selectAll();
	public List<BoardVO> searchList(String searchKey, String searchWord);
	
}
