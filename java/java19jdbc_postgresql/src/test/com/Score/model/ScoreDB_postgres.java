package test.com.Score.model;

public interface ScoreDB_postgres {

	String DRIVER_NAME = "org.postgresql.Driver";
	String URL = "jdbc:postgresql://localhost:5432/golfzon";
	String USER = "kosta";
	String PASSWORD = "hi123456";

	String SQL_SELECT_ALL = "select * from score order by num desc;";

	String SQL_INSERT = "INSERT INTO public.score(num, name, eng, kor, math) VALUES (nextval('seq_board'), ?,?,?,?)";
	String SQL_UPDATE = "update score set name=?,eng=?,kor=?,math=? where num=?";
	String SQL_DELETE = "delete from score where num=?";
	String SQL_SELECT_ONE = "select * from score where num=?";
	String SQL_SEARCH_LIST_NAME = "select * from score where name like ? order by num desc";
	String SQL_SEARCH_LIST_ENG = "select * from score where eng >= ? order by num desc";
	String SQL_SEARCH_LIST_KOR = "select * from score where kor >= ? order by num desc";
	String SQL_SEARCH_LIST_MATH = "select * from score where math >= ? order by num desc";

}
