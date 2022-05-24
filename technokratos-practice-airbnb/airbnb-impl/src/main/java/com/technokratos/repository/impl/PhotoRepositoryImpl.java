package com.technokratos.repository.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.technokratos.model.PhotoEntity;
import com.technokratos.repository.PhotoRepository;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PhotoRepositoryImpl implements PhotoRepository {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    @Override
    public String savePhoto(MultipartFile photo) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("size", photo.getSize());
        ObjectId id = gridFsTemplate.store(
                photo.getInputStream(), photo.getOriginalFilename() + UUID.randomUUID(), photo.getContentType(), metaData);
        return id.toString();
    }

    @Override
    public void delete(String id) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }

    @Override
    public Optional<PhotoEntity> findById(String id) throws IOException {
        GridFSFile gridFsFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        PhotoEntity photo = null;

        if (gridFsFile != null && gridFsFile.getMetadata() != null) {
            photo = new PhotoEntity();
            photo.setId(gridFsFile.getId().toString());
            photo.setName(gridFsFile.getFilename());
            photo.setType(gridFsFile.getMetadata().get("_contentType").toString());
            photo.setSize(gridFsFile.getMetadata().get("size").toString());
            photo.setPhoto(IOUtils.toByteArray(operations.getResource(gridFsFile).getInputStream()));
        }

        return Optional.ofNullable(photo);
    }
}
