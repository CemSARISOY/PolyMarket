package Persist;

public class Main {
    public static void main(String[] args) {
        var u = new UserDaoPostGre();
        u.getUserById(1);
    }
}
