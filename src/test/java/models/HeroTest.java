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
    @Test
    public void AllHeroesCorrectlyReturned_true() throws Exception{
        Hero hero = new Hero("Marvel");
        Hero otherHero = new Hero("Comparing heroes");
        assertEquals(0, Hero.getAll().size());
    }
    @Test
    public void AllHeroesContainsAllHeroes_true() throws Exception{
        Hero hero = new Hero("Marvel");
        Hero otherHero = new Hero("Comparing heroes");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

}