/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AChauhan4
 */
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RR {
    
    public String RR(String RRID)
    {
        String Returndata="No data Found";
                Connection con = null;
		//CallableStatement cstmt = null;
                PreparedStatement ps= null;
		ResultSet rs = null;
        try{
                SQLServerDataSource ds = new SQLServerDataSource();
			//ds.setIntegratedSecurity(true);
                        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Database"));
                        String data[] = br.readLine().split(",");
			ds.setServerName(data[0]);
                        ds.setUser(data[1]);
                        ds.setPassword(data[2]);
			ds.setPortNumber(Integer.parseInt(data[4]));
			ds.setDatabaseName(data[3]);
			con = ds.getConnection();
			ps = con.prepareStatement("select * from RR where RRID = ?");
                        ps.setInt(0, Integer.parseInt(RRID));
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            Returndata="RRID = "+RRID+" PSID= "+rs.getString("PSID")+" SkillSet = "+rs.getString("SkillSet");
                        }
                        br.close();
                        ps.close();
                        con.close();
        }
        catch(Exception ex)
        {
            Returndata = ex.toString();
        }
        return Returndata;
    }
    
    public String RRVendor(String Vendor)
    {
        String Returndata="No data Found";
                Connection con = null;
		//CallableStatement cstmt = null;
                PreparedStatement ps= null;
		ResultSet rs = null;
        try{
                SQLServerDataSource ds = new SQLServerDataSource();
			//ds.setIntegratedSecurity(true);
                        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Database"));
                        String data[] = br.readLine().split(",");
			ds.setServerName(data[0]);
                        ds.setUser(data[1]);
                        ds.setPassword(data[2]);
			ds.setPortNumber(Integer.parseInt(data[4]));
			ds.setDatabaseName(data[3]);
			con = ds.getConnection();
			ps = con.prepareStatement("select * from RR where vendor = ?");
                        ps.setString(0, Vendor);
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            Returndata+="RRID = "+rs.getString("RRID")+" vendor= "+rs.getString("Vendor")+" SkillSet = "+rs.getString("SkillSet")+"</br>";
                        }
                        br.close();
                        ps.close();
                        con.close();
        }
        catch(Exception ex)
        {
            Returndata = ex.toString();
        }
        return Returndata;
    }
    
    public String RRSkillSet(String SkillSet)
    {
        String Returndata="No data Found";
                Connection con = null;
		//CallableStatement cstmt = null;
                PreparedStatement ps= null;
		ResultSet rs = null;
        try{
                SQLServerDataSource ds = new SQLServerDataSource();
			//ds.setIntegratedSecurity(true);
                        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Database"));
                        String data[] = br.readLine().split(",");
			ds.setServerName(data[0]);
                        ds.setUser(data[1]);
                        ds.setPassword(data[2]);
			ds.setPortNumber(Integer.parseInt(data[4]));
			ds.setDatabaseName(data[3]);
			con = ds.getConnection();
			ps = con.prepareStatement("select * from RR where SkillSet = ?");
                        ps.setString(0, SkillSet);
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            Returndata+="RRID = "+rs.getString("RRID")+" vendor= "+rs.getString("Vendor")+" SkillSet = "+SkillSet+"</br>";
                        }
                        br.close();
                        ps.close();
                        con.close();
        }
        catch(Exception ex)
        {
            Returndata = ex.toString();
        }
        return Returndata;
    }
    public String RR(String Vendor,String SkillSet)
    {
        String Returndata="No data Found";
                Connection con = null;
		//CallableStatement cstmt = null;
                PreparedStatement ps= null;
		ResultSet rs = null;
        try{
                SQLServerDataSource ds = new SQLServerDataSource();
			//ds.setIntegratedSecurity(true);
                        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Database"));
                        String data[] = br.readLine().split(",");
			ds.setServerName(data[0]);
                        ds.setUser(data[1]);
                        ds.setPassword(data[2]);
			ds.setPortNumber(Integer.parseInt(data[4]));
			ds.setDatabaseName(data[3]);
			con = ds.getConnection();
			ps = con.prepareStatement("select * from RR where vendor = ? and Skillset = ?");
                        ps.setString(0, Vendor);
                        ps.setString(1, SkillSet);
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            Returndata+="RRID = "+rs.getString("RRID")+" vendor= "+Vendor+" SkillSet = "+SkillSet+"</br>";
                        }
                        br.close();
                        ps.close();
                        con.close();
        }
        catch(Exception ex)
        {
            Returndata = ex.toString();
        }
        return Returndata;
    }
    
    public String RR()
    {
        String Returndata="No data Found";
                Connection con = null;
                PreparedStatement ps= null;
		ResultSet rs = null;
        try{
                SQLServerDataSource ds = new SQLServerDataSource();
			//ds.setIntegratedSecurity(true);
                        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Database"));
                        String data[] = br.readLine().split(",");
			ds.setServerName(data[0]);
                        ds.setUser(data[1]);
                        ds.setPassword(data[2]);
			ds.setPortNumber(Integer.parseInt(data[4])); 
			ds.setDatabaseName(data[3]);
			con = ds.getConnection();
			ps = con.prepareStatement("select * from RR");
                        //ps.setInt(0, Integer.parseInt(RRID));
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            Returndata+="RRID = "+rs.getInt("RRID")+" Vendor= "+rs.getString("Vendor")+" SkillSet = "+rs.getString("SkillSet")+"</br>";
                        }
                        br.close();
                        ps.close();
                        con.close();
        }
        catch(Exception ex)
        {
            Returndata = ex.toString();
        }
        return Returndata;
    } 
    public String Thankyou(String user,String type)
    {
        String ReturnData="Bye Prakash";
     if(type.toLowerCase().equals("greetings"))
     {
         ReturnData = "Hello Prakash";
     }
       Connection con = null;
                PreparedStatement ps= null;
		ResultSet rs = null;
        try{
                SQLServerDataSource ds = new SQLServerDataSource();
			//ds.setIntegratedSecurity(true);
                        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Database"));
                        String data[] = br.readLine().split(",");
			ds.setServerName(data[0]);
                        ds.setUser(data[1]);
                        ds.setPassword(data[2]);
			ds.setPortNumber(Integer.parseInt(data[4])); 
			ds.setDatabaseName(data[3]);
			con = ds.getConnection();
			ps = con.prepareStatement("select * from Greeting where Greetings = ?");
                        ps.setString(0, user);
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            ReturnData = rs.getString("Response");
                        }
                        br.close();
                        ps.close();
                        con.close();
        }
        catch(Exception ex)
        {
            return ReturnData;
        }
        return ReturnData;
    }
}
