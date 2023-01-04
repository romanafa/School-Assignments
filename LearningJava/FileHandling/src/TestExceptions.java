public class TestExceptions {
    public static void main(String[] args) {
        try {
            int i = 0;
            int y = 2 / i;
            System.out.println("Welcome to Java");
        }
        finally {
            System.out.println("The finally clause is executed");
        }
    }
}
