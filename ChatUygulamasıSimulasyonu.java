/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatuygulamasısimulasyonu;
/**
 *
 * @author borek
 */
public class ChatUygulamasıSimulasyonu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MesajKuyrugu mesajKuyrugu = new MesajKuyrugu(10);

        String[] mesajlarGonderici1 = {"Merhaba", "Nasilsin?","Bende iyiyim"};
        String[] mesajlarGonderici2 = {"Selam", "Iyiyim sen nasilsin?", "Allah'a emanet"};

        Thread gonderici1 = new Thread(new Gonderen(mesajKuyrugu, mesajlarGonderici1));
        Thread gonderici2 = new Thread(new Gonderen(mesajKuyrugu, mesajlarGonderici2));
        Thread alici = new Thread(new Alan(mesajKuyrugu));

        gonderici1.start();
        gonderici2.start();
        alici.start();

        try {
            gonderici1.join();
            gonderici2.join();
            alici.interrupt(); // Alici thread'ini durdurmak için
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chat Simulasyonu Tamamlandi.");
    }
    
}
