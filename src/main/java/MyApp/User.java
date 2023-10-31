package MyApp;

public class User {
    private static String user_name;
    private static String password;
    private static String email;
    private static String Conform_Pass;

    public void User(){


    }
    public static void Set_name(String name) {
        user_name = name;
    }

    public static void Set_pass(String pass) {
        password=pass;
    }

    public static void Set_email(String email1) {
        email=email1;
    }

    public static void Set_conf(String conf) {
        Conform_Pass=conf;
    }

    public Object get_Name() {
        return user_name;
    }
}

