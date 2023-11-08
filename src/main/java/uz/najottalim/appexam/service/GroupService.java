package uz.najottalim.appexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najottalim.appexam.dto.GroupDto;
import uz.najottalim.appexam.dto.GroupUpdateDto;
import uz.najottalim.appexam.entity.Group;
import uz.najottalim.appexam.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository repository;

    public Group create(GroupDto dto) {
        return repository.save(mapToEntity(dto));
    }

    public List<Group> read() {
        return repository.findAll();
    }

    public Optional<Group> readById(Long id){
        return repository.findById(id);
    }

    public String update(GroupUpdateDto dto){
        if (repository.existsById(dto.getId())){
            Optional<Group> byId = repository.findById(dto.getId());
            Group group = byId.get();
            group.setGroupName(dto.getGroupName());
            repository.save(group);
            return "Group Updated";
        }
        else {
            return "Group Not Found";
        }
    }


    public String delete(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Group deleted";
        }else {
            return "Group Not Found";
        }
    }


    private Group mapToEntity(GroupDto dto) {
        return Group.builder()
                .groupName(dto.getGroupName())
                .build();
    }
}
