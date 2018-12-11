import java.util.ArrayList;

class NormalBaggage extends Baggage {

    NormalBaggage() {
        super();
    }

    NormalBaggage(int id, double width, double height, double length, String owner, ArrayList<String> content, SecurityRating securityRating, double weight) {
        super(id, width, height, length, owner, content, securityRating, weight);
    }

}
