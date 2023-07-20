package com.mongoDBApi.api.repository;

import com.mongoDBApi.api.model.IL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILRepository extends MongoRepository<IL,String> {

}
