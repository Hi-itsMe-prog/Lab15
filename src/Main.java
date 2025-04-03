import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the random string with IP-address: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String ipRegex = "::1|\\b((([a-fA-F0-9]{1,4}:){7}[a-fA-F0-9]{1,4})\\b" +
                "|\\b(([a-fA-F0-9]{1,4})?::([a-fA-F0-9]{1,4})(:[a-fA-F0-9]{1,4}){0,5})\\b"+
                "|\\b(([a-fA-F0-9]{1,4}:)?([a-fA-F0-9]{1,4})::([a-fA-F0-9]{1,4})(:[a-fA-F0-9]{1,4}){0,4})\\b"+
                "|\\b((([a-fA-F0-9]{1,4}:)?){0,2}([a-fA-F0-9]{1,4})::([a-fA-F0-9]{1,4})(:[a-fA-F0-9]{1,4}){0,3})\\b"+
                "|\\b((([a-fA-F0-9]{1,4}:)?){0,3}([a-fA-F0-9]{1,4})::([a-fA-F0-9]{1,4})(:[a-fA-F0-9]{1,4}){0,3})\\b"+
                "|\\b((([a-fA-F0-9]{1,4}:)?){0,4}([a-fA-F0-9]{1,4})::([a-fA-F0-9]{1,4})(:[a-fA-F0-9]{1,4}){0,3})\\b"+
                "|\\b((([a-fA-F0-9]{1,4}:)?){0,5}([a-fA-F0-9]{1,4})::([a-fA-F0-9]{1,4})(:[a-fA-F0-9]{1,4}){0,3})\\b"+
                "|\\b([a-fA-F0-9]{1,4}:){1,6}:[a-fA-F0-9]{1,4})\\b";

        Pattern pattern = Pattern.compile(ipRegex);
        Matcher matcher = pattern.matcher(s);

        boolean found = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("IP.txt"))) {
            while (matcher.find()) {
                String match = matcher.group();
                if (!match.equals("::")) {
                    System.out.println(match);
                    bw.write(match);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("IP address not found in the string.");
                bw.write("IP address not found in the string.");
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}