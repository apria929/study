package common.bigData;
/**
 *  主类
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int wordNum = 10000000;
        int splitsNum = 5000;
        WordUtil wordUtil = new WordUtil();
        wordUtil.genWords2File(wordNum);
        File bigFile = new File(wordUtil.bigFilePath);
        File[] splits = new File(wordUtil.splitFilesPath).listFiles();
        wordUtil.writeWords2Splits(bigFile, splitsNum);
        System.out.println(">>>>>> Start statistic Top 100 frequently occurred words in each split file.");
        List<Map.Entry<String, Integer>> totalList = new ArrayList<>();
        for (File split : splits) {
            List<Map.Entry<String, Integer>> top100List = wordUtil.readSplitFile(split);
            totalList.addAll(top100List);
            top100List.clear();
        }
        wordUtil.sort(totalList);
        System.out.println(">>>>>> Top 100 frequently occured (word, count): ");
        System.out.println(totalList.subList(0, 100));

    }
}