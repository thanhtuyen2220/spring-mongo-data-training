package com.pycogroup.superblog.repository;

import com.pycogroup.superblog.model.Comment;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CustomCommentRepositoryImpl implements CustomCommentRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomCommentRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void activateCommentById(ObjectId commentId) {
        Query query = new Query(Criteria.where("id").is(commentId));
        Update update = new Update();
        update.set("enabled", true);
        mongoTemplate.updateFirst(query, update, Comment.class);
    }

    @Override
    public void deactivateCommentById(ObjectId commentId) {
        Query query = new Query(Criteria.where("id").is(commentId));
        Update update = new Update();
        update.set("enabled", false);
        mongoTemplate.updateFirst(query, update, Comment.class);
    }
}
