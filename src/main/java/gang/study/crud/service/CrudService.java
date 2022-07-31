package gang.study.crud.service;


import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.PageRequestDTO;
import gang.study.crud.dto.PageResultDTO;
import gang.study.crud.entity.Crud;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CrudService {

    //목록보기
    PageResultDTO<CrudDTO, Crud> getList(PageRequestDTO requestDTO);

    //등록
    Long register(CrudDTO dto);

    //상세보기
    CrudDTO read(Long bno );

    void modify(CrudDTO dto);

    //삭제
    void delete(Long dto);

    // entity를 dto로 변환
    default CrudDTO entityToDTO(Crud entity){
        CrudDTO dto = CrudDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
        return dto;
    }

    // dto를 entity로 변환
    default Crud dtoToEntity(CrudDTO dto){
        Crud crud = Crud.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return crud;
    }
}
