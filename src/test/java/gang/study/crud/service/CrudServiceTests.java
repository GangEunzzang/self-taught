package gang.study.crud.service;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.PageRequestDTO;
import gang.study.crud.dto.PageResultDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.service.CrudService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrudServiceTests {

    @Autowired
    private CrudService service;

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(2).size(10).build();

        PageResultDTO<CrudDTO, Crud> resultDTO = service.getList(pageRequestDTO);

        for(CrudDTO crudDTO : resultDTO.getDtoList()) {
            System.out.println(crudDTO);
        }
    }
}
