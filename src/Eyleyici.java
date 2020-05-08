public class Eyleyici implements IEyleyici {


    private Gecikme gecikme;
    private MerkeziIslemBirimi merkez;
    public Eyleyici(Gecikme gecikme,MerkeziIslemBirimi merkez)
    {

        this.gecikme=gecikme;
        this.merkez=merkez;
    }
    @Override
    public void sogutucuAc() {

        gecikme.bekleme("İsteğiniz gönderildi...","Soğutucu açılmaya çalışılıyor ...");

        merkez.veritabaniBaglan();

        boolean deger = merkez.sorguBool("Sogutucu", "durum");

        if (deger) {
            merkez.veritabaniKes();
            Ekran.getInstance(" ").mesajGoster("Sogutucu zaten açık ... \n");

        } else {
            merkez.veriEkle("Sogutucu", "durum", true);
            merkez.veritabaniKes();
            Ekran.getInstance(" ").mesajGoster("Sogutucu açıldı ... \n");
        }
    }

    @Override
    public void sogutucuKapat() {

        gecikme.bekleme("İsteğiniz gönderildi...","Soğutucu kapatılmaya çalışılıyor ...");
        merkez.veritabaniBaglan();
        boolean deger = merkez.sorguBool("Sogutucu", "durum");


        if (!deger) {
            merkez.veritabaniKes();
            Ekran.getInstance(" ").mesajGoster("Sogutucu zaten kapalı ... \n");
        } else {
            merkez.veriEkle("Sogutucu", "durum", false);
            merkez.veritabaniKes();
            Ekran.getInstance(" ").mesajGoster("Sogutucu kapandı ... \n");

        }
    }

}
