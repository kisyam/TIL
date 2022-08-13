package test.com.board.model;

public interface BoardDB_postgres {

	String DRIVER_NAME = "org.postgresql.Driver";
	String URL = "jdbc:postgresql://localhost:5432/golfzon";
	String USER = "kosta";;
	String PASSWORD = "hi123456";

	String SQL_SELECT_ALL = "select * from board order by num desc";

	String SQL_INSERT = "INSERT INTO public.board(num, title, content, writer) VALUES (nextval('seq_board'), ?,?,?)";
	String SQL_UPDATE = "update board set title=?,content=?,writer=?,wdate=now() where num=?";
	String SQL_DELETE = "delete from board where num=?";
	String SQL_SELECT_ONE = "select * from board where num=?";
	String SQL_SEARCH_LIST_CONTENT = "select * from board where content like ? order by num desc";
	String SQL_SEARCH_LIST_WRITER = "select * from board where writer like ? order by num desc";
	String SQL_SEARCH_LIST_TITLE = "select * from board where title like ? order by num desc";

}
