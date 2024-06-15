package umc.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.StoreHandler;
import umc.coverter.MissionConverter;
import umc.domain.Mission;
import umc.domain.Store;
import umc.repository.MissionRepository;
import umc.repository.StoreRepository;
import umc.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements  MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.createMissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission newMission = MissionConverter.toMission(request,store);

        return missionRepository.save(newMission);
    }
}
