package ua.zhdanova.hw19;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObjectToJson(Object object) throws Exception {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T convertJsonToObject(String json, Class<T> valueType) throws Exception {
        return objectMapper.readValue(json, valueType);
    }
}
