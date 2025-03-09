package com.my.spring.toursproj.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * `findByName` function ka bana zaroori tha kyun ke yeh method database se specific `Group` ko uske naam ke zariye dhoondhne ke liye use hota hai. Jab aap 
 * `GroupRepository` interface ko `JpaRepository` se extend karte hain, to aapko kuch custom methods define karne ki zaroorat hoti hai jo aapke business logic ko 
 * support karte hain.
 * Yeh method aapko yeh faida deta hai ke aap asaani se aur efficiently database se `Group` objects ko retrieve kar sakte hain jo ke specific naam ke hain. 
 * Is tarah aapko manually SQL queries likhne ki zaroorat nahi padti aur aapka code zyada readable aur maintainable ho jata hai.
 * Is method ko use karne se aap sirf method call karke `Group` ko naam ke zariye retrieve kar sakte hain, jaise
 * Group group = groupRepository.findByName("exampleName");
 * Is tarah aapka code zyada clean aur concise hota hai.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);

    List<Group> findAllByUserId(String id);

}
