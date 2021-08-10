package pe.com.bcp.apiproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bcp.apiproduct.entity.Product;

//con esto se implementa el crud de una entidad
public interface ProductsDao extends JpaRepository<Product, Long> {
}

