package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.Board;

import java.util.Date;

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
        board.setContent(Prompt.input("내용?"));
        board.setCreatedDate(new Date());
        board.setNo(Board.getNextSeqNo()); // 불러오면 번호를 세팅
        BoardList.add(board);
    }

    private static void listBoard() {
        System.out.println("번호 제목 작성일 조회수");
        Board[] boards = BoardList.toArray();
        for (Board board : BoardList.toArray()) {
            System.out.printf("%d %s %tD %s\n", board.getNo(), board.getTitle(), board.getCreatedDate(), board.getViewCount());
        }
    }

    private static void viewBoard() {
        int boardNo = Prompt.inputInt("게시글 번호?:");
        Board board = BoardList.findByNo(boardNo);
        if (board == null) {
            System.out.println("없는 게시글입니다.");
            return;
        }
        board.setViewCount(board.getViewCount() + 1);
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성일 : %1$tY-%1$tm-%1$td  %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
        System.out.printf("조회수: %s\n", board.getViewCount());
    }

    private static void updateBoard() {
        int boardNo = Prompt.inputInt("회원번호?:");
        Board board = BoardList.findByNo(boardNo);
        if (board == null) {
            System.out.println("없는 회원입니다.");
            return;
        }
        board.setViewCount(board.getViewCount() + 1);
        board.setTitle(Prompt.input("제목(%s)?", board.getTitle()));
        board.setContent(Prompt.input("내용(%s)?", board.getContent()));
        System.out.println("변경했습니다.");
    }

    private static void deleteBoard() {
        int boardNo = Prompt.inputInt("게시글 번호?:");
        Board deletedBoard = BoardList.delete(boardNo);
        if (deletedBoard != null) {
            System.out.printf("'%d' 게시글을 삭제 했습니다.\n", deletedBoard.getNo());
        } else {
            System.out.println("없는 게시글입니다.");
        }
    }

    public static Board findByNo(int boardNo) {
        for (int i = 0; i < boardLength; i++) {
            Board board = boards[i];
            if (board.getNo() == boardNo) {
                return board;
            }
        }
        return null;
    }


    public static int indexof(Board board) {
        for (int i = 0; i < boardLength; i++) {
            if (boards[i] == board) {
                return i;
            }
        }
        return -1;
    }
}

