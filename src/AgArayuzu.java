import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class AgArayuzu
{
    private boolean dongu = true;
    private ITusTakimi tusTakimi;
    private Gecikme gecikme;
    private MerkeziIslemBirimi merkez;

    public AgArayuzu()
    {
        tusTakimi=new TusTakimi();
        gecikme=new Gecikme();
        merkez=new MerkeziIslemBirimi();
    }

    public void menu()
    {
        Ekran.getInstance("").mesajGoster("----- SEÇİM MENÜSÜ -----");
        Ekran.getInstance(" ").mesajGoster("1.Sıcaklık Görüntüle");
        Ekran.getInstance(" ").mesajGoster("2.Sogutucuyu Aç");
        Ekran.getInstance(" ").mesajGoster("3.Sogutucuyu Kapat");
        Ekran.getInstance(" ").mesajGoster("4.Çıkış");
        Ekran.getInstance(" ").mesajGoster("------------------------");
        Ekran.getInstance(" ").mesajGoster("Seciminiz:");
    }

    public void Basla() {

        merkez.veritabaniBaglan();

        Random random = new Random();
        merkez.veriEkle("Sıcaklık", "deger", String.valueOf(random.nextInt(40)));
        merkez.veritabaniKes();
        Ekran.getInstance("----Kullanıcı Bilgileri----");
        Ekran.getInstance("").mesajGoster("isim : ");
        String isim = tusTakimi.veriAl();
        Ekran.getInstance(" ").mesajGoster("sifre :");
        String sifre = tusTakimi.veriAl();

        Kullanici kullanici=new Kullanici(isim,sifre,merkez,gecikme);

        if (kullanici.Giris(isim, sifre)) {
            Ekran.getInstance(" ").mesajGoster("Kullanıcı doğrulandı... \n");

            while (dongu) {

                menu();
                String secim = tusTakimi.veriAl();
                switch (secim) {
                    case "1":

                        ISicaklikAlgilayici sıcak=new SicaklikAlgilayici(merkez,gecikme);
                        sıcak.sicaklikGoruntulue();
                        break;
                    case "2":
                       IEyleyici sogutucuac=new Eyleyici(gecikme,merkez);
                       sogutucuac.sogutucuAc();
                        break;
                    case "3":
                        IEyleyici sogutucukapat=new Eyleyici(gecikme,merkez);
                        sogutucukapat.sogutucuKapat();
                        break;
                    case "4":
                        dongu = false;
                        break;
                    default:
                        Ekran.getInstance(" ").mesajGoster("Böyle bir seçim yok ...");
                        break;
                }

            }
        } else {
            Ekran.getInstance(" ").mesajGoster("Böyle bir kullanıcı bulunmamaktadır...");
        }
    }
}
