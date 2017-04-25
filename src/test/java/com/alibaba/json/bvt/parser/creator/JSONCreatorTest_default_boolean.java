package com.alibaba.json.bvt.parser.creator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import junit.framework.TestCase;
import org.junit.Assert;

public class JSONCreatorTest_default_boolean extends TestCase {

    public void test_create() throws Exception {
        Model model = JSON.parseObject("{\"id\":false,\"name\":\"wenshao\"}", Model.class);
        Assert.assertFalse(model.id);
        Assert.assertEquals("wenshao", model.name);
    }

    public void test_createMissingField() throws Exception {
        try {
            JSON.parseObject("{\"name\":\"wenshao\"}", Model.class);
            fail();
        } catch (JSONException e) {
            assertEquals("Missing field 'id' to deserialize JSON to type 'com.alibaba.json.bvt.parser.creator." + getClass().getSimpleName() + "$Model'", e.getMessage());
        }
    }

    public static class Model {

        private final boolean id;
        private final String name;

        @JSONCreator
        public Model(@JSONField(name="id") boolean id, @JSONField(name="name") String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Value {

    }
}
