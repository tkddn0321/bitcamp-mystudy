package bitcamp.myapp.command;

import bitcamp.util.Prompt;

import java.util.Stack;

public class HistoryCommand implements Command {

  public void execute(String menuName) {
    Prompt.printHistory();
  }
}