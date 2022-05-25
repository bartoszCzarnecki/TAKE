/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bartek
 */
@Named(value = "formBean")
@RequestScoped
public class FormBean {

    private int c;
    private int a;
    private int b;
    private Date currentDate;
    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
        this.currentDate = new Date();
    }
    
    public void calculate() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
        c = a + b;
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(
                    String.format("%d + %d = %d", a, b, c)
            ));

    }
    
    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }
    
    /**
     * @return the currentDate
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
}
