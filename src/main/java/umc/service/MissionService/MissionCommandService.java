package umc.service.MissionService;

import umc.domain.Mission;
import umc.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission createMission(MissionRequestDTO.createMissionDTO request);
}
