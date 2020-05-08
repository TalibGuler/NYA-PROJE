import java.util.Scanner;

public class TusTakimi implements ITusTakimi {
    @Override
    public String veriAl() {
        Scanner veri = new Scanner(System.in);
        return veri.next();

    }
}
