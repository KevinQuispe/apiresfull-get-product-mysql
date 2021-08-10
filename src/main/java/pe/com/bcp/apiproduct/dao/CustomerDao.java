package pe.com.bcp.apiproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bcp.apiproduct.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
