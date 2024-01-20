package org.example.costbudgeting.entities;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Client}
 */
@Value
public class ClientDto implements Serializable {
    Long id;
    String name;
    String email;
    String phone;
    Address address;
}