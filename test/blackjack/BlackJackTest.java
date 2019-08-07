/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aulak
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BlackJack.
     
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BlackJack.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of hasBJack method, of class BlackJack.
     */
    
    @Test
    public void testHasBJackGood() {
        System.out.println("GoodhasBJack");
        int handValue = 21;
        boolean expResult = true;
        boolean result = BlackJack.hasBJack(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testHasBJackBad() {
        System.out.println("BadhasBJack");
        int handValue = 0;
        boolean expResult = false;
        boolean result = BlackJack.hasBJack(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    @Test
    public void testIsyornGood() {
        System.out.println("Goodisyorn");
        String answer = "yes";
        boolean expResult = true;
        boolean result = BlackJack.isyorn(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     @Test
    public void testIsyornBoundary() {
        System.out.println("Boundaryisyorn");
        String answer = "";
        boolean expResult = false;
        boolean result = BlackJack.isyorn(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     @Test
    public void testIsyornBad() {
        System.out.println("Badisyorn");
        String answer = "123";
        boolean expResult = false;
        boolean result = BlackJack.isyorn(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     /**
     * Test of Won method, of class BlackJack.
     */
   /* @Test
    public void testWon() {
        System.out.println("Won");
        BlackJack.Won();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        /**
     * Test of isHorS method, of class BlackJack.
     */
    @Test
    public void testIsHorSGood() {
        System.out.println("GoodisHorS");
        String option = "hit";
        boolean expResult = true;
        boolean result = BlackJack.isHorS(option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsHorSBoundry() {
        System.out.println("BoundaryisHorS");
        String option = "";
        boolean expResult = false;
        boolean result = BlackJack.isHorS(option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsHorSBad() {
        System.out.println("BadisHorS");
        String option = "abcdefg";
        boolean expResult = false;
        boolean result = BlackJack.isHorS(option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Bust method, of class BlackJack.
     */
    @Test
    public void testBustGood() {
        System.out.println("GoodBust");
        int handValue= 15;
        boolean expResult = false;
        boolean result = BlackJack.Bust(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testBustBoundry() {
        System.out.println("BoundaryBust");
        int handValue= 21;
        boolean expResult = false;
        boolean result = BlackJack.Bust(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testBustBad() {
        System.out.println("BadBust");
        int handValue= 23;
        boolean expResult = true;
        boolean result = BlackJack.Bust(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }   
}
