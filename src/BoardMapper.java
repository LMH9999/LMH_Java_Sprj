import java.util.ArrayList;

//인터페이스 선언
public interface BoardMapper {
    public ArrayList<Board> getBoard();
    public void createBoard(Board board);
    public Board readBoard(int bno);
    public void updateBoard(Board board);
    public void deleteBoard(int bno);
    //public void clearBoard();
    public void clearBoard();
}
