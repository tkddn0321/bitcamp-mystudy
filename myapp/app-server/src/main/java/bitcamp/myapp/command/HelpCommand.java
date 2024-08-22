package bitcamp.myapp.command;

import bitcamp.command.Command;
import bitcamp.net.Prompt;

import java.util.Stack;

public class HelpCommand implements Command {

  public void execute(String menuName, Prompt prompt) {
    prompt.println("도움말입니다!");
  }
}
