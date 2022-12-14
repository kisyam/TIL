package test.com.Score.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.board.model.BoardDB_postgres;
import test.com.board.model.BoardVO;

public class ScoreDAOimpl implements ScoreDAO {

	Connection conn;// 전역변수 초기화 필요 X
	PreparedStatement pstmt;
	ResultSet rs;

	public ScoreDAOimpl() {
		System.out.println("ScoreDAOimpl...");
		try {
			Class.forName(ScoreDB_postgres.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void jdbcConnectionTest() {

		try {
			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
			System.out.println("conn successed...");
			// 검색 : DQL
			String sql = "select version() as version";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("version"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

	}

	@Override
	public int insert(ScoreVO vo) {
		System.out.println("insert()...");
		System.out.println(vo);// 정상적으로 잘넘어왔는지
		int flag = 0;
		try {
			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getMath());
			// 3-6
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;
	}

	@Override
	public int update(ScoreVO vo) {
		System.out.println("update()...");
		System.out.println(vo);

		int flag = 0;

		try {
			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
			System.out.println("conn successed...");
			// 입력,수정,삭제: DML
			// 4.
			pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_UPDATE);
			// 5.
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getNum());
			// 6.
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;

	}

	@Override
	public int delete(ScoreVO vo) {
		System.out.println("delete()...");
		System.out.println(vo);

		int flag = 0;
		try {
			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
																														// 대문자,소문자
			System.out.println("conn successed...");
			// 입력,수정,삭제: DML
			pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_DELETE);// pstmt 초기화
			pstmt.setInt(1, vo.getNum());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {// delete 는 rs 필요없음
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		return flag;
	}

	@Override
	public ScoreVO selectOne(ScoreVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);

		ScoreVO vo2 = new ScoreVO();

		try {
			// 3.
			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
			System.out.println("conn successed...");
			// 검색 : DQL
			// 4.
			pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());

			// 5.
			rs = pstmt.executeQuery();

			// 6.
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setEng(rs.getInt("eng"));
				vo2.setKor(rs.getInt("kor"));
				vo2.setMath(rs.getInt("math"));
				vo2.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vo2;
	}

	@Override
	public List<ScoreVO> selectAll() {
		System.out.println("selectAll()...");
		List<ScoreVO> vos = new ArrayList<ScoreVO>();
		try {

			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVO vo2 = new ScoreVO();
				while (rs.next()) {
					vo2.setNum(rs.getInt("num"));
					vo2.setEng(rs.getInt("eng"));
					vo2.setKor(rs.getInt("kor"));
					vo2.setMath(rs.getInt("math"));
					vo2.setName(rs.getString("name"));
					vos.add(vo2);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

	@Override
	public List<ScoreVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList...");
		System.out.println(searchKey);
		System.out.println(searchWord);

		List<ScoreVO> vos = new ArrayList<ScoreVO>();
		try {
			// 3.
			conn = DriverManager.getConnection(ScoreDB_postgres.URL, ScoreDB_postgres.USER, ScoreDB_postgres.PASSWORD);// ctrl+shift+x,y
			System.out.println("conn successed...");
			// 4.
			if (searchKey.equals("name")) {
				pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_SEARCH_LIST_NAME);
				pstmt.setString(1, "%" + searchWord + "%");
			} else if (searchKey.equals("eng")) {
				pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_SEARCH_LIST_ENG);
				pstmt.setInt(1, Integer.parseInt(searchWord));
			} else if (searchKey.equals("kor")) {
				pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_SEARCH_LIST_KOR);
				pstmt.setInt(1, Integer.parseInt(searchWord));
			} else if (searchKey.equals("math")) {
				pstmt = conn.prepareStatement(ScoreDB_postgres.SQL_SEARCH_LIST_MATH);
				pstmt.setInt(1, Integer.parseInt(searchWord));
			}

			// 5.
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num"));
				vo.setEng(rs.getInt("eng"));
				vo.setKor(rs.getInt("kor"));
				vo.setMath(rs.getInt("math"));
				vo.setName(rs.getString("name"));
				vos.add(vo);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

}
