package ua.zhdanova.hw19;

import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoDBHandler mongoDBHandler = null;
        try {
            People people = new People("Maria Zhdanova", 24);

            String jsonString = JsonProcessor.convertObjectToJson(people);
            System.out.println("JSON String: " + jsonString);

            People deserializedObject = JsonProcessor.convertJsonToObject(jsonString, People.class);
            System.out.println("Deserialized Object: " + deserializedObject);

            mongoDBHandler = new MongoDBHandler("mongodb://localhost:27017",
                    "Mongo", "Maria");

            Document document = new Document("name", "Alice").append("age", 30);
            mongoDBHandler.insertDocument(document);

            Document foundDocument = mongoDBHandler.findDocument("name", "Alice");
            System.out.println("Found Document: " + foundDocument);

            Document updatedDocument = new Document("age", 31);
            mongoDBHandler.updateDocument("name", "Alice", updatedDocument);

            mongoDBHandler.deleteDocument("name", "Alice");

        } catch (Exception e) {
            throw new RuntimeException("An error occurred: " + e);
        } finally {
            if (mongoDBHandler != null) {
                try {
                    mongoDBHandler.closeConnection();
                } catch (Exception e) {
                    throw new RuntimeException("Error closing MongoDB connection: " + e);
                }
            }
        }
    }
}

