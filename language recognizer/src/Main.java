import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int lang;
        String path1, path2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj sciezke folderu treningowego");

        path1 = scanner.next(); // Z:\\NAI\\Ćwiczenia\\Ćwiczenia4\\data\\train C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia4\\data\\train

        System.out.println("Podaj sciezke folderu testowego");

        path2 = scanner.next(); // Z:\\NAI\\Ćwiczenia\\Ćwiczenia4\\data\\test C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia4\\data\\test

        lang = Objects.requireNonNull(new File(path1).listFiles(File::isDirectory)).length;

        List<String> langnames = Objects.requireNonNull(Arrays.stream(Objects.requireNonNull(new File(path1).
                listFiles(File::isDirectory))).map(File::getName).collect(Collectors.toList()));

        //System.out.println("Language count: " + lang);

        List<Perceptron> plist = new ArrayList<>();

        for (String lan : langnames)
            plist.add(new Perceptron(lan));

        for(int i=0; i<100; i++)
        for (File dir : Objects.requireNonNull(new File(path1).listFiles(File::isDirectory))) {

            for (Perceptron p : plist) {
                //System.out.println("Perceptron lan: " + p.lan);
                p.learn(dir);
                //System.out.println("Perceptron " + p.lan + " learned language " + dir.getName());
            }
        }

        double[] out = new double[lang];
        int count, c;

        for (File dir : Objects.requireNonNull(new File(path2).listFiles(File::isDirectory))) {

            for (File file : Objects.requireNonNull(dir.listFiles())) {

                //System.out.println("Testing language " + dir.getName());

                c=0;

                for (Perceptron p : plist) {
                    out[c++] = p.test(file, dir.getName());
                }


                count = 0;

                //for (double i : out)
                //    System.out.println(i);

                for (double i : out)
                    if (i != 0)
                        count++;

                if (count == 0)
                    System.out.println("Language not recognized in " + file.getName());
                else if (count == 1) {
                    for (int i = 0; i < out.length; i++)
                        if (out[i] != 0)
                            System.out.println("Language in " + file.getName() + " is " + plist.get(i).lan);
                } else {
                    double maximum = 0;

                    for (double i : out)
                        if (i > maximum)
                            maximum = i;

                    for (int i = 0; i < out.length; i++)
                        if (out[i] == maximum)
                            System.out.println("Language in " + file.getName() + " is " + plist.get(i).lan);
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        String value;

        while (true) {
            System.out.println("Podaj tekst:");

            value = scan.nextLine();

            if (value.equals("exit"))
                return;

            c = 0;

            for (Perceptron p : plist) {
                out[c++] = p.test(value);
            }

            count = 0;

            //for (double i : out)
            //    System.out.println(i);

            for (double i : out)
                if (i != 0)
                    count++;

            if (count == 0)
                System.out.println("Language not recognized");
            else if (count == 1) {
                for (int i = 0; i < out.length; i++)
                    if (out[i] != 0)
                        System.out.println("Language is " + plist.get(i).lan);
            } else {
                double maximum = 0;

                for (double i : out)
                    if (i > maximum)
                        maximum = i;

                for (int i = 0; i < out.length; i++)
                    if (out[i] == maximum)
                        System.out.println("Language is " + plist.get(i).lan);
            }

        }

    }
}
