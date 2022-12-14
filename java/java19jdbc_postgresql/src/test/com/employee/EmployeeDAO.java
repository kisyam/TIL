package test.com.employee;

import java.util.List;

public interface EmployeeDAO {

	public int insert(EmployeeVO vo);

	public int update(EmployeeVO vo);

	public int delete(EmployeeVO vo);

	public EmployeeVO selectOne(EmployeeVO vo);

	public List<EmployeeVO> selectAll();

	public List<EmployeeVO> searchList(String searchKey, String searchWord);

}
