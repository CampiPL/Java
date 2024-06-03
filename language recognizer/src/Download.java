import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Download {

    Obs observe(String nazwaPliku) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File(nazwaPliku));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scan.useDelimiter("\n\r");

        String value;
        Scanner sc, s;
        int total = 0;

        while (scan.hasNext()) {

            sc = new Scanner(scan.next());
            sc.useDelimiter("[^A-z]");

            while (sc.hasNext()) {

                s = new Scanner(sc.next());
                s.useDelimiter("\s");

                while (s.hasNext()) {

                    value = s.next();

                    for (char c : value.toCharArray())
                        total++;
                }
            }
        }

        Obs obs = new Obs(total);

        try {
            scan = new Scanner(new File(nazwaPliku));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scan.useDelimiter("\n\r");

        while (scan.hasNext()) {

            sc = new Scanner(scan.next());
            sc.useDelimiter("[^A-z]");

            while (sc.hasNext()) {

                s = new Scanner(sc.next());
                s.useDelimiter("\s");

                while (s.hasNext()) {

                    value = s.next();

                    value = value.toUpperCase();

                    for (char c : value.toCharArray()) {

                        for (int i = 0; i < 26; i++)
                            if (c == (char) (i + 65))
                                obs.add(i);
                    }
                }
            }
        }

        obs.countFreq();

        return obs;
    }

}