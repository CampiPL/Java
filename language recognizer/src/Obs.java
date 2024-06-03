public class Obs {

    double[] freq;
    int total;

    Obs(int total) {

        this.freq = new double[26];
        this.total = total;

        for (int i = 0; i < 26; i++)
            this.freq[i] = 0;

    }

    void add(int i) {
        this.freq[i]++;
    }

    void countFreq() {
        for (int i = 0; i < 26; i++)
            this.freq[i] = this.freq[i] / total;
    }
}
