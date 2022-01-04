package Core;

public class Notification {
	private int id;
	private String type;
	private String description;
	private Boolean isRead;
	
	
	public Notification(int id, String type, String description, Boolean isRead) {
		this.id = id;
		this.type = type;
		this.description = description;
		this.isRead = isRead;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsRead() {
		return isRead;
	}
	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}


	@Override
	public String toString() {
		return "Notification [type=" + type + ", description=" + description + ", isRead=" + isRead + "]";
	} 
	
	
	
}
