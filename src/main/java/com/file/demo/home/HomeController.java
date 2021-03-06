package com.file.demo.home;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.file.demo.home.enm.FileDownLoadEnum;

@RestController
public class HomeController {

	private final HomeService homeService;

	private HomeController( HomeService homeService ) {
		this.homeService = homeService;
	}

	@RequestMapping("preview")
	public void preview(HttpServletResponse response, @RequestBody FileVO vo) {
		homeService.fileHandler(response, vo);
	}

	@RequestMapping("fileDownLoad")
	public void fileDownLoad(HttpServletResponse response
			, @RequestParam(name = "type", defaultValue = "") FileDownLoadEnum type
			, @RequestParam(name = "fileName", defaultValue = "") String fileName
			, @RequestParam(name = "bufferSize", defaultValue = "") int bufferSize) {

		FileVO file = FileVO.builder().type(type).fileName(fileName).bufferSize(bufferSize).build();
		homeService.fileHandler(response, file);
	}
}
