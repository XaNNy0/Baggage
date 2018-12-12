import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalBaggageTest {


    private NormalBaggage baggage;
    private ArrayList<String> content;

    @BeforeEach
    void setUp() {
        String[] contents = {"TShirt", "Jeans", "Shorts", "Book", "Towel"};
        content = new ArrayList<>();
        content.addAll(Arrays.asList(contents));
        baggage = new NormalBaggage(1, 1, 1, 1, "test", content, SecurityRating.harmless, 7);
    }

    @Test
    void scanBaggage() {
        NormalBaggage testBaggage = new NormalBaggage();
        testBaggage.scanBaggage(2, 2, 2, 2, "test2", content, SecurityRating.harmless, 9);
        assertEquals(2, testBaggage.getId());
        assertEquals(2, testBaggage.getWidth());
        assertEquals(2, testBaggage.getHeight());
        assertEquals(2, testBaggage.getLength());
        assertEquals("test2", testBaggage.getOwner());
        assertEquals(content, testBaggage.getContent());
        assertEquals(SecurityRating.harmless, testBaggage.getSecurityRating());
        assertEquals(9, testBaggage.getWeight());
    }

    @Test
    void securityScan() {
        baggage.securityScan(SecurityRating.threat);
        assertEquals(SecurityRating.threat, baggage.getSecurityRating());
        assertEquals(Status.postCheck, baggage.getStatus());
    }

    @Test
    void notifySecurityEmployees() {
        baggage.securityScan(SecurityRating.threat);
        baggage.notifySecurityEmployees();
        assertEquals(Status.specialThreatCheck, baggage.getStatus());
    }

    @Test
    void transportBaggage() {
        baggage.transportBaggage();
        assertEquals(Status.deliverToAircraft, baggage.getStatus());
    }

    @Test
    void calculateVolume() {
        assertEquals(baggage.getHeight() * baggage.getLength() * baggage.getWidth(),
                baggage.calculateVolume());
    }
}