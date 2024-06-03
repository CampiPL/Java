import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int p, out, ans;
        double a, prog = 0, count, check, net;
        String path1, path2;

        Download d = new Download();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj sciezke pliku treningowego");

        path1 = scanner.next(); // Z:\\NAI\\Ćwiczenia\\Ćwiczenia3\\dataforperceptron\\iris_perceptron\\training.txt C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia3\\dataforperceptron\\iris_perceptron\\training.txt

        System.out.println("Podaj sciezke pliku testowego");

        path2 = scanner.next(); // Z:\\NAI\\Ćwiczenia\\Ćwiczenia3\\dataforperceptron\\iris_perceptron\\test.txt C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia3\\dataforperceptron\\iris_perceptron\\test.txt

        System.out.println("Podaj liczbe atrybutow");

        p = scanner.nextInt();

        List<Obs> test = d.ObsList(path2, p);
        List<Obs> train = d.ObsList(path1, p);
        List<String> classes;

        classes = train.stream().map(x -> x.name).distinct().collect(Collectors.toList());

        count = test.size();
        check = test.size();

        double[] w = new double[p];

        for (int j = 0; j < p; j++)
            w[j] = 0;

        System.out.println("Podaj parametr uczenia");

        a = scanner.nextDouble();

        for(int t = 0; t<10000; t++) {
            for (Obs i : train) {

                net = 0;

                if (i.name.equals(classes.get(0)))
                    ans = 1;
                else
                    ans = 0;

                for (int j = 0; j < i.par.length; j++)
                    net += i.par[j] * w[j];

                if (net >= prog)
                    out = 1;
                else
                    out = 0;

                for (int j = 0; j < w.length; j++)
                    w[j] = w[j] + (ans - out) * a * i.par[j];

                prog = prog - (ans - out) * a;

            }
        }

        for (Obs i : test) {

            net = 0;

            if (i.name.equals(classes.get(0)))
                ans = 1;
            else
                ans = 0;

            for (int j = 0; j < i.par.length; j++)
                net += i.par[j] * w[j];

            if (net >= prog)
                out = 1;
            else
                out = 0;

            if (out != ans)
                check--;

            System.out.println(i);
            System.out.println("Answer: " + classes.get(out));
            System.out.println();
        }

        System.out.println("Accuracy: " + check / count);
        System.out.println();

        Scanner sc, scan = new Scanner(System.in);
        Obs o;
        String value;
        int y;

        while(true){

            System.out.println("Podaj wektor:");

            sc = new Scanner(scan.next());
            sc.useDelimiter(",");

            o = new Obs(p);

            y = 0;

            while (sc.hasNext()) {

                value = sc.next();

                if(value.equals("exit"))
                    return;

                o.addPar(Double.parseDouble(value), y++);

            }

            net = 0;

            for (int j = 0; j < o.par.length; j++)
                net += o.par[j] * w[j];

            if (net >= prog)
                out = 1;
            else
                out = 0;

            System.out.println(o);
            System.out.println("Answer: " + classes.get(out));
            System.out.println();
        }

    }
}
