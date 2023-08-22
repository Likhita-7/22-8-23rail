


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Ser {
	Connection con;
	ResultSet rs;
	public void meth() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");
		//System.out.println("connection created");
		
	}
	public JSONArray meth1() throws SQLException, JSONException {
		PreparedStatement st=con.prepareStatement("select trn_start from train_data");
		rs=st.executeQuery();
		//System.out.println(rs);
		JSONArray js=new JSONArray();
		
		while(rs.next()) {
			JSONObject ob=new JSONObject();
			ob.put("st", rs.getString(1));
			js.put(ob);
			
		}
		return js;
		
		}
	public JSONArray meth2(String v1,String v2) throws SQLException {
		PreparedStatement st=con.prepareStatement("select trn_name from train_data where trn_start=? and trn_end=?");
		st.setString(1, v1);
		st.setString(2, v2);
		
		rs=st.executeQuery();
		System.out.println(rs);
		JSONArray js=new JSONArray();
		System.out.println(rs.getFetchSize());
		while(rs.next()) {
			System.out.println("ghvdf");
			JSONObject ob=new JSONObject();
			ob.put("st",rs.getString("trn_name"));
			js.put(ob);
		}
		System.out.println("this is json array");
		System.out.println(js);
		return js;
	}
	public Ticket meth3(String from,String to,String tlist,String clas,String[] na,String[] ag, String[] ge) {
		ArrayList<Passenger> ps=new ArrayList<>();
		for(int i=0;i<na.length;i++) {
			Passenger p=new Passenger(na[i],Integer.parseInt(ag[i]),ge[i]);
			System.out.println(p);
			ps.add(p);
		
		}
		Ticket t= new Ticket(tlist,from,to,clas);
		t.setTl(ps);
		
		return t;
		
		
	}
	public void meth4(Ticket t) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into Ticket(trainname,from_st,to_st,class_st) values(?,?,?,?) returning pnr");
		ps.setString(1, t.getTname());
		ps.setString(2, t.getFrom());
		ps.setString(3, t.getTo());
		ps.setString(4, t.getClas());
		ResultSet rs = ps.executeQuery();
		int x=rs.getInt("pnr");
		ArrayList<Passenger> pp=t.getTl();
		for(Passenger d:pp) {
		PreparedStatement p=con.prepareStatement("insert into passenger values(?,?,?,?)");
		p.setLong(1, x);
		p.setString(2,d.getName());
		p.setInt(3,d.getAge());
		p.setString(4,d.getGender());
		p.executeQuery();
		
		
		}
		
	}
}
