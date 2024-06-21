package bitcamp.myapp.command;

import bitcamp.myapp.vo.User;

public class ArrayList {
    private static final int MAX_SIZE = 100;

    private User[] list = new User[MAX_SIZE];
    private int size = 0;

    public void add(User obj) {
        list[size++] = obj;
    }

    public User remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        User deletedObj = list[index];
        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return deletedObj;
    }

    public User[] toArray() {
        User[] arr = new User[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list[i];
        }
        return arr;
    }

    public int indexOf(User obj) {
        for (int i = 0; i < size; i++) {
            if (this.list[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public User get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ArrayList l;
        return list[index];
    }
}
