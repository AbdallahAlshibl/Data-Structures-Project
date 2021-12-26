
import java.util.ArrayList;

class SLLNode<T> {
	private T info = null;
	public SLLNode<T> next;
	static ArrayList<String> msllNodeArrayList = new ArrayList<String>();
	static int msllCount = -1;

	public SLLNode() {
		this(null, null);
	}

	public SLLNode(T el) {
		this(el, null);
	}

	public SLLNode(T el, SLLNode<T> ptr) {
		info = el;
		next = ptr;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
}
