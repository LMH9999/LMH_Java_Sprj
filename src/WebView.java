import java.util.ArrayList;
public class WebView {
    public void printBoard(ArrayList<Board> boardList) {
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------------------");
        for (int i=0;i<boardList.size();i++) {
            System.out.print(boardList.get(i).getBno()+"  ");
            System.out.print(boardList.get(i).getBwriter()+"  ");
            System.out.print(boardList.get(i).getBdate()+"  ");
            System.out.print(boardList.get(i).getBtitle());
        }

    }
}
