package _SchoolStuff.selfStudy.Methods;

public class JavaRocksMess {
    public static void main(String[] args) {
        border();
        message();
        border();
        
    }

    public static String message() {
        System.out.println("Java rocks!");
        return "";
    }

    public static void border() {
        int i = 0;
        for (i = 0; i <= 10; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
