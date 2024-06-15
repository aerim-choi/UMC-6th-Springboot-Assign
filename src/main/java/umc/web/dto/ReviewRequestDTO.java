package umc.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.validation.annotation.ExistStore;

public class ReviewRequestDTO {
    @Getter
    public static class createReviewDto{
        Long memberId;
        @ExistStore
        Long storeId;
        @NotBlank
        String body;
        @Min(1) @Max(5)
        int score;
    }
}
