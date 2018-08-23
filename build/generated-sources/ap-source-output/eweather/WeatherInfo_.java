package eweather;

import eweather.CityInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-23T14:52:59")
@StaticMetamodel(WeatherInfo.class)
public class WeatherInfo_ { 

    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoSnow;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoDescription;
    public static volatile SingularAttribute<WeatherInfo, Boolean> weatherInfoIscurrent;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoDt;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoRain;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoMaintemp;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoSpeed;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoTimestamp;
    public static volatile SingularAttribute<WeatherInfo, Integer> weatherInfoId;
    public static volatile SingularAttribute<WeatherInfo, CityInfo> cityId;
    public static volatile SingularAttribute<WeatherInfo, String> weatherInfoClouds;

}