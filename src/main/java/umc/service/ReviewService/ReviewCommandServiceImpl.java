package umc.service.ReviewService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.StoreHandler;
import umc.coverter.ReviewConverter;
import umc.domain.Member;
import umc.domain.Review;
import umc.domain.Store;
import umc.repository.MemberRepository;
import umc.repository.ReviewRepository;
import umc.repository.StoreRepository;
import umc.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.createReviewDto request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Review newReview = ReviewConverter.toReview(request, member, store);

        return reviewRepository.save(newReview);
    }
}
