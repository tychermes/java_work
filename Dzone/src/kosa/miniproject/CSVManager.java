package kosa.miniproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVManager {

    private List<List<String>> csvList = new ArrayList<List<String>>();

	public List<List<String>> readCSV() {
        File csv = new File("./sampleDB.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) { 
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        return csvList;
    }

	public void writeCSV(List<List<String>> dataList) {
//		List<List<String>> dataList = new ArrayList<List<String>>();
	    File csv = new File("./sampleDB.csv");
	    BufferedWriter bw = null; // 출력 스트림 생성
	    try {
	        bw = new BufferedWriter(new FileWriter(csv));
//	        bw = new BufferedWriter(new FileWriter(csv, true));
	        // csv파일의 기존 값에 이어쓰려면 위처럼 true를 지정하고, 기존 값을 덮어쓰려면 true를 삭제한다

	        for (int i = 0; i < dataList.size(); i++) {
	        	List<String> data = dataList.get(i);
	            String aData = "";
	            for(int j=0; j<dataList.get(0).size(); j++) {
	            	aData += data.get(j); 
	            	if(j<dataList.get(0).size()-1) {
	            		aData += ","; // 한 줄에 넣을 각 데이터 사이에 ,를 넣는다
	            	}
	            }
	            bw.write(aData);  // 작성한 데이터를 파일에 넣는다
	            bw.newLine(); // 개행
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (bw != null) {
	                bw.flush(); // 남아있는 데이터까지 보내 준다
	                bw.close(); // 사용한 BufferedWriter를 닫아 준다
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
    public List<List<String>> getCsvList() {
		return csvList;
	}

	public void setCsvList(List<List<String>> csvList) {
		this.csvList = csvList;
	}
    
}