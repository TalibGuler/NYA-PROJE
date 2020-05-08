public class Ekran {

    private static Ekran ekran;

    private Ekran(String mesaj)
    {
        System.out.println(mesaj);
    }
    public static synchronized Ekran getInstance(String mesaj){
        if (ekran==null)
            ekran=new Ekran(mesaj);
        return ekran;
    }

    public void mesajGoster(String mesaj) {
        System.out.println(mesaj);
    }
}
