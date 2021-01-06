import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class CLInput {
    private BufferedReader br;

    public CLInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(String prompt) {
        String res=null;
        while(res == null) {
            try {
                System.out.print(prompt + ": ");
                res = br.readLine();
            } catch (Exception e) {
                res = null;
            }
        }

        return res;
    }

    public int readInteger(String prompt) {
        int res=0;
        boolean ok = false;
        while(!ok) {
            try {
                System.out.print(prompt + ": ");
                res = Integer.parseInt(br.readLine());
                ok = true;
            } catch (Exception e) {
                System.out.println("Input non valido.");
            }
        }

        return res;
    }

    public float readFloat(String prompt) {
        float res=0;
        boolean ok = false;
        while(!ok) {
            try {
                System.out.print(prompt + ": ");
                res = Float.parseFloat(br.readLine());
                ok = true;
            } catch (Exception e) {
                System.out.println("Input non valido.");
            }
        }

        return res;
    }
    public char readChar(String prompt) {
        char res=0;
        boolean ok = false;
        while(!ok) {
            try {
                System.out.print(prompt + ": ");
                String str = br.readLine();
                if(str.length() == 1) {
                    res = str.charAt(0);
                    ok = true;
                }
                else {
                    System.out.println("Troppi caratteri");
                }
            } catch (Exception e) {
                System.out.println("Input non valido.");
            }
        }

        return res;
    }
}