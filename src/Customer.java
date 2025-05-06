import java.util.Random;


public class Customer {
private String name;
private MagicSchool requestedSchool;
private Random random;

public Customer(String name){
    this.name=name;
    this.random=new Random();
}
public void generateRandomRequest(){
    MagicSchool[]schools=MagicSchool.values();
        requestedSchool=schools[random.nextInt(schools.length)];
    }
    public String getName(){
        return name;
    }
    public MagicSchool getRequestedSchool(){
        return requestedSchool;
    }
    @Override
            public String toString() {
        return name+" requests a potion from the "+requestedSchool;
    }
}



