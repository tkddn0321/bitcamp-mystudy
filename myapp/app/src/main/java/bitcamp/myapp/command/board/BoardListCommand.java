package bitcamp.myapp.command.board;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;

import java.util.List;
import java.util.Map;

public class BoardListCommand implements Command {

  private BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

    @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    System.out.println("번호 제목 작성일 조회수");

      try {
        for (Board board: boardDao.list()) {
          System.out.printf("%d %s %s %s\n", board.getNo(), board.getTitle(), board.getCreatedDate(), board.getViewCount());
        }
      } catch (Exception e) {
        System.out.println("목록 조회 중 오류 발생!");
      }
    }
}
