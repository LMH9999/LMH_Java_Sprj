import java.util.ArrayList;
public interface BoardMapper {
    public ArrayList<Board> getBoard();
    public void createBoard(Board board);
    public void readBoard(Board board);
    public void updateBoard(Board board);
    public void deleteBoard(int id);
    public void clearBoard();
}
