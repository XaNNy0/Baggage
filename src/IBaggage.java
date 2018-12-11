import java.util.ArrayList;

public interface IBaggage {
    void scanBaggage(int id, double width, double height, double length, String owner, ArrayList<String> content, SecurityRating securityRating, double weight);
    void securityScan(SecurityRating securityRating);
    void notifySecurityEmployees();
    void transportBaggage();
    double calculateVolume();
}
