//import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    public static void main(String[] args) {

        //데이터베이스 기능들을 담기 위한 초기화
        DBUtil db = new DBUtil();
        Scanner scan = new Scanner(System.in);

        //마이바티스 설정을 위한 초기화
        db.init();

        //기본적으로 계속 프로그램이 돌아가도록 반복문
        while (true){
            //데이터베이스에서 게시물 목록 가져오기
            ArrayList<Board> boardList = db.getBoard();
            //기본적인 인터페이스 초기화
            WebView wv = new WebView();
            //게시물 전체 목록 표시
            wv.printBoard(boardList);
            wv.printMainMenu();
            //사용자의 원하는 메뉴 읽기
            String cmd = scan.nextLine();
            System.out.println();

            //4를 입력하면 프로그램 종료
            if (cmd.equals("4")){
                System.out.println("** 게시판 종료 **");
                break;
            } else if (cmd.equals("1")) {
                //1을 입력하면 게시물 생성으로 이동
                System.out.println("[새 게시물 입력]");
                System.out.print("제목: ");
                String title = scan.nextLine();
                System.out.print("내용: ");
                String content = scan.nextLine();
                System.out.print("글쓴이: ");
                String writer = scan.nextLine();
                wv.printSubMenu();
                //게시글 만드는걸 확정하는 보조메뉴
                String menuNo = scan.nextLine();
                //1을 입력받으면 입력받은 제목, 내용, 글쓴이의 정보로 데이터베이스 새 게시물 생성
                if(menuNo.equals("1")){
                    try {
                        db.createBoard(title,content,writer);
                    }catch (Exception e){
                        e.printStackTrace();
                        break;
                    }
                }
            } else if (cmd.equals("2")) {
                //2를 입력하면 원하는 번호의 게시물을 상세보기
                System.out.println("[게시물 읽기]");
                System.out.print("bno: ");
                //원하는 게시물의 번호 입력받기
                int bno = Integer.parseInt(scan.nextLine());
                //데이터베이스에서 원하는 번호의 게시물 정보 가져오기
                Board board = db.readBoard(bno);
                //웹뷰에 있는 인터페이스 불러와서 원하는 게시물 정보 출력
                wv.printReadBoard(board);
                wv.printReadSubMenu();
                String menuNo = scan.nextLine();
                System.out.println();

                //1번 업데이트를 선택한다면 방금 읽은 게시물 수정하기
                if (menuNo.equals("1")) {
                    System.out.println("[수정 내용 입력]");
                    System.out.print("제목: ");
                    String title = scan.nextLine();
                    System.out.print("내용: ");
                    String content = scan.nextLine();
                    System.out.print("글쓴이: ");
                    String writer = scan.nextLine();
                    //보조메뉴 출력
                    wv.printSubMenu();
                    String subMenuNo = scan.nextLine();
                    //1을 선택해 확정 지었다면 데이터베이스에서 게시물 수정
                    if (subMenuNo.equals("1")) {
                        try {
                            db.updateBoard(bno, title, content, writer);
                        }catch (Exception e){
                            e.printStackTrace();
                            break;
                        }
                    }
                } else if (menuNo.equals("2")) {
                    //2번 삭제를 선택했다면 방금 읽은 게시물을 삭제하기
                    wv.printSubMenu();
                    String subMenuNo = scan.nextLine();
                    //확정짓는 보조메뉴를 1번 선택했다면 데이터베이스에서 게시물 삭제
                    if (subMenuNo.equals("1")) {
                        try {
                            db.deleteBoard(bno);
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }

            } else if (cmd.equals("3")) {
                //3번을 선택했다면 게시물 전체 삭제
                System.out.println("[게시물 전체 삭제]");
                wv.printSubMenu();
                String menuNo = scan.nextLine();
                //확정짓는 보조메뉴 1번을 선택하면 데이터베이스 전체 게시물 삭제
                if(menuNo.equals("1")) {
                    try {
                        db.clearBoard();
                    }catch (Exception e){
                        e.printStackTrace();
                        break;
                    }
                }

            }

        }
        
    }
}

