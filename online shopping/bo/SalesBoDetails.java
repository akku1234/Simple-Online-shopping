package com.llts.miniproject.bo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llts.miniproject.model.Sales;
@Repository
public interface SalesBoDetails  extends JpaRepository<Sales, Integer>{

}
