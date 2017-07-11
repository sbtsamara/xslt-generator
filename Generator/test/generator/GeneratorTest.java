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

/**
 *
 * @author usersbt
 */
public class GeneratorTest {
    
    public GeneratorTest() {
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
    public void testReadLine() {
        System.out.println("    readLine");
        String text = "code,code";
        String[] expResult = {"code","code"};
        String[] result = Generator.readLine(text);
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testReadWriteLine() {
        System.out.println("    readWriteLine");
        String text = "code"+"\n"+"code";
        String[] expResult = {"code","code"};
        String[] result = Generator.readWriteLine(text);
        assertArrayEquals(expResult, result);
    }
    
}