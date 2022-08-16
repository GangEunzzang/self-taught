package gang.study.crud.service;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.PageRequestDTO;
import gang.study.crud.dto.PageResultDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.entity.CrudReply;
import gang.study.crud.querydsl.CrudSearchCondition;
import gang.study.crud.repository.CrudReplyRepository;
import gang.study.crud.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CrudServiceImpl implements CrudService {

    private final ModelMapper modelMapper;
    private final CrudRepository crudRepository;
    private final CrudReplyRepository crudReplyRepository;
//    @Override
//    public List<CrudDTO> getList() {
//        List<Crud> result = crudRepository.findAll();
//        List<CrudDTO> list = result.stream().map(crud -> entityToDTO(crud)).collect(Collectors.toList());
//        return list;
//    }

//    @Override
//    public List<CrudDTO> getListQuerydsl(CrudSearchCondition condition) {
//        List<Crud> search = crudRepository.search(condition);
//        return search.stream()
//                .map(s -> entityToDTO(s))
//                .collect(Collectors.toList());
//    }

    @Override
    public PageResultDTO<CrudDTO, Crud> getList(PageRequestDTO requestDTO) {
        log.info(requestDTO);

        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
        Page<Crud> result = crudRepository.findAll(pageable);

        Function<Crud, CrudDTO> fn = (entity -> entityToDTO(entity));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public Long register(CrudDTO dto) {
        Crud crud = dtoToEntity(dto);
        crudRepository.save(crud);
        return crud.getBno();
    }

    @Override
    public CrudDTO read(Long bno) {
        Crud crud = Crud.builder().bno(bno).build();
        Crud result = crudRepository.findByBno(bno);
        List<CrudReply> crudReplyList = crudReplyRepository.findByCrud(crud);
        
        log.info("******************************");
        log.info("result 전" + result);
        log.info("reply 전" + crudReplyList);
        log.info("******************************");
        log.info(entitiesToDTO(result,crudReplyList));

        return entitiesToDTO(result,crudReplyList);
    }

    @Override
    public void modify(CrudDTO dto) {
        Optional<Crud> result = crudRepository.findById(dto.getBno());
        if(result.isPresent()){
            Crud crud = result.get();
            crud.title = dto.getTitle();
            crud.content = dto.getContent();
            crudRepository.save(crud);
        }
    }
    @Override
    public void delete(Long dto) {
        crudRepository.deleteById(dto);
    }


//    public Board register(BoardDTO dto){
//        log.info("변환 전 " + dto.getTitle() + " 변환 전" + dto.getContent());
//        Board board = modelMapper.map(dto, Board.class);
//        log.info("내용 " + board.getContent() + "제목" + board.getTitle());
//        return boardRepository.save(board);
//    }



}
