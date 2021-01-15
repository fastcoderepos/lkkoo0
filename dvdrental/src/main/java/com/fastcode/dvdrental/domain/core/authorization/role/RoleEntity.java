package com.fastcode.dvdrental.domain.core.authorization.role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.authorization.rolepermission.RolepermissionEntity;
import com.fastcode.dvdrental.domain.core.authorization.userrole.UserroleEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class RoleEntity extends AbstractEntity {

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
    
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
        private Set<RolepermissionEntity> rolepermissionsSet = new HashSet<RolepermissionEntity>();
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
        private Set<UserroleEntity> userrolesSet = new HashSet<UserroleEntity>();

}



