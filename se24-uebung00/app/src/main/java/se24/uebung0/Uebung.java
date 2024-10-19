package se24.uebung0;

// imports for csv reading

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Uebung {
    private Scanner sc;
    public Uebung(String path) {
        // Scanner zuweisen
        try {
            this.sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sc.useDelimiter(" ");
    }

    // returnt String
    public String readOut() {
        StringBuilder output = new StringBuilder();
        
        // Prüfe, ob der Scanner die nächste Zeile hat
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(";");
            
            if (parts.length >= 5) {
                String timestamp = parts[0];  // "2017-04-13T15:59:51"
                String status = parts[1];      // "Z"
                String name = parts[2];        // "Huber,Hans"
                String items = parts[3];       // "3xStaubsauger,5xRegenschirm"
                String customerId = parts[4];  // "273308"
                
                // Zeitstempel aufbereiten
                String date = timestamp.substring(0, 10); // "2017-04-13"
                String time = timestamp.substring(11, 16); // "15:59"
                
                // Name umdrehen
                String[] nameParts = name.split(",");
                String fullName = nameParts[1] + " " + nameParts[0]; // "Hans Huber"
                
                // Statusbezeichnung
                String statusText = "";
                switch (status) {
                    case "Z":
                        statusText = "zugestellt";
                        break;
                    case "A":
                        statusText = "angelegt";
                        break;
                    case "V":
                        statusText = "verarbeitet";
                        break;
                    case "E":
                        statusText = "erstellt";
                        break;
                    default:
                        statusText = "unbekannt";
                        break;
                }
                
                // Ausgabe formatieren
                output.append(String.format("%s hat am %s um %s Uhr den Zustand einer Lieferung auf '%s' geändert. Die Lieferung beinhaltet %s. Der Adressat hat die Kundennummer %s.%n",
                        fullName, date, time, statusText, items, customerId));
            }
        }
        
        sc.close();
        return output.toString();
    }

    // Nur ausgeben
    public void readOnly() {
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
        sc.close();
    }
    
    


}