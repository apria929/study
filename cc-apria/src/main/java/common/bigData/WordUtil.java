package common.bigData;

import java.io.*;
import java.security.SecureRandom;
import java.util.*;

public class WordUtil {

    int maxLen = 16;
    int write_batch_size = 3;
    String sample = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String bigFilePath = "/Users/apria/codes/data/wordsFile.log";
    String splitFilesPath = "/Users/root/test/wordsTop100/splitFiles/";

    /**
     * generate random words
     *
     * */

    public void genWords2File(int numOfWords) {
        System.out.println(">>>>>> Start generating random words and writing to a big file.");
        SecureRandom secureRandom = new SecureRandom();
        int cnt = 0;
        File file = new File(bigFilePath);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            fw = new FileWriter(file, true);        // 文件可追加写
            bw = new BufferedWriter(fw);
            for (int i = 0; i < numOfWords; i++) {
                // word length
                int len = secureRandom.nextInt(maxLen);
                if (len == 0) {
                    len = 1;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len; j++) {
                    sb.append(sample.charAt(secureRandom.nextInt(sample.length())));
                }
                bw.write(sb.toString() + "\n");     // 必须要加换行符
                cnt++;
                if (cnt % write_batch_size == 0) {
                    // 批量flush，提高效率
                    bw.flush();
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /**
     * 遍历大文件中的words，对每个word取hash值并余，余数即split order
     * 相同word将被写入到同一个split小文件中，方便后续的读取出现次数
     *
     * */
    public void writeWords2Splits(File bigFile, int numOfSplits) {
        System.out.println(">>>>>> Start writing words that has same hashcode to split file.");
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        Map<Integer, BufferedWriter> bwMap = new HashMap<>();
        Map<Integer, LinkedList<String>> splitDataMap = new HashMap<>();
        try {
            fr = new FileReader(bigFile);
            br = new BufferedReader(fr);
            File splitFiles = new File(splitFilesPath);
            if (splitFiles.exists()) {
                splitFiles.delete();
            }
            splitFiles.mkdirs();
            for (int i = 0; i < numOfSplits; i++) {
                fw = new FileWriter(splitFilesPath + i + ".log", true);
                bw = new BufferedWriter(fw);
                bwMap.put(i, bw);
                splitDataMap.put(i, new LinkedList<>());
            }
            String word = br.readLine();
            while (word != null) {
                int hash = word.hashCode();
                hash = hash >= 0 ? hash : -hash;
                int splitOrder = hash % numOfSplits;
                // 根据splitOrder去获取同一个list（存储待写入同一个split文件的所有words）
                List<String> wordList = splitDataMap.get(splitOrder);
                wordList.add(word + "\n");
                // 属于同一个splitOrder的word，每积累到write_batch_size个，就批量写一次，并将wordList的内容清空
                if (wordList.size() % write_batch_size == 0) {
                    bw = bwMap.get(splitOrder);
                    for (String record : wordList) {
                        bw.write(record);
                    }
                    bw.flush();
                    wordList.clear();
                }
                word = br.readLine();
            }
            // 上面必须满write_batch_size个才执行写的操作，因此还需要将最后一次剩余的但不足write_batch_size的words写入
            for (Integer order : bwMap.keySet()) {
                LinkedList<String> list = splitDataMap.get(order);
                BufferedWriter writer = bwMap.get(order);
                for (String element : list) {
                    writer.write(element);
                }
                writer.flush();
                writer.close();
                list.clear();
            }
            bwMap.clear();
            splitDataMap.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 读取各split小文件，统计每个小文件中出现次数前100的word及其次数
     *
     * */
    public List<Map.Entry<String, Integer>> readSplitFile(File splitFile) {
        FileReader fr = null;
        BufferedReader br = null;
        Map<String, Integer> wordCntMap = new HashMap<>();
        try {
            fr = new FileReader(splitFile);
            br = new BufferedReader(fr);
            String word = br.readLine();
            while (word != null) {
                if (!wordCntMap.containsKey(word)) {
                    wordCntMap.put(word, 1);
                } else {
                    int cnt = wordCntMap.get(word);
                    cnt++;
                    wordCntMap.replace(word, cnt);
                }
                word = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> cntList = new ArrayList<Map.Entry<String, Integer>>(wordCntMap.entrySet());
        sort(cntList);
        if (cntList.size() >= 100) {
            return cntList.subList(0, 100);
        } else {
            return cntList;
        }

    }

    /**
     * 对List<Map<key, value>>按照value降序排序
     * */
    public void sort(List<Map.Entry<String, Integer>> map) {
        Collections.sort(map, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
    }
}





