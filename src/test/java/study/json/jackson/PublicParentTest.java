package study.json.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PublicParentTest {
    private static final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    static void beforeAll() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void should_return_parent_when_not_son() {
        String json = """
            {"type": "b", "name": "parent", "a": "i is a"}""";
        PublicParent res = Assertions.assertDoesNotThrow(() -> mapper.readValue(json, PublicParent.class));
        Assertions.assertEquals("parent", res.getName());
    }

    @Test
    void should_return_son_when_is_son() {
        String json = """
            {"type": "a", "name": "son", "a": "i is a"}""";
        SonA res = (SonA) Assertions.assertDoesNotThrow(() -> mapper.readValue(json, PublicParent.class));
        Assertions.assertEquals("i is a", res.getA());
    }
}