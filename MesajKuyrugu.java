/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatuygulamasısimulasyonu;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author borek
 */
public class MesajKuyrugu {
    private final Queue<Mesaj> kuyruk = new LinkedList<>();
    private final int kapasite;

    public MesajKuyrugu(int kapasite) {
        this.kapasite = kapasite;
    }

    public synchronized void mesajGonder(Mesaj mesaj) throws InterruptedException {
        while (kuyruk.size() == kapasite) {
            wait();
        }
        kuyruk.add(mesaj);
        notifyAll();
    }

    public synchronized Mesaj mesajAl() throws InterruptedException {
        while (kuyruk.isEmpty()) {
            wait();
        }
        Mesaj mesaj = kuyruk.poll();
        notifyAll();
        return mesaj;
    }
}
