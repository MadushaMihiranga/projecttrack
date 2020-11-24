/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projecttrack.User.Entity;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author madusha mihiranga
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Column(name = "nonexpired")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean nonexpired;

    @Column(name = "nonlocked")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean nonlocked;

    @Column(name = "credentialsnonexpired")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean credentialsnonexpired;

    @Column(name = "enabled")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enabled;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Column(name = "createdate")
    private LocalDateTime createdate;

    @Column(name = "resetcode")
    private String resetcode;

    @Column(name = "lastpswresetdate")
    private LocalDateTime lastpswresetdate;

    @JoinTable(name = "user_has_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id",nullable = false, updatable = false)})
    @ManyToMany( cascade = {CascadeType.ALL,},fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<Authority>();

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    /* @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<Authority> authorityList;*/

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getNonexpired() {
        return nonexpired;
    }

    public void setNonexpired(Boolean nonexpired) {
        this.nonexpired = nonexpired;
    }

    public Boolean getNonlocked() {
        return nonlocked;
    }

    public void setNonlocked(Boolean nonlocked) {
        this.nonlocked = nonlocked;
    }

    public Boolean getCredentialsnonexpired() {
        return credentialsnonexpired;
    }

    public void setCredentialsnonexpired(Boolean credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    public String getResetcode() {
        return resetcode;
    }

    public void setResetcode(String resetcode) {
        this.resetcode = resetcode;
    }

    public LocalDateTime getLastpswresetdate() {
        return lastpswresetdate;
    }

    public void setLastpswresetdate(LocalDateTime lastpswresetdate) {
        this.lastpswresetdate = lastpswresetdate;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projecttrackentity.entity.User[ id=" + id + " ]";
    }
    
}
