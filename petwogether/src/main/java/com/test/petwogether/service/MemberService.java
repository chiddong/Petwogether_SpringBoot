package com.test.petwogether.service;

import java.util.HashMap;
import java.util.List;

import com.test.petwogether.model.admin.AdminDTO;
import com.test.petwogether.model.member.AdoptReviewDTO;
import com.test.petwogether.model.member.MemberDTO;
import com.test.petwogether.model.petsitter.PetSitterDTO;

public interface MemberService {
	

	MemberDTO mLoginCheck(String id, String pass);

	PetSitterDTO fLoginCheck(String id, String pass);

	AdminDTO aLoginCheck(String id, String pass);

	
	
	//지현 START ============

	List<AdoptReviewDTO> adrlist(HashMap<String, Integer> map);

	AdoptReviewDTO getadrdetail(String arseq);

	int getmaxarseq();

	int adradd(AdoptReviewDTO ardto);

	AdoptReviewDTO editadr(String arseq);

	int updateadr(AdoptReviewDTO ardto);

	int adrdel(String arseq);

	int updatearview(String arseq);

	int reducearview(String arseq);

	List<AdoptReviewDTO> adrsearch(String word);

	int getTotalAReview();

	//지현 END ============
	
	
}
