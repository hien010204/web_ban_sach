/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vn.quanli.webansach_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="category_id")
    private int categoryId;

    @Column(name = "category_name", columnDefinition= "nvarchar(256)")
    private String categoryName;
    
    @ManyToMany(fetch = FetchType.LAZY,  cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinTable(name = "book_category",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> bookList;
}