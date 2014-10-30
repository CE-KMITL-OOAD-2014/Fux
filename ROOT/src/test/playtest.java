package test;

import static org.junit.Assert.*;

import org.junit.Test;

import test.GameRoom;
import test.User;

public class playtest {

	@Test
	public void test() {
		
		User[] testUser = new User[6];
		for(int i = 0 ; i < 6 ;i++)
		testUser[i] = new User();
		testUser[0].IDnum = 1234;
		testUser[1].IDnum = 2345;
		testUser[2].IDnum = 3456;
		testUser[3].IDnum = 4567;
		testUser[4].IDnum = 5678;
		testUser[5].IDnum = 6789;
		
		GameRoom testRoom = new GameRoom();
		
		testRoom.join(testUser[0]);
		testRoom.join(testUser[1]);
		testRoom.join(testUser[2]);
		testRoom.join(testUser[3]);
		testRoom.join(testUser[4]);
		testRoom.join(testUser[5]);
		
		testRoom.play.start(testUser);
		assertEquals(false, testRoom.play.isWin());
		Werewolf wereTest = new Werewolf(1211,"werewolf");
		assertEquals("alive", testRoom.play.carreer.vi[1].status);
		wereTest.kill(testRoom.play.carreer.vi[1]);
		assertEquals("die", testRoom.play.carreer.vi[1].status);
		assertEquals("alive", testRoom.play.carreer.vi[2].status);
		testRoom.play.carreer.vi[0].vote(testRoom.play.carreer.vi[2]);
		testRoom.play.carreer.vi[2].vote(testRoom.play.carreer.vi[3]);
		testRoom.play.carreer.vi[3].vote(testRoom.play.carreer.vi[2]);
		testRoom.play.carreer.vi[4].vote(testRoom.play.carreer.vi[2]);
		testRoom.play.carreer.vi[5].vote(testRoom.play.carreer.vi[2]);
		
		String str = testRoom.play.day.computeVote(testRoom.play.carreer.vi);
		testRoom.play.sub(str);
		assertEquals("die", testRoom.play.carreer.vi[2].status);
		assertEquals(false, testRoom.play.isWin());
	}
}
