package models;

import java.util.List;

public interface EndangeredAnimalManagement {
    //create
    void add(EndangeredAnimal endangeredAnimal);

    //update
    void update(EndangeredAnimal endangeredAnimal);

    //read specific endangered animal
    EndangeredAnimal getEndangeredAnimalById(int id);

    //read all endangered animals
    List<EndangeredAnimal> getEndangeredAnimals();

    //delete specific endangered animal
    void deleteEndangeredAnimal(int id);

    //delete all endangered animals
    void deleteAllEndangeredAnimals();
}
