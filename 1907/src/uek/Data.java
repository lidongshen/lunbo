package uek;

public class Data{
	
	private String id;
	private String name;
	private String age;
	private String sex;
	private String score;
	private String uid;
	private String sessionname;
	private String sessionuid;
	public Data(String id, String name, String age, String sex, String score, String uid, String sessionname,
			String sessionuid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
		this.uid = uid;
		this.sessionname = sessionname;
		this.sessionuid = sessionuid;
	}
	public Data() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSessionname() {
		return sessionname;
	}
	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}
	public String getSessionuid() {
		return sessionuid;
	}
	public void setSessionuid(String sessionuid) {
		this.sessionuid = sessionuid;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", score=" + score + ", uid="
				+ uid + ", sessionname=" + sessionname + ", sessionuid=" + sessionuid + "]";
	}
	
	
	
}
