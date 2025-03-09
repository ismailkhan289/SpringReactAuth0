package com.my.spring.toursproj.model;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ManyToMany annotation ka matlab hai ke yeh ek relational mapping hai jo ke
 *             do entities ke darmiyan many-to-many relationship ko define karti
 *             hai.
 *             Iska matlab yeh hai ke ek Event ke multiple User attendees ho
 *             sakte hain aur ek User multiple Events attend kar sakta hai.
 *             Is example mein, Event class mein @ManyToMany annotation
 *             attendees field par lagaya gaya hai jo ke Set<User> type ka hai.
 *             Yeh batata hai ke ek event
 *             ke bohot saare users ho sakte hain jo us event ko attend kar rahe
 *             hain.
 *             Iska matlab yeh hai ke database mein ek join table banega jo
 *             Event aur User ke darmiyan many-to-many relationship ko manage
 *             karega.
 */

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private Instant date;
    private String title;
    private String description;
    @ManyToMany
    private Set<User> attendees;

}
