package pl.yakubus;

public class Main {

    public static void main(String[] args) {
        Histogram hist = new Histogram();
        hist.setUrl("D:/temp.txt");
        int[] zakresy = new int[2];

        zakresy[0] = 4;
        zakresy[1] = 5;

        int[] wynik = hist.iloscSlow(zakresy);
        System.out.println("\nilosc slow");
        for (int w : wynik) {
            System.out.print(" w-" + w);
        }
        System.out.println("\nilosc Roznych slow");
        int[] wynikRozne = hist.iloscRoznychSlow(zakresy);
        for (int wr : wynikRozne) {
            System.out.print(" wr-" + wr);
        }

        System.out.println("\n-\nTest histogram");
        int[] histokram = hist.histogram();
        int hi =0;
        for(int h : histokram){
            System.out.print(hi + "\t");
            hi++;
        }
        System.out.print("\n");
        for(int h : histokram){
            System.out.print(h + "\t");
        }


        System.out.println("\n-\n Test histogramRóżne");
        int[] histogramRozne = hist.histogramRozne();
        int hr=0;
        for(int h : histogramRozne){
            System.out.print(hr + "\t");
            hr++;
        }
        System.out.print("\n");
        for(int h : histogramRozne){
            System.out.print(h + "\t");
        }

    }
}
