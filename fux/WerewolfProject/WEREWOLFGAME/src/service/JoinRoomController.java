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
	public JSONObject getCreate(@RequestParam("username") String username){
		JDBCdataRoom jdbcDateRoom = new JDBCdataRoom();
		JSONObject json= new JSONObject();
		int idRoom = jdbcDateRoom.insertRoom(username);
		try {
			json.put("idRoom", idRoom);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	} 
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public JSONObject getJoin(@RequestParam("username") String username,
			@RequestParam("idRoom") int idRoom){
		JDBCdataRoom jdbcDateRoom = new JDBCdataRoom();
		JSONObject json= new JSONObject();
		int returnIdRoom = jdbcDateRoom.updatePlayer(username,idRoom);
		try {
			json.put("idRoom", returnIdRoom);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	} 
	
	@RequestMapping(value = "/exit", method = RequestMethod.POST)
	public JSONObject postCreate(@RequestParam("username") String username,
			@RequestParam("idRoom") int idRoom){
		JDBCdataRoom jdbcDateRoom = new JDBCdataRoom();
		jdbcDateRoom.deletePlayer(username, idRoom);
		JSONObject json= new JSONObject();
		try {
			json.put("idRoom", 0);
		} catch (JSONException e){
			e.printStackTrace();
	}
		return json;
	} 
}

	


