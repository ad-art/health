package org.health.model;

public interface SQLRequest {
    /*
    * method required for adding table to DB
    * return status with String
    * */
    String getTableCreationStatus();

    /*
    * @param name - specific name of dogs
    * @return count of dog with specific name
    * */
    Integer getInfo(String name);
}
