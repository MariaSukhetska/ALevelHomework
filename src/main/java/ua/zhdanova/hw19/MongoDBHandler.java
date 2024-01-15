package ua.zhdanova.hw19;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBHandler {
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    public MongoDBHandler(String connectionString, String databaseName, String collectionName) {
        this.mongoClient = MongoClients.create(connectionString);
        this.collection = mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public void insertDocument(Document document) {
        collection.insertOne(document);
    }

    public Document findDocument(String key, String value) {
        return collection.find(new Document(key, value)).first();
    }

    public void updateDocument(String key, String value, Document updatedDocument) {
        collection.updateOne(new Document(key, value), new Document("$set", updatedDocument));
    }

    public void deleteDocument(String key, String value) {
        collection.deleteOne(new Document(key, value));
    }

    public void closeConnection() {
        mongoClient.close();
    }
}
