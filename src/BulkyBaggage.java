import java.util.ArrayList;

class BulkyBaggage extends Baggage implements IBulkyBaggage {

    private TypeOfBulkiness typeOfBulkiness;

    BulkyBaggage() {
        super();
    }

    BulkyBaggage(int id, double width, double height, double length, String owner, ArrayList<String> content, SecurityRating securityRating, double weight, TypeOfBulkiness typeOfBulkiness) {
        super(id, width, height, length, owner, content, securityRating, weight);
        setTypeOfBulkiness(typeOfBulkiness);
    }


    TypeOfBulkiness getTypeOfBulkiness() {
        return typeOfBulkiness;
    }

    void setTypeOfBulkiness(TypeOfBulkiness typeOfBulkiness) {
        this.typeOfBulkiness = typeOfBulkiness;
    }

    public int calculateWorkforce() {
        return (int) Math.ceil(getWeight() / 20);
    }

}
