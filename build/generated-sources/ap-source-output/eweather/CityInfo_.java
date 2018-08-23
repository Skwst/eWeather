package eweather;

import eweather.WeatherInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-23T14:52:59")
@StaticMetamodel(CityInfo.class)
public class CityInfo_ { 

    public static volatile SingularAttribute<CityInfo, String> cityName;
    public static volatile CollectionAttribute<CityInfo, WeatherInfo> weatherInfoCollection;
    public static volatile SingularAttribute<CityInfo, Integer> cityId;

}