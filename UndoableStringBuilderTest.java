package Task0;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * this is the Junit testing for UndoStringBuilder  
 * @author Aviya and Mali Bloch
 * @version 7/11/2022
 *
 */
public class UndoableStringBuilderTest {
	UndoableStringBuilder usb = new UndoableStringBuilder ();

	/**
	 * this function tests the Undo function
	 */
	@Test
	public void testUndo() {
		usb.append("need to check");
		usb.delete(4,8);
		usb.append("abcd");
		usb.undo();
		usb.undo();
		StringBuilder expected = new StringBuilder("need to check");
		assertEquals("testing append" ,expected.toString() , usb.toString());
	}
	/**
	 * this function tests the append function
	 */
	@Test
	public void testAppend() {
		usb.append("need to check");
		StringBuilder expected = new StringBuilder("need to check");
		assertEquals("testing append" ,expected.toString() , usb.toString());
	}
	/**
	 * this function tests the delete function
	 */
	@Test
	public void testDelete() {
		usb.append("need to check");
		usb.delete(4,8);
		StringBuilder expected = new StringBuilder("needcheck");
		assertEquals("testing delete" ,expected.toString() , usb.toString());
	}
	/**
	 * this function tests the insert function
	 */
	@Test
	public void testInsert() {
		usb.append("need to check");
		usb.insert(4, " now");
		StringBuilder expected = new StringBuilder("need now to check");
		assertEquals("testing insert" ,expected.toString() , usb.toString());
	}
	/**
	 * this function tests the replace function
	 */
	@Test
	public void testReplace() {
		usb.append("need to check");
		usb.replace(4,8, " no ");
		StringBuilder expected = new StringBuilder("need no check");
		assertEquals("testing replace" ,expected.toString() , usb.toString());
	}
	/**
	 * this function tests the reverse function
	 */
	@Test
	public void testReverse() {
		usb.append("abcd");
		usb.reverse();
		StringBuilder expected = new StringBuilder("dcba");
		assertEquals("testing reverse" ,expected.toString() , usb.toString());
	}

}
