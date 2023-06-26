package gebal_rsp;

import java.util.ArrayList;
import java.util.List;
//이교진
public class Data {
	private String id, server;

	List data = new ArrayList<>();

	public Data(String id, String server) {

		this.id = id;
		this.server = server;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServer() {
		return server;
	}

	public void setPw(String server) {
		this.server = server;
	}

}
