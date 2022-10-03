package uz.data.warehause.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehause.entity.Attachment;
import uz.data.warehause.repository.AttachmentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    AttachmentRepository attachmentRepository;

    public Attachment getById(Integer id){
        Optional<Attachment> byId = attachmentRepository.findById(id);
        return byId.orElse(null);
    }

    public Result create(Attachment attachment){
        attachmentRepository.save(attachment);
        return new Result("Successfully added!",true);
    }
}
