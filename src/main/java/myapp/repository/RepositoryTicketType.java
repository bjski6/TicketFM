package myapp.repository;

import myapp.model.Ticket;
import myapp.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryTicketType extends JpaRepository <TicketType, Long> {


}

