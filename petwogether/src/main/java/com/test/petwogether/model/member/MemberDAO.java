package com.test.petwogether.model.member;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {

	

	MemberDTO mLoginCheck(MemberDTO dto);

	
	
	
	//지현 START =======
	
	List<AdoptReviewDTO> adrlist(HashMap<String, Integer> map);

	AdoptReviewDTO getadrdetail(String arseq);

	int getmaxarseq();

	int adradd(AdoptReviewDTO ardto);

	AdoptReviewDTO editadr(String arseq);

	int updateadr(AdoptReviewDTO ardto);

	int deladr(String arseq);

	int updatearview(String arseq);

	int reducearview(String arseq);

	List<AdoptReviewDTO> adrsearch(String word);

	int gettotalareview();
	
	//지현 END   =======
	
	

}
