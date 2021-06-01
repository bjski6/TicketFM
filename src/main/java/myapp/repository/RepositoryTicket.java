package myapp.repository;

import myapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryTicket extends JpaRepository <Ticket, Long> {


}

