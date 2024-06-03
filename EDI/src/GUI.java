import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    JLabel label1;
    JLabel msg1;
    JLabel msg2;
    JLabel msg3;
    JLabel msg4;
    JLabel msg5;
    JLabel msg6;
    JLabel msg7;
    JLabel info1;
    JLabel info2;
    JLabel info3;
    JLabel info4;
    JLabel info5;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton gmnButton;
    JButton gmoButton;
    JButton mlnButton;
    JButton mloButton;
    JButton restart;
    JButton okGenMode;
    JButton okDeleteFiles;
    JButton okEnd;
    JButton okOpEnd;
    JButton okNoFile;
    JButton usun;
    JButton anuluj;
    JTextField path;
    String opt;
    Log log;

    GUI() {

        this.label1 = new JLabel();

        this.msg1 = new JLabel();

        this.msg2 = new JLabel();

        this.msg3 = new JLabel();

        this.msg4 = new JLabel();

        this.msg5 = new JLabel();

        this.msg6 = new JLabel();

        this.msg7 = new JLabel();


        this.info1 = new JLabel();

        this.info2 = new JLabel();

        this.info3 = new JLabel();

        this.info4 = new JLabel();

        this.info5 = new JLabel();


        this.button1 = new JButton();

        this.button2 = new JButton();

        this.button3 = new JButton();

        this.button4 = new JButton();

        this.button5 = new JButton();

        this.gmnButton = new JButton();

        this.gmoButton = new JButton();

        this.mlnButton = new JButton();

        this.mloButton = new JButton();

        this.restart = new JButton();

        this.okGenMode = new JButton();

        this.okDeleteFiles = new JButton();

        this.okEnd = new JButton();

        this.okOpEnd = new JButton();

        this.okNoFile = new JButton();

        this.usun = new JButton();

        this.anuluj = new JButton();


        this.path = new JTextField();


        this.button1.setFocusable(false);

        this.button2.setFocusable(false);

        this.button3.setFocusable(false);

        this.button4.setFocusable(false);

        this.button5.setFocusable(false);

        this.gmnButton.setFocusable(false);

        this.gmoButton.setFocusable(false);

        this.mlnButton.setFocusable(false);

        this.mloButton.setFocusable(false);

        this.restart.setFocusable(false);

        this.okGenMode.setFocusable(false);

        this.okDeleteFiles.setFocusable(false);

        this.okEnd.setFocusable(false);

        this.okOpEnd.setFocusable(false);

        this.okNoFile.setFocusable(false);

        this.usun.setFocusable(false);

        this.anuluj.setFocusable(false);


        this.button1.setText("Faktury");

        this.button2.setText("Batch");

        this.button3.setText("Użytkownik");

        this.button4.setText("Manual Load");

        this.button5.setText("Wygeneruj pliki");


        this.gmnButton.setText("Nowe dokumenty");

        this.gmoButton.setText("Nadpisanie istniejących dokumentów");

        this.mlnButton.setText("Nowe dokumenty");

        this.mloButton.setText("Nadpisanie istniejących dokumentów");

        this.restart.setText("Restart");

        this.okGenMode.setText("OK");

        this.okDeleteFiles.setText("OK");

        this.okEnd.setText("Zakończ");

        this.okOpEnd.setText("OK");

        this.okNoFile.setText("OK");

        this.usun.setText("Usuń");

        this.anuluj.setText("Anuluj");


        this.label1.setBounds(0, 0, 250, 50);

        this.button1.setBounds(0, 50, 250, 30);

        this.button2.setBounds(0, 100, 250, 30);

        this.button3.setBounds(0, 150, 250, 30);

        this.button4.setBounds(0, 200, 250, 30);

        this.button5.setBounds(0, 250, 250, 30);

        this.gmnButton.setBounds(0, 50, 250, 30);

        this.gmoButton.setBounds(0, 100, 250, 30);

        this.mlnButton.setBounds(0, 50, 250, 30);

        this.mloButton.setBounds(0, 100, 250, 30);

        this.restart.setBounds(480, 390, 85, 30);

        this.okGenMode.setBounds(480, 390, 85, 30);

        this.okDeleteFiles.setBounds(480, 390, 85, 30);

        this.okEnd.setBounds(480, 350, 85, 30);

        this.okOpEnd.setBounds(480, 390, 85, 30);

        this.okNoFile.setBounds(385, 350, 85, 30);

        this.usun.setBounds(480, 350, 85, 30);

        this.anuluj.setBounds(480, 390, 85, 30);


        this.path.setBounds(0, 352, 260, 25);


        this.info1.setBounds(250, 50, 350, 30);

        this.info2.setBounds(250, 100, 350, 30);

        this.info3.setBounds(250, 150, 350, 30);

        this.info4.setBounds(250, 200, 350, 30);

        this.info5.setBounds(250, 250, 350, 30);


        this.msg1.setBounds(0, 330, 500, 15);

        this.msg2.setBounds(0, 350, 500, 15);

        this.msg3.setBounds(0, 370, 500, 15);

        this.msg4.setBounds(0, 390, 500, 15);

        this.msg5.setBounds(0, 410, 500, 15);

        this.msg6.setBounds(0, 430, 500, 15);

        this.msg7.setBounds(0, 450, 500, 15);


        this.button1.addActionListener(e -> {


            clear();

            genInv();

        });


        this.button2.addActionListener(e -> {


            clear();

            genBatch();

        });


        this.button3.addActionListener(e -> {


            clear();

            genUsr();

        });


        this.button4.addActionListener(e -> {


            clear();

            manLoad();

        });


        this.button5.addActionListener(e -> {


            clear();

            genOnly();

        });


        this.gmnButton.addActionListener(e -> {


            clear();

            gmn();

        });


        this.gmoButton.addActionListener(e -> {


            clear();

            gmo();

        });


        this.mlnButton.addActionListener(e -> {


            clear();

            mln();

        });


        this.mloButton.addActionListener(e -> {


            clear();

            mlo();

        });


        this.restart.addActionListener(e -> {

            clear();

            restart();

        });


        this.okGenMode.addActionListener(e -> {

            clear();

            genMode();

        });


        this.okDeleteFiles.addActionListener(e -> {

            clear();

            deleteFiles();

        });


        this.okEnd.addActionListener(e -> {

            clear();

            end();

        });


        this.okOpEnd.addActionListener(e -> {

            clear();

            opEnd();

        });


        this.usun.addActionListener(e -> {

            clear();

            usun();

        });


        this.anuluj.addActionListener(e -> {

            clear();

            anuluj();

        });


        this.okNoFile.addActionListener(e -> {


            if (path.getText().equals(""))
                ;

            else {


                clear();


                switch (opt) {
                    case "INV" -> genInv();
                    case "BATCH" -> genBatch();
                    case "USR" -> genUsr();
                    default -> label1.setText("ERROR");
                }

            }


        });


        this.setTitle("Generator XML");

        this.setIconImage(new ImageIcon("icon.png").getImage());

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setLayout(null);

        this.setResizable(false);

        this.setSize(600, 500);

        this.setVisible(true);

        this.add(this.label1);

        this.add(this.button1);

        this.add(this.button2);

        this.add(this.button3);

        this.add(this.button4);

        this.add(this.button5);

        this.add(this.gmnButton);

        this.add(this.gmoButton);

        this.add(this.mlnButton);

        this.add(this.mloButton);

        this.add(this.restart);

        this.add(this.okGenMode);

        this.add(this.okDeleteFiles);

        this.add(this.okEnd);

        this.add(this.okOpEnd);

        this.add(this.okNoFile);

        this.add(this.usun);

        this.add(this.anuluj);

        this.add(this.path);

        this.add(this.msg1);

        this.add(this.msg2);

        this.add(this.msg3);

        this.add(this.msg4);

        this.add(this.msg5);

        this.add(this.msg6);

        this.add(this.msg7);

        this.add(this.info1);

        this.add(this.info2);

        this.add(this.info3);

        this.add(this.info4);

        this.add(this.info5);


        try {

            this.log = new Log("Log.txt");

        } catch (SecurityException | IOException e) {

            e.printStackTrace();

            this.msg2.setText("UWAGA!!! Nie udało się połączyć z plikiem Log.txt");

            this.log.logger.severe("UWAGA!!! Nie udało się połączyć z plikiem Log.txt");

        }


        this.log.logger.info("***Program wystartowany***");


        clear();


        boolean czy_istnieja = false;


        for (File file : new File(System.getProperty("user.dir")).listFiles())

            if (file.getName().matches(".*.XML") || file.getName().matches("ALPL.*.CMD"))

                czy_istnieja = true;


        if (czy_istnieja) {


            this.okEnd.setVisible(false);


            this.log.logger.info("Znaleziono istniejące pliki XML i CMD.");

            this.msg1.setText("UWAGA! Znalazłem istniejące pliki XML i CMD. Aby kontynuować muszę je usunąć");


            this.usun.setVisible(true);

            this.anuluj.setVisible(true);

        } else

            start();


    }


    void start() {


        this.log.logger.info("MENU główne");


        this.label1.setText("Wybierz tryb generowania dokumentów:");


        this.info1.setText(" - tworzy dokument z pliku ALPL_FAC_EDI_GENDOC.txt");

        this.info2.setText(" - tworzy dokument z pliku ALPL_FAC_EDI_GENBATCH.txt");

        this.info3.setText(" - tworzy i ładuje dokument z ALPL_FAC_EDI_GENUSER.txt");

        this.info4.setText(" - ładuje pliki XML z MANLOAD na WINSCP");

        this.info5.setText(" - tworzy dokumenty z GENDOC.txt i GENBATCH.txt");


        this.label1.setVisible(true);


        this.path.setText(this.opt);


        this.button1.setVisible(true);

        this.button2.setVisible(true);

        this.button3.setVisible(true);

        this.button4.setVisible(true);

        this.button5.setVisible(true);


        this.info1.setVisible(true);

        this.info2.setVisible(true);

        this.info3.setVisible(true);

        this.info4.setVisible(true);

        this.info5.setVisible(true);


    }


    void anuluj() {


        this.log.logger.info("Anulowano usuwanie plików");

        this.log.logger.info("***Koniec programu***");


        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));


            writer.append("\n");


            writer.close();


        } catch (IOException e) {

            this.log.logger.warning("Nie można dodać nowej linii do log");

        }


        System.exit(0);

    }


    void usun() {


        for (File file : new File(System.getProperty("user.dir")).listFiles())

            if (file.getName().matches(".*.XML") || file.getName().matches("ALPL.*.CMD")) {

                file.delete();

                this.log.logger.info("Usunięty plik: " + file.getName());

            }


        this.log.logger.info("Pliki zostały usunięte");


        this.okEnd.setVisible(true);


        start();

    }


    void clear() {


        this.button1.setVisible(false);

        this.button2.setVisible(false);

        this.button3.setVisible(false);

        this.button4.setVisible(false);

        this.button5.setVisible(false);

        this.gmnButton.setVisible(false);

        this.gmoButton.setVisible(false);

        this.mlnButton.setVisible(false);

        this.mloButton.setVisible(false);

        this.restart.setVisible(false);

        this.okGenMode.setVisible(false);

        this.okDeleteFiles.setVisible(false);

        this.okOpEnd.setVisible(false);

        this.okNoFile.setVisible(false);

        this.usun.setVisible(false);

        this.anuluj.setVisible(false);


        this.path.setVisible(false);


        this.label1.setText("");


        this.info1.setText("");

        this.info2.setText("");

        this.info3.setText("");

        this.info4.setText("");

        this.info5.setText("");


        this.msg1.setText("");

        this.msg2.setText("");

        this.msg3.setText("");

        this.msg4.setText("");

        this.msg5.setText("");

        this.msg6.setText("");

        this.msg7.setText("");

    }


    void genInv() {


        String dir;


        if (this.path.getText().equals("")) {

            dir = System.getProperty("user.dir");

            this.log.logger.info("Wybrano opcję \"Faktury\"");

        } else {

            dir = this.path.getText();

            this.log.logger.info("Szukanie pliku w folderze " + dir);

        }


        File[] backup = new File(dir).listFiles();


        if (!new File(dir + "\\ALPL_FAC_EDI_GENDOC.txt").exists()) {

            noFile();

            opt = "INV";

        } else {

            new File(dir + "\\ALPL_FAC_EDI_GENDOC.txt").renameTo(new File(dir + "\\ALPL_FAC_EDI_GENDOC.CMD"));


            boolean error = false;


            this.log.logger.info("Rozpoczynam generowanie plików");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = dir + "\\ALPL_FAC_EDI_GENDOC.CMD";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {


                File[] comp = new File(dir).listFiles();


                List<File> curr = new ArrayList<>();


                boolean czytensam;


                assert comp != null;
                for (File value : comp) {


                    czytensam = false;


                    assert backup != null;
                    for (File file : backup) {


                        if (value.getName().equals(file.getName()))

                            czytensam = true;


                    }


                    if (!czytensam)

                        curr.add(value);


                }


                for (File file : curr)

                    if (file.getName().matches(".*.XML"))

                        this.log.logger.info("Wygenerowano plik " + file.getName());


                this.log.logger.info("Generowanie plików zakończone sukcesem");


                this.msg1.setText("Generowanie plików zakończone sukcesem");


                this.okGenMode.setVisible(true);

            } else {

                this.msg1.setText("Operacja zakończona niepowodzeniem");

                this.log.logger.warning("Operacja zakończona niepowodzeniem");

                this.restart.setVisible(true);

            }


        }


    }


    void genBatch() {


        String dir;


        if (this.path.getText().equals("")) {

            dir = System.getProperty("user.dir");

            this.log.logger.info("Wybrano opcję \"Batch\"");

        } else {

            dir = this.path.getText();

            this.log.logger.info("Szukanie pliku w folderze " + dir);

        }


        File[] backup = new File(dir).listFiles();


        if (!new File(dir + "\\ALPL_FAC_EDI_GENBATCH.txt").exists()) {

            noFile();

            opt = "BATCH";

        } else {

            new File(dir + "\\ALPL_FAC_EDI_GENBATCH.txt").renameTo(new File(dir + "\\ALPL_FAC_EDI_GENBATCH.CMD"));


            boolean error = false;


            this.log.logger.info("Rozpoczynam generowanie plików");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = dir + "\\ALPL_FAC_EDI_GENBATCH.CMD";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {


                File[] comp = new File(dir).listFiles();


                List<File> curr = new ArrayList<>();


                boolean czytensam;


                for (File value : comp) {


                    czytensam = false;


                    for (File file : backup) {


                        if (value.getName().equals(file.getName()))

                            czytensam = true;


                    }


                    if (!czytensam)

                        curr.add(value);


                }


                for (File file : curr)

                    if (file.getName().matches(".*.XML"))

                        this.log.logger.info("Wygenerowano plik " + file.getName());


                this.log.logger.info("Generowanie plików zakończone");


                this.msg1.setText("Operacja zakończona sukcesem");


                this.okGenMode.setVisible(true);

            } else {

                this.log.logger.warning("Problem z wygenerowaniem plików");

                this.msg1.setText("Problem z wygenerowaniem plików");

                this.restart.setVisible(true);

            }


        }


    }


    void genUsr() {


        this.log.logger.info("Wybrano opcję \"Użytkownik\"");


        String dir;


        if (this.path.getText().equals("")) {

            dir = System.getProperty("user.dir");

            this.log.logger.info("Wybrano opcję \"Użytkownik\"");

        } else {

            dir = this.path.getText();

            this.log.logger.info("Szukanie pliku w folderze " + dir);

        }


        File[] backup = new File(dir).listFiles();


        if (!new File(dir + "\\ALPL_FAC_EDI_GENUSER.txt").exists()) {

            noFile();

            opt = "USR";

        } else {

            boolean error = false;


            String str;


            str = LocalDateTime.now().toString().replace('-', ' ').replace('T', ' ').replace(':', ' ').substring(0, 19);


            String[] tab = str.split(" ");


            str = "";


            for (String string : tab)

                str += string;


            new File(dir + "\\ALPL_FAC_EDI_GENUSER.txt").renameTo(new File(dir + "\\USERS_" + str + ".XML"));


            this.log.logger.info("Następuje załadowanie pliku przez SFTP");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = "winscp.com /ini=nul /script=" + dir + "\\UPLOAD_USER.txt";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (error) {

                this.msg1.setText("Problem z wygenerowaniem lub wysłaniem plików");

                this.log.logger.warning("Problem z wygenerowaniem lub wysłaniem plików");


                this.restart.setVisible(true);

            } else {


                File[] comp = new File(dir).listFiles();


                List<File> curr = new ArrayList<>();


                boolean czytensam;


                for (File value : comp) {


                    czytensam = false;


                    for (File file : backup) {


                        if (value.getName().equals(file.getName()))

                            czytensam = true;


                    }


                    if (!czytensam)

                        curr.add(value);


                }


                for (File file : curr)

                    if (file.getName().matches(".*.XML"))

                        this.log.logger.info("Wygenerowano plik " + file.getName());


                this.log.logger.info("Generowanie i załadowanie plików zakończone sukcesem");


                this.msg1.setText("Generowanie i załadowanie plików zakończone sukcesem");


                this.okOpEnd.setVisible(true);

            }


        }


    }


    void manLoad() {


        this.log.logger.info("Wybrano opcję \"Manual Load\"");


        int fileExist = 0;


        try {

            for (File file : new File("MANLOAD").listFiles())

                if (file.getName().matches(".*.XML")) {

                    fileExist = 1;

                    this.log.logger.info("Plik do przesłania: " + file.getName());

                }

        } catch (NullPointerException e) {

            this.log.logger.warning("Folder MANLOAD może być pusty lub nie istnieć");

        }


        if (fileExist == 1) {

            this.log.logger.info("Program znalazł plik .XML");

            clear();

            mlsftp();

        } else

            nf_ml();


    }


    void genOnly() {


        this.log.logger.info("Wybrano opcję \"Wygeneruj pliki\"");


        File[] backup = new File(System.getProperty("user.dir")).listFiles();


        boolean error = false;


        if (new File(System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENDOC.txt").exists()) {


            this.log.logger.info("Generowanie z pliku ALPL_FAC_EDI_GENDOC.txt");


            new File(System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENDOC.txt").renameTo(new File(System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENDOC.CMD"));


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENDOC.CMD";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {


                File[] comp = new File(System.getProperty("user.dir")).listFiles();


                List<File> curr = new ArrayList<>();


                boolean czytensam;


                for (File value : comp) {


                    czytensam = false;


                    for (File file : backup) {


                        if (value.getName().equals(file.getName()))

                            czytensam = true;


                    }


                    if (!czytensam)

                        curr.add(value);


                }


                for (File file : curr)

                    if (file.getName().matches(".*.XML"))

                        this.log.logger.info("Wygenerowano plik " + file.getName());


                this.msg1.setText("Generowanie plików z ALPL_FAC_EDI_GENDOC.txt zakończone sukcesem");

                this.log.logger.info("Generowanie plików z ALPL_FAC_EDI_GENDOC.txt zakończone sukcesem");


                this.msg3.setText("Pliki zostaly wygenerowane i sa gotowe do edycji");

                this.msg4.setText("Po zakonczonej edycji wgraj pliki do katalogu C:\\EDI\\MANLOAD");

                this.msg5.setText("Nastepnie uruchom program z opcja [M/m] Manual load");

                this.msg6.setText("! ! ! UWAGA - nie przeniesienie plikow spowoduje ich skasowanie");

                this.msg7.setText("przy nastepnym uruchomieniu generatora.");

            } else {

                this.msg1.setText("Problem z wygenerowaniem plików z ALPL_FAC_EDI_GENDOC.txt");

                this.log.logger.warning("Problem z wygenerowaniem plików z ALPL_FAC_EDI_GENDOC.txt");

            }


        } else {

            this.msg1.setText("Brak pliku ALPL_FAC_EDI_GENDOC.txt");

            this.log.logger.warning("Brak pliku ALPL_FAC_EDI_GENDOC.txt");

        }


        backup = new File(System.getProperty("user.dir")).listFiles();


        error = false;


        if (new File(System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENBATCH.txt").exists()) {


            new File(System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENBATCH.txt").renameTo(new File(System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENBATCH.CMD"));


            this.log.logger.info("Generowanie z pliku ALPL_FAC_EDI_GENBATCH.txt");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = System.getProperty("user.dir") + "\\ALPL_FAC_EDI_GENBATCH.CMD";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {


                File[] comp = new File(System.getProperty("user.dir")).listFiles();


                List<File> curr = new ArrayList<>();


                boolean czytensam;


                for (File value : comp) {


                    czytensam = false;


                    for (File file : backup) {


                        if (value.getName().equals(file.getName()))

                            czytensam = true;


                    }


                    if (!czytensam)

                        curr.add(value);


                }


                for (File file : curr)

                    if (file.getName().matches(".*.XML"))

                        this.log.logger.info("Wygenerowano plik " + file.getName());


                this.msg2.setText("Generowanie plików z ALPL_FAC_EDI_GENBATCH.txt zakończone sukcesem");

                this.log.logger.info("Generowanie plików z ALPL_FAC_EDI_GENBATCH.txt zakończone sukcesem");


                this.msg3.setText("Pliki zostaly wygenerowane i sa gotowe do edycji");

                this.msg4.setText("Po zakonczonej edycji wgraj pliki do katalogu C:\\EDI\\MANLOAD");

                this.msg5.setText("Nastepnie uruchom program z opcja [M/m] Manual load");

                this.msg6.setText("! ! ! UWAGA - nie przeniesienie plikow spowoduje ich skasowanie");

                this.msg7.setText("przy nastepnym uruchomieniu generatora.");

            } else {

                this.msg2.setText("Problem z wygenerowaniem plików z ALPL_FAC_EDI_GENBATCH.txt");

                this.log.logger.warning("Problem z wygenerowaniem plików z ALPL_FAC_EDI_GENBATCH.txt");

            }


        } else {

            this.msg2.setText("Brak pliku ALPL_FAC_EDI_GENBATCH.txt");

            this.log.logger.warning("Brak pliku ALPL_FAC_EDI_GENBATCH.txt");


        }


        this.restart.setVisible(true);

    }


    void genMode() {


        this.gmnButton.setVisible(true);

        this.gmoButton.setVisible(true);


        this.label1.setText("Wybierz tryb przetwarzania dokumentów:");

    }


    void mlsftp() {


        this.mlnButton.setVisible(true);

        this.mloButton.setVisible(true);


        this.label1.setText("Wybierz tryb przetwarzania dokumentów:");


    }


    void gmn() {


        this.log.logger.info("Wybrano opcję \"Nowe dokumenty\"");


        boolean czy_exist = false;


        for (File file : new File(System.getProperty("user.dir")).listFiles())

            if (file.getName().matches(".*.XML"))

                czy_exist = true;


        if (!czy_exist) {


            this.log.logger.warning("Brak plików do przesłania");

            this.msg1.setText("Brak plików do przesłania");


            this.restart.setVisible(true);

        } else {

            boolean error = false;


            this.log.logger.info("Następuje załadowanie pliku przez SFTP");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = "winscp.com /ini=nul /script=" + System.getProperty("user.dir") + "\\UPLOAD_GMN.txt";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {

                this.msg1.setText("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.log.logger.info("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.okOpEnd.setVisible(true);

            } else {

                this.log.logger.warning("Problem z wysłaniem plików");

                this.msg1.setText("Problem z wysłaniem plików");

                this.restart.setVisible(true);

            }


        }


    }


    void gmo() {


        this.log.logger.info("Wybrano opcję \"Nadpisanie istniejacych dokumentów\"");


        boolean czy_exist = false;


        for (File file : new File(System.getProperty("user.dir")).listFiles())

            if (file.getName().matches(".*.XML"))

                czy_exist = true;


        if (!czy_exist) {


            this.log.logger.warning("Brak plików do przesłania");

            this.msg1.setText("Brak plików do przesłania");


            this.restart.setVisible(true);

        } else {

            boolean error = false;


            this.log.logger.info("Następuje załadowanie pliku przez SFTP");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = "winscp.com /ini=nul /script=" + System.getProperty("user.dir") + "\\UPLOAD_GMO.txt";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {

                this.msg1.setText("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.log.logger.info("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.okOpEnd.setVisible(true);

            } else {

                this.log.logger.warning("Problem z wysłaniem plików");

                this.msg1.setText("Problem z wysłaniem plików");

                this.restart.setVisible(true);

            }


        }


    }


    void mln() {


        this.log.logger.info("Wybrano opcję \"Nowe dokumenty\"");


        boolean czy_exist = false, error = false;


        try {


            for (File file : new File("MANLOAD").listFiles())

                if (file.getName().matches(".*.XML"))

                    czy_exist = true;


        } catch (NullPointerException e) {

            error = true;

        }


        if (error) {

            this.log.logger.warning("Folder MANLOAD może nie istnieć lub być pusty");

            this.msg1.setText("Folder MANLOAD może nie istnieć lub być pusty");


            this.restart.setVisible(true);

        } else if (!czy_exist) {


            this.log.logger.warning("Brak plików do przesłania");

            this.msg1.setText("Brak plików do przesłania");


            this.restart.setVisible(true);

        } else {


            this.log.logger.info("Następuje załadowanie pliku przez SFTP");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = "winscp.com /ini=nul /script=" + System.getProperty("user.dir") + "\\UPLOAD_MLN.txt";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {

                this.msg1.setText("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.log.logger.info("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.okOpEnd.setVisible(true);

            } else {

                this.log.logger.warning("Problem z wysłaniem plików");

                this.msg1.setText("Problem z wysłaniem plików");

                this.restart.setVisible(true);

            }


        }


    }


    void mlo() {


        this.log.logger.info("Wybrano opcję \"Nadpisanie istniejacych dokumentów\"");


        boolean czy_exist = false, error = false;


        try {


            for (File file : new File("MANLOAD").listFiles())

                if (file.getName().matches(".*.XML"))

                    czy_exist = true;


        } catch (NullPointerException e) {

            error = true;

        }


        if (error) {

            this.log.logger.warning("Folder MANLOAD może nie istnieć lub być pusty");

            this.msg1.setText("Folder MANLOAD może nie istnieć lub być pusty");


            this.restart.setVisible(true);

        } else if (!czy_exist) {


            this.log.logger.warning("Brak plików do przesłania");

            this.msg1.setText("Brak plików do przesłania");


            this.restart.setVisible(true);

        } else {


            this.log.logger.info("Następuje załadowanie pliku przez SFTP");


            try {

                Runtime rt = Runtime.getRuntime();

                String commands = "winscp.com /ini=nul /script=" + System.getProperty("user.dir") + "\\UPLOAD_MLO.txt";

                Process proc = rt.exec(commands);


                BufferedReader stdInput = new BufferedReader(new

                        InputStreamReader(proc.getInputStream()));


                BufferedReader stdError = new BufferedReader(new

                        InputStreamReader(proc.getErrorStream()));


                String s;


                s = stdInput.readLine();


                if (s != null) {


                    log.logger.info("INFO LOG");


                    while ((s = stdInput.readLine()) != null)

                        log.logger.info(s);


                }


                s = stdError.readLine();


                if (s != null) {


                    log.logger.info("ERROR LOG");


                    while ((s = stdError.readLine()) != null)

                        log.logger.warning(s);


                }


            } catch (IOException e) {

                error = true;

            }


            if (!error) {

                this.msg1.setText("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.log.logger.info("Załadowanie pliku przez SFTP zakończone sukcesem");

                this.okOpEnd.setVisible(true);

            } else {

                this.log.logger.warning("Problem z wygenerowaniem plików");

                this.msg1.setText("Problem z wygenerowaniem plików");

                this.restart.setVisible(true);

            }


        }


    }


    void nf_ml() {


        this.log.logger.warning("Nie znaleziono plików do wysyłki");


        this.msg1.setText("Nie znaleziono plików do wysyłki");


        this.restart.setVisible(true);


    }


    void noFile() {


        this.log.logger.warning("Nie znaleziono pliku źródłowego z Business Objects");


        this.label1.setText("Nie znaleziono pliku źródłowego");

        this.msg1.setText("Podaj ścieżkę folderu do przeszukania:");

        this.msg4.setText("Przeszukany folder:");


        if (this.path.getText().equals(""))

            this.msg5.setText(System.getProperty("user.dir"));

        else

            this.msg5.setText(this.path.getText());


        this.path.setText("");

        this.path.setVisible(true);

        this.okNoFile.setVisible(true);

        this.restart.setVisible(true);

    }


    void opEnd() {


        this.msg1.setText("Operacja zakończona, tymczasowe pliki TXT/CMD i \\MANLOAD\\XML zostaną usunięte");


        this.okDeleteFiles.setVisible(true);

    }


    void deleteFiles() {


        this.log.logger.info("Usuwanie plików");


        for (File file : new File(System.getProperty("user.dir")).listFiles()) {


            if (file.getName().matches("ALPL.*.CMD") || file.getName().matches("ALPL.*.TXT")) {

                file.delete();

                this.log.logger.info("Plik " + file.getName() + " został usunięty");

            }


        }


        try {


            for (File f : new File("MANLOAD").listFiles()) {


                if (f.getName().matches(".*.XML")) {

                    f.delete();

                    this.log.logger.info("Plik " + f.getName() + " został usunięty");

                }


            }


        } catch (NullPointerException e) {

            this.msg1.setText("Folder MANLOAD może nie istnieć lub być pusty");

            this.log.logger.severe("Folder MANLOAD może nie istnieć lub być pusty");

        }


        this.msg1.setText("Usuwanie plików zakończone");

        this.log.logger.info("Usuwanie plików zakończone");


        this.restart.setVisible(true);

    }


    void end() {


        this.log.logger.info("Program kończy działanie");


        deleteFiles();


        this.log.logger.info("***Koniec programu***");


        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));


            writer.append("\n");


            writer.close();


        } catch (IOException e) {

            this.log.logger.warning("Nie można dodać nowej linii do log");

        }


        System.exit(0);

    }


    void restart() {


        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));


            writer.append("\n");


            writer.close();


        } catch (IOException e) {

            this.log.logger.warning("Nie można dodać nowej linii do log");

        }


        this.log.logger.info("Powrót do MENU głównego");


        this.label1.setText("Wybierz tryb generowania dokumentów:");


        this.info1.setText(" - tworzy dokument z pliku ALPL_FAC_EDI_GENDOC.txt");

        this.info2.setText(" - tworzy dokument z pliku ALPL_FAC_EDI_GENBATCH.txt");

        this.info3.setText(" - tworzy i ładuje dokument z ALPL_FAC_EDI_GENUSER.txt");

        this.info4.setText(" - ładuje pliki XML z MANLOAD na WINSCP");

        this.info5.setText(" - tworzy dokumenty z GENDOC.txt i GENBATCH.txt");


        this.label1.setVisible(true);


        this.path.setText("");


        this.button1.setVisible(true);

        this.button2.setVisible(true);

        this.button3.setVisible(true);

        this.button4.setVisible(true);

        this.button5.setVisible(true);


        this.info1.setVisible(true);

        this.info2.setVisible(true);

        this.info3.setVisible(true);

        this.info4.setVisible(true);

        this.info5.setVisible(true);


        this.msg1.setVisible(true);

        this.msg2.setVisible(true);

        this.msg3.setVisible(true);

        this.msg4.setVisible(true);

        this.msg5.setVisible(true);

    }

}