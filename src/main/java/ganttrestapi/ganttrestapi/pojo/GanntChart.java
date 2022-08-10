package ganttrestapi.ganttrestapi.pojo;

public class GanntChart {

	private final long id;
	private final String content;

	public GanntChart(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
