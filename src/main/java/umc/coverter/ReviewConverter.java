package umc.coverter;

import umc.domain.Member;
import umc.domain.Review;
import umc.domain.Store;
import umc.repository.MemberRepository;
import umc.repository.StoreRepository;
import umc.web.dto.ReviewRequestDTO;
import umc.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.createReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.createReviewResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.createReviewDto request, Member member, Store store){
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
