package it.eng.unipa.filesharing.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class UserRoleOid implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UUID uuid;
	
	private String email;
	
	public UserRoleOid() {}
	
	public UserRoleOid(UUID uuid,String email) {
		this.uuid = uuid;
		this.email = email;
	}
	
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserRoleOid)) {
            return false;
        }
        UserRoleOid that = (UserRoleOid) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(this.getEmail(), that.getEmail());
        eb.append(this.getUuid(), that.getUuid());
        return eb.isEquals();
    }
	
	@Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.getEmail());
        hcb.append(this.getUuid());
        return hcb.toHashCode();
    }

}
