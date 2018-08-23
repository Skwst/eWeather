/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eweather;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

/**
 *
 * @author Methoz
 */
public class TempUtilsTest {
    
    public TempUtilsTest() {
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
    public void testGetWeatherForCities() throws Exception {
        System.out.println("testGetWeatherForCities");
        TempUtils instance = new TempUtils();
        List<String> cityIds = new ArrayList<>();
        cityIds.add("735914");
        String result = instance.getWeatherForCities(instance.getBaseUrl(), instance.getApiKey(), cityIds);
        assertThat(result,containsString("Katerini"));

    
    }

    
    @Test
    public void testGetWeatherForCitiesCount() throws Exception {
        System.out.println("testGetWeatherForCitiesCount");
        TempUtils instance=new TempUtils();
        List<String> cityIds=new ArrayList<>();
        cityIds.add("735914");
        cityIds.add("734077");
        cityIds.add("264371");
        String result=instance.getWeatherForCities(instance.getBaseUrl(), instance.getApiKey(), cityIds);
        String x=result.substring(7);
        String[] split=(x.split(","));
        assertTrue(Integer.parseInt(split[0])==3);

        
        
    
    }


    @Test(expected=MalformedURLException.class) 
    public void testGetWeatherForCitiesMalformedException() throws Exception {
        System.out.println("testGetWeatherForCitiesMalformedException");
        TempUtils instance=new TempUtils();
        List<String> cityIds = new ArrayList<>();
        cityIds.add("734077");
        String baseURL="xttp://api.openasdasdsadasdweathermap.org/data/2.5/group";
        String result=instance.getWeatherForCities(baseURL, instance.getApiKey(), cityIds);

        
    }
    
}
