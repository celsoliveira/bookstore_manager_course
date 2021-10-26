package com.intro.springboot.bookstoremanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    private Integer age;
}
