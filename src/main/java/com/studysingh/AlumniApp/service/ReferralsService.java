package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Referrals;
import com.studysingh.AlumniApp.repository.ReferralsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferralsService {

    @Autowired
    private ReferralsRepository referralsRepository;

    public List<Referrals> getAllReferrals() {
        return referralsRepository.findAll();
    }

    public Referrals getReferralById(int referralId) {
        return referralsRepository.findById(referralId);
    }

    public void addReferral(Referrals referrals) {
        referralsRepository.save(referrals);
    }

    public void updateReferral(Referrals referrals) {
        referralsRepository.update(referrals);
    }

    public void deleteReferral(int referralId) {
        referralsRepository.deleteById(referralId);
    }
}
