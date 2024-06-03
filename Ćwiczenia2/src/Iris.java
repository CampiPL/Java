import java.util.Arrays;

public class Iris {

    double[] par;
    String name;

    public Iris(int p) {

        this.par = new double[p];
    }

    public void setName(String name) {
        this.name = name;
    }

    void addPar(double par, int x){

        this.par[x] = par;
    }

    @Override
    public String toString() {
        return "Iris{" +
                "par=" + Arrays.toString(par) +
                ", name='" + name + '\'' +
                '}';
    }
}
