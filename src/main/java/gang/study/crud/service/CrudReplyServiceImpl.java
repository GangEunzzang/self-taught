package gang.study.crud.service;

import gang.study.crud.dto.CrudReplyDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.entity.CrudReply;
import gang.study.crud.repository.CrudReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class CrudReplyServiceImpl implements CrudReplyService{

    private final CrudReplyRepository crudReplyRepository;
    @Override
    public List<CrudReplyDTO> getListOfCrud(Long bno) {
        Crud crud = Crud.builder().bno(bno).build();

        List<CrudReply> result = crudReplyRepository.findByCrud(crud);

        return result.stream().map(crudReply ->
                entityToDTO(crudReply)).collect(Collectors.toList());
    }

    @Override
    public Long register(CrudReplyDTO crudReplyDTO) {
        CrudReply crudReply = dtoToEntity(crudReplyDTO);
        crudReplyRepository.save(crudReply);
        return crudReply.getRno();
    }

}
