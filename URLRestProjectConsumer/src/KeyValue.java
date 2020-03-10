
public class KeyValue {
	String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "KeyValue [data=" + data + "]";
	}

	public KeyValue(String data) {
		super();
		this.data = data;
	}

	public KeyValue() {
		super();
	}	
}
