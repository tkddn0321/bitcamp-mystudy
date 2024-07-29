package bitcamp.menu;

import java.util.Objects;

public abstract class AbstractMenu implements Menu {

    protected String title;


    public AbstractMenu(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AbstractMenu menuGroup)) {
            return false;
        }

        return Objects.equals(title, menuGroup.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String getTitle() {
        return title;
    }
}
