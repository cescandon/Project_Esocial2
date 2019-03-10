/*
* Class is to provide accessibility to database esocial for Client information. 
* Connect to Java DB and derby host esocial
* build works with the clean and build option. regular build output is outdated 
* plugins maven 1.6
* Getters and setters are provided.
* Query provided for database structure esocial[nbuser]
*/
package esocial.skeleton;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author conradescandon
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientID = :clientId")
    , @NamedQuery(name = "Client.findByClientFirstName", query = "SELECT c FROM Client c WHERE c.clientFN = :clientFN")
    , @NamedQuery(name = "Client.findByClientLastName", query = "SELECT c FROM Client c WHERE c.clientLN = :clientLN")
    , @NamedQuery(name = "Client.findbyClientsEmail", query = "SELECT c FROM Client c WHERE c.email = :email")
        
})


public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer clientID;
    @Column(name = "FirstName")
    private String clientFN;
    @Column (name = "LastName")
    private String clientLN;
    @Column (name = "EMAIL")
    private String email;
    

    
    public Client()
    {
        
    }
    
    public Client(Integer clientID)
    {
        this.clientID = clientID;
    }
    
    public Integer getClientId()
    {
        return clientID;
    }
    
    public void setClientId(Integer ClientID) {
        this.clientID = ClientID;
    }
    
    public void setFirstName(String Fname)
    {
        clientFN = Fname;
    }
    
    public String getFName()
    {
        return clientFN;
    }
    
    public void setLastName(String Lname)
    {
        clientLN = Lname;
    }
    
    public String getLastName()
    {
        return clientLN;
    }
    
    public void setEmail(String _email)
    {
        email = _email;
    }
    
    public String getemail()
    {
        return email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esocial.skeleton.Client[ id=" + clientID + " ]";
    }
    
}
