package com.github.s_places.seven_places_rest;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** 
 * @author splaces.project@gmail.com
 * Entity class for main objects 
 */
@Document(collection = "continents_continent")
public @Data class Continent {

    /** @value protocol for image link fields */
    private static final String PREFIX = "http://";
    /** @value domain name for image link fields */
    private static final String HOST = "localhost";
    /** @value port to connect for image link fields */
    private static final String PORT = "8080";

    /** @return concated value path to file in image fields */
    private String getHostname() {
        return PREFIX + HOST + ":" + PORT + "/";
    }

    /** Id of the record in database */
    @Id
    private String id;

    /** Number of a place */
    @Field
    private int number;

    /** Name of a place */
    @Field
    private String name;

    /** Name of a country when a place is located */
    @Field
    private String country;

    /** Human population of a place */
    @Field
    private long population;

    /** Information about the place */
    @Field
    private String overview;

    /** Main languages of a place */
    @Field
    private String languages;

    /** Foto of a place */
    @Field(value = "first_image")
    private String firstImage;

    /** Foto of a place */
    @Field(value = "second_image")
    private String secondImage;

    /** Foto of a place */
    @Field(value = "third_image")
    private String thirdImage;

    /** @return full path and name of the first foto of a place */
    public String getFirstImage() {
        return getHostname() + firstImage;
    }

    /** @return full path and name of the second foto of a place */
    public String getSecondImage() {
        return getHostname() + secondImage;
    }

    /** @return full path and name of the third foto of a place */
    public String getThirdImage() {
        return getHostname() + thirdImage;
    }
}