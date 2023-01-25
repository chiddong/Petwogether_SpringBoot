package com.test.petwogether.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.test.petwogether.model.admin.AdminDAO;
import com.test.petwogether.model.admin.AdminDTO;
import com.test.petwogether.model.member.AdoptReviewDTO;
import com.test.petwogether.model.member.MemberDAO;
import com.test.petwogether.model.member.MemberDTO;
import com.test.petwogether.model.petsitter.PetSitterDAO;
import com.test.petwogether.model.petsitter.PetSitterDTO;

@Service
@Primary
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO mdao;

	@Autowired
	private PetSitterDAO pdao;

	@Autowired
	private AdminDAO ddao;

	@Override
	public MemberDTO mLoginCheck(String id, String pass) {

		MemberDTO dto = new MemberDTO();
		dto.setMid(id);
		dto.setMpw(pass);

		return mdao.mLoginCheck(dto);

	}

	@Override
	public PetSitterDTO fLoginCheck(String id, String pass) {

		PetSitterDTO dto = new PetSitterDTO();
		dto.setPsid(id);
		dto.setPspw(pass);

		return pdao.pLoginCheck(dto);
	}

	@Override
	public AdminDTO aLoginCheck(String id, String pass) {

		AdminDTO dto = new AdminDTO();
		dto.setAdid(id);
		dto.setAdpw(pass);

		return ddao.aLoginCheck(dto);
	}
	
	//지현START=======

	@Override
	public List<AdoptReviewDTO> adrlist(HashMap<String, Integer> map) {

		return mdao.adrlist(map);
	}
	
	@Override
	public AdoptReviewDTO getadrdetail(String arseq) {

		return mdao.getadrdetail(arseq);
	}
	
	@Override
	public int getmaxarseq() {

		return mdao.getmaxarseq();
	}
	
	@Override
	public int adradd(AdoptReviewDTO ardto) {

		return mdao.adradd(ardto);
	}
	
	@Override
	public AdoptReviewDTO editadr(String arseq) {

		return mdao.editadr(arseq);
	}
	
	
	@Override
	public int updateadr(AdoptReviewDTO ardto) {
		
		return mdao.updateadr(ardto);
	}
	
	@Override
	public int adrdel(String arseq) {

		return mdao.deladr(arseq);
	}
	
	@Override
	public int updatearview(String arseq) {

		return mdao.updatearview(arseq);
	}
	
	@Override
	public int reducearview(String arseq) {

		return mdao.reducearview(arseq);
	}
	
	@Override
	public List<AdoptReviewDTO> adrsearch(String word) {

		return mdao.adrsearch(word);
	}
	
	@Override
	public int getTotalAReview() {

		return mdao.gettotalareview();
	}
	
	//지현END =======
	
}
