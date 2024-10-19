import se24.uebung0.Uebung;

public class Main {
    static String file = "src/main/resources/auftraege.csv"; // relative File
    public static void main(String[] args) {

        Uebung csvReader = new se24.uebung0.Uebung(file);
        String Output = csvReader.readOut();

        System.out.println(Output);
    }
}
