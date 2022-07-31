package gang.study.crud.controller;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.service.CrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CrudController {

    private final CrudService crudService;

    @GetMapping("/list")
    public void select(Model model) {
        //서비스 호출
        //view페이지로 전달
    }

    @GetMapping("/register")
    public void register(){
    }

    @PostMapping("/register")
    public String register(CrudDTO dto){
        log.info("등록 로그 -------------------");
        log.info("CrudDTO" + dto);
        crudService.register(dto);

        return "redirect:/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(Long bno, Model model){

        log.info("상세보기 로그 -----------------");
        log.info("몇번 상세보기 하는중?"+ bno);

        CrudDTO dto = crudService.read(bno);

        model.addAttribute("dto", dto );
    }


    @PostMapping("/modify")
    public String modify(CrudDTO dto){
        log.info("수정하기 로그 ----------");
        log.info("dto ----" + dto);

        crudService.modify(dto);

        return "redirect:/read?bno="+dto.getBno();
    }

    @GetMapping("/delete")
    public String delete(Long bno){
        log.info("삭제하기 로그-------");
        log.info(bno+"번 삭제완료");

        crudService.delete(bno);
        return "redirect:/list";
    }
}
