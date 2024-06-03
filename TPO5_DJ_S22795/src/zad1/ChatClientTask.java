/**
 * @author Depka Jakub S22795
 */

package zad1;

import java.util.List;
import java.util.concurrent.*;

public class ChatClientTask implements Runnable {

    ChatClient c;
    List<String> msgs;
    int wait;

    ChatClientTask(ChatClient c, List<String> msgs, int wait) {

        this.c = c;
        this.msgs = msgs;
        this.wait = wait;
    }

    void get() throws InterruptedException, ExecutionException {
        // this.start();
    }

    static ChatClientTask create(ChatClient c, List<String> msgs, int wait) {

        return new ChatClientTask(c, msgs, wait);
    }

    ChatClient getClient() {

        return this.c;
    }

    @Override
    public void run() {

        try {

            this.c.login();

            if (this.wait != 0)
                Thread.sleep(this.wait);

            for (String req : this.msgs) {

                this.c.send(req);

                if (this.wait != 0)
                    Thread.sleep(this.wait);

            }

            this.c.logout();

            if (this.wait != 0)
                Thread.sleep(this.wait);

        } catch (InterruptedException e) {

        }

    }

}
