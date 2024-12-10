/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatuygulamasısimulasyonu;

/**
 *
 * @author borek
 */
public class Gonderen implements Runnable {
    private final MesajKuyrugu mesajKuyrugu;
    private final String[] mesajlar;

    public Gonderen(MesajKuyrugu mesajKuyrugu, String[] mesajlar) {
        this.mesajKuyrugu = mesajKuyrugu;
        this.mesajlar = mesajlar;
    }

    @Override
    public void run() {
        try {
            for (String mesaj : mesajlar) {
                Mesaj yeniMesaj = new Mesaj(mesaj);
                mesajKuyrugu.mesajGonder(yeniMesaj);
                System.out.println("Mesaj Gonderildi: " + mesaj);
                Thread.sleep(1000); // Simülasyon için bekleme süresi
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
