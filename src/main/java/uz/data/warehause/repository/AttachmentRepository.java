package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
