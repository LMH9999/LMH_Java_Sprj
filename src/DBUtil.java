import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
    SqlSessionFactory sqlSessionFactory;

    public void init() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (Exception e) {
            System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
            e.printStackTrace();
        }
    }

    public ArrayList<Board> getBoard() {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        ArrayList<Board> boardList = mapper.getBoard();

        return boardList;
    }
//    public ArrayList<Board> readBoard(){
//
//    }
    public void createBoard(String title, String content, String writer) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(title, content, writer);
        mapper.createBoard(board);

        session.commit(); // update, delete, insert
    }
    public void updateBoard(String title, String content, String writer) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(title,content,writer);
        mapper.updateBoard(board);

        session.commit(); // update, delete, insert
    }
    public void deleteBoard(int bno) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.deleteBoard(bno);

        session.commit(); // update, delete, insert
    }

    public void clearBoard(){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.clearBoard();

        session.commit();
    }

}
