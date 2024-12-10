/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatuygulamasısimulasyonu;

/**
 *
 * @author borek
 */
public class Alan implements Runnable {
    private final MesajKuyrugu mesajKuyrugu;

    public Alan(MesajKuyrugu mesajKuyrugu) {
        this.mesajKuyrugu = mesajKuyrugu;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Mesaj alinanMesaj = mesajKuyrugu.mesajAl();
                System.out.println("Mesaj Al: " + alinanMesaj.getIcerik());
                Thread.sleep(1000); // Simülasyon için bekleme süresi
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
