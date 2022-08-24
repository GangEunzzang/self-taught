package gang.study.crud.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    public static void main(String[] args) throws IOException {

        File file = new File("/Users/igang-eun/Desktop/test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        List<String> aLines = new ArrayList<String>();


        while ((line = reader.readLine()) != null) {
            aLines.add(line);
        }

        aLines.remove(aLines.get(0));
        aLines.remove(aLines.size()-1);

        for (int i=0; i<aLines.size(); i++) {

            String[] a = aLines.get(i).split("\\|");
            FileDTO dto = new FileDTO();

            System.out.println("값은? " + a[0]);

            dto = dto.builder().one1(a[0]).one2(a[1]).one3(a[2])
                    .one4(a[3]).one5(a[4]).one6(a[5])
                    .one7(a[6]).one8(a[7]).one9(a[8])
                    .one10(a[9]).one11(a[10]).one12(a[11])
                    .one13(a[12]).one14(a[13]).one15(a[14])
                    .build();
            System.out.println(dto);
        }




        reader.close();
    }

}