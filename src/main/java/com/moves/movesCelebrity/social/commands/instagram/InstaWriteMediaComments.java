package com.moves.movesCelebrity.social.commands.instagram;

import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.dao.SocialMediaPostDao;
import com.moves.movesCelebrity.social.types.Command;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class InstaWriteMediaComments implements Command<Void, ArrayList<Document>> {


    @Override
    public CompletableFuture<Void> execute(ArrayList<Document> documents) {
        return CompletableFuture.supplyAsync(() -> {
            insert(documents);
            return null;
        });
    }

    public void insert(ArrayList<Document> documents) {
        if (documents != null && documents.size() != 0)
            SocialMediaPostDao.insertMany(documents, MovesConfiguration.COLLECTION_MEDIA_COMMENTS);
    }
}
