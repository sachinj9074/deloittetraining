package javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//Java IO serialization and deserialization
class User implements Serializable{
	private static final long serialVersionUID= 1L; 
	//serialVersionUID changes every time
	//We get it from cmd prompt by executing the path of the User file
	//If object and class have different UID the code will not work
	
	private String name;
	
	private String email;
	

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
}
public class Main {
    
	public static void main(String[] args) {

		Main m = new Main();

		try {
			m.deSerialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done..");
	}

	void serialize() throws FileNotFoundException, IOException {
		String fileName="user.txt";
		User u=new User("ashish","ashish@gmail.com");
		try(FileOutputStream fOut=new FileOutputStream(fileName)){
			ObjectOutputStream objOut=new ObjectOutputStream(fOut);
			objOut.writeObject(u);
		}
	}
	
	void deSerialize() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		String fileName="user.txt";
		User u=null;
		try(FileInputStream fIn=new FileInputStream(fileName)){
			ObjectInputStream objIn = new ObjectInputStream(fIn);
			u=(User) objIn.readObject();
			System.out.println(u);
		}
	}
	
	}