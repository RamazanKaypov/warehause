package uz.data.warehause.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.data.warehause.entity.Attachment;
import uz.data.warehause.entity.AttachmentContent;
import uz.data.warehause.repository.AttachmentContentRepository;
import uz.data.warehause.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentContentService {

    AttachmentRepository attachmentRepository;

    AttachmentContentRepository attachmentContentRepository;

    public Result addFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file.isEmpty()) return new Result("File not found!",false);
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        String contentType = file.getContentType();
        Attachment save = attachmentRepository.save(new Attachment(null, originalFilename, size, contentType));
        byte[] bytes = file.getBytes();
        attachmentContentRepository.save(new AttachmentContent(null,bytes,save));
        return new Result("Successfully saved!",true);
    }

    public void downloadAttachment(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isPresent()){
            Attachment attachment = byId.get();
            Optional<AttachmentContent> attachmentContentByAttachment_id = Optional.ofNullable(attachmentContentRepository.getAttachmentContentByAttachment_Id(attachment.getId()));
            if (attachmentContentByAttachment_id.isPresent()){
                AttachmentContent attachmentContent = attachmentContentByAttachment_id.get();
                response.setHeader("Content-Disponsition",
                        "attachment; filename=\""+attachment.getName()+"\"");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getBytes(),response.getOutputStream());
            }
        }
    }
}
