package com.example.demo.daos;
import com.example.demo.model.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.example.demo.ifaces.CrudRepository;
import com.example.demo.ifaces.DoctorRespository;

public class DoctorDao implements CrudRepository <Doctor> ,DoctorRespository<Doctor>{
private Connection con;

public DoctorDao (Connection con) {
super();
this.con = con;

}
	

	@Override
	public int add(Doctor t) {

	String sql = "insert into kanic_doctor values(?,?,?,?,?,?)";
	//	String sql = "insert into doctor values(?,?,?,?,?,?)";
		
		int rowAdded=0;
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1,t.getDoctorId());
			pstmt.setString(2, t.getDoctorName());
			pstmt.setLong(3, t.getHandPhone());
			pstmt.setString(4, t.getEmail());
			pstmt.setString(5, t.getSpecialization());
			pstmt.setString(6, t.getCity());
			
			 rowAdded = pstmt.executeUpdate();
			      
			} catch (SQLException e) {
			       e.printStackTrace();
			}


       return rowAdded;
	}

	@Override
	public List<Doctor> findAll() {
		
		String sql ="select * from kanic_doctor";
		List<Doctor> docList = new ArrayList<Doctor>();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql) ){
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println(pstmt.getClass().getName());
			
			while(rs.next()) {
			
				Doctor found = mapResultSetToDoctor(rs);
				
				docList.add(found);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return docList;
	}

	@Override
	public Doctor findById(int pkey) {
		String sql ="select * from doctor where doctorId=?";
		Doctor found = null;
		try(PreparedStatement pstmt = con.prepareStatement(sql) ) {
			
			pstmt.setInt(1, pkey);
			
			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
			 found = mapResultSetToDoctor(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return found;
	}

	@Override
	public int update(Doctor t) {
		
		int pkey=t.getDoctorId();
		
		Object rowFound = findById(pkey);
		int rowUpdated=0;
		if(rowFound==null) {
			System.out.println("elemnt not Found Hencing Adding element");
			add(t);
		}else {
			System.out.println("elemntFound can be updated");
			
			String sql ="update kanic_doctor set doctorName=? ,handPhone=?,email=?,specialization=?,city=? where doctorId=?";

			
			try  (PreparedStatement pstmt = con.prepareStatement(sql)){
				
				
				
				
				pstmt.setString(1, t.getDoctorName());
				pstmt.setLong(2, t.getHandPhone());
				pstmt.setString(3, t.getEmail());
				pstmt.setString(4, t.getSpecialization());
				pstmt.setString(5, t.getCity());
				pstmt.setInt(6,t.getDoctorId());
				
				rowUpdated = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowUpdated;
	}
	

	@Override
	public int deleteById(int pkey) {
		String sql = "delete from kanic_doctor where doctorId=?";

		int rowdeteled=0;
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {


			pstmt.setInt(1,pkey);
			rowdeteled = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return rowdeteled;
	}

	
	private Doctor mapResultSetToDoctor(ResultSet rs) throws SQLException{
		int doctorId =	rs.getInt("doctorId");
		String doctorName =	rs.getString("doctorName");
		long handPhone =rs.getLong("handPhone");
		String	email= rs.getString("email");
		String	specialization=rs.getString("specialization");
		String	city=rs.getString("city");
		
		Doctor found = new Doctor(doctorId,doctorName,handPhone,email,specialization,city);
			
		return found;
	}

	@Override
	public List<Doctor> findByCity(String cityName) {
		
		String sql ="select * from kanic_doctor where city=?";
		
		List<Doctor> docList = new ArrayList<Doctor>();
		Doctor found = null;
		try(PreparedStatement pstmt = con.prepareStatement(sql) ) {
			
			pstmt.setString(1,cityName);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			 found = mapResultSetToDoctor(rs);
			 docList.add(found);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return docList;
	}


}
