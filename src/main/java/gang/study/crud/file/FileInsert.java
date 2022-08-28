package gang.study.crud.file;

import gang.study.crud.file.domain.entity.CooconData;
import gang.study.crud.file.dto.CooconDataDTO;
import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileInsert {

    private File file;

    public static List<CooconDataDTO> fileRead(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        System.out.println("파일명 : " + file.getName());
        System.out.println("파일 위치 : " + file.getPath());
        System.out.println("파일 사이즈 :" + file.length() + "byte");

        String line;

        List<String> aLines = new ArrayList<String>();

        // 이번줄의 내용이 있으면 읽어온다.
        while ((line = reader.readLine()) != null) {
            aLines.add(line);
        }

        //TODO: 첫번째 줄(S로 시작하는지 검증 로직 구현)
        //TODO: 마지막 줄(E로 시작하는지 검증 및 데이터 수 비교 구현)
        aLines.remove(aLines.get(0));
        aLines.remove(aLines.size()-1);

        List<CooconDataDTO> cooconDataDTOList = CooconDataDTO.readDataToDTO(aLines);
        reader.close();
        return cooconDataDTOList;
    }
}
