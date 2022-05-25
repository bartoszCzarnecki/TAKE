/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bartek
 */
@Named(value = "tableBean")
@RequestScoped
public class TableBean {
    
    private List<Student> students;
    
    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
        students = new ArrayList<>();
        students.add(new Student("Adam", "Adamski", 4.25));
        students.add(new Student("Bartosz", "Bartoszewicz", 4.00));
        students.add(new Student("Cyprian", "Cyprianski", 3.50));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
