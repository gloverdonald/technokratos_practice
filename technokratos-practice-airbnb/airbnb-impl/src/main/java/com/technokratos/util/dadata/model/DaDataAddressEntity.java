package com.technokratos.util.dadata.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DaDataAddressEntity {

    @SerializedName("source")
    private String source;

    @SerializedName("result")
    private String result;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("country")
    private String country;

    @SerializedName("region_fias_id")
    private String regionFiasId;

    @SerializedName("region_kladr_id")
    private String regionKladrId;

    @SerializedName("region_with_type")
    private String regionWithType;

    @SerializedName("region_type")
    private String regionType;

    @SerializedName("region_type_full")
    private String regionTypeFull;

    @SerializedName("region")
    private String region;

    @SerializedName("area_fias_id")
    private String areaFiasId;

    @SerializedName("area_kladr_id")
    private String areaKladrId;

    @SerializedName("area_with_type")
    private String areaWithType;

    @SerializedName("area_type")
    private String areaType;

    @SerializedName("area_type_full")
    private String areaTypeFull;

    @SerializedName("area")
    private String area;

    @SerializedName("city_fias_id")
    private String cityFiasId;

    @SerializedName("city_kladr_id")
    private String cityKladrId;

    @SerializedName("city_with_type")
    private String cityWithType;

    @SerializedName("city_area")
    private String cityArea;

    @SerializedName("city_district")
    private String cityDistrict;

    @SerializedName("city_type")
    private String cityType;

    @SerializedName("city_type_full")
    private String cityTypeFull;

    @SerializedName("city")
    private String city;

    @SerializedName("settlement_fias_id")
    private String settlementFiasId;

    @SerializedName("settlement_kladr_id")
    private String settlementKladrId;

    @SerializedName("settlement_with_type")
    private String settlementWithType;

    @SerializedName("settlement_type")
    private String settlementType;

    @SerializedName("settlement_type_full")
    private String settlementTypeFull;

    @SerializedName("settlement")
    private String settlement;

    @SerializedName("street_fias_id")
    private String streetFiasId;

    @SerializedName("street_kladr_id")
    private String streetKladrId;

    @SerializedName("street_with_type")
    private String streetWithType;

    @SerializedName("street_type")
    private String streetType;

    @SerializedName("street_type_full")
    private String streetTypeFull;

    @SerializedName("street")
    private String street;

    @SerializedName("house_fias_id")
    private String houseFiasId;

    @SerializedName("house_kladr_id")
    private String houseKladrId;

    @SerializedName("house_type")
    private String houseType;

    @SerializedName("house_type_full")
    private String houseTypeFull;

    @SerializedName("house")
    private String house;

    @SerializedName("block_type")
    private String blockType;

    @SerializedName("block_type_full")
    private String blockTypeFull;

    @SerializedName("block")
    private String block;

    @SerializedName("flat_type")
    private String flatType;

    @SerializedName("flat_type_full")
    private String flatTypeFull;

    @SerializedName("flat")
    private String flat;

    @SerializedName("flat_area")
    private double flatArea;

    @SerializedName("square_meter_price")
    private double squareMeterPrice;

    @SerializedName("flat_price")
    private double flatPrice;

    @SerializedName("postal_box")
    private String postalBox;

    @SerializedName("fias_id")
    private String fiasId;

    @SerializedName("kladr_id")
    private String kladrId;

    @SerializedName("okato")
    private String okato;

    @SerializedName("oktmo")
    private String oktmo;

    @SerializedName("tax_office")
    private String taxOffice;

    @SerializedName("tax_office_legal")
    private String taxOfficeLegal;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("geo_lat")
    private double geoLat;

    @SerializedName("geo_lon")
    private double geoLon;

    @SerializedName("beltway_distance")
    private String beltwayDistance;

    @SerializedName("unparsed_parts")
    private String unparsedParts;
}
