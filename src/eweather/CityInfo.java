/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eweather;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tybrob
 */
@Entity
@Table(name = "CITY_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CityInfo.findAll", query = "SELECT c FROM CityInfo c")
    , @NamedQuery(name = "CityInfo.findByCityId", query = "SELECT c FROM CityInfo c WHERE c.cityId = :cityId")
    , @NamedQuery(name = "CityInfo.findByCityName", query = "SELECT c FROM CityInfo c WHERE c.cityName = :cityName")})
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CITY_ID")
    private Integer cityId;
    @Column(name = "CITY_NAME")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<WeatherInfo> weatherInfoCollection;

    public CityInfo() {
    }

    public CityInfo(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Collection<WeatherInfo> getWeatherInfoCollection() {
        return weatherInfoCollection;
    }

    public void setWeatherInfoCollection(Collection<WeatherInfo> weatherInfoCollection) {
        this.weatherInfoCollection = weatherInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityInfo)) {
            return false;
        }
        CityInfo other = (CityInfo) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eweather.CityInfo[ cityId=" + cityId + " ]";
    }
    
}
