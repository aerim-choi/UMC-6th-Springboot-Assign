package umc.service.StoreService;


import org.springframework.data.domain.Page;
import umc.domain.Review;
import umc.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
