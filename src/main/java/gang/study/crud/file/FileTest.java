package gang.study.crud.file;

import gang.study.crud.file.dto.CooconDataDTO;
import gang.study.crud.file.dto.ImportantDataDTO;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

//        File file = new File("/Users/igang-eun/Desktop/coocon/INDUSTRY_ALL.20220814");
        File file = new File("/Users/igang-eun/Desktop/test.txt");
        FileInsert.fileRead(file);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        String start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss"));
        // ***********************************************************
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/self";
        String id = "root";
        String pw = "12345678";

        Connection con = DriverManager.getConnection(url,id,pw);

        PreparedStatement stmt = null;
//        con.setAutoCommit(false);
//
//        String sql = "insert into coocon_data " +
//                "(company_register_num, franchisee_name, " +
//                " large_sectors_code, large_sectors_name, " +
//                " medium_sectors_code, medium_sectors_name, " +
//                " small_sectors_code, small_sectors_name, " +
//                " franchisee_address, postal_code, " +
//                " update_date, franchisee_info_status, " +
//                " franchisee_info_division, close_date) " +
//                " value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        stmt = con.prepareStatement(sql);
//        for(int i = 0; i < cooconDataDTOList.size(); i++ ) {
//
//            CooconDataDTO dataDTO = cooconDataDTOList.get(i);
//
//            stmt.setString(1, dataDTO.getCompanyRegisterNum());
//            stmt.setString(2,dataDTO.getFranchiseeName());
//            stmt.setString(3, dataDTO.getLargeSectorsCode());
//            stmt.setString(4, dataDTO.getLargeSectorsName());
//            stmt.setString(5, dataDTO.getMediumSectorsCode());
//            stmt.setString(6, dataDTO.getMediumSectorsName());
//            stmt.setString(7, dataDTO.getSmallSectorsCode());
//            stmt.setString(8, dataDTO.getSmallSectorsName());
//            stmt.setString(9, dataDTO.getFranchiseeAddress());
//            stmt.setString(10, dataDTO.getPostalCode());
//            stmt.setString(11, dataDTO.getUpdateDate());
//            stmt.setString(12, dataDTO.getFranchiseeInfoStatus());
//            stmt.setString(13, dataDTO.getFranchiseeInfoDivision());
//            stmt.setString(14, dataDTO.getCloseDate());
//
//            // addBatch에 담기
//            stmt.addBatch();
//
//            // 파라미터 Clear
//            stmt.clearParameters() ;
//
//            if( (i % 6000) == 0){
//                stmt.executeBatch() ;
//                stmt.clearBatch();
//                con.commit() ;
//            }
//        }
//        stmt.executeBatch() ;
//        con.commit() ;


        String selectSql = "select company_register_num,  " +
                "franchisee_name, large_sectors_code, " +
                "large_sectors_name, franchisee_address, " +
                "postal_code, update_date " +
                "from coocon_data" ;

        ResultSet rs;

        stmt = con.prepareStatement(selectSql);
        rs = stmt.executeQuery(selectSql); // 여기에 담긴다

        List<ImportantDataDTO> importantDataDTOList = new ArrayList<>();

        while (rs.next()) {
            ImportantDataDTO coocon = ImportantDataDTO.CooconDataRefine(rs);
            importantDataDTOList.add(coocon);
        }

        for(int i = 1; i<importantDataDTOList.size(); i++){
            System.out.println("변환 데이터는 : " + importantDataDTOList.get(i));
        }
        System.out.println("크기는 : " + importantDataDTOList.size());

        stmt.close();
        stopWatch.stop();

        String end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss"));

        System.out.println("작업 시작 시간 : " + start);
        System.out.println("작업 소요 시간 : " + stopWatch.getTime(TimeUnit.SECONDS) + "초");
        System.out.println("작업 종료 시간 : " + end);
    }



}