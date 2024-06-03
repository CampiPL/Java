import java.util.Arrays;

public class Obs {

    double[] par;
    String name;

    Obs(int p){
        this.par = new double[p];
    }

    void addPar(double value, int x){
        this.par[x] = value;
    }

    public void setPar(double[] par) {
        this.par = par;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Iris{" +
                "par=" + Arrays.toString(par) +
                ", name='" + name + '\'' +
                '}';
    }
}
