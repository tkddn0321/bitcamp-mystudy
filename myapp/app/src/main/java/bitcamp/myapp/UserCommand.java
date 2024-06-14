package bitcamp.myapp;

public class UserCommand {

    static final int MAX_SIZE = 100;
    static User[] users = new User[MAX_SIZE];
    static int userLength = 0;

    static String[] name = new String[MAX_SIZE];
    static String[] email = new String[MAX_SIZE];
    static String[] password = new String[MAX_SIZE];
    static String[] tel = new String[MAX_SIZE];

    static void executeUserCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                addUser();
                break;
            case "목록":
                listUser();
                break;
            case "조회":
                viewUser();
                break;
            case "변경":
                updateUser();
                break;
            case "삭제":
                deleteUser();
                break;
        }
    }

    static void addUser() {
        User user = new User();
        user.name = Prompt.input("이름?");
        user.email = Prompt.input("이메일?");
        user.password = Prompt.input("암호?");
        user.tel = Prompt.input("연락처?");
        users[userLength++] = user;
    }

    static void listUser() {
        System.out.println("번호 이름 이메일");
        for (int i = 0; i < userLength; i++) {
            User user = users[i];
            System.out.printf("%d %s %s\n", i + 1, user.name, user.email);
        }
    }

    static void viewUser() {
        int userNo = Integer.parseInt(Prompt.input("회원번호?:"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        User user = users[userNo - 1];
        System.out.printf("이름: %s\n", user.name);
        System.out.printf("이메일: %s\n", user.email);
        System.out.printf("연락처: %s\n", user.tel);
    }

    static void updateUser() {
        int userNo = Integer.parseInt(Prompt.input("회원번호?:"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        User user = users[userNo - 1];
        user.name = Prompt.input(String.format("이름(%s)?", user.name));
        user.email = Prompt.input(String.format("이메일(%s)?", user.email));
        user.password = Prompt.input("암호?");
        user.tel = Prompt.input(String.format("연락처(%s)?", user.tel));
        System.out.println("변경했습니다.");
    }

    static void deleteUser() {
        int userNo = Integer.parseInt(Prompt.input("회원번호?:"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        for (int i = userNo; i < userLength; i++) {
            name[i - 1] = name[i];
            email[i - 1] = email[i];
            password[i - 1] = password[i];
            tel[i - 1] = tel[i];
        }
        userLength--;
        name[userLength] = null;
        email[userLength] = null;
        password[userLength] = null;
        tel[userLength] = null;
    }
}
