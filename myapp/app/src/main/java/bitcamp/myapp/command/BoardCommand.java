package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.Board;

import java.time.LocalDate;

public class BoardCommand {
    private static final int MAX_SIZE = 100;
    private static Board[] boards = new Board[MAX_SIZE];
    private static int boardLength = 0;

    public static void executeBoardCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                addBoard();
                break;
            case "목록":
                listBoard();
                break;
            case "조회":
                viewBoard();
                break;
            case "변경":
                updateBoard();
                break;
            case "삭제":
                deleteBoard();
                break;
        }
    }

    private static void addBoard() {
        Board board = new Board();
        board.setTitle(Prompt.input("제목?"));
        board.setDescription(Prompt.input("내용?"));
        board.setDateWritten(LocalDate.now());
        boards[boardLength++] = board;
    }

    private static void listBoard() {
        System.out.println("번호 제목 작성일 조회수");
        for (int i = 0; i < boardLength; i++) {
            Board board = boards[i];
            System.out.printf("%d %s %s %s %s\n", i + 1, board.getTitle(), board.getDescription(), board.getDateWritten(), board.getViewCount());
        }
    }

    private static void viewBoard() {
        int userNo = Prompt.inputInt("회원번호?:");
        if (userNo < 1 || userNo > boardLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        Board board = boards[userNo - 1];
        board.increaseViewCount();
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getDescription());
        System.out.printf("작성일: %s\n", board.getDateWritten());
        System.out.printf("조회수: %s\n", board.getViewCount());
    }

    private static void updateBoard() {
        int userNo = Prompt.inputInt("회원번호?:");
        if (userNo < 1 || userNo > boardLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        Board board = boards[userNo - 1];
        board.setTitle(Prompt.input("제목(%s)?", board.getTitle()));
        board.setDescription(Prompt.input("내용(%s)?", board.getDescription()));
        System.out.println("변경했습니다.");
    }

    private static void deleteBoard() {
        int userNo = Prompt.inputInt("게시글 번호?:");
        if (userNo < 1 || userNo > boardLength) {
            System.out.println("없는 게시글입니다.");
            return;
        }
        for (int i = userNo; i < boardLength; i++) {
            boards[i - 1] = boards[i];
        }
        boards[--boardLength] = null;
        System.out.println("삭제했습니다.");
    }
}

