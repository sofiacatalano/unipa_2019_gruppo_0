package it.eng.unipa.filesharing.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class MembershipOid implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;
	
	private Long bucketId;
	
	public MembershipOid() {}
	
	public MembershipOid(Long bucketId,String email) {
		this.bucketId = bucketId;
		this.email = email;
	}
	
	
	public Long getBucketId() {
		return bucketId;
	}
	
	public void setBucketId(Long bucketId) {
		this.bucketId = bucketId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MembershipOid)) {
            return false;
        }
        MembershipOid that = (MembershipOid) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(this.getEmail(), that.getEmail());
        eb.append(this.getBucketId(), that.getBucketId());
        return eb.isEquals();
    }
	
	@Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.getEmail());
        hcb.append(this.getBucketId());
        return hcb.toHashCode();
    }

}
