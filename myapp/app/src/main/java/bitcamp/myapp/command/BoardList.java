package bitcamp.myapp.command;

import bitcamp.myapp.vo.Board;

public class BoardList {
    private static final int MAX_SIZE = 100;

    private static Board[] boards = new Board[MAX_SIZE];
    private static int boardLength = 0;

    public void add(Board board) {
        this.boards[this.boardLength++] = board;
    }

    public Board delete(int boardNo) {
        Board deletedBoard = findByNo(boardNo);
        if (deletedBoard == null) {
            System.out.println("없는 회원입니다.");
            return null;
        }
        int index = indexOf(deletedBoard);
        for (int i = index + 1; i < this.boardLength; i++) {
            this.boards[i - 1] = this.boards[i];
        }
        boards[--boardLength] = null;
        return deletedBoard;
    }

    public Board[] toArray() {
        Board[] arr = new Board[this.boardLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.boards[i];
        }
        return arr;
    }

    public Board findByNo(int userNo) {
        for (int i = 0; i < this.boardLength; i++) {
            Board board = this.boards[i];
            if (board.getNo() == userNo) {
                return board;
            }
        }
        return null;
    }

    public int indexOf(Board board) {
        for (int i = 0; i < this.boardLength; i++) {
            if (this.boards[i] == board) {
                return i;
            }
        }
        return -1;
    }
}
