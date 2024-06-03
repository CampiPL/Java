/**
 * @author Depka Jakub S22795
 */

package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChatServer extends Thread {

    static HashMap<String, SocketChannel> clients = new HashMap<>();
    StringBuilder log;
    ServerSocketChannel ssc;
    Selector s;
    {
        try {
            this.s = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ChatServer(String host, int port) {

        this.log = new StringBuilder();

        try {
            this.s = Selector.open();

            this.ssc = ServerSocketChannel.open();
            this.ssc.socket().bind(new InetSocketAddress(host, port));
            this.ssc.configureBlocking(false);

            this.ssc.register(this.s, this.ssc.validOps());

        } catch (IOException e) {

        }

    }

    void startServer() {

        this.start();
        System.out.println("Server started" + "\n");
    }

    void stopServer() throws InterruptedException {

        Thread.sleep(1000);
        this.interrupt();
        System.out.println("Server stopped");
    }

    String getServerLog() {

        return String.valueOf(this.log).replace("STOP", "\n");
    }

    @Override
    public void run() {

        try {

            while (!isInterrupted()) {

                this.s.select();

                Set<SelectionKey> keys = this.s.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {

                    SelectionKey key = it.next();

                    if (key.isAcceptable()) {

                        SocketChannel socketChannel = this.ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(this.s, SelectionKey.OP_READ);
                    }

                    if (key.isReadable()) {

                        SelectableChannel sec = key.channel();
                        SocketChannel soc = (SocketChannel) sec;

                        if (soc.isOpen()) {

                            ByteBuffer bb = ByteBuffer.allocate(256);
                            StringBuilder req = new StringBuilder();

                            while (soc.read(bb) > 0) {

                                bb.flip();
                                req.append(Charset.forName("ISO-8859-2").decode(bb));
                                bb.clear();
                            }

                            if (req.toString().contains("logged in"))
                                clients.put(req.substring(0, req.indexOf(":")), soc);

                            if (req.toString().contains("logged out")) {

                                String id = req.substring(0, req.toString().indexOf(":"));
                                clients.get(id).write(Charset.forName("ISO-8859-2").encode(req.toString().replace(": logged", " logged")));
                                clients.remove(id);
                            }

                            req = new StringBuilder(req.toString().replace(": logged", " logged"));

                            if (!req.toString().isEmpty()) {
                                this.log.append(new SimpleDateFormat("HH:mm:ss.SSS").format(System.currentTimeMillis())).append(" ").append(req);

                                for (Map.Entry<String, SocketChannel> entry : clients.entrySet())
                                    entry.getValue().write(Charset.forName("ISO-8859-2").encode(req.toString()));
                            }

                        }

                    }

                    it.remove();
                }

            }

        } catch (IOException e) {

        }

    }

}