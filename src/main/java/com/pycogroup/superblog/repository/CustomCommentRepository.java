package com.pycogroup.superblog.repository;

import org.bson.types.ObjectId;

public interface CustomCommentRepository {
    void activateCommentById(ObjectId commentId);
    void deactivateCommentById(ObjectId commentId);
}
