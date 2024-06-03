import java.util.Arrays;

public class Obs {

    private double[] par;
    private String name;
    private Double dist;

    Obs(int p){
        this.par = new double[p];
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDist() {
        return dist;
    }

    public void setDist(Double dist) {
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Obs{" +
                "par=" + Arrays.toString(par) +
                ", name='" + name + '\'' +
                ", dist=" + dist +
                '}';
    }
}
