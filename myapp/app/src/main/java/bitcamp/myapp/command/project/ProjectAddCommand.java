package bitcamp.myapp.command.project;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;

import java.util.List;

public class ProjectAddCommand implements Command {

  private List<Project> projectList;
  private ProjectMemberHandler projectMemberHandler;

  public ProjectAddCommand(List<Project> projectList, ProjectMemberHandler projectMemberHandler) {
    this.projectList = projectList;
    this.projectMemberHandler = projectMemberHandler;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    Project project = new Project();
    project.setTitle(Prompt.input("프로젝트명?"));
    project.setDescription(Prompt.input("설명?"));
    project.setStartDate(Prompt.input("시작일?"));
    project.setEndDate(Prompt.input("종료일?"));

    System.out.println("팀원:");
    projectMemberHandler.addMembers(project);

    project.setNo(Project.getNextSeqNo());

    projectList.add(project);

    System.out.println("등록했습니다.");
  }
}
