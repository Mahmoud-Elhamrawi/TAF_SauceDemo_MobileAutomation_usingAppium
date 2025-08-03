package Utils.FileUtils;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileClass {

    public static void cleanFolder(File folderPath) {
        try {
            FileUtils.deleteQuietly(folderPath);
        } catch (Exception e) {
            LogClass.error("failed to clean folder" + e.getMessage());
        }

    }


}
