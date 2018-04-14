package com.cafe24.bitmall.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.MemberDao;
import com.cafe24.bitmall.vo.MemberVo;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;
    
    public MemberVo getUser(MemberVo memberVo) {
	return memberDao.get( memberVo );
    }

    public void join(MemberVo memberVo) {
	memberDao.join( memberVo );
    }

    public MemberVo getUser(Long no) {
	return memberDao.get( no );
    }

    public void modify(MemberVo memberVo) {
	memberDao.update( memberVo );
    }

    public List<MemberVo> getAll() {
	return memberDao.getAll();
    }

}
