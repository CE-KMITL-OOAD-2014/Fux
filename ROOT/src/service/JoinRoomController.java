package service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JDBC.JDBCdataRoom;

@RestController
@RequestMapping("/room")
public class JoinRoomController {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String getCreate(@RequestParam("username") String username) {
//	public String getCreate(){
//		String username = "xxxx";
		JDBCdataRoom jdbcDateRoom = new JDBCdataRoom();
		JSONObject json = new JSONObject();
		int idRoom = jdbcDateRoom.insertRoom(username);
		try {
			json.put("idRoom", idRoom);
			json.put("url", "game.html");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String getJoin(@RequestParam("username") String username,
			@RequestParam("usercreate") String creater) {
//		public String getJoin(){
//		String creater = "xxxx",username = "deknarog3";
		JDBCdataRoom jdbcDateRoom = new JDBCdataRoom();
		JSONObject json = new JSONObject();

		int returnidRoom = jdbcDateRoom.updatePlayer(username, creater);
		try {
			json.put("creater", creater);
			json.put("idRoom", returnidRoom);
			json.put("url", "game.html");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	@RequestMapping(value = "/exit", method = RequestMethod.POST)
	public String postExit(@RequestParam("username") String username,
			@RequestParam("idRoom") int idRoom) {
		JDBCdataRoom jdbcDateRoom = new JDBCdataRoom();
		jdbcDateRoom.deletePlayer(username, idRoom);
		JSONObject json = new JSONObject();
		try {
			json.put("idRoom", 0);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
}
