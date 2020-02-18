import java.util.Scanner;

public class GenerateClassName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        original = "_" + original;
        original = original.replace('.', '_');
        original = original.replaceAll(" ", "");
        System.out.println(original);
    }
}
