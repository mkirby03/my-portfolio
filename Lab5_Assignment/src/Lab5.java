//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Lab5.java
//Brief Description of Program: Creates a Pet parent class with constructors, instance variables and methods, and setter and getter methods that
//child classes will inherit and create or add instance methods of their own for specific types of pets (also override a method from parent class)
//Due Date: 10/10/22

class Pet
{
    //Instance variables
    private String type;
    private String name;
    private String birth_date;
    private String owner;
    private Double weight;
    private String sex;
    private String color;
    //default constructor
    public Pet()
    {
        type = " ";
        name = " ";
        birth_date = " ";
        owner = " ";
        weight = 0.0;
        sex = " ";
        color = " ";
    }
    //constructor with parameters
    public Pet(String t, String a_name, String a_birth_date, String a_owner, Double a_weight, String a_sex, String a_color)
    {
        type = t;
        name = a_name;
        birth_date = a_birth_date;
        owner = a_owner;
        weight = a_weight;
        sex = a_sex;
        color = a_color;
    }
    //addtional methods
    public void speak()
    {
        System.out.println("Hello");
    }
    
    public void getTag()
    {
        System.out.println("If lost, call " + owner);
    }
    //Create toString() method to output information
    public String toString()
    {
        String my_message = "Name: " + name + "\n" + "Type: " + type + "\n" + "Birth Date: " + birth_date + "\n" + "Owner: " + owner + "\n" + "Weight: "
                + weight + "\n" + "Sex: " + sex + "\n" + "Color: " + color + "\n";
        return my_message;
    }
    //Create "setter" and "getter" methods for each instance variable
    public void setType(String t)
    {
       this.type = t;
    }
    public String getType()
    {
       return type;
    }
    public void setName(String a_name)
    {
       this.name = a_name;
    }
    public String getName()
    {
       return name;
    }
    public void setBirthDate(String a_birth_date)
    {
       this.birth_date = a_birth_date;
    }
    public String getBirthDate()
    {
       return birth_date;
    }
    public void setOwner(String a_owner)
    {
       this.owner = a_owner;
    }
    public String getOwner()
    {
       return owner;
    }
    public void setWeight(Double a_weight)
    {
       this.weight = a_weight;
    }
    public Double getWeight()
    {
       return weight;
    }
    public void setSex(String a_sex)
    {
       this.sex = a_sex;
    }
    public String getSex()
    {
       return sex;
    }
    public void setColor(String a_color)
    {
       this.color = a_color;
    }
    public String getColor()
    {
       return color;
    }
}
//Create child class of parent class Pet called Cat that overrides speak() method and adds instance methods of its own that are void & take no parameters
class Cat extends Pet
{
    @Override
    public void speak()
    {
        System.out.println("meow");
        //super.speak();
    }
    //instance methods or functions
    public void scratch_post()
    {
        System.out.println("scratch, scratch");
    }
    public void ignore_owner()
    {
        System.out.println("looks away and stays put");
    }
    public void sleep()
    {
        System.out.println("zzz");
    }
    public void climb_trees()
    {
        System.out.println("runs up tree");
    }
}
//Create child class of parent class Pet called Dog that overrides speak() method and adds instance methods of its own that are void & take no parameters
class Dog extends Pet
{
    @Override
    public void speak()
    {
        System.out.println("bark! bark!");
        //super.speak();
    }
    //instance methods or functions
    public void roll_over()
    {
        System.out.println("rolls around on back until upright again");
    }
    public void play_dead()
    {
        System.out.println("lays still with mouth open");
    }
    public void sit()
    {
        System.out.println("sits down on butt");
    }
    public void whine()
    {
        System.out.println("hmmn!, hmmn!");
    }
    public void wag_tail()
    {
        System.out.println("whoosh, whoosh - wiggle, wiggle");
    }
}
//Create child class of parent class Pet called Bird that overrides speak() method and adds instance methods of its own that are void & take no parameters
class Bird extends Pet
{
    @Override
    public void speak()
    {
        System.out.println("chirp! chirp!");
        //super.speak();
    }
    //instance methods or functions
    public void sing()
    {
        System.out.println("whistle, whistle");
    }
    public void fly()
    {
        System.out.println("soar, whoosh");
    }
    public void eat_bird_seed()
    {
        System.out.println("peck, peck");
    }
}
//Create child class of parent class Pet called Turtle that overrides speak() method and adds instance methods of its own that are void & take no parameters
class Turtle extends Pet
{
    @Override
    public void speak()
    {
        System.out.println("grunt! grunt!");
        //super.speak();
    }
    //instance methods or functions
    public void crawl()
    {
        System.out.println("scoot, scoot");
    }
    public void hide_in_shell()
    {
        System.out.println("retreats, ducks inside");
    }
    public void swim()
    {
        System.out.println("splash, splash");
    }
}
//Main Method
public class Lab5 {
    public static void main(String[] args)
    {
        //create two objects for Pet and class and one constructor object for child classes (test getTag method from Pet class)
        Pet object_one_pet = new Pet();
        Pet object_two_pet = new Pet("Shadow", "Dog", "1/13/2013", "Karen", 42.6, "Male", "Black");
        Cat object_three_cat = new Cat();  //use setters to change toString() method output
        Dog object_four_dog = new Dog();
        Bird object_five_bird = new Bird();
        Turtle object_six_turtle = new Turtle();
        //test objects one at a time by class starting with Pet class and test each objects methods by objectname.methodname();
        object_one_pet.speak();
        object_two_pet.getTag();
        System.out.println(object_two_pet);
        //Test Cat methods and object and use object to invoke toString() method and print out the output
        object_three_cat.speak();
        object_three_cat.scratch_post();
        object_three_cat.ignore_owner();
        object_three_cat.sleep();
        object_three_cat.climb_trees();
        object_three_cat.setType("Cat");
        object_three_cat.setName("Tom");
        object_three_cat.setBirthDate("2/14/2015");
        object_three_cat.setOwner("Brian");
        object_three_cat.setWeight(40.2);
        object_three_cat.setSex("Male");
        object_three_cat.setColor("Brown");
        System.out.println(object_three_cat);
        //Test Dog methods and object and use object to invoke toString() method and print out the output
        object_four_dog.speak();
        object_four_dog.roll_over();
        object_four_dog.play_dead();
        object_four_dog.sit();
        object_four_dog.whine();
        object_four_dog.wag_tail();
        object_four_dog.setType("Dog");
        object_four_dog.setName("Tasha");
        object_four_dog.setBirthDate("3/21/2011");
        object_four_dog.setOwner("Martin");
        object_four_dog.setWeight(38.2);
        object_four_dog.setSex("Female");
        object_four_dog.setColor("Light Brown");
        System.out.println(object_four_dog);
        //Test Bird methods and object and use object to invoke toString() method and print out the output
        object_five_bird.speak();
        object_five_bird.sing();
        object_five_bird.fly();
        object_five_bird.eat_bird_seed();
        object_five_bird.setType("Bird");
        object_five_bird.setName("Blu");
        object_five_bird.setBirthDate("5/1/2018");
        object_five_bird.setOwner("Bree");
        object_five_bird.setWeight(11.5);
        object_five_bird.setSex("Male");
        object_five_bird.setColor("Red");
        System.out.println(object_five_bird);
        //Test Turtle methods and object and use object to invoke toString() method and print out the output
        object_six_turtle.speak();
        object_six_turtle.crawl();
        object_six_turtle.hide_in_shell();
        object_six_turtle.swim();
        object_six_turtle.setType("Turtle");
        object_six_turtle.setName("Francine");
        object_six_turtle.setBirthDate("12/27/2016");
        object_six_turtle.setOwner("Julie");
        object_six_turtle.setWeight(50.5);
        object_six_turtle.setSex("Female");
        object_six_turtle.setColor("Green");
        System.out.println(object_six_turtle);
    }
}
