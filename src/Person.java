
public class Person {
	
	public int id;
	public String username;
	public String password;

	public Person(int id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
}
