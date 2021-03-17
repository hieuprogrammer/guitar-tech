package io.hieu.guitartech.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrandTest extends BaseEntity {
    Brand brand;

    @Before
    public void setUp() throws Exception {
        brand = new Brand();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String nameValue = "Gibson";
        brand.setName(nameValue);
        assertEquals(nameValue, brand.getName());
    }

    @Test
    public void getLogoUrl() {
    }

    @Test
    public void getGuitars() {
    }
}