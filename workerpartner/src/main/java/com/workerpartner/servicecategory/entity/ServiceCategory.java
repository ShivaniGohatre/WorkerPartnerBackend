package com.workerpartner.servicecategory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_category")
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String name;

    // A KEY such as "plumbing", not an emoji or image. The Angular app decides how each key looks.
    @Column(name = "icon_key", length = 40)
    private String iconKey;

    @Column(name = "base_rate")
    private Integer baseRate;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder = 0;

    @Column(nullable = false)
    private Boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIconKey() { return iconKey; }
    public void setIconKey(String iconKey) { this.iconKey = iconKey; }

    public Integer getBaseRate() { return baseRate; }
    public void setBaseRate(Integer baseRate) { this.baseRate = baseRate; }

    public Integer getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(Integer displayOrder) { this.displayOrder = displayOrder; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
