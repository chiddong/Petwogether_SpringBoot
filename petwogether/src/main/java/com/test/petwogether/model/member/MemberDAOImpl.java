package com.test.petwogether.model.member;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	@Override
	public MemberDTO mLoginCheck(MemberDTO dto) {

		return sql.selectOne("member.auth", dto);
	}
	
	//지현 START ======

	@Override
	public List<AdoptReviewDTO> adrlist(HashMap<String, Integer> map) {
		
		return sql.selectList("member.adrlist", map);
	}
	
	@Override
	public AdoptReviewDTO getadrdetail(String arseq) {

		return sql.selectOne("member.getadrdetail", arseq);
	}
	
	@Override
	public int getmaxarseq() {

		return sql.selectOne("member.getmaxarseq");
	}
	
	@Override
	public int adradd(AdoptReviewDTO ardto) {

		return sql.insert("member.adradd" ,ardto);
	}
	
	@Override
	public AdoptReviewDTO editadr(String arseq) {

		return sql.selectOne("member.editadr", arseq);
	}
	
	@Override
	public int updateadr(AdoptReviewDTO ardto) {

		return sql.update("member.updateadr", ardto);
	}
	
	@Override
	public int deladr(String arseq) {

		return sql.delete("member.deladr", arseq);
	}
	
	@Override
	public int updatearview(String arseq) {

		return sql.update("member.updatearview", arseq);
	}
	
	@Override
	public int reducearview(String arseq) {
		
		return sql.update("member.reducearview", arseq);
	}
	
	@Override
	public List<AdoptReviewDTO> adrsearch(String word) {

		return sql.selectList("member.adrsearch", word);
	}
	
	@Override
	public int gettotalareview() {
		
		return sql.selectOne("member.gettotalareview");
	}
	
	//지현 END  ======
	
	
}
