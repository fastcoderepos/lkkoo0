package com.fastcode.dvdrental.domain.core.authorization.userpermission;

import java.time.*;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter
@NoArgsConstructor
public class UserpermissionId implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long permissionId;
    private Long userId;
    
    public UserpermissionId(Long permissionId,Long userId) {
 	this.permissionId = permissionId;
 	this.userId = userId;
    }
    
}
