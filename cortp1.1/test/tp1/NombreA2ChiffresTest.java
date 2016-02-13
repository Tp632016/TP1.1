/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static tp1.Main.mulNombre;
import static tp1.Main.sommeNombre;

/**
 *
 * @author Quentin CHAPELLE
 */
public class NombreA2ChiffresTest {
    
    public NombreA2ChiffresTest() {
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("cor tp1.1 tests");
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
     * Test of testChiffre method, of class NombreA2Chiffres.
     */
    @Test
    public void test_OK_TestChiffre() {
        System.out.println("Cas passant testChiffre");
        int c = 0;
        boolean expResult = true;
        boolean result = NombreA2Chiffres.testChiffre(c);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void test_KO_TestChiffre() {
        System.out.println("Cas non passant testChiffre");
        int c = 10;
        boolean expResult = false;
        boolean result = NombreA2Chiffres.testChiffre(c);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of construct NombreA2Chiffres.
     */
    @Test
    public void test_OK_CreateNombreA2Chiffres() {
        try {
            System.out.println("Cas passant création NombreA2Chiffres");
            
            int c1 = 1;
            int c2 = 9;
            
            NombreA2Chiffres test = new NombreA2Chiffres(c1,c2);
            
            assertEquals(c1, test.getC1());
            assertEquals(c2, test.getC2());
        } catch (Exception ex) {
            Logger.getLogger(NombreA2ChiffresTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void test_OK_addtestArith(){
        
        try {
            NombreA2Chiffres result = NombreA2Chiffres.arith(1,2,false);
            assertEquals(result.getC1(), 0);
            assertEquals(result.getC2(), 3);
        } catch (Exception ex) {
            Logger.getLogger(NombreA2ChiffresTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void test_OK_multestArith(){ 
        try {
            NombreA2Chiffres result = NombreA2Chiffres.arith(6,2,true);
            assertEquals(result.getC1(), 1);
            assertEquals(result.getC2(), 2);
        } catch (Exception ex) {
            Logger.getLogger(NombreA2ChiffresTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @Test
    public void test_OK_addNegtestArith(){ 
        try {
            NombreA2Chiffres result = NombreA2Chiffres.arith(6,-2,false);
            assertEquals(result.getC1(), 0);
            assertEquals(result.getC2(), 4);
            
            NombreA2Chiffres result2 = NombreA2Chiffres.arith(4,-6,false);
            assertEquals(result2.getC1(), 0);
            assertEquals(result2.getC2(), -2);
        } catch (Exception ex) {
            Logger.getLogger(NombreA2ChiffresTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test 
    public void test_KO_testArith()
    {
        
        try {
            NombreA2Chiffres result = NombreA2Chiffres.arith(10,9,true);
            fail("Invalid object and no exception");
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }
    
    @Test
    public void test_OK_sommeNombre(){
        
        try {
            int [] b= {2,2,1};
            int [] c= {8,4};
            int [] expect = {0,7,1};
            
            int [] result = sommeNombre(b,c);
            
            assertArrayEquals(result, expect);
        } catch (Exception ex) {
            Logger.getLogger(NombreA2ChiffresTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void test_OK_mulNombre(){
        
        try {
            int [] b= {2,2,1};
            int [] c= {8,4};
            int [] expect = {6,5,8,5};
            
            int [] result = mulNombre(b,c);
            
            assertArrayEquals(expect,result);
        } catch (Exception ex) {
            Logger.getLogger(NombreA2ChiffresTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
