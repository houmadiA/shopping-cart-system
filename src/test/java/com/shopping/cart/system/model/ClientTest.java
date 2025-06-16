package com.shopping.cart.system.model;

import com.shopping.cart.system.model.client.BusinessClient;
import com.shopping.cart.system.model.client.ClientType;
import com.shopping.cart.system.model.client.IndividualClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testIndividualClientCreation() {
        var client = new IndividualClient("001", "John", "Doe");

        assertEquals("001", client.getClientId());
        assertEquals("John", client.getFirstName());
        assertEquals("Doe", client.getLastName());
        assertEquals(ClientType.INDIVIDUAL, client.getClientType());
    }

    @Test
    public void testIndividualClientInvalidData() {
        assertThrows(IllegalArgumentException.class,
                () -> new IndividualClient(null, "John", "Doe"));
        assertThrows(IllegalArgumentException.class,
                () -> new IndividualClient("001", null, "Doe"));
        assertThrows(IllegalArgumentException.class,
                () -> new IndividualClient("001", "John", ""));
    }

    @Test
    public void testBusinessClientCreation() {
        var client = new BusinessClient("002", "TechCorp", "FR123456789",
                "123456789", 15_000_000);

        assertEquals("002", client.getClientId());
        assertEquals("TechCorp", client.getCompanyName());
        assertEquals("FR123456789", client.getVatNumber());
        assertEquals("123456789", client.getSirenNumber());
        assertEquals(15_000_000, client.getAnnualRevenue());
        assertTrue(client.isLargeEnterprise());
        assertEquals(ClientType.BUSINESS, client.getClientType());
    }

    @Test
    public void testBusinessClientSmallEnterprise() {
        var client = new BusinessClient("003", "SmallBiz", null,
                "987654321", 5_000_000);

        assertFalse(client.isLargeEnterprise());
    }

    @Test
    public void testBusinessClientInvalidData() {
        assertThrows(IllegalArgumentException.class,
                () -> new BusinessClient("002", "", "VAT", "SIREN", 1000));
        assertThrows(IllegalArgumentException.class,
                () -> new BusinessClient("002", "Company", "VAT", null, 1000));
        assertThrows(IllegalArgumentException.class,
                () -> new BusinessClient("002", "Company", "VAT", "SIREN", -1000));
    }
}