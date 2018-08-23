
package eweather;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.json.*;
import java.util.*;
import javax.persistence.*;

public class ApiCall {
    
    public ApiCall(){}
    
    //μέθοδος για κλήση της πρόβλεψης των 5 ημερών
    public static void  get5DaysWeatherData(String url) throws IOException{
    
    URL url1 = new URL(url);
    int i=0;
    JsonReader reader1 = Json.createReader(new InputStreamReader(url1.openStream()));
    JsonObject cityDataObject=reader1.readObject();
    JsonObject cityObject=cityDataObject.getJsonObject("city");
    JsonArray cityHoursArray = cityDataObject.getJsonArray("list");
    reader1.close();
    long currentTimestamp = System.currentTimeMillis();
    
    for(JsonValue value:cityHoursArray){
     
        JsonObject cityHourDataObject=cityHoursArray.getJsonObject(i);
        JsonObject mainObject = cityHourDataObject.getJsonObject("main");
        JsonObject windObject=cityHourDataObject.getJsonObject("wind");
        JsonObject cloudsObject=cityHourDataObject.getJsonObject("clouds");
        JsonArray weatherArray=cityHourDataObject.getJsonArray("weather");
        JsonObject weatherObject=weatherArray.getJsonObject(0); 

        i=i+1;
        WeatherInfo temp = new WeatherInfo();  
        CityInfo city = new CityInfo(cityObject.getInt("id"));
        temp.setCityId(city);
        temp.setWeatherInfoMaintemp(mainObject.get("temp").toString());
        temp.setWeatherInfoDescription(weatherObject.getString("description"));
        temp.setWeatherInfoClouds(cloudsObject.get("all").toString());
        temp.setWeatherInfoSpeed(windObject.get("speed").toString());
        temp.setWeatherInfoDt(cityHourDataObject.get("dt").toString()); 
        
        try{
         temp.setWeatherInfoRain(mainObject.get("rain").toString());   
        }
        catch(java.lang.NullPointerException exception){
           temp.setWeatherInfoRain(null);
        }
       try{
        temp.setWeatherInfoSnow( mainObject.get("snow").toString());    
        }
        catch(java.lang.NullPointerException exception){
           temp.setWeatherInfoSnow( null); 
        }              
        temp.setWeatherInfoTimestamp(Long.toString(currentTimestamp));
        temp.setWeatherInfoIscurrent(Boolean.FALSE);
        EntityManager em;   
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eWeatherPU");       
        em = emf.createEntityManager();       
        em.getTransaction().begin(); 
        em.persist(temp);           
        em.getTransaction().commit();
    } 
      }
//μέθοδος για κλήση του καιρού τώρα
 public static void getGroupCurrentWeatherData(String url) throws IOException{
         
    URL url1 = new URL(url);
    JsonReader reader1 = Json.createReader(new InputStreamReader(url1.openStream()));
    JsonObject citiesDataObject=reader1.readObject();
    JsonArray citiesArray = citiesDataObject.getJsonArray("list"); 
    reader1.close();
    int i=0;
    long currentTimestamp = System.currentTimeMillis();
    
    for(JsonValue value:citiesArray){
        JsonObject cityDataObject=citiesArray.getJsonObject(i);

        JsonObject mainObject = cityDataObject.getJsonObject("main");
        JsonObject windObject=cityDataObject.getJsonObject("wind");
        JsonObject cloudsObject=cityDataObject.getJsonObject("clouds");
        JsonArray weatherArray=cityDataObject.getJsonArray("weather");
        JsonObject weatherObject=weatherArray.getJsonObject(0);  
        WeatherInfo temp = new WeatherInfo();  
        CityInfo city = new CityInfo(cityDataObject.getInt("id"));
        temp.setCityId(city);
        temp.setWeatherInfoMaintemp( mainObject.get("temp").toString());
        temp.setWeatherInfoDescription(weatherObject.getString("description"));
        temp.setWeatherInfoClouds(cloudsObject.get("all").toString());
        temp.setWeatherInfoSpeed(windObject.get("speed").toString());
        temp.setWeatherInfoDt(cityDataObject.get("dt").toString()); 
        try{
         temp.setWeatherInfoRain(mainObject.get("rain").toString());   
        }
        catch(java.lang.NullPointerException exception){
            temp.setWeatherInfoRain(null);
        }
         try{
         temp.setWeatherInfoSnow(mainObject.get("snow").toString());   
        }
        catch(java.lang.NullPointerException exception){
            temp.setWeatherInfoSnow( null); 
        }
        temp.setWeatherInfoTimestamp(Long.toString(currentTimestamp));
         temp.setWeatherInfoIscurrent(Boolean.TRUE);
        EntityManager em;     
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eWeatherPU"); 
        em = emf.createEntityManager();         
        em.getTransaction().begin();
        em.persist(temp);         
        em.getTransaction().commit();
        i=i+1;   
    }
}
   //μέθοδος που καλέι τις 5 ημέρες για όλες τις πόλεις
   public static void getForecast(){  
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eWeatherPU");
        EntityManager em = emf.createEntityManager();
        List<CityInfo> ciList = em.createNamedQuery("CityInfo.findAll",CityInfo.class).getResultList();
         
         for(CityInfo ci : ciList)
           try
           {
             ApiCall.get5DaysWeatherData("http://api.openweathermap.org/data/2.5/forecast?id="+ ci.getCityId().toString() +"&units=metric&APPID=9d1ce877456094f2668678365a4774b2");
           }
           catch (IOException e){System.out.println(e.getMessage());}
     }
   
   //μέθοδος που καλεί τον καιρό τώρα γα όλες τις πόλεις
   public static void getCurrent(){  
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eWeatherPU");
        EntityManager em = emf.createEntityManager();
        List<CityInfo> ciList = em.createNamedQuery("CityInfo.findAll",CityInfo.class).getResultList();
         
        String url = "";
        
         for(CityInfo ci : ciList)
              url += ci.getCityId().toString() + ',';
        
         url = url.substring(0,url.length()-1);
         
         try
           {
             ApiCall.getGroupCurrentWeatherData("http://api.openweathermap.org/data/2.5/group?id="+url+"&units=metric&APPID=9d1ce877456094f2668678365a4774b2");  
           }
           catch (IOException e){System.out.println(e.getMessage());} 
     }
}