package gang.study.crud.service;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.dto.PageRequestDTO;
import gang.study.crud.dto.PageResultDTO;
import gang.study.crud.entity.Crud;
import gang.study.crud.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

    private final CrudRepository crudRepository;

//    @Override
//    public List<CrudDTO> getList() {
//        List<Crud> result = crudRepository.findAll();
//        List<CrudDTO> list = result.stream().map(crud -> entityToDTO(crud)).collect(Collectors.toList());
//        return list;
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
        Optional<Crud> result = crudRepository.findById(bno);

        if(result.isPresent()){
            return entityToDTO(result.get());
        }else{
            return null;
        }

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
}
