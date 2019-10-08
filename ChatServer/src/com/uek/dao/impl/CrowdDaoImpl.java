package com.uek.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uek.dao.inter.ICrowdDao;
import com.uek.domain.Crowd;
import com.uek.utils.DBUtil;

public class CrowdDaoImpl implements ICrowdDao{

	@Override
	public Crowd loadCrowd(String name) {
		Crowd crowd = null;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "select * from t_crowd where name='" + name + "'";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				crowd = new Crowd();
				crowd.setId(rs.getInt("id"));
				crowd.setCreaterId(rs.getInt("creater_id"));
				crowd.setCreaterTime(rs.getString("creater_time"));
				crowd.setCreaterTime(rs.getString("name"));
				crowd.setCreaterTime(rs.getString("description"));
				crowd.setCreaterTime(rs.getString("logo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return crowd;
		
	}

}
