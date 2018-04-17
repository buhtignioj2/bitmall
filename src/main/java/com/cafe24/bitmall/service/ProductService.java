package com.cafe24.bitmall.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.repository.ProductDao;
import com.cafe24.bitmall.vo.ProductVo;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    
    private static String SAVE_PATH = "/uploads";
    
    public List<ProductVo> get(Long no) {
	List<ProductVo> vo = productDao.get(no);
	return vo;
    }

    public ProductVo getOne(Long no) {
	return productDao.getOne(no);
    }

    public List<ProductVo> getAll() {
	return productDao.getAll();
    }

    public void addProduct(ProductVo vo) {
	productDao.insert(vo);
    }

    public List<ProductVo> getAllList() {
	return productDao.getAllList();
    }
    public void restore(MultipartFile multipartFile, ProductVo vo) {
	String saveFileName = "";
	try {
	    if ( multipartFile.isEmpty() == true ) {
		productDao.update( vo );
		return ;
	    }

	    String orgFileName = multipartFile.getOriginalFilename();
	    String extName = orgFileName.substring( orgFileName.lastIndexOf( '.' ) + 1 );
	    saveFileName = generateSaveFileName( extName );

	    writeFile( multipartFile, saveFileName );
	    vo.setNewName( saveFileName );
	    productDao.update( vo );
	    
	} catch ( IOException e ) {
	    e.printStackTrace();
	}
    }
    
    private String generateSaveFileName(String extName) {
	String fileName = "";
	Calendar calendar = Calendar.getInstance();
	fileName += calendar.get( Calendar.YEAR );
	fileName += calendar.get( Calendar.MONTH );
	fileName += calendar.get( Calendar.DATE );
	fileName += calendar.get( Calendar.HOUR );
	fileName += calendar.get( Calendar.MINUTE );
	fileName += calendar.get( Calendar.SECOND );
	fileName += calendar.get( Calendar.MILLISECOND );
	fileName += "." + extName;
	return fileName;
    }
    
    private void writeFile(MultipartFile file, String saveFileName) throws IOException {
	byte[] fileData = file.getBytes();
	FileOutputStream fos = new FileOutputStream( SAVE_PATH + "/" + saveFileName );
	fos.write( fileData );
	fos.close();
    }
}
