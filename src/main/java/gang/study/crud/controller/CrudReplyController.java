package gang.study.crud.controller;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.CrudReplyDTO;
import gang.study.crud.entity.CrudReply;
import gang.study.crud.file.domain.repository.querydsl.CooconQueryRepository;
import gang.study.crud.service.CrudReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.security.Principal;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CrudReplyController {

    private final CrudReplyService crudReplyService;
    private final CooconQueryRepository cooconQueryRepository;

    @GetMapping("/crud/{bno}")
    public ResponseEntity<List<CrudReplyDTO>> getList(@PathVariable("bno")Long bno){
        log.info("댓글 작동");
        List<CrudReplyDTO> crudReplyDTOList = crudReplyService.getListOfCrud(bno);

        return new ResponseEntity<>(crudReplyDTOList, HttpStatus.OK);
    }

    @PostMapping("/crud/{bno}")
    public ResponseEntity<Long> addCrudReply(@RequestBody CrudReplyDTO crudReplyDTO){
        Long rno = crudReplyService.register(crudReplyDTO);
        return new ResponseEntity<>(rno,HttpStatus.OK);
    }

    @GetMapping("test/{id}")
    public boolean getTest(@PathVariable String id) {
        boolean exists = cooconQueryRepository.exists(id);

        return exists;
    }



}
