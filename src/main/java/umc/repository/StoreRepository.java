package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Review;
import umc.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
