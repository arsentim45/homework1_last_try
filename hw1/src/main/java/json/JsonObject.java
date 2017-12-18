package json;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private ArrayList<JsonPair> jsonArray = new ArrayList();
    public JsonObject(JsonPair... jsonPairs) {
        jsonArray.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        StringBuffer jsonStringBuff = new StringBuffer("{");
        for (JsonPair pair : jsonArray){
            jsonStringBuff.append("'"+pair.key+"'").append(": ").append(pair.value.toJson()).append(", ");
        }
        if (jsonStringBuff.length() > 10) {
            jsonStringBuff.deleteCharAt(jsonStringBuff.length() - 1);
            jsonStringBuff.deleteCharAt(jsonStringBuff.length() - 1);
        }
        jsonStringBuff.append("}");
        String jsonString = jsonStringBuff.toString();
        return jsonString;
    }

    public void add(JsonPair jsonPair) {
        jsonArray.add(jsonPair);
    }

    public Json find(String name) {
        for(JsonPair pair : jsonArray){
            if(name.equals(pair.key)){
                return pair.value;
            }


        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject obj = new JsonObject();
        for (String name : names){
            if (this.find(name) != null){
                obj.add(new JsonPair(name, new JsonString(this.find(name).toJson())));
            }
            else {
                return null;
            }
        }
        return obj;
    }
}
