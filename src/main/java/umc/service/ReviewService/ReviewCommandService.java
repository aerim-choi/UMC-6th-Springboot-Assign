package umc.service.ReviewService;

import umc.domain.Review;
import umc.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review createReview(ReviewRequestDTO.createReviewDto request);
}
