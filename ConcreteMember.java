package Task0;

/*
 * this is the "observe" ,
 *  it's mean that each object from this class "want" to know when
 *  the observable (UndoableStringBuilder) is changing...  
 */
public class ConcreteMember  implements Member{
	 public UndoableStringBuilder s;
	    
//	private String name;
//	private Sender topic;
//	
	public ConcreteMember  (String s) {
		this.s=s;??
	}
	        
	@Override
	 public void update(UndoableStringBuilder usb) {
        s = usb;
        System.out.println(s.toString());
//	public void update() {
//		String msg = (String) topic.getUpdate(this);
//		if(msg == null){
//			System.out.println(name+":: No new message");
//		}else
//		System.out.println(name+":: Consuming message::"+msg); 
//		
}

	@Override
    public String toString() {
        return s.toString();
    }
//	@Override
//	public void setSubject(Sender sub) {
//		this.topic=sub;
//		
//	}

}
