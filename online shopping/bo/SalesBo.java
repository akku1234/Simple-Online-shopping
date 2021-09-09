package com.llts.miniproject.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesBo {

	@Autowired
	SessionFactory sf;

}
