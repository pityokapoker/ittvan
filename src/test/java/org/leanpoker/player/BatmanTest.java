/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tgeczy
 */
public class BatmanTest {
    
    public BatmanTest() {
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
     * Test of getRealRank method, of class Batman.
     */
    @Test
    public void testOnePair() {
        Batman instance = new Batman();
        
        int result = instance.getRealRank(5,6,10,30,35,40,50);        
        assertEquals(14, result);
        result = instance.getRealRank(1,6,10,30,35,49,50);        
        assertEquals(25, result);
    }
    
    @Test
    public void testTwoPair() {
        Batman instance = new Batman();
        
        int result = instance.getRealRank(5,6,10,30,35,49,50);        
        assertEquals(38, result);
        result = instance.getRealRank(1,6,10,30,31,49,50);        
        assertEquals(38, result);
    }
    
    @Test
    public void testThreeOfKind() {
        Batman instance = new Batman();
        
        int result = instance.getRealRank(5,6,7,30,35,41,50);        
        assertEquals(40, result);
        result = instance.getRealRank(2,5,15,30,36,37,38);        
        assertEquals(48, result);
    }
    
//    @Ignore @Test
//    public void testStraight() {
//        Batman instance = new Batman();
//        
//        int result = instance.getRealRank(1,5,9,12,18,39,50);        
//        assertEquals(56, result);
//    }
//    
//    @Ignore @Test
//    public void testPotentialRankMap0(){
//        System.out.println("testPotentialRankMap0");
//        Batman instance = new Batman();
//        HashMap<Integer,Integer> result = instance.getPotentialRankMap0();
//        assertNotNull(result);
//        Integer sum = 0;
//        for(Integer rank = 0; rank <= 116; rank++)
//        {
//            Integer count = result.get(rank);
//            System.out.println("rank: " + rank + ", count: " + count);
//            assertNotNull(count);
//            assertNotEquals((Integer)0, count);
//            sum += count;
//        }
//        
//        
//        System.out.println(sum);
//        
//        
//    }
    
    
}
