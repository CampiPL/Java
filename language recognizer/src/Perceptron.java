import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Perceptron {

    String lan;
    double[] w;
    double teta;
    Download d;

    public Perceptron(String lan) {

        this.lan = lan;
        this.d = new Download();
        this.w = new double[26];
        this.teta = 0;

        for (int i = 0; i < 26; i++)
            this.w[i] = 0;
    }

    public void learn(File dir) {

        Obs obs;
        double net;
        int out, ans;

        for (File file : Objects.requireNonNull(dir.listFiles())) {

            obs = d.observe(file.getPath());

            net = 0;

            if (dir.getName().equals(this.lan))
                ans = 1; // badany jezyk jest jezykiem perceptrona
            else
                ans = 0; //badany jezyk nie jest jezykiem perceptrona

            for (int j = 0; j < obs.freq.length; j++)
                net += obs.freq[j] * this.w[j];

            if (net >= this.teta)
                out = 1; // badany jezyk jest jezykiem perceptrona
            else
                out = 0; //badany jezyk nie jest jezykiem perceptrona

            //System.out.println("ans: " + ans);
            //System.out.println("out: " + out);

            for (int j = 0; j < obs.freq.length; j++)
                this.w[j] = this.w[j] + (ans - out) * obs.freq[j];

            this.teta = this.teta - (ans - out);

            //System.out.println(file.getName() + " " + this.lan + " " + this.teta);
            //System.out.println("ans = " + ans + ", out = " + out);
            //System.out.println(Arrays.toString(this.w));
        }
    }

    public double test(File file, String lang) {

        Obs obs;
        double net;
        int out;

        obs = d.observe(file.getPath());

        net = 0;

        //System.out.println("Perceptron lan: " + this.lan);

        for (int j = 0; j < obs.freq.length; j++) {
            //System.out.println("w[" + j + "]: " + this.w[j]);
            net += obs.freq[j] * this.w[j];
        }

        //System.out.println("net: " + net);
        //System.out.println("teta: " + this.teta);

        if (net >= this.teta)
            out = 1;
        else
            out = 0;

        if (out == 1)
            return net;
        else
            return 0;
    }

    public double test(String value) {

        double net;
        int out, ans;

        Scanner scan = new Scanner(value);

        scan.useDelimiter("\n\r");

        String v;
        Scanner sc, s;
        int total = 0;

        while (scan.hasNext()) {

            sc = new Scanner(scan.next());
            sc.useDelimiter("[^A-z]");

            while (sc.hasNext()) {

                s = new Scanner(sc.next());
                s.useDelimiter("\s");

                while (s.hasNext()) {

                    v = s.next();

                    for (char c : v.toCharArray())
                        total++;
                }
            }
        }

        Obs obs = new Obs(total);

        scan = new Scanner(value);

        scan.useDelimiter("\n\r");

        while (scan.hasNext()) {

            sc = new Scanner(scan.next());
            sc.useDelimiter("[^A-z]");

            while (sc.hasNext()) {

                s = new Scanner(sc.next());
                s.useDelimiter("\s");

                while (s.hasNext()) {

                    v = s.next();

                    v = v.toUpperCase();

                    for (char c : v.toCharArray()) {

                        for (int i = 0; i < 26; i++)
                            if (c == (char) (i + 65))
                                obs.add(i);
                    }
                }
            }
        }

        obs.countFreq();

        net = 0;

        //System.out.println("Perceptron lan: " + this.lan);

        for (int j = 0; j < obs.freq.length; j++) {
            //System.out.println("w[" + j + "]: " + this.w[j]);
            net += obs.freq[j] * this.w[j];
        }

        //System.out.println("net: " + net);
        //System.out.println("teta: " + this.teta);

        if (net >= this.teta)
            out = 1;
        else
            out = 0;

        if (out == 1)
            return net;
        else
            return 0;
    }
}
