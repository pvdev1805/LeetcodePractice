package string.problem2138;

public class Main {
    public static void main(String[] args) {
        // Test case 1:
        String[] res1 = new Solution().divideString("abcdefghi", 3, 'x');
        for (String s : res1) {
            System.out.printf("%s ", s);
        }

        System.out.println();

        // Test case 2:
        String[] res2 = new Solution().divideString("abcdefghij", 3, 'x');
        for (String s : res2) {
            System.out.printf("%s ", s);
        }
    }
}
