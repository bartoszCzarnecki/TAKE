/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

/**
 *
 * @author Bartek
 */
public class Student {
        private String firstName;
        private String lastName;
        private Double average;
        
        public Student(String firstName, String lastName, Double average) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
        }

        /**
         * @return the firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @param firstName the firstName to set
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * @return the lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @param lastName the lastName to set
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * @return the average
         */
        public Double getAverage() {
            return average;
        }

        /**
         * @param average the average to set
         */
        public void setAverage(Double average) {
            this.average = average;
        }
    }