import java.util.ArrayList;

abstract class Baggage implements IBaggage {

    private int id;
    private double width;
    private double height;
    private double length;
    private double weight;
    private String owner;
    private ArrayList<String> content;
    private SecurityRating securityRating;
    private Status status;

    private void setId(int id) {
        this.id = id;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setLength(double length) {
        this.length = length;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    private void setContent(ArrayList<String> content) {
        this.content = content;
    }

    private void setSecurityRating(SecurityRating securityRating) {
        this.securityRating = securityRating;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    int getId() {
        return id;
    }

    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    double getLength() {
        return length;
    }

    double getWeight() {
        return weight;
    }

    String getOwner() {
        return owner;
    }

    ArrayList<String> getContent() {
        return content;

    }

    SecurityRating getSecurityRating() {
        return securityRating;
    }

    Status getStatus() {
        return status;
    }


    Baggage() {
        setStatus(Status.preCheck);
    }

    Baggage(int id, double width, double height, double length, String owner, ArrayList<String> content, SecurityRating securityRating, double weight) {
        scanBaggage(id, width, height, length, owner, content, securityRating, weight);
    }

    public void scanBaggage(int id, double width, double height, double length, String owner, ArrayList<String> content, SecurityRating securityRating, double weight) {
        setId(id);
        setWidth(width);
        setHeight(height);
        setLength(length);
        setWidth(width);
        setOwner(owner);
        setContent(content);
        setWeight(weight);
        setStatus(Status.preCheck);
        securityScan(securityRating);
    }

    public void securityScan(SecurityRating securityRating) {
        setSecurityRating(securityRating);
        setStatus(Status.postCheck);

    }

    public void notifySecurityEmployees() {
        switch (getSecurityRating()) {
            case harmless:
                System.out.println("Baggage with ID " + getId() + "is harmless");
                break;

            case safetyCritical:
                System.out.println("Baggage with ID " + getId() + "is Safty Critical");
                break;

            case threat:
                setStatus(Status.specialThreatCheck);
                System.out.println("Baggage with ID " + getId() + "is a threat, please contact your boss");
                break;
        }

    }

    public void transportBaggage() {
        setStatus(Status.deliverToAircraft);
        System.out.println("Baggage " + id + "is now inside the Aircraft");
    }

    public double calculateVolume() {
        return getHeight() * getWidth() * getLength();
    }
}
