package umc.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.validation.annotation.ExistStore;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class createMissionDTO{
        @ExistStore
        Long storeId;
        int reward;
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }
}
