package gang.study.crud.file;

import gang.study.crud.file.domain.repository.CooconDataRepository;
import gang.study.crud.file.dto.CooconDataDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.StopWatch;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class FileTest {


    private final CooconDataRepository cooconDataRepository;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        File file = new File("/Users/igang-eun/Desktop/coocon/INDUSTRY_MOD.20220814");
//        File file = new File("/Users/igang-eun/Desktop/test.txt");
        List<CooconDataDTO> cooconDataDTOList = FileInsert.fileRead(file);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        String start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss"));
        // ***********************************************************
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/self";
//        String id = "root";
//        String pw = "12345678";
//
//        Connection con = DriverManager.getConnection(url,id,pw);
//
//        PreparedStatement stmt = null;
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
//            // addBatch??? ??????
//            stmt.addBatch();
//
//            // ???????????? Clear
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


//        String selectSql = "select company_register_num,  " +
//                "franchisee_name, large_sectors_code, " +
//                "large_sectors_name, franchisee_address, " +
//                "postal_code, update_date " +
//                "from coocon_data" ;
//
//        ResultSet rs;
//
//        stmt = con.prepareStatement(selectSql);
//        rs = stmt.executeQuery(selectSql); // ????????? ?????????
//
//        List<ImportantDataDTO> importantDataDTOList = new ArrayList<>();
//
//        while (rs.next()) {
//            ImportantDataDTO coocon = ImportantDataDTO.CooconDataRefine(rs);
//            importantDataDTOList.add(coocon);
//        }
//
//        for(int i = 1; i<importantDataDTOList.size(); i++){
//            System.out.println("?????? ???????????? : " + importantDataDTOList.get(i));
//        }
//        System.out.println("????????? : " + importantDataDTOList.size());
//
//        stmt.close();
        stopWatch.stop();


        String end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss"));

        System.out.println("?????? ?????? ?????? : " + start);
        System.out.println("?????? ?????? ?????? : " + stopWatch.getTime(TimeUnit.SECONDS) + "???");
        System.out.println("?????? ?????? ?????? : " + end);
        System.out.println("?????? ?????? ?????? : " + end);
    }



}