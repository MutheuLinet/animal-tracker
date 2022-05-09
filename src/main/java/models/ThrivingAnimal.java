package models;

public class ThrivingAnimal extends Animal{
    public static final String ANIMAL_TYPE = "Thriving_Animal";

    public ThrivingAnimal(String animalName) {
        if (animalName.equals("")){
            throw new RuntimeException("Please submit an Animal name.");
        }
        this.animalName = animalName;
        this.animalType =ANIMAL_TYPE;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setType(String type) {
        this.animalType = type;
    }

    // overriding endangered animal
    @Override
    public boolean equals(Object otherThrivingAnimal) {
        if (otherThrivingAnimal instanceof ThrivingAnimal) {
            ThrivingAnimal newThrivingAnimal = (ThrivingAnimal) otherThrivingAnimal;
            return (this.getAnimalName().equals(newThrivingAnimal.getAnimalName()));
        }

        return false;
    }
}
