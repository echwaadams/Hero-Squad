package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    public void checkForCorrectInstantiationOfHeroes_true() throws Exception {
        Hero hero = new Hero("Marvel");
        assertEquals(true,hero instanceof Hero);
    }
    @Test
    public void HeroInstantiatesWithName_true() throws Exception{
        Hero hero = new Hero("Marvel");
        assertEquals("Marvel", hero.getName());
    }

    @AfterEach
    void tearDown() {
    }

}