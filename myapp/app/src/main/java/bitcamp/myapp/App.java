package bitcamp.myapp;

import bitcamp.myapp.command.BoardCommand;
import bitcamp.myapp.command.HelpCommand;
import bitcamp.myapp.command.ProjectCommand;
import bitcamp.myapp.command.UserCommand;
import bitcamp.myapp.util.Prompt;

public class App {


  String[] Menus = new String[]{"회원", "프로젝트", "게시판", "공지사항", "도움말", "종료"};
  String[][] subMenus = {
      {"등록", "목록", "조회", "변경", "삭제"},
      {"등록", "목록", "조회", "변경", "삭제"},
      {}
  };

  UserCommand userCommand = new UserCommand("회원");
  BoardCommand boardCommand = new BoardCommand("게시판");
  BoardCommand noticeCommand = new BoardCommand("도움말");
  ProjectCommand projectCommand = new ProjectCommand(userCommand.getUserList(), "프로젝트");
  HelpCommand helpCommand = new HelpCommand();


  public static void main(String[] args) {
    new App().execute();
  }

  void execute() {
    printMenu();

    String command;
    while (true) {
      try {
        command = Prompt.input("메인>");

        if (command.equals("menu")) {
          printMenu();

        } else {
          int menuNo = Integer.parseInt(command);
          String menuTitle = getMenuTitle(menuNo, Menus); // 설명하는 변수
          if (menuTitle == null) {
            System.out.println("유효한 메뉴 번호가 아닙니다.");
          } else if (menuTitle.equals("종료")) {
            break;
          } else {
            processMenu(menuTitle);
          }
        }
      } catch (NumberFormatException ex) {
        System.out.println("숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");

    Prompt.close();
  }

  void printMenu() {
    String boldAnsi = "\033[1m";
    String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";

    String appTitle = "[프로젝트 관리 시스템]";
    String line = "----------------------------------";

    System.out.println(boldAnsi + line + resetAnsi);
    System.out.println(boldAnsi + appTitle + resetAnsi);

    for (int i = 0; i < Menus.length; i++) {
      if (Menus[i].equals("종료")) {
        System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), Menus[i], resetAnsi);
      } else {
        System.out.printf("%d. %s\n", (i + 1), Menus[i]);
      }
    }

    System.out.println(boldAnsi + line + resetAnsi);
  }

  void printSubMenu(String menuTitle, String[] menus) {
    System.out.printf("[%s]\n", menuTitle);
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i]);
    }
    System.out.println("9. 이전");
  }

  boolean isValidateMenu(int menuNo, String[] menus) {
    return menuNo >= 1 && menuNo <= menus.length;
  }

  String getMenuTitle(int menuNo, String[] menus) {
    return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
  }

  void processMenu(String menuTitle) {

          switch (menuTitle) {
            case "회원":
              userCommand.execute();
              break;
            case "프로젝트":
              projectCommand.execute();
              break;
            case "게시판":
              boardCommand.execute();
              break;
            case "공지사항":
              noticeCommand.execute();
              break;
            case "도움말":
              helpCommand.execute();
              break;
            default:
              System.out.printf("%s 메뉴의 명령을 처리할 수 없습니다.\n", menuTitle);
          }
        }
}
