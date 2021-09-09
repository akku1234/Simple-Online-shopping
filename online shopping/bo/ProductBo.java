package com.llts.miniproject.bo;
import java.io.IOException;
import java.util.Base64;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.llts.miniproject.model.Product;
import com.llts.miniproject.model.User;

@Repository
public class ProductBo {

	@Autowired
	SessionFactory sf;
	
	@Autowired
	ProductDetailsBo pd;

	
	public void saveProduct(MultipartFile file, String pname, String pdescribe, int pcost,int quantity, int pid, String pcat)
	{
		Product u =new Product();
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		u.setPcat(pcat);;
		u.setPcost(pcost);
		u.setPdescribe(pdescribe);
		u.setPname(pname);
		u.setPid(pid);
		u.setQuantity(quantity);
		
		try {
			u.setPimage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		pd.save(u);
	}
	
	public void updateProduct(MultipartFile file, String pname, String pdescribe, int pcost,int quantity, int pid, String pcat)
	{
		Product u =new Product();
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		u.setPcat(pcat);;
		u.setPcost(pcost);
		u.setPdescribe(pdescribe);
		u.setPname(pname);
		u.setPid(pid);
		u.setQuantity(quantity);
		
		
		try {
			u.setPimage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		pd.save(u);
	}
	
	
	public boolean deleteProductById(int pid) {
		Session s=sf.openSession();
		s.beginTransaction();
		Product u1=(Product) s.get(Product.class, pid);
		System.out.println(u1);
		s.delete(u1);
		s.getTransaction().commit();
		return true;
	    
	}
	public Product getProductById(int pid) {
		Session s=sf.openSession(); 
		s.beginTransaction();
		Product u2=(Product) s.get(Product.class, pid);
		s.getTransaction().commit();
		return u2;
	}

}
