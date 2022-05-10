package models;

public class EndangeredAnimal extends Animal {

    public String health;
    public String age;

    public static final String ANIMAL_TYPE = "Endangered_Animal";

    public EndangeredAnimal(String animalName, String health, String age) {
       if (animalName.equals("") || health.equals("") || age.equals("")){
           throw new RuntimeException("Please input all fields");
       }
        this.animalName =animalName;
        this.age = age;
        this.health = health;
        this.animalType =ANIMAL_TYPE;
        this.id=id;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAnimalName() {
        return animalName;
    }

    public void setName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // overriding endangered animal
    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if (otherEndangeredAnimal instanceof EndangeredAnimal) {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return (this.getAnimalName().equals(newEndangeredAnimal.getAnimalName()));
        }
        return false;
    }


}
