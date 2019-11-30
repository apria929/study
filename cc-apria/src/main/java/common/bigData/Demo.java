package common.bigData;


import common.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.SecureRandom;
import java.util.*;


public class Demo {
    private static Logger logger= LoggerFactory.getLogger(Demo.class);
    private static   String bigWordfile="/Users/apria/codes/data/bigData.txt";
    private static   String splitFilesPath = "/Users/apria/codes/data/splitFiles/";
    private static   String sample = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static   int maxlength=50;
    private static   int write_batch_size=100;
    private static   int numOfSplits=100;


    public static void main(String[] args) {
        if (args.length>0){
            String type=args[0];
            long start=System.currentTimeMillis();
          logger.info("start..."+type+new Date());
            if ("1".equals(type)){
                int numberOfWords=Integer.parseInt(args[1]);
                bigWordfile= PropertiesUtil.get("bigWordfile");
                createWordFile(bigWordfile,numberOfWords);
            }else if ("2".equals(type)){
                bigWordfile= PropertiesUtil.get("bigWordfile");
                numOfSplits= Integer.parseInt(PropertiesUtil.get("numOfSplits"));
                splitFilesPath= PropertiesUtil.get("splitFilesPath");

                File bigFile = new File(bigWordfile);
                writeWords2Splits(bigFile,splitFilesPath,numOfSplits);
                File[] splits = new File(splitFilesPath).listFiles();
                List<Map.Entry<String, Integer>> totalList = new ArrayList<>();
                for (File file:splits){
                    totalList.addAll(readSplitFile(file));
                }
                Collections.sort(totalList, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue()-o1.getValue();
                    }
                });
                logger.info(String.valueOf(totalList.subList(0,10)));
            }
            logger.info("end..."+type+(System.currentTimeMillis()-start));
        }else {
            logger.info("no params");
        }

    }


    private static void createWordFile(String bigWordfile,int numberOfWords){
        File file =new File(bigWordfile);
        SecureRandom secureRandom=new SecureRandom();
        int temp=0;
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            if (file.exists()){
                file.delete();
            }
            fileWriter=new FileWriter(file,true);
            bufferedWriter=new BufferedWriter(fileWriter);
            for (int i=0;i<numberOfWords;i++){
                int len= secureRandom.nextInt(maxlength);
                len=len>0?len:1;
                StringBuilder stringBuilder=new StringBuilder();
                for (int j=0;j<len;j++){
                    stringBuilder.append(sample.charAt(secureRandom.nextInt(sample.length())));
                }
                bufferedWriter.write(stringBuilder.toString()+"\n");
                temp++;
                if (temp%write_batch_size==0){
                    bufferedWriter.flush();
                }
            }
            bufferedWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 遍历大文件中的words，对每个word取hash值并余，余数即split order
     * 建立numOfSplits 个文件句柄并存储在map中 减少建立句柄的消耗，
     * 建立numOfSplits 个列表也存储在map中，用于批量flush，提高效率
     * 相同word将被写入到同一个split小文件中，方便后续的读取出现次数
     * */
    public  static void writeWords2Splits(File bigFile, String splitFilesPath, int numOfSplits) {
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
              deleteFiles(splitFiles);
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static List<Map.Entry<String, Integer>> readSplitFile(File splitFile) {
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        Map<String,Integer> wordCntMap=new HashMap<>();
        try {
            fileReader=new FileReader(splitFile);
            bufferedReader=new BufferedReader(fileReader);
            String word = bufferedReader.readLine();
            while (word != null) {
                if (!wordCntMap.containsKey(word)) {
                    wordCntMap.put(word, 1);
                } else {
                    int cnt = wordCntMap.get(word);
                    cnt++;
                    wordCntMap.replace(word, cnt);
                }
                word = bufferedReader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Map.Entry<String,Integer>> cntList=new ArrayList<Map.Entry<String, Integer>>(wordCntMap.entrySet());
        Collections.sort(cntList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        if (cntList.size() >= 100) {
            return cntList.subList(0, 100);
        } else {
            return cntList;
        }
    }

    public static boolean deleteFiles(File file){
        boolean b=false;
        if (file.exists()){
            if (file.isDirectory()){
                for (File file1:file.listFiles()){
                    deleteFiles(file1);
                }
            }else {
                file.delete();
            }
            return file.delete();
        }else {
            return true;
        }
    }








}
