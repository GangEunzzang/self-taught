package gang.study.crud.service;


import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.CrudReplyDTO;
import gang.study.crud.dto.PageRequestDTO;
import gang.study.crud.dto.PageResultDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.entity.CrudReply;

import java.util.List;
import java.util.stream.Collectors;

public interface CrudService {


//    List<CrudDTO> getListQuerydsl(CrudSearchCondition condition);
    //목록보기
    PageResultDTO<CrudDTO, Crud> getList(PageRequestDTO requestDTO);

    //등록
    Long register(CrudDTO dto);

    //상세보기
    CrudDTO read(Long bno );

    void modify(CrudDTO dto);

    //삭제
    void delete(Long dto);



    default CrudDTO entityToDTO(Crud entity){
        CrudDTO dto = CrudDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
        return dto;
    };

    // entity를 dto로 변환
    default CrudDTO entitiesToDTO(Crud entity, List<CrudReply> crudReply){
        CrudDTO dto = CrudDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();

        // crudReply 쿼리로 불러온 값을 받아와서 배열 원소 가공을 위해 ㅌ
        // stream.map() <- 요소들을 특정조건에 해당하는 값으로 변환해줌
        // 람다식을 이용해서 reply에 값을 담고 그 후 builder패턴을 통해 값 변환 후 list로 변환

        List<CrudReplyDTO> crudReplyDTOList = crudReply.stream().map(reply -> {
            return CrudReplyDTO.builder()
                    .content(reply.getContent())
                    .build();
        }).collect(Collectors.toList());

        dto.setCrudReplyDTOList(crudReplyDTOList);

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
