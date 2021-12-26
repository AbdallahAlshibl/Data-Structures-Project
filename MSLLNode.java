
import java.util.ArrayList;

class MSLLNode<T> {
	private String info;
	private SLLNode<T> head;
	private SLLNode<T> tail;
	private MSLLNode<T> next;
	static ArrayList<City> cityArrayList = new ArrayList<City>();
	static int count = -1;

	MSLLNode() {
	}

	MSLLNode(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SLLNode<T> getHead() {
		return head;
	}

	public void setHead(SLLNode<T> head) {
		this.head = head;
	}

	public SLLNode<T> getTail() {
		return tail;
	}

	public void setTail(SLLNode<T> tail) {
		this.tail = tail;
	}

	public MSLLNode<T> getNext() {
		return next;
	}

	public void setNext(MSLLNode<T> next) {
		this.next = next;
	}
}
