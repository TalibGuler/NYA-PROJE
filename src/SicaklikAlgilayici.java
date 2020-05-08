public class SicaklikAlgilayici  implements ISicaklikAlgilayici {


    private MerkeziIslemBirimi merkez;
    private Gecikme gecikme;
    public SicaklikAlgilayici(MerkeziIslemBirimi merkez,Gecikme gecikme)
    {

        this.merkez=merkez;
        this.gecikme=gecikme;
    }

    @Override
    public void sicaklikGoruntulue()
    {
        merkez.veritabaniBaglan();
        String veri = merkez.sorgu("Sıcaklık","deger");
        gecikme.bekleme("Sıcaklık degeri bekleniyor...","Sıcaklık degeri algılandı...");
        Ekran.getInstance(" ").mesajGoster("Sıcaklık degeri:"+veri+" Derece \n" );
    }
}