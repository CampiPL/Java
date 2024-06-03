public class Dis {

    double distance;
    String iris;

    public Dis(double distance, String iris) {
        this.distance = distance;
        this.iris = iris;
    }

    @Override
    public String toString() {
        return "Dis{" +
                "distance=" + this.distance +
                ", iris='" + this.iris + '\'' +
                '}';
    }
}
