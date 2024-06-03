import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Download {

    List<Obs> ObsList(String nazwaPliku, int p) {
        List<Obs> iList = new ArrayList<>();

        Scanner scan = null;
        try {
            scan = new Scanner(new File(nazwaPliku));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert scan != null;
        scan.useDelimiter("\n");

        String value;

        while (scan.hasNext()) {
            Scanner sc = new Scanner(scan.next());
            sc.useDelimiter(",");
            Obs obs = new Obs(p);
            int x=0;

            while (sc.hasNext()) {

                value = sc.next();

                if (x<p)
                    obs.addPar(Double.parseDouble(value), x);
                else
                    obs.setName(value);

                x++;
            }
            iList.add(obs);
        }
        return iList;
    }
}