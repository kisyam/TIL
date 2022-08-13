package test.com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {
	Connection conn;// 전역변수 초기화 필요 X
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDAOimpl() {
//		System.out.println("BoardDAOimpl...");

		try {
			Class.forName(BoardDB_postgres.DRIVER_NAME);
//			System.out.println("Driver successed..");

//			jdbcConnectionTest();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void jdbcConnectionTest() {

		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
//			System.out.println("conn successed...");
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
	public int insert(BoardVO vo) {
//		System.out.println("insert()...");
		System.out.println(vo);

		int flag = 0;
		// 3-3
		try {
			// 3-4 getconnection
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
//			System.out.println("conn successed...");
			// 3-5
			// 입력,수정,삭제: DML
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
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
	public int update(BoardVO vo) {
//		System.out.println("update()...");
		System.out.println(vo);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
//			System.out.println("conn successed...");
			// 입력,수정,삭제: DML
			// 4.
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_UPDATE);
			// 5.
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getNum());
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
	public int delete(BoardVO vo) {
//		System.out.println("delete()...");
		System.out.println(vo);

		// 1.
		int flag = 0;
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
																														// 대문자,소문자
//			System.out.println("conn successed...");
			// 입력,수정,삭제: DML
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_DELETE);// pstmt 초기화
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
	public BoardVO selectOne(BoardVO vo) {
//		System.out.println("selectOne...");
		System.out.println(vo);
		BoardVO vo2 = new BoardVO();
		// 2.
		try {
			// 3.
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
//			System.out.println("conn successed...");
			// 검색 : DQL
			// 4.
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());

			// 5.
			rs = pstmt.executeQuery();

			// 6.
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getTimestamp("wdate"));
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
	public List<BoardVO> selectAll() {
//		System.out.println("selectAll...");
		// 1.
		List<BoardVO> vos = new ArrayList<BoardVO>();

		// 2.
		try {
			// 3.
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
//			System.out.println("conn successed...");
			// 검색 : DQL

			// 4.
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SELECT_ALL);

			// 5.
			rs = pstmt.executeQuery();

			// 6.
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getTimestamp("wdate"));
				vos.add(vo);
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
	public List<BoardVO> searchList(String searchKey, String searchWord) {
//		System.out.println("searchList...");
		System.out.println(searchKey);
		System.out.println(searchWord);
		// 1.
		List<BoardVO> vos = new ArrayList<BoardVO>();
		// 2.
		try {
			//3.
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);// ctrl+shift+x,y
//			System.out.println("conn successed...");
			//4.
			if (searchKey.equals("title")) {
				pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SEARCH_LIST_TITLE);
			} else if (searchKey.equals("content")) {
				pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SEARCH_LIST_CONTENT);
			} else if (searchKey.equals("writer"))
				pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SEARCH_LIST_WRITER);

			//5.
			pstmt.setString(1, "%" + searchWord + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getTimestamp("wdate"));
				vos.add(vo);
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

}
