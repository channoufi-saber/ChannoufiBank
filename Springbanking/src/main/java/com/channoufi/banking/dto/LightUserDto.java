package com.channoufi.banking.dto;

import com.channoufi.banking.models.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class LightUserDto {

  private Integer id;

  @NotNull(message = "Le prenom ne doit pas etre vide")
  @NotEmpty(message = "Le prenom ne doit pas etre vide")
  @NotBlank(message = "Le prenom ne doit pas etre vide")
  private String firstname;

  @NotNull(message = "Le nom ne doit pas etre vide")
  @NotEmpty(message = "Le nom ne doit pas etre vide")
  @NotBlank(message = "Le nom ne doit pas etre vide")
  private String lastname;

  public static LightUserDto fromEntity(User user) {
    return LightUserDto.builder()
        .id(user.getId())
        .firstname(user.getFirstname())
        .lastname(user.getLastname())
        .build();
  }

  public static User toEntity(LightUserDto user) {
    return User.builder()
        .id(user.getId())
        .firstname(user.getFirstname())
        .lastname(user.getLastname())
        .build();
  }

}