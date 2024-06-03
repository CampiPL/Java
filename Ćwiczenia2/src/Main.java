import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int k, p;
        double count, check;
        String ans, path1, path2;

        Download d = new Download();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe atrybutow");

        p = scanner.nextInt();

        System.out.println("Podaj sciezke pliku treningowego");

        path1 = scanner.next(); //Z:\NAI\Ćwiczenia\Ćwiczenia2\iris\train.txt C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia2\\iris\\train.txt

        List<Iris> train = d.IrisList(path1, p);

        System.out.println("Podaj sciezke pliku testowego");

        path2 = scanner.next(); //Z:\NAI\Ćwiczenia\Ćwiczenia2\iris\test.txt C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia2\\iris\\test.txt

        List<Iris> test = d.IrisList(path2, p);

        count = test.size();
        check = test.size();

        Dis v;
        List<Dis> dis;
        List<String> classes;
        double cor, math;

        classes = train.stream().map(x -> x.name).distinct().collect(Collectors.toList());

        int[] tab = new int[classes.size()];

        System.out.println("Podaj k");
        k = scanner.nextInt();

        for(Iris i : test){

            dis = new ArrayList<>();

            for(int x=0; x<classes.size(); x++)
                tab[x] = 0;

            for(Iris is : train){

                math = 0;

                for(int g=0; g<p; g++)
                    math+=Math.pow(is.par[g]-i.par[g],2);

                cor=Math.sqrt(math);

                v = new Dis(cor,is.name);
                dis.add(v);

            }

            dis = dis.stream().sorted(Comparator.comparingDouble(o -> o.distance)).limit(k).collect(Collectors.toList());

            for(Dis di : dis) {

                System.out.println(di);

                for(int x=0; x<classes.size(); x++) 
                    if (di.iris.equals(classes.get(x)))
                        tab[x]++;

            }

            int maxin = 0;

            for(int x=0; x<classes.size(); x++)
                if(tab[x]>tab[maxin])
                    maxin = x;

            ans = classes.get(maxin);

            if(!ans.equals(i.name))
                check--;

            System.out.println(ans);
            System.out.println();
        }

        System.out.println("Accurecy: " + check/count);

        System.out.println();

        Scanner scan = new Scanner(System.in);
        Scanner sc;
        String value = "";
        Iris i;
        int y;

        while(true){
            sc = new Scanner(scan.next());
            sc.useDelimiter(",");

            i = new Iris(p);
            y = 0;

            System.out.println("Podaj wektor:");

            while (sc.hasNext()) {

                value = sc.next();

                if(value.equals("exit"))
                    return;

                i.addPar(Double.parseDouble(value), y++);

            }

            System.out.println(i);

            dis = new ArrayList<>();

            for(Iris is : train){

                math = 0;

                for(int g=0; g<p; g++)
                    math+=Math.pow(is.par[g]-i.par[g],2);

                cor=Math.sqrt(math);

                v = new Dis(cor,is.name);
                dis.add(v);
            }

            dis = dis.stream().sorted(Comparator.comparingDouble(o -> o.distance)).limit(k).collect(Collectors.toList());

            for(int b=0; b<classes.size(); b++)
                tab[b] = 0;

            for(Dis di : dis) {

                System.out.println(di);

                for(int b=0; b<classes.size(); b++)
                    if(di.iris.equals(classes.get(b)))
                        tab[b]++;
            }

            int maxin = 0;

            for(int b=0; b<classes.size(); b++)
                if(tab[b]>tab[maxin])
                    maxin = b;

            ans = classes.get(maxin);

            System.out.println(ans);
            System.out.println();
        }

    }
}
