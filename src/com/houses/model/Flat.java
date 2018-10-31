package com.houses.model;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public class Flat {
    private Integer houseId;
    private Integer flatNumber;
    private String flatOwner;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getFlatOwner() {
        return flatOwner;
    }

    public void setFlatOwner(String flatOwner) {
        this.flatOwner = flatOwner;
    }
}
