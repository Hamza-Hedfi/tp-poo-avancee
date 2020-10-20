package com.deuterium.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public abstract class SuperEntity {

    protected UUID id;
    protected String description;
    protected String label;

    {
        id = UUID.randomUUID();
        description = "";
        label = "";
    }

}
