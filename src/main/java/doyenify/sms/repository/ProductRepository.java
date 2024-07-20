package doyenify.sms.repository;

import doyenify.sms.entities.product;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface ProductRepository extends JpaRepository<product, Long> {

}
