import javax.swing.*;

public class App {
    public static void main(String[] args) {
        String choise, train;
        do {
            choise = JOptionPane.showInputDialog(null, "1. Get data from latest trains \n " +
                    "2. Get data from one train\n " +
                    "3. End programm \n ");
            if(choise.equals("1")) {
                String url = "https://rata.digitraffic.fi/api/v1/train-locations/latest/"; //REST API kaikki junat
                DataApi_Trains dataApi = new DataApi_Trains(url);
                Thread dataThread = new Thread(dataApi); //Kaikkien junien datan säie
                dataThread.start(); //Aloitetaan säie, jonka pyörittää DataApi_Trains luokkaa
                while (dataThread.isAlive()) {
                    System.out.println("Searching..");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            else if (choise.equals("2")) {
                train = JOptionPane.showInputDialog(null, "Enter train number" );
                String url = "https://rata.digitraffic.fi/api/v1/train-locations/latest/"+ train; //REST API yksi juna
                DataApi_Trains dataApi = new DataApi_Trains(url);
                Thread dataThread = new Thread(dataApi); //Kaikkien junien datan säie
                dataThread.start(); //Aloitetaan säie, jonka pyörittää DataApi_Trains luokkaa
                while (dataThread.isAlive()) {
                    System.out.println("Searching..");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }while(!choise.equals("3"));
    }
}

