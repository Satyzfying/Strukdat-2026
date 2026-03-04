public class Cat {
    
    private String name;
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
        if(hunger>=100){
            System.out.println(name +" is not hungry!"); //inget nambahin fungsi nama kucing
        }
        else{
            hunger+=10;
        }
    }
    public void pet(){
        if(energy<50){
            mood = "tired";
        }
        else{
            mood = "happy";
        }
    }
    public void play(){
        if (energy<=0){
            System.out.println(name +" is tired, cannot play");
        }
        else{
            mood = "happy";
            energy -= 10;
        }
    }
    public String getName() {
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
                       " and its hunger is " + hunger);
    }
    public static void main(String[] args) throws Exception {
        Cat Tabi = new Cat("Tabi","Happy",50,50);

        Tabi.eat();
        Tabi.pet();
        Tabi.play();
        Tabi.showStatus();

    }
}
