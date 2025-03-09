package com.my.spring.toursproj.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 1. `@Data`, `@NoArgsConstructor`, aur `@RequiredArgsConstructor` annotations
 * Lombok library se hain jo aapke liye getters, setters, aur constructors
 * automatically
 * generate karte hain.
 * 2. `@Entity` aur `@Table(name = "user_group")` annotations Hibernate ko
 * batate hain ke ye class database table ke sath map hogi jiska naam
 * "user_group" hoga.
 * 3. `@Id` aur `@GeneratedValue` annotations batate hain ke `id` field primary
 * key hai aur automatically generate hogi.
 * 4. `@NonNull` annotation ensure karta hai ke `name` field kabhi null na ho.
 * 5. `@ManyToOne(cascade = CascadeType.PERSIST)` batata hai ke ek `Group` ka
 * aik `User` se taluq hai aur jab `Group` persist hoga to `User` bhi persist
 * hoga agar wo
 * already database mein nahi hai.
 * 6. `@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)` batata
 * hai ke ek `Group` ke multiple `Event` objects ho sakte hain aur jab `Group`
 * load hoga to
 * `Event` objects bhi saath load honge. CascadeType.ALL ka matlab hai ke
 * `Group` ke sath related `Event` objects pe bhi sab operations (persist,
 * merge, remove, etc.) apply honge.
 * 
 * Yeh annotations aur mappings aapko object-relational mapping (ORM) mein madad
 * karte hain taake aap easily Java objects ko database tables ke sath map kar
 * saken.
 */

@Setter
@Getter
@AllArgsConstructor
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_group")
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;

}
