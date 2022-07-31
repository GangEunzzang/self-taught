package gang.study.crud.controller;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.CrudReplyDTO;
import gang.study.crud.service.CrudReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CrudReplyController {

    private final CrudReplyService crudReplyService;

    @GetMapping("/crud/{bno}")
    public ResponseEntity<List<CrudReplyDTO>> getList(@PathVariable("bno")Long bno){
        log.info("댓글 작동");
        List<CrudReplyDTO> crudReplyDTOList = crudReplyService.getListOfCrud(bno);

        return new ResponseEntity<>(crudReplyDTOList, HttpStatus.OK);
    }



}
