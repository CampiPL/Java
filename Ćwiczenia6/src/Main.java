import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int p = 3, K, it = 1;
        String path;

        Download d = new Download();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj sciezke folderu");

        path = scanner.next(); // Z:\\NAI\\Ćwiczenia\\Ćwiczenia6\\iris\\train.txt C:\\Users\\Asus-komputer\\Desktop\\Studia\\NAI\\Ćwiczenia\\Ćwiczenia6\\iris\\train.txt

        System.out.println("Podaj K");

        K = scanner.nextInt();

        List<Obs> train = d.ObsList(path, p);
        List<Centroid> cent = null;
        List<String> classes;

        classes = train.stream().map(Obs::getName).distinct().collect(Collectors.toList());

        boolean check = true;
        double c, dist;
        double[] loc, ir = new double[classes.size()];
        List<List<Obs>> l = new ArrayList<>();

        while (check) {

            cent = new ArrayList<>();

            check = false;

            for (int i = 0; i < K; i++)
                cent.add(new Centroid(p));

            for (Obs obs : train) {

                dist = 0;

                for (int i = 0; i < obs.getPar().length; i++)
                    dist += Math.pow(obs.getPar()[i] - cent.get(0).getPar()[i], 2);

                dist = Math.sqrt(dist);

                obs.setDist(dist);

                for (int i = 1; i < K; i++) {

                    dist = 0;

                    for (int j = 0; j < obs.getPar().length; j++)
                        dist += Math.pow(obs.getPar()[j] - cent.get(i).getPar()[j], 2);

                    dist = Math.sqrt(dist);

                    if (dist < obs.getDist())
                        obs.setDist(dist);

                }

                for (int i = 0; i < K; i++) {

                    dist = 0;

                    for (int j = 0; j < obs.getPar().length; j++)
                        dist += Math.pow(obs.getPar()[j] - cent.get(i).getPar()[j], 2);

                    dist = Math.sqrt(dist);

                    if (dist == obs.getDist()) {
                        cent.get(i).getObsList().add(obs);
                        break;
                    }

                }
            }

            for (int i = 0; i < K; i++)
                if (cent.get(i).getObsList().size() == 0) {
                    check = true;
                    break;
                }
        }

        loc = new double[p];

        for (int i = 0; i < K; i++) {

            Arrays.fill(loc, 0);

            for (int j = 0; j < p; j++) {

                for (int x = 0; x < cent.get(i).getObsList().size(); x++)
                    loc[j] += cent.get(i).getObsList().get(x).getPar()[j];

                loc[j] /= cent.get(i).getObsList().size();
            }

            for (int j = 0; j < cent.get(i).getPar().length; j++) {

                cent.get(i).getPar()[j] = loc[j];
            }
        }

        for (int i = 0; i < K; i++) {

            Arrays.fill(ir,0);
            dist = 0;

            for (int j = 0; j < cent.get(i).getObsList().size(); j++) {
                dist += Math.pow(cent.get(i).getObsList().get(j).getDist(), 2);

                for (int x = 0; x < classes.size(); x++)
                    if(cent.get(i).getObsList().get(j).getName().equals(classes.get(x)))
                        ir[x]++;

            }

        }

        for (int i = 0; i < K; i++) {
            l.add(cent.get(i).getObsList());
        }

        check = true;

        while (check) {

            System.out.println("Iteretion " + it++ + "\n");

            check = false;

            for (Centroid centroid : cent) {
                centroid.setObsList(new ArrayList<>());
            }

            for (Obs obs : train) {

                dist = 0;

                for (int i = 0; i < obs.getPar().length; i++)
                    dist += Math.pow(obs.getPar()[i] - cent.get(0).getPar()[i], 2);

                dist = Math.sqrt(dist);

                obs.setDist(dist);

                for (int i = 1; i < K; i++) {

                    dist = 0;

                    for (int j = 0; j < obs.getPar().length; j++)
                        dist += Math.pow(obs.getPar()[j] - cent.get(i).getPar()[j], 2);

                    dist = Math.sqrt(dist);

                    if (dist < obs.getDist())
                        obs.setDist(dist);

                }

                for (int i = 0; i < K; i++) {

                    dist = 0;

                    for (int j = 0; j < obs.getPar().length; j++)
                        dist += Math.pow(obs.getPar()[j] - cent.get(i).getPar()[j], 2);

                    dist = Math.sqrt(dist);

                    if (dist == obs.getDist())
                        cent.get(i).getObsList().add(obs);

                }
            }

            for (int i = 0; i < K; i++)
                if (!cent.get(i).getObsList().equals(l.get(i))) {
                    check = true;
                    break;
                }

            for (int i = 0; i < K; i++) {

                Arrays.fill(loc, 0);

                for (int j = 0; j < p; j++) {

                    for (int x = 0; x < cent.get(i).getObsList().size(); x++)
                        loc[j] += cent.get(i).getObsList().get(x).getPar()[j];

                    loc[j] /= cent.get(i).getObsList().size();
                }

                for (int j = 0; j < cent.get(i).getPar().length; j++) {

                    cent.get(i).getPar()[j] = loc[j];
                }

            }

            for (int i = 0; i < K; i++) {

                Arrays.fill(ir,0);
                dist = 0;

                c = cent.get(i).getObsList().size();

                for (int j = 0; j < cent.get(i).getObsList().size(); j++) {
                    dist += Math.pow(cent.get(i).getObsList().get(j).getDist(), 2);

                    for (int x = 0; x < classes.size(); x++)
                        if (cent.get(i).getObsList().get(j).getName().equals(classes.get(x)))
                            ir[x]++;
                }

                System.out.println("Cent " + i);
                System.out.println("Dist: " + dist);
                for (int j = 0; j < classes.size(); j++)
                    System.out.println(classes.get(j) + ": " + ir[j]/c * 100 + "%");

                System.out.println();

            }

            l = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                l.add(cent.get(i).getObsList());
            }

        }

    }
}
