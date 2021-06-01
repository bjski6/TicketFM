package myapp.repository;

import myapp.model.News;
import myapp.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTicketStatus extends JpaRepository <TicketStatus, Long> {
}
