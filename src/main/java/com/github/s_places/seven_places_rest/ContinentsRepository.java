package com.github.s_places.seven_places_rest;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/** 
 * @author splaces.project@gmail.com
 * Combined DAO and Rest "magic entity" for
 * representation of a content.
 */
public interface ContinentsRepository extends MongoRepository<Continent, Integer> {

    /** @return all records from the database and represent it via REST controller */
    @Override
    List<Continent> findAll();

}