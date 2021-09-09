package com.llts.miniproject.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.llts.miniproject.bo.ProductBo;
import com.llts.miniproject.bo.ProductDetailsBo;
import com.llts.miniproject.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductDetailsBo pd;

	public List<Product> getAllProducts(){
		return pd.findAll();
	}
	

}
