package pp.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonDemo {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> toMap(String json) throws IOException {
        Map<String, Object> map = objectMapper.readValue(json, HashMap.class);
        return map;
    }

    public static String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("classId", 123);
        map.put("className", "asdf");
        Map<String, Object> member = new HashMap<>();
        map.put("member", member);
        member.put("name", "jo");
        member.put("sex", "male");

        String json = toJson(map);
        System.out.println(json);

        LogPOJO logPOJO = objectMapper.readValue(json, LogPOJO.class);
        System.out.println(logPOJO);

        System.out.println(toJson(logPOJO));

        map = toMap(json);
        System.out.println(map);
    }
}
