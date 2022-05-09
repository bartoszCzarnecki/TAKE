/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bartek
 */
@Entity
@NamedQuery(name = "Complaint.findByStatus", query =
"SELECT c FROM Complaint c WHERE c.status = :status"
)
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotNull 
    private LocalDate complaintDate;

    /**
     * Get the value of complaintDate
     *
     * @return the value of complaintDate
     */
    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    /**
     * Set the value of complaintDate
     *
     * @param complaintDate new value of complaintDate
     */
    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }
    
    @NotNull
    @Size(min = 1, max = 6)
    private String status;

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    @NotNull
    @Size(min = 1, max = 60)
    private String author;

    /**
     * Get the value of author
     *
     * @return the value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the value of author
     *
     * @param author new value of author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @NotNull
    @Size(min = 1, max = 60)
    private String complaintText;

    /**
     * Get the value of complaintText
     *
     * @return the value of complaintText
     */
    public String getComplaintText() {
        return complaintText;
    }

    /**
     * Set the value of complaintText
     *
     * @param complaintText new value of complaintText
     */
    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Complaint[ id=" + id + " ]";
    }
    
}
