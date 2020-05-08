public class Kullanici
{
    private String isim;
    private String sifre;
    private MerkeziIslemBirimi merkez;
    private Gecikme gecikme;
    public Kullanici(String isim,String sifre,MerkeziIslemBirimi merkez,Gecikme gecikme)
    {
        this.isim=isim;
        this.sifre=sifre;
        this.merkez=merkez;
        this.gecikme=gecikme;
    }

    public boolean Giris(String isim, String sifre)
    {
        gecikme.bekleme("Giriş yapılıyor ...","Kullanıcı doğrulanıyor ...");
        merkez.veritabaniBaglan();
        if (merkez.kullanici(isim, sifre))
        {
            merkez.veritabaniKes();
            return true;
        }

        merkez.veritabaniKes();
        return false;
    }

}
