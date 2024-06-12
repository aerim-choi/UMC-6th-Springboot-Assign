package umc.service.MemberSevice;

import umc.domain.Member;
import umc.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
