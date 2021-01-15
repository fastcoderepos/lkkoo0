package com.fastcode.dvdrental.domain.core.authorization.permission;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.authorization.rolepermission.RolepermissionEntity;
import com.fastcode.dvdrental.domain.core.authorization.userpermission.UserpermissionEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permission")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PermissionEntity extends AbstractEntity {

    @Basic
    @Column(name = "display_name", nullable = false,length =255)
    private String displayName;

    @Basic
    @Column(name = "name", nullable = false,length =255)
    private String name;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
        private Set<UserpermissionEntity> userpermissionsSet = new HashSet<UserpermissionEntity>();
    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
        private Set<RolepermissionEntity> rolepermissionsSet = new HashSet<RolepermissionEntity>();

}



