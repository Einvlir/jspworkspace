package com.koreait.shoppingmall.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.exception.FileHandleException;
import com.koreait.shoppingmall.exception.UploadException;
import com.koreait.shoppingmall.model.common.file.FileManager;
import com.koreait.shoppingmall.model.service.category.TopCategoryService;
import com.koreait.shoppingmall.model.service.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	private TopCategoryService topCategoryService;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ProductService productService;
	//상품 등록 폼 처리
	@GetMapping("/product/registform")
	public String registForm(Model model) {
		//3단계 : 최상위카테고리 가져오기
		List topList = topCategoryService.selectAll();
		//4단계 : 결과저장
		model.addAttribute("topList", topList);
		return "admin/product/regist";
	}
	
	//상품 등록 요청(파일업로드가 포함되어 있슴)
	@PostMapping("/product/regist")
	public String regist(Product product, HttpServletRequest request) {
		
		
		//VO에 등록한 MultipartFile 객체에 업로드된 파일이 이미 들어있으므로, 개발자는 이 객체를 이용하여 업로드된 파일을
		//원하는대로 제어하면 된다..
		MultipartFile photo=product.getPhoto();
		ServletContext context = request.getServletContext();
		Long time = System.currentTimeMillis();
		String filename = time+"."+fileManager.getExt(photo.getOriginalFilename());
		fileManager.saveFile(context, filename, photo);
		product.setProduct_img(filename);
		productService.regist(product);

		
		return "redirect:/admin/product/list";
	}
	//상품 삭제
	@PostMapping("/product/del")
	public String delete(Product product, HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		productService.delete(product.getProduct_id());
		fileManager.deleteFile(context, product.getProduct_img());
		return "redirect:/admin/product/list";
	}
	//모든 상품 가져오기
	
	@GetMapping("/product/list")
	public String getList(Model model) {
		//3단계 일시키기
		List productList = productService.selectAll();
		//4 저장
		model.addAttribute("productList",productList);
		return "admin/product/product_list";
	}
	@GetMapping("/product/detail")
	public String getDetail(int product_id, Model model) {
		Product product = productService.select(product_id);
		List topList = topCategoryService.selectAll();
		model.addAttribute("product",product);
		model.addAttribute("topList",topList);
		return "admin/product/content";
	}
	
	@ExceptionHandler(UploadException.class)
	public String handleException(UploadException e, Model model) {
		model.addAttribute("e",e);
		return "error/result";
	}

	@ExceptionHandler(FileHandleException.class)
	public String handleException(FileHandleException e, Model model) {
		model.addAttribute("e",e);
		return "error/result";
	}
}
