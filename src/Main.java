import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //scanning input
        System.out.println("Enter n : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        //create empty table
        Pixel[][] table = new Pixel[n][n];

        boolean run = true;
        while(run) {
            boolean conflict = false;
            //define domain {1,2,...,n} for all pixels
            ArrayList<Integer> primaryDomain = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                primaryDomain.add(i + 1);
            }

            //put value 0 in all pixels at the beginning
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    table[i][j] = new Pixel(new ArrayList<>(primaryDomain), i, j);
                }
            }

            //select random value for pixels based on their constraint and domain
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
//                    System.out.println(i + "," + j + ": " + table[i][j].getDomain().toString());
                    if (!table[i][j].getDomain().isEmpty()) {
                        int randomIndex = RandomHelper.nextInt(table[i][j].getDomain().size());
                        int randomValue = table[i][j].getDomain().get(randomIndex);
                        table[i][j].setValue(randomValue);
                        table[i][j].updateRelatedDomains(table, n);
                    } else {
//                        System.out.println("Conflict has happend!");
                        conflict = true;
                    }
                }
            }

            if(!conflict){
                run = false;
            }
        }

        //print the Latin Square
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j].getValue() + ", ");
            }
            System.out.println();
        }
    }
}
