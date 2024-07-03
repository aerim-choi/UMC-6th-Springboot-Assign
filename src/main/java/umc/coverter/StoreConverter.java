package umc.coverter;

import org.springframework.data.domain.Page;
import umc.domain.Review;
import umc.web.dto.ReviewRequestDTO;
import umc.web.dto.ReviewResponseDTO;
import umc.web.dto.StoreRequestDTO;
import umc.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static Review toReview(ReviewRequestDTO.createReviewDto request){
        return Review.builder()
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }
    public static ReviewResponseDTO.createReviewResultDTO toCreateReviewResponseDTO(Review review){
        return ReviewResponseDTO.createReviewResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();




    }
}
