package umc.service.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.MemberMissionHandler;
import umc.apiPayload.exception.handler.MissionHandler;
import umc.coverter.MemberMissionConverter;
import umc.coverter.MissionConverter;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.repository.MemberRepository;
import umc.repository.MissionRepository;
import umc.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public boolean isProgressMemberMission(Long memberId, Long missionId) {
        return memberMissionRepository.findAll().stream()
                .filter(memberMission -> memberMission.getMission().getId().equals(missionId) &&
                        memberMission.getStatus() == MissionStatus.PROGRESS &&
                        memberMission.getMember().getId().equals(memberId))
                .findFirst()
                .isEmpty();
    }

    @Override
    @Transactional
    public MemberMission createMemberMission(MemberMissionRequestDTO.createMemberMissionDTO request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request,member,mission);
        return memberMissionRepository.save(newMemberMission);
    }
}
