package service;

import java.util.Random;

import model.MemberModel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.*;

import JDBC.JDBCmember;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(@RequestParam("username") String username,
			@RequestParam("pass") String pass) {
//	public String getLogin(){
//		String username = "deknarog";
//		String pass = "123456789";
		JDBCmember jdbcMember = new JDBCmember();
		MemberModel user = jdbcMember.SQLselectMember(username);
		JSONObject objson = new JSONObject();

		if (user.getUserName().equals("")) {
			try {
				objson.put("isFouldID", false);
				objson.put("isTruePassword", false);
				objson.put("sesionID", 0);
				objson.put("url",
						"home.html");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else if (user.getPassword().equals(pass)) {
			Random rd = new Random();
			user.setsesID(rd.nextInt());
			jdbcMember.updateMember(user);
			try {
				objson.put("isFouldID", true);
				objson.put("isTruePassword", true);
				objson.put("sesionID", user.getsesID());
				objson.put("url",
						"lobby.html");
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else {
			try {
				objson.put("isFouldID", true);
				objson.put("isTruePassword", false);
				objson.put("sesionID", 0);
				objson.put("url",
						"home.html");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return objson+"";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public JSONObject getRegister(@RequestParam("username") String username,
			@RequestParam("pass") String pass) {
		JDBCmember jdbcMember = new JDBCmember();
		MemberModel user = jdbcMember.SQLselectMember(username);
		JSONObject objson = new JSONObject();
		if (user.getUserName().equals("")) {// fail
			jdbcMember.insertMember(new MemberModel(0, username, pass));
			try {
				objson.put("isSuccess", false);
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else if (user.getUserName().equals(username)) {// success
			try {
				objson.put("isSuccess", true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objson;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public JSONObject getLogin(@RequestParam("username") String username) {
		JDBCmember jdbcMember = new JDBCmember();
		MemberModel user = jdbcMember.SQLselectMember(username);
		user.setsesID(0);
		JSONObject objson = new JSONObject();
		try {
			objson.put("login", false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		jdbcMember.updateMember(user);
		return objson;
	}
}
