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

    @Override
    public String toString() {
        return getName();
    }
    
    
}
