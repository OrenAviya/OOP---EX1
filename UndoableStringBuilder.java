package Task0;

import java.util.Stack;
/**
 * This class is like StringBuilder but with the option to do undo to a function
 * @author Aviya and Mali Bloch
 * @version 2 (7/11/2022)
*/
public class UndoableStringBuilder implements Sender  {//implements todoUndo
	private StringBuilder s;
	private Stack<String> HelpUndo;
	
	
	/**
	 * This function is the empty constructor of the class
	 **/	
	public UndoableStringBuilder(){
		this.s = new StringBuilder();
		this.HelpUndo = new Stack<String>(); 
	}
	/**
	 * This function is the constructor of the class
	 * @param str - for the string.
	 **/
	public UndoableStringBuilder(StringBuilder str) {
		this.s = str;
		this.HelpUndo = new Stack<String>();
	}
	
	/**
	 * This function is undoing the last action that was done on the String
	 **/
	public void undo(){
		try {
			String str = HelpUndo.pop();
			this.s.replace(0, s.length(), str);
			} 
		catch (Exception e) 
			{
			System.out.println("we have caught an exception");
			e.printStackTrace();
			if (HelpUndo.isEmpty()) {System.out.println("there is no back step... ");}
			}
	}
	/**
	 * This function appends the input string to the end of our string
	 * @param str - a string that will be added
	 * @return our StringBuilder after appending the given string at the end 
	 **/
	
	
	public UndoableStringBuilder append(String str) {
		
		if (str==null) { 
			System.err.println("can't append null to a string, no change has done");
		}
		else try{
			HelpUndo.push(s.toString());
			this.s = s.append(str);
			}
			catch(RuntimeException e) {
			e.printStackTrace();
		}
			UndoableStringBuilder usb = new UndoableStringBuilder(s) ;
			return usb;
			
		
	}
		
	/**
	 * This function deletes a substring from our string
	 * @param start --a start index that the substring starts at 
	 * @param end- an end index for the substring (the end itself is not included)
	 * @return our StringBuilder that is our string without the substring
	 **/
	 public UndoableStringBuilder delete(int start, int end) {
		try {
			HelpUndo.push(s.toString());
		 this.s = s.delete(start, end); 
		 UndoableStringBuilder usb = new UndoableStringBuilder(s) ;
		return usb;
		 
		}
		catch (Exception e){
			if (start > this.s.length()|| start > end || start <0) {
				System.err.println("the indexes are not posibble ");
				System.err.println("No changes were done. the string before delete: "+s.toString());	
			}
			else {
			System.out.println("we have caught an exception");
			e.printStackTrace();
			System.out.println("No changes were done. the string before delete: "+s.toString());
			}	
		}
		UndoableStringBuilder usb = new UndoableStringBuilder(s) ;
		return usb;
	 }
	 /**
		 * This function inserts the input string to the offset index of our string
		 * @param offset - an index that will be the beginning of the substring
		 * @param str - a string that will be added 
		 * @return our StringBuilder that is our string with the added string at the right place
		 **/
	 public UndoableStringBuilder insert(int offset, String str) {
		
		 if (str == null) {
				System.err.println("the method accept just a not-null strings ") ;
		  } 
		 else try{
			 HelpUndo.push(s.toString());
		 this.s = this.s.insert(offset, str);
		 }
		 catch (Exception e){
			 if (offset > s.length() || offset < 0  ) {
				System.err.println("the indexes are not posibble ");
				System.err.println("No changes were done. the string before: "+s.toString());
			 }
			 else {
				 System.out.println("we have caught an exception");
					e.printStackTrace();
					System.out.println("No changes were done. the string before : "+s.toString());
			 }
		 }
		 UndoableStringBuilder usb = new UndoableStringBuilder(s) ;
			return usb;
	 }
	 /**
		 * This function replaces the input string the substring of our string
		 * @param start - a start index
		 * @param end - an end index of the substring that will be replaced
		 * @param str - a string that will be replacing 
		 * @return our StringBuilder that is our StringBuilder with the added string at the end 
		 **/
	 public UndoableStringBuilder replace(int start,int end, String str)
	 {
		  try{
			HelpUndo.push(s.toString()); 
			 this.s = this.s.replace(start, end, str);
		}
		 catch (NullPointerException e) {
			  if (str == null) {
					System.err.println("the method accept just a not-null strings ") ;
					e.printStackTrace();
			  }
		  }
		catch (RuntimeException e) {

		 if (this.s.length()<start || this.s.length() < str.length() || this.s.length() < end)
			 {
			 System.err.println(" the string's length is: " + s.length()+ " . your numbers is out of bound");
			 e.printStackTrace();
			 }
			
			else {
				System.out.println("we have caught an exception");
				e.printStackTrace();
			}
		}
		
		UndoableStringBuilder usb = new UndoableStringBuilder(s) ;
		return usb;
		 
		 
	 }
	 /**
	  * this function Causes this character sequence to be replaced by the reverse of the sequence. 
	  * @return reversed StringBuilder
	  */
	 public UndoableStringBuilder reverse() {
		 try{
			 HelpUndo.push(s.toString());
		 this.s = this.s.reverse();
		 }
		 catch (Exception e) {
			System.out.println("we have caught an exception");
			e.printStackTrace(); 
		 }
		 UndoableStringBuilder usb = new UndoableStringBuilder(s) ;
		return usb;
	 }

	 /**
	  * this function return a string that represent the UndoStringBuilder.
	  */
	 public String toString() {
		 return (this.s.toString());
	 }
	 /**
	  * this is the main , here we do the basic tests to our functions.
	  * @param args - for the main
	  */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndoableStringBuilder usb = new UndoableStringBuilder();
		 usb.append("to be or not to be") ;
		 System.out.println(usb) ;
		 usb.replace(3, 5, "eat") ;
		 System.out.println(usb) ;
		 usb.replace(17, 19, null) ;
		 System.out.println(usb) ;
		 usb.reverse();
		 System.out.println(usb) ;
		 usb.delete(8, 10);
		 System.out.println (usb);
		 usb.undo();
		 System.out.println(usb) ;
		 usb.undo ();
		 System.out.println(usb) ;
		 usb.undo ();
		 System.out.println(usb) ;
		 usb.insert(6, null);
		 System.out.println(usb) ;
		 usb.undo ();
		 System.out.println(usb) ;
		 usb.insert(0, " it is tasty ");
		 System.out.println(usb) ;
		 usb.append(null);
		 System.out.println(usb) ;


	}
	@Override
	public void register(Observer obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unregister(Observer obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getUpdate(Observer obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
