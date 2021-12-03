package Persist;

public class Main {
    public static void main(String[] args) {
        var u = new UserDaoMySQL();
        u.getUserById(1);
    }
}
