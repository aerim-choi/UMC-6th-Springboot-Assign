package umc.coverter;

import umc.domain.Mission;
import umc.domain.Store;
import umc.web.dto.MissionRequestDTO;
import umc.web.dto.MissionResponseDTO;

import java.time.LocalDate;

public class MissionConverter {
    public static MissionResponseDTO.createMissionResultDTO toMissionResultDTO(Mission mission) {
        return MissionResponseDTO.createMissionResultDTO.builder()
                .missionId(mission.getId())
                .createAt(LocalDate.now())
                .build();

    }
    public static Mission toMission(MissionRequestDTO.createMissionDTO request, Store store){
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }
}
