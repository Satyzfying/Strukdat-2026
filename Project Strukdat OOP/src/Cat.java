public abstract class Cat { //abstraction
    
    private String name; //encapsulation
    private String mood;
    private int energy;
    private int hunger;

    public Cat(String name, String mood, int energy, int hunger){
        this.name = name;
        this.mood = mood;
        this.energy= energy;
        this.hunger = hunger;
    }

    public void eat(){
        System.out.println("You offered "+getName()+ " to eat");
        if(hunger>=100){
            System.out.println(name +" is not hungry!"); 
        }
        else{
            hunger+=10;
            System.out.println(getName()+" is eating");
        }
    }
    public void pet(){
        System.out.println("You want to pet " + getName());
        if(energy<50){
            mood = "tired";
        }
        else{
            mood = "happy";
        }
        System.out.println("Done Petting");
    }
    public abstract void play();//abstraction
    
    public String getName() {//getter
         return name;
    }

    public String getMood() {
        return mood;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHunger() {
        return hunger;
    }
    public void showStatus() {
    System.out.println("My cat " + name +
                       " is " + mood +
                       ", its energy is: " + energy +
                       " and its hunger is " + hunger + "\n");
    }

    static class PersianCat extends Cat { //inheritnance
        public PersianCat(String name, String mood, int energy, int hunger){
    
            super(name, mood, energy, hunger);
        }
        @Override
        public void play(){
            System.out.println("You want to play with "+getName());
            System.out.println(getName()+" is laying on its back");
        }
    }
    static class SiameseCat extends Cat {
        public SiameseCat(String name, String mood, int energy, int hunger){
    
            super(name, mood, energy, hunger);
        }
        @Override
        public void play(){
            System.out.println("You want to play with "+getName());
            System.out.println(getName()+" is jumping everywhere!");
        }
    }

    public static void main(String[] args) throws Exception {
        Cat Tabi = new PersianCat("Tabi","Happy",50,50); //polymorphism

        Tabi.eat();
        Tabi.pet();
        Tabi.play();
        Tabi.showStatus();

        Cat Grayie = new SiameseCat("Grayie","Tired",0,0);
        Grayie.eat();
        Grayie.pet();
        Grayie.play();
        Grayie.showStatus();
    }
}
