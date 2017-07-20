/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


/**
 *
 * @author usersbt
 */
public class WorkJsonTest {
    
    public WorkJsonTest() {
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
    
    @Test
    public void testParseJson() {       
        System.out.println("    parseJson");
        String[] attribute = {"СУММА","(123)"};
        String expResult = "sum(123)\n"; 
        String result = WorkJson.parseJson(attribute);
        System.out.println(result);
        assertEquals(expResult, result); //assertTrue(expResult.equals(result));
    }
    
    @Test
    public void testbrackets() {
        System.out.println("    brackets");
        String bracket = "((СУММА))";
        String expResult = "СУММА";     
        String result = WorkJson.checkFormat(bracket);
        System.out.println(result);
        assertEquals(expResult, result);   
    }
}
