package umc.service.MemberMission;

import umc.domain.mapping.MemberMission;
import umc.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission createMemberMission(MemberMissionRequestDTO.createMemberMissionDTO request);
    public boolean isProgressMemberMission(Long memberId, Long missionId);
}
