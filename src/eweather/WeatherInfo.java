/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eweather;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tybrob
 */
@Entity
@Table(name = "WEATHER_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeatherInfo.findAll", query = "SELECT w FROM WeatherInfo w")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoId", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoId = :weatherInfoId")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoMaintemp", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoMaintemp = :weatherInfoMaintemp")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoDescription", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoDescription = :weatherInfoDescription")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoClouds", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoClouds = :weatherInfoClouds")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoSpeed", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoSpeed = :weatherInfoSpeed")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoDt", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoDt = :weatherInfoDt")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoRain", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoRain = :weatherInfoRain")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoSnow", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoSnow = :weatherInfoSnow")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoTimestamp", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoTimestamp = :weatherInfoTimestamp")
    , @NamedQuery(name = "WeatherInfo.findByWeatherInfoIscurrent", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoIscurrent = :weatherInfoIscurrent")
        , @NamedQuery(name = "WeatherInfo.findByWeatherInfoIscurrentAndTimestamp", query = "SELECT w FROM WeatherInfo w WHERE w.weatherInfoIscurrent = :weatherInfoIscurrent and w.weatherInfoTimestamp = :weatherInfoTimestamp")
})
public class WeatherInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WEATHER_INFO_ID")
    private Integer weatherInfoId;
    @Column(name = "WEATHER_INFO_MAINTEMP")
    private String weatherInfoMaintemp;
    @Column(name = "WEATHER_INFO_DESCRIPTION")
    private String weatherInfoDescription;
    @Column(name = "WEATHER_INFO_CLOUDS")
    private String weatherInfoClouds;
    @Column(name = "WEATHER_INFO_SPEED")
    private String weatherInfoSpeed;
    @Column(name = "WEATHER_INFO_DT")
    private String weatherInfoDt;
    @Column(name = "WEATHER_INFO_RAIN")
    private String weatherInfoRain;
    @Column(name = "WEATHER_INFO_SNOW")
    private String weatherInfoSnow;
    @Column(name = "WEATHER_INFO_TIMESTAMP")
    private String weatherInfoTimestamp;
    @Column(name = "WEATHER_INFO_ISCURRENT")
    private Boolean weatherInfoIscurrent;
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    @ManyToOne(optional = false)
    private CityInfo cityId;

    public WeatherInfo() {
    }

    public WeatherInfo(Integer weatherInfoId) {
        this.weatherInfoId = weatherInfoId;
    }

    public Integer getWeatherInfoId() {
        return weatherInfoId;
    }

    public void setWeatherInfoId(Integer weatherInfoId) {
        this.weatherInfoId = weatherInfoId;
    }

    public String getWeatherInfoMaintemp() {
        return weatherInfoMaintemp;
    }

    public void setWeatherInfoMaintemp(String weatherInfoMaintemp) {
        this.weatherInfoMaintemp = weatherInfoMaintemp;
    }

    public String getWeatherInfoDescription() {
        return weatherInfoDescription;
    }

    public void setWeatherInfoDescription(String weatherInfoDescription) {
        this.weatherInfoDescription = weatherInfoDescription;
    }

    public String getWeatherInfoClouds() {
        return weatherInfoClouds;
    }

    public void setWeatherInfoClouds(String weatherInfoClouds) {
        this.weatherInfoClouds = weatherInfoClouds;
    }

    public String getWeatherInfoSpeed() {
        return weatherInfoSpeed;
    }

    public void setWeatherInfoSpeed(String weatherInfoSpeed) {
        this.weatherInfoSpeed = weatherInfoSpeed;
    }

    public String getWeatherInfoDt() {
        return weatherInfoDt;
    }

    public void setWeatherInfoDt(String weatherInfoDt) {
        this.weatherInfoDt = weatherInfoDt;
    }

    public String getWeatherInfoRain() {
        return weatherInfoRain;
    }

    public void setWeatherInfoRain(String weatherInfoRain) {
        this.weatherInfoRain = weatherInfoRain;
    }

    public String getWeatherInfoSnow() {
        return weatherInfoSnow;
    }

    public void setWeatherInfoSnow(String weatherInfoSnow) {
        this.weatherInfoSnow = weatherInfoSnow;
    }

    public String getWeatherInfoTimestamp() {
        return weatherInfoTimestamp;
    }

    public void setWeatherInfoTimestamp(String weatherInfoTimestamp) {
        this.weatherInfoTimestamp = weatherInfoTimestamp;
    }

    public Boolean getWeatherInfoIscurrent() {
        return weatherInfoIscurrent;
    }

    public void setWeatherInfoIscurrent(Boolean weatherInfoIscurrent) {
        this.weatherInfoIscurrent = weatherInfoIscurrent;
    }

    public CityInfo getCityId() {
        return cityId;
    }

    public void setCityId(CityInfo cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weatherInfoId != null ? weatherInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeatherInfo)) {
            return false;
        }
        WeatherInfo other = (WeatherInfo) object;
        if ((this.weatherInfoId == null && other.weatherInfoId != null) || (this.weatherInfoId != null && !this.weatherInfoId.equals(other.weatherInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eweather.WeatherInfo[ weatherInfoId=" + weatherInfoId + " ]";
    }
    
}
