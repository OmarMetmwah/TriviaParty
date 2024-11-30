package com.metmwah.triviaparty.feature.game.entity;


import com.metmwah.triviaparty.core.entity.HasIntId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Game extends HasIntId {

}
