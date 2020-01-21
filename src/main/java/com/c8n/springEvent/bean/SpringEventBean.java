package com.c8n.springEvent.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dragon on 2020/1/21.
 */
@Entity
@Table(name = "spring_event_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpringEventBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "[desc]")
    private String desc;

    @Column(name = "time", columnDefinition = "datetime default CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private Date time;
}
