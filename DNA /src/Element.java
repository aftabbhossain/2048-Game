
public class Element {
	public enum Type {DNA, RNA, UNUSED}

	private Type t;
	private lab4linked <String> l;
	
	public Element (Type t, lab4linked <String> l) {
		this.t = t;
		this.l = l;
	}

	public Type getT() {
		return t;
	}

	public void setT(Type t) {
		this.t = t;
	}

	public lab4linked<String> getL() {
		return l;
	}

	public void setL(lab4linked<String> l) {
		this.l = l;
	}
	}

