import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Centroid {

    private double[] par;
    private List<Obs> obsList;

    public Centroid(int p) {
        this.par = new double[p];

        for (int i = 0; i < p; i++) {
            this.par[i] = Math.random() * 8;
        }

        this.obsList = new ArrayList<>();
    }

    void addPar(double value, int x){
        this.par[x] = value;
    }

    public double[] getPar() {
        return par;
    }

    public void setPar(double[] par) {
        this.par = par;
    }

    public List<Obs> getObsList() {
        return obsList;
    }

    public void setObsList(List<Obs> obsList) {
        this.obsList = obsList;
    }

    @Override
    public String toString() {
        return "Centroid{" +
                "par=" + Arrays.toString(par) +
                ", obsList=" + obsList +
                '}';
    }
}
