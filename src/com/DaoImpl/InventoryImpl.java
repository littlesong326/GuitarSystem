package com.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Idao.InventoryIDao;

import model.Guitar;
import guitar.system.dao.DataConnection;

public class InventoryImpl implements InventoryIDao  {
	public  List<Guitar> searchGuitar( Guitar guitar) throws Exception {
		// TODO Auto-generated method stub
		List<Guitar> result = new ArrayList<Guitar>();
		String sql = "select * from guitar where 1=1 ";
		if(guitar.getType()!=null&guitar.getType()!=""){
			sql+=" and type='"+guitar.getType()+"'";
		}
		if(guitar.getBuilder()!=null&guitar.getBuilder()!=""){
			sql+=" and builder='"+guitar.getBuilder()+"'";
		}
		if(guitar.getBackwood()!=null&guitar.getBackwood()!=""){
			sql+=" and backwood='"+guitar.getBackwood()+"'";
		}
		if(guitar.getTopwood()!=null&guitar.getTopwood()!=""){
			sql+=" and topwood='"+guitar.getTopwood()+"'";
		}
		if(guitar.getSerialNumber()!=null&guitar.getSerialNumber()!=""){
			sql+=" and serialNumber='"+guitar.getSerialNumber()+"'";
		}
		Connection conn=DataConnection.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Guitar guitarnew=null;
		while (rs.next()) {
				guitarnew= new Guitar();
				guitarnew.setType(rs.getString("type"));
				guitarnew.setBackwood(rs.getString("backwood"));
				guitarnew.setTopwood(rs.getString("topwood"));
				guitarnew.setSerialNumber(rs.getString("serialNumber"));
				guitarnew.setBuilder(rs.getString("builder"));
				result.add(guitarnew);
		}
	ptmt.close();
		return result;
	}

	@Override
	public boolean addGuitar() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGuitar() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGuitar() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
