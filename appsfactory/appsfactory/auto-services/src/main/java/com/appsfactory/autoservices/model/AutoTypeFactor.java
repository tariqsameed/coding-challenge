package com.appsfactory.autoservices.model;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Entity
@Data
public class AutoTypeFactor {

    @Id
    Integer id;

    String carName;

    String status;

    Double factor;

    public AutoTypeFactor() {

    }
}
