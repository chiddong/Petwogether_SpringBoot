package com.test.petwogether.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.petwogether.model.admin.AdminDTO;
import com.test.petwogether.model.member.AdoptReviewDTO;
import com.test.petwogether.model.member.MemberDTO;
import com.test.petwogether.model.petsitter.PetSitterDTO;
import com.test.petwogether.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping("/main/index")
	public String index() {
		
		return "main/index";
	}
	
	   //설   
	   @GetMapping("/member/login")
	   public String login() {
	      
	      return "member/login";
	   }
	   
	   //설
	   @PostMapping(value="/member/loginok")
	   public String loginok(String user, String id, String pass, HttpSession session, Model model) {
	      
		   String level = "";
	         String sseq = "";
	         
	         
	         if (user.equals("m")) {
	            MemberDTO dto = service.mLoginCheck(id, pass);
	            if (dto != null) {
	               level = dto.getMlevel();
	               sseq = dto.getMseq();
	            }
	            
	         } else if (user.equals("p")) {
	            PetSitterDTO dto = service.fLoginCheck(id, pass);
	            if (dto != null) {
	               level = dto.getPslevel();
	               sseq = dto.getPsseq();
	            }
	         } else {
	            AdminDTO dto = service.aLoginCheck(id, pass);
	            if (dto != null) {
	               level = dto.getAdlevel();
	               sseq = dto.getAdseq();
	            }
	         }
	                  
	         if (!level.equals("")) {
	            //로그인 성공
	            session.setAttribute("auth", id); 
	            session.setAttribute("lv", level);
	            session.setAttribute("sseq",sseq);
	            
	            return "redirect:/main/index";
	         } else {
	            //로그인 실패
	            return "member/login";
	         }
	         
	      }
	   
	   //설   
	   @GetMapping("/member/logout")
	   public String logout(HttpSession session) {
	      
	      session.removeAttribute("auth");
	      session.removeAttribute("lv");   
	      
	      return "redirect:/member/login";
	   }
	   	
	
	
	
		
	//지현 SRART ========
	
	
	//목록 읽기, RESTful
	//ResponseBody를 해주면, HTML 페이지 리턴이 아닌 데이터가 리턴이 됨
	//RestController를 사용하면 아래의 두 어노테이션을 하나로 합칠 수 있음
	@ResponseBody
	@GetMapping("/member/adoptreview")
	public ModelAndView adrlist(Model model, String page) {
		
		AdoptReviewDTO ardto = new AdoptReviewDTO();

		//페이징 처리
		
		System.out.println(page);
		//한 페이지 당 출력할 게시물 수
		int pageSize = 10;
		
		//총 게시물 수
		int totalCount = service.getTotalAReview();
		
		//총 페이지 수
		int totalPage = (int)(Math.ceil((double)totalCount/pageSize));
		
		//페이지바 태그
		String pagebar = "";
		
		//한번에 보여지는 페이지 수
		int blockSize = 10;
		
		int nowPage = 0;		//현재 페이지 번호(= page)
		int begin = 0;			//rnum 시작 위치
		int end = 0;			//rnum 끝 위치		
		
		if (page == null || page == "") nowPage = 1;
		else nowPage = Integer.parseInt(page);
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1; 
		
		//출력될 페이지 번호
		int n = 0;
		
		//루프 변수
		int loop = 0;
		
		loop = 1;
		n = ((nowPage -1)/blockSize) * blockSize + 1;
		
		if(n == 1) {
			pagebar += String.format(" <a href='/member/adoptreview?page=1'> [이전 10페이지]&nbsp;&nbsp;&nbsp;</a> ");
		} else {
			pagebar += String.format(" <a href='/member/adoptreview?page=%d'> [이전 10페이지]&nbsp;&nbsp;&nbsp;</a> ", n-1);			
		}
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += String.format(" <a href='#!' style='color:#F8A1A4;'>%d</a> ", n);
			} else {
				pagebar += String.format(" <a href='/member/adoptreview?page=%d'>%d</a> ", n, n);
			}
			
			loop++;
			n++;
			
		}
		
		if (n > totalPage) {
			pagebar += String.format(" <a href='/member/adoptreview?page=%d'>&nbsp;&nbsp;&nbsp;[다음 10페이지]</a> ", totalPage);			
		} else {			
			pagebar += String.format("  <a href='/member/adoptreview?page=%d'>&nbsp;&nbsp;&nbsp;[다음 10페이지]</a> ", n);
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//rownum에 맞춰서 데이터를 잘라와야함
		map.put("begin", begin);
		map.put("end", end);


		//페이징 처리 끝
		
		List<AdoptReviewDTO> adrlist = service.adrlist(map);
		
		//regdate 처리
		for(int i=0; i<adrlist.size(); i++) {
			
			adrlist.get(i).getArregdate();
			
			String regdate = (adrlist.get(i).getArregdate()).substring(0, 10);
			
			adrlist.get(i).setArregdate(regdate);
		}
		

		//RESTful로 데이터를 얻어와서 html로 연결
	    ModelAndView modelAndView = new ModelAndView();
	    
	    modelAndView.addObject("adrlist", adrlist);
	    modelAndView.addObject("pagebar", pagebar);
	    modelAndView.setViewName("member/adoptreview");
	    
	    //System.out.println(adrlist.toString());
	        

	        return modelAndView;
	}
	
	@ResponseBody 
	@GetMapping("/member/adoptreviewsearch")
	public List<AdoptReviewDTO> arlist(String word){
				
		List<AdoptReviewDTO> adrlist = service.adrsearch(word);
		
		for (AdoptReviewDTO dto : adrlist) {

			dto.setArregdate(dto.getArregdate().substring(0,10));

		}
		
		System.out.println();
		System.out.println(adrlist);

		return adrlist;
		
	}//adoptreviewsearch
	
	
	//게시물 자세히보기
	@GetMapping("/member/adoptreviewdetail")
	public String adrdetail(String arseq, Model model, HttpSession session, String arviews) {		
		
		AdoptReviewDTO ardto = service.getadrdetail(arseq);
		int arseqs = Integer.parseInt(arseq);
		int arview = 0;
		
		if(arviews == null || arviews.equals(0) || arviews =="") {
			arview = Integer.parseInt(ardto.getArview());
			arview++;
		} else {
			arview = Integer.parseInt(arviews);
		}
		
		//조회수 증가
		
		int result = service.updatearview(arseq);
		
		model.addAttribute("arview", arview);
		model.addAttribute("ardto", ardto);
		model.addAttribute("arseqs", arseqs);
		
		return "/member/adoptreviewdetail";
	}
	
	//게시물 작성 폼
	@GetMapping("/member/adoptreviewadd")
	public String adoptreviewadd() {
		
		return "member/adoptreviewadd";
	}
	
	//게시물 등록하기
	@PostMapping("/member/adoptreviewaddok")
	public String adoptreviewaddok(HttpServletRequest req, HttpSession session) {
		
		AdoptReviewDTO ardto = new AdoptReviewDTO();

		//MultipartRequest와 동일
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//작성되는 게시물의 게시물 번호 알아오기 > detail 페이지 이동을 위해서
		int maxarseq = (service.getmaxarseq() + 1);
		String arseq = maxarseq + "" ;
		
		String artitle = multi.getParameter("artitle");
		String arcontent = multi.getParameter("arcontent");
		String mseq = (String)session.getAttribute("sseq");

		MultipartFile attach = multi.getFile("arfile");

			String filename = attach.getOriginalFilename();
			//업로드한 파일이 저장될 경로
			String path = req.getRealPath("/static/files");
			
			
//			System.out.println("*************************");
//			System.out.println("*************************");
//			System.out.println(filename);
//			System.out.println(path);
//			System.out.println("*************************");
//			System.out.println("*************************");

			
			if(filename != null && filename !="" && filename.length() != 0) {
				//파일명 중복 방지 > 파일명 확인하는 method 인 getFileName 생성
				filename = getFileName(path, filename);
				
			} else {
				filename ="null";
			}
			
			//파일 이동
			File file2 = new File(path + "\\" + filename);
			
			ardto.setArfile(filename);
			
			try {
				
				attach.transferTo(file2);
				
				} catch (Exception e) {
			}

			
			//(arseq, mseq, artitle, arcontent, arregdate, arview, arfile)
			ardto.setArtitle(artitle);
			ardto.setArcontent(arcontent);
			ardto.setMseq(mseq);
			ardto.setArseq(arseq);		
				
			
			int result = service.adradd(ardto);	
	
			
			if(result == 1){ 
	
			return "redirect:/member/adoptreviewdetail?arseq=" + arseq;
			
			} else { 
				
			return "redirect:/member/adoptreview";
			
			}

		
	}//adoptreviewaddok
	
	private String getFileName(String path, String filename) {


			// 저장 폴더내의 파일명을 중복되지 않게 만들기
			// path = "resource/files"
			// filename = "test.txt"

			// 덮어쓰기 할때 오류가 나니까 이렇게 이름이 바뀌게 해주자.
			// test.txt > test(1).txt > test(2).txt
			int n = 1; // 인덱스 숫자
			int index = filename.lastIndexOf("."); // 확장자 위치
			
			String tempName = filename.substring(0, index);
			String tempExt = filename.substring(index); 

			while (true) {

				File file = new File(path + "\\" + filename);

				if (file.exists()) {
					// 있다. > 중복 > 파일명 변경

					filename = String.format("%s(%d)%s", tempName, n, tempExt);
					n++;

				} else {
					// 없다. > 사용 가능한 파일명
					return filename;
				}
			}

	} // getFileName
	
	//게시물 수정하기
	@GetMapping("/member/adoptreviewedit")
	public String adoptrevieweddit(String arseq, Model model) {
		
		AdoptReviewDTO ardto = service.editadr(arseq);
		int arseqs = Integer.parseInt(arseq);
		int arviews = Integer.parseInt(ardto.getArview());
		
		model.addAttribute("ardto", ardto);
		model.addAttribute("arseqs", arseqs);
		model.addAttribute("arviews", arviews);
		

		return "member/adoptreviewedit";
	}
	
	@PostMapping("/member/adoptrevieweditok")
	public String adoptrevieweditok(HttpServletRequest req, HttpSession session) {
		
		AdoptReviewDTO ardto = new AdoptReviewDTO();

		//MultipartRequest와 동일
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//작성되는 게시물의 게시물 번호 알아오기 > detail 페이지 이동을 위해서
		String arseq = multi.getParameter("arseq");
		String arviews = multi.getParameter("arview");
		String artitle = multi.getParameter("artitle");
		String arcontent = multi.getParameter("arcontent");
		String mseq = (String)session.getAttribute("sseq");

		String arview = (Integer.parseInt(arviews) - 1) + "";
		

		MultipartFile attach = multi.getFile("arfile");

			
			String filename = attach.getOriginalFilename();
			//업로드한 파일이 저장될 경로
			//String rpath = req.getRealPath("/files");
			String path = "C:\\class\\code\\springboot\\petwogether\\petwogether\\src\\main\\resources\\static\\files";

			if(filename != null && filename !="" && filename.length() != 0) {
				//파일명 중복 방지 > 파일명 확인하는 method 인 getFileName 생성
				filename = getFileName(path, filename);				
			}
			
			//파일 이동
			File file2 = new File(path + "\\" + filename);
			
			ardto.setArfile(filename);
			
			try {
				
				attach.transferTo(file2);
				
				} catch (Exception e) {
			}
	
			//(arseq, mseq, artitle, arcontent, arregdate, arview, arfile)
			ardto.setArtitle(artitle);
			ardto.setArcontent(arcontent);
			ardto.setMseq(mseq);
			ardto.setArseq(arseq);		
			ardto.setArseq(arview);		
				
			int vresult = service.reducearview(arseq);
			int result = service.updateadr(ardto);	
	
			
			if(result == 1){ 
	
				return "redirect:/member/adoptreviewdetail?arseq=" + arseq;
				
			
			} else { 
				
			return "redirect:/member/adoptreview";
			
			}


	} //adoptrevieweditok
	
	
	//게시물 삭제하기
	@GetMapping("/member/adoptreviewdelok")
	public String adoptreviewdelok(String arseq) {

		int result = service.adrdel(arseq);
		
		
		if(result == 1){ 

		return "redirect:/member/adoptreview";
		
		} else { 
			
			return "redirect:/member/adoptreviewdetail?arseq=" + arseq;
		
		}
		
		
	}//adoptreviewdelok
	

	
	
	//지현 END  =========
	
	
	
	
	
	
}
