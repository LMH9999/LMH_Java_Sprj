import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//롬복을 이용한 게시판에서 사용할 getter,setter와 생성자 및 변수들 선언
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public Board(String btitle, String bcontent, String bwriter, Date bdate) {
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }

    public Board(String btitle, String bcontent, String bwriter) {
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    public Board(int bno) {
        this.bno = bno;
    }

    public Board(int bno, String btitle, String bcontent, String bwriter) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
}