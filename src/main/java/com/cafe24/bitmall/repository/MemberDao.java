package com.cafe24.bitmall.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.jblog.exception.MemberDaoException;

@Repository
public class MemberDao {
    @Autowired
    private SqlSession sqlSession;
    
    public MemberVo get( MemberVo memberVo ) throws MemberDaoException {
	return sqlSession.selectOne( "member.getByIdAndPassword", memberVo );
    }

    public boolean join(MemberVo memberVo) {
	return sqlSession.insert( "member.insert", memberVo ) == 1;
    }

    public MemberVo get(Long no) {
	return sqlSession.selectOne( "member.getByNo", no );
	}

    public boolean update(MemberVo memberVo) {
	return sqlSession.update( "member.update", memberVo ) == 1;
    }

    public List<MemberVo> getAll() {
	return sqlSession.selectList( "member.getAll" );
    }

}
