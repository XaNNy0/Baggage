import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BulkyBaggageTest {

    private BulkyBaggage bulkyBaggage;
    private ArrayList<String> content;

    @BeforeEach
    void setUp() {
        String[] contents = {"TShirt", "Jeans", "Shorts", "Book", "Towel"};
        content = new ArrayList<>();
        content.addAll(Arrays.asList(contents));
        bulkyBaggage = new BulkyBaggage(1,1,1,1, "test",content, SecurityRating.harmless,27, TypeOfBulkiness.heavy);
    }
    @Test
    void scanBaggage() {
        BulkyBaggage testBaggage = new BulkyBaggage();
        testBaggage.scanBaggage(2,2,2,2, "test2", content, SecurityRating.harmless, 9);
        assertEquals(2,testBaggage.getId());
        assertEquals(2, testBaggage.getWidth());
        assertEquals(2, testBaggage.getHeight());
        assertEquals(2, testBaggage.getLength());
        assertEquals( "test2", testBaggage.getOwner());
        assertEquals(content, testBaggage.getContent());
        assertEquals(SecurityRating.harmless, testBaggage.getSecurityRating());
        assertEquals(9, testBaggage.getWeight());
    }
    @Test
    void securityScan() {
        bulkyBaggage.securityScan(SecurityRating.threat);
        assertEquals(SecurityRating.threat, bulkyBaggage.getSecurityRating());
        assertEquals(Status.postCheck, bulkyBaggage.getStatus());
    }
    @Test
    void notifySecurityEmployees() {
        bulkyBaggage.securityScan(SecurityRating.threat);
        bulkyBaggage.notifySecurityEmployees();
        assertEquals(Status.specialThreatCheck, bulkyBaggage.getStatus());
    }
    @Test
    void transportBaggage() {
        bulkyBaggage.transportBaggage();
        assertEquals(Status.deliverToAircraft, bulkyBaggage.getStatus());
    }
    @Test
    void calculateVolume() {
        assertEquals(bulkyBaggage.getHeight()* bulkyBaggage.getLength()* bulkyBaggage.getWidth(),
                bulkyBaggage.calculateVolume());
    }
    @Test
    void setTypeOfBulkiness() {
        bulkyBaggage.setTypeOfBulkiness(TypeOfBulkiness.heavyAndUnwieldy);
        assertEquals(TypeOfBulkiness.heavyAndUnwieldy, bulkyBaggage.getTypeOfBulkiness());
        bulkyBaggage.setTypeOfBulkiness(TypeOfBulkiness.heavy);
        assertEquals(TypeOfBulkiness.heavy, bulkyBaggage.getTypeOfBulkiness());
        bulkyBaggage.setTypeOfBulkiness(TypeOfBulkiness.unwieldy);
        assertEquals(TypeOfBulkiness.unwieldy, bulkyBaggage.getTypeOfBulkiness());
    }
    @Test
    void calculateMenNeeded() {
        assertEquals(2,bulkyBaggage.calculateMenNeeded());
        assertEquals((int)Math.ceil(bulkyBaggage.getWeight()/20), bulkyBaggage.calculateMenNeeded());
    }
}