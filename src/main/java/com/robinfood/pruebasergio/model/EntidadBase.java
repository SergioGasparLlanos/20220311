package com.robinfood.pruebasergio.model;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EntidadBase {
    
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;
    
}
