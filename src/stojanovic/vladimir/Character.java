package stojanovic.vladimir;

public class Character {

	public String name;
	public String allegiance;
	public String message_file;

	public Character(String name, String allegiance, String message_file) {
		super();
		this.name = name;
		this.allegiance = allegiance;
		this.message_file = message_file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public String getMessage_file() {
		return message_file;
	}

	public void setMessage_file(String message_file) {
		this.message_file = message_file;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", allegiance=" + allegiance + ", message_file=" + message_file + "]";
	}

}
