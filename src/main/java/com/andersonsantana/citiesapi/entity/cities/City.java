package com.andersonsantana.citiesapi.entity.cities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {
    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;

    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocation;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    private Double latitude;

    private Double longitude;

    @Column(name = "cod_tom", updatable = false, insertable = false)
    private Long codTom;


    public City() {
    }

    public City(Long id, String name, Integer uf, Integer ibge, String geolocation, Point location, Double latitude, Double longitude, Long codTom) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.ibge = ibge;
        this.geolocation = geolocation;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.codTom = codTom;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public Point getLocation() {
        return location;
    }


    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Long getCodTom() {
        return codTom;
    }
}
