package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.apiPayload.ApiResponse;
import umc.coverter.ReviewConverter;
import umc.domain.Review;
import umc.service.ReviewService.ReviewCommandService;
import umc.web.dto.ReviewRequestDTO;
import umc.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping
    public ApiResponse<ReviewResponseDTO.createReviewResultDTO> createReview(@RequestBody @Valid ReviewRequestDTO.createReviewDto request) {
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}

