public class Gecikme
{
   public void bekleme(String mesaj1, String mesaj2){
        try {

            Ekran.getInstance(" ").mesajGoster(mesaj1);
            Thread.sleep(2000);
            Ekran.getInstance("").mesajGoster(mesaj2);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
