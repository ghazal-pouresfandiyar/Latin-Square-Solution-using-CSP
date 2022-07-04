import java.util.ArrayList;

public class Pixel {
    private int x;
    private int y;
    private int value;
    private ArrayList<Integer> domain;

    //constructor
    public Pixel(ArrayList<Integer> domain, int x, int y) {
        this.value = 0;
        this.domain = domain;
        this.x = x;
        this.y = y;
    }

    //getters
    public int getValue() {
        return value;
    }
    public ArrayList<Integer> getDomain() {
        return domain;
    }

    //set value based on the domain
    public void setValue(int value) {
        //check if the value is in domain
        if (domain.contains(value)) {
            this.value = value;
        }else{
            System.out.println("Select value from domain");
        }
    }

    //update domains of pixels in the same raw and column as current pixel
    public void updateRelatedDomains(Pixel[][] table, int n){
        domain.clear();
        for(int i = 0; i < n ; i++){
            table[x][i].getDomain().remove(new Integer(value));
            table[i][y].getDomain().remove(new Integer(value));
        }
    }
}
