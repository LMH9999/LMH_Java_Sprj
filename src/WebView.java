import java.util.ArrayList;
public class WebView {

    //기본적으로 반복되는 메인메뉴 화면
    public void printBoard(ArrayList<Board> boardList) {
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "  title", "    date");
        System.out.println("-----------------------------------------------------------------------");

        for (int i=0;i<boardList.size();i++) {
            System.out.printf("%-6s%-12s%-16s%-40s\n",
                    boardList.get(i).getBno(),
                    boardList.get(i).getBwriter(),
                    boardList.get(i).getBtitle(),
                    boardList.get(i).getBdate());
        }
    }

    //read 기능을 사용했을 때 특정 번호의 글을 불러온 화면
    public void printReadBoard(Board board){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("제목 : "+ board.getBtitle());
        System.out.println("글쓴이 : "+ board.getBwriter());
        System.out.println("-------------------------------------------------------------------");
        System.out.println("내용 : "+ board.getBcontent());
    }

    //메인메뉴 화면
    public void printMainMenu(){
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴선택: ");
    }

    //선택했을때 한번 되묻는 메뉴
    public void printSubMenu(){
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("보조메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴선택: ");
    }

    //특정 게시물을 읽었을때 나오는 메뉴
    public void printReadSubMenu(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조메뉴: 1.Update | 2.Delete | 3.List");
        System.out.print("메뉴선택: ");
    }

}
