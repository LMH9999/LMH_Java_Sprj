import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}