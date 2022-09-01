package gang.study.crud.service;

import gang.study.crud.dto.CrudReplyDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.entity.CrudReply;

import java.util.List;

public interface CrudReplyService {

    List<CrudReplyDTO> getListOfCrud(Long bno);

    Long register(CrudReplyDTO crudReplyDTO);

    default CrudReply dtoToEntity(CrudReplyDTO crudReplyDTO){
        CrudReply crudReply = CrudReply.builder()
                .rno(crudReplyDTO.getRno())
                .content(crudReplyDTO.getContent())
                .crud(Crud.builder().bno(crudReplyDTO.getCrud()).build())
                .build();
        return crudReply;
    }

    default CrudReplyDTO entityToDTO(CrudReply crudReply){
        CrudReplyDTO crudReplyDTO = CrudReplyDTO.builder()
                .rno(crudReply.getRno())
                .content(crudReply.getContent())
                .crud(crudReply.getCrud().getBno())
                .build();
        return crudReplyDTO;
    }

}
