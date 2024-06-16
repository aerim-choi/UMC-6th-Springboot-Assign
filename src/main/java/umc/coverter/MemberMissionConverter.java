package umc.coverter;

import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.web.dto.MemberMissionRequestDTO;
import umc.web.dto.MemberMissionResponseDTO;

import java.time.LocalDate;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.createMemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.createMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createAt(LocalDate.now())
                .build();
    }
    public static MemberMission toMemberMission(MemberMissionRequestDTO.createMemberMissionDTO request, Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
