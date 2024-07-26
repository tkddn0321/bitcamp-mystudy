package bitcamp.context;

import bitcamp.menu.MenuGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext {

    MenuGroup mainMenu = new MenuGroup("메인");

    Map<String, Objects> objContainer = new HashMap<>();

    public MenuGroup getMainMenu() {
        return mainMenu;
    }

    public void addAttribute(String name, Objects value) {
        objContainer.put(name, value);
    }

    public Object getAttribute(String name) {
        return objContainer.get(name);
    }

}
