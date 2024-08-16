package bitcamp.myapp.command.board;

import bitcamp.command.Command;
import bitcamp.context.ApplicationContext;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;

public class BoardAddCommand implements Command {

    private BoardDao boardDao;
    private ApplicationContext ctx;

    public BoardAddCommand(BoardDao boardDao, ApplicationContext ctx) {
        this.boardDao = boardDao;
        this.ctx = ctx;
    }

    @Override
    public void execute(String menuName) {

        Board board = new Board();
        board.setTitle(Prompt.input("제목?"));
        board.setContent(Prompt.input("내용?"));
        board.setWriter((User) ctx.getAttribute("loginUser"));


        try {
            boardDao.insert(board);
        } catch (Exception e) {
            System.out.println("게시판 등록 중 오류 발생!");
        }
    }

}
