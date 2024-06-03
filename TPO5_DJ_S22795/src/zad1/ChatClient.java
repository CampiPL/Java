/**
 * @author Depka Jakub S22795
 */

package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ChatClient extends Thread {

    String id;
    StringBuilder chat;
    SocketChannel sc;

    ChatClient(String host, int port, String id) {

        this.id = id;
        this.chat = new StringBuilder("=== " + id + " chat view" + "\n");

        try {
            this.sc = SocketChannel.open(new InetSocketAddress(host, port));
            this.sc.configureBlocking(false);
        } catch (IOException e) {

        }
    }

    void login() {

        this.start();
        this.send("logged in");
    }

    void logout() throws InterruptedException {

        this.send("logged out");
        Thread.sleep(21);
        this.interrupt();
    }

    void send(String req) {

        ByteBuffer bb = Charset.forName("ISO-8859-2").encode(this.id + ": " + req + "STOP");

        try {
            Thread.sleep(37);
            this.sc.write(bb);
        } catch (IOException e) {
            send(req);
        } catch (InterruptedException e) {

        }
    }

    String getChatView() {

        return this.chat.toString().replace("STOP", "\n");
    }

    @Override
    public void run() {

        try {

            while (!isInterrupted()) {

                ByteBuffer bb = ByteBuffer.allocate(256);
                StringBuilder req = new StringBuilder();

                while (this.sc.read(bb) > 0) {

                    bb.flip();
                    req.append(Charset.forName("ISO-8859-2").decode(bb));
                    bb.clear();
                }

                if (!req.toString().isEmpty())
                    this.chat.append(req);

            }

        } catch (IOException e) {

        }

    }

}
