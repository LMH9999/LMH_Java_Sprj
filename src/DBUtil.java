import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//데이터베이스의 기능들을 모아둔 곳
public class DBUtil {
    SqlSessionFactory sqlSessionFactory;

    //마이바티스 설정을 초기화하고, 데이터베이스 연결을 위한 메소드
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

    //데이터베이스에서 모든 게시물 목록을 가져오는 메소드
    public ArrayList<Board> getBoard() {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        ArrayList<Board> boardList = mapper.getBoard();

        //쿼리문으로 불러온 게시물 목록을 리턴
        return boardList;
    }

    //원하는 번호의 게시물을 상세보기 하기위한 메소드
    public Board readBoard(int no){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = mapper.readBoard(no);

        //원하는 게시물 정보를 리턴
        return board;
    }

    //새로운 게시물을 생성하는 메소드
    public void createBoard(String title, String content, String writer) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(title, content, writer);
        mapper.createBoard(board);

        //새로운 게시물 올리기 실행
        session.commit();
    }

    //원하는 게시물을 수정하는 메소드
    public void updateBoard(int bno, String title, String content, String writer) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(bno, title,content,writer);
        mapper.updateBoard(board);

        //게시물 수정 실행
        session.commit();
    }

    //원하는 게시물을 삭제하는 메소드
    public void deleteBoard(int bno) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.deleteBoard(bno);

        //게시물 삭제 실행
        session.commit();
    }

    //게시물 전체를 삭제하는 메소드
    public void clearBoard(){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.clearBoard();

        //게시물 전체 삭제 실행
        session.commit();
    }
}
