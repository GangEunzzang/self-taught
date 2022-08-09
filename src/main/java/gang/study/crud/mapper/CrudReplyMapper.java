//package gang.study.crud.mapper;
//
//
//import gang.study.crud.dto.CrudReplyDTO;
//import gang.study.crud.entity.CrudReply;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(componentModel = "spring")
//public interface CrudReplyMapper {
//    CrudReplyMapper INSTANCE = Mappers.getMapper(CrudReplyMapper.class);
//
//    @Mappings({
//    @Mapping(target = "rno", ignore = true), // rno는 변환 제외
//    @Mapping(source = "crud", target = "bno") //  dto.crud 를 crudreply.crud로 변환
//    })
//    CrudReply toEntity(CrudReplyDTO crudReplyDTO);
//
//
//    @Mapping(source = "bno", target = "crud")
//    CrudReplyDTO toDTO(CrudReply crudReply);
//}
