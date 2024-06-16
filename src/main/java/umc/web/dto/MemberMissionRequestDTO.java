package umc.web.dto;

import lombok.Getter;
import umc.validation.annotation.ProgressMemberMission;

public class MemberMissionRequestDTO {

    @Getter
    @ProgressMemberMission
    public static class createMemberMissionDTO{
        Long memberId;
        Long missionId;
    }
}
