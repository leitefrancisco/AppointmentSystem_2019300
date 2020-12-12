/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

/**
 *
 * @author Francisco Leite
 */

//Class created in order to make possible the selection of the barber and its location in the "costumer make new appointment" view

//constructor will get the name and the user id of the barber
public class ComboBoxItem {
    private int id;
    private String name;
   

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public ComboBoxItem(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //this overrise is used to convert the getname mathod in a String otherwise it would show the location in the memory of the content and not the word.
    @Override
    public String toString() {
        return getName();
    }
    
    
}
