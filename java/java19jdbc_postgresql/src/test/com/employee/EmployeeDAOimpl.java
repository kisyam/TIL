package test.com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public EmployeeDAOimpl() {
		try {
			Class.forName(EmployeeDB_postgres.DRIVER_NAME);

			jdbcConnectionTest();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void jdbcConnectionTest() {

		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);
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
	public int insert(EmployeeVO vo) {
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_INSERT);
			pstmt.setString(1, vo.getFirst_name());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setDate(5, vo.getHire_date());
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
	public int update(EmployeeVO vo) {
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_UPDATE);
			pstmt.setString(1, vo.getFirst_name());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setDate(5, vo.getHire_date());
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
	public int delete(EmployeeVO vo) {
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);

			pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_DELETE);
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
	public EmployeeVO selectOne(EmployeeVO vo) {
		System.out.println("selectOne...");
		System.out.println(vo);
		EmployeeVO vo2 = new EmployeeVO();
		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);// ctrl+shift+x,y
			pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setSalary(rs.getInt(100));
				vo2.setHire_date(rs.getDate(1));

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
	public List<EmployeeVO> selectAll() {
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();

		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setNum(rs.getInt("num"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt(1));
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
	public List<EmployeeVO> searchList(String searchKey, String searchWord) {
		System.out.println(searchKey);
		System.out.println(searchWord);
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();
		try {
			conn = DriverManager.getConnection(EmployeeDB_postgres.URL, EmployeeDB_postgres.USER,
					EmployeeDB_postgres.PASSWORD);// ctrl+shift+x,y
			if (searchKey.equals("first_name")) {
				pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SEARCH_LIST_FIRST_NAME);
				pstmt.setString(1, "%" + searchWord + "%");
			} else if (searchKey.equals("last_name")) {
				pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SEARCH_LIST_LAST_NAME);
				pstmt.setString(1, "%" + searchWord + "%");
			} else if (searchKey.equals("email")) {
				pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SEARCH_LIST_EMAIL);
				pstmt.setString(1, "%" + searchWord + "%");
			} else if (searchKey.equals("salary")) {
				pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SEARCH_LIST_SALARY);
				pstmt.setInt(1, Integer.parseInt(searchWord));
			} else if (searchKey.equals("hire_date")) {
				pstmt = conn.prepareStatement(EmployeeDB_postgres.SQL_SEARCH_LIST_HIRE_DATE);
				pstmt.setInt(1, Integer.parseInt(searchWord));
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setNum(rs.getInt("num"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt(100));
				vo.setHire_date(rs.getDate(1));
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
