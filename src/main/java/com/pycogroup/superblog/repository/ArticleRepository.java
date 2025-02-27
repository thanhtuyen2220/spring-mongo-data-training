package com.pycogroup.superblog.repository;

import com.pycogroup.superblog.model.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, ObjectId> {
    //Article findByArticleId(ObjectId id);
    Article findArticleById(ObjectId id);
    Article deleteArticleById(ObjectId id);
    //Article findByArticleId(ObjectId id);
}
