import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    public void newHero_instantiatesCorrectly_true() throws Exception{
        Hero newHero = Hero.setUpNewHero();
        assertTrue(newHero instanceof Hero);
    }
    @Test
    public void newHero_getName_String() throws Exception{
        Hero newHero = Hero.setUpNewHero();
        assertEquals("squid",newHero.getName());
    }
    @Test
    public void newHero_getAge_Int() throws Exception{
        Hero newHero = Hero.setUpNewHero();
        assertEquals(1,newHero.getAge());
    }
    @Test
    public void newHero_getPower_String() throws Exception{
        Hero newHero = Hero.setUpNewHero();
        assertTrue(true, newHero.getPower());
    }
    @Test
    public void newHero_getWeakness_String() throws Exception{
        Hero newHero = Hero.setUpNewHero();
        assertEquals("weak", newHero.getWeakness());
    }
    @Test
    public void newHero_getAllInstances_true() throws Exception{
        Hero newHero = Hero.setUpNewHero();
        Hero anotherHero = Hero.setUpNewHero();
        assertTrue(Hero.getAllInstances().contains(newHero));
        assertTrue(Hero.getAllInstances().contains(anotherHero));
    }
    @Test
    public void newHero_getId_Int() throws Exception{
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero anotherHero = Hero.setUpNewHero();
        Hero anotherHero1 = Hero.setUpNewHero();
        assertEquals(3, anotherHero1.getId());
    }
    @Test
    public void newHero_findById_id(){
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero anotherHero = Hero.setUpNewHero();
        assertEquals(2,Hero.findById(anotherHero.getId()).getId());
    }

}