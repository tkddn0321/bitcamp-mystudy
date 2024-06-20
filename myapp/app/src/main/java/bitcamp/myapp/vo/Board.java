package bitcamp.myapp.vo;

import java.util.Date;

public class Board {

    private static int seqNo; // 매번 초기화 되면 안되고 한번만 선언되기 위해 statuc 으로 선언

    private int no;
    private String title;
    private String content;
    private Date createdDate;
    private int viewCount;

    public static int getNextSeqNo() {
        return ++seqNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
