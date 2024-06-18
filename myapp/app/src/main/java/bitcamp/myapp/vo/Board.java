package bitcamp.myapp.vo;

import java.time.LocalDate;

public class Board {
    private String title;
    private String description;
    private LocalDate dateWritten;
    private int viewCount;

    public void increaseViewCount() {
        this.viewCount++;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(LocalDate date) {
        this.dateWritten = date;
    }
}
