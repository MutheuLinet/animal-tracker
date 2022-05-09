package models;

import java.util.List;

public interface ThrivingAnimalManagement {
    //create
    void add(ThrivingAnimal thrivingAnimal);

    //update
    void update(ThrivingAnimal thrivingAnimal);

    //read specific endangered animal
    ThrivingAnimal getThrivingAnimalById(int id);

    //read all endangered animals

    List<ThrivingAnimal> getThrivingAnimals();

    //delete specific endangered animal
    void deleteThrivingAnimal(int id);

    //delete all endangered animals
    void deleteAllThrivingAnimals();
}
