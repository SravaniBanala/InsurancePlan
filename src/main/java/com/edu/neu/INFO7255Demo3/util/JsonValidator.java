package com.edu.neu.INFO7255Demo3.util;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;

/* validating JSON data against JSON Schema */
@Service
public class JsonValidator {
    public void validateJson(JSONObject object) throws IOException {
        try(InputStream inputStream = getClass().getResourceAsStream("/plan-schema.json")){
        	
        	/* Reading and parsing into JSON object */
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            
            /* load and parse the JSON Schema represented by the rawSchema into a Schema object */
            Schema schema = SchemaLoader.load(rawSchema);
             
            /* validate JSONObject (object) against the loaded schema */
            schema.validate(object);
        }
    }
}
