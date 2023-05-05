/*
When we put our code in subfolders ("packages"), we need to describe which of these subfolders
are relevant to people running our code. We do this with a Module.
 */
//We declare a module with the word 'module' then the name of the module:

module David9thLab.main {
    //inside, we declare what other modules (or third party dependencies) we're importing
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    //we also declare what packages/subfolders from our code we want to make visible to the rest of the world:
    opens org.example;
    exports org.example;

}