package Utils.DataUtil;

import Utils.LogUtil.LogClass;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadJsonFile {

    static String fileName;
    static String filePath = "src/test/resources/TestData/";
    static String jsonReader;


    public ReadJsonFile(String fileName) {
        ReadJsonFile.fileName = fileName;

        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath + fileName + ".json"));
            jsonReader = jsonObject.toJSONString();
            LogClass.info("json file loaded");
        } catch (Exception e) {
            LogClass.error("failed to load json file" + e.getMessage());
        }
    }


    // get json data
    public static String getJsonData(String key) {
        String jsonData;
        try {
            jsonData = JsonPath.read(jsonReader, key);
            return jsonData;
        } catch (Exception e) {
            LogClass.error("failed to get json key " + e.getMessage());
            return null;
        }
    }



}
