package bitcamp.myapp.vo;

import bitcamp.myapp.command.ArrayList;

public class Project {
    private static int seqNo; // 매번 초기화 되면 안되고 한번만 선언되기 위해 statuc 으로 선언

    private int no;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private ArrayList members = new ArrayList();

    public static int getNextSeqNo() {
        return ++seqNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList getMembers() {
        return members;
    }

    public void setMembers(ArrayList members) {
        this.members = members;
    }
}
