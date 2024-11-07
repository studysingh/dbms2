package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.Referrals;
import com.studysingh.AlumniApp.service.ReferralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/referrals")
public class ReferralsController {

    @Autowired
    private ReferralsService referralsService;

    @GetMapping
    public List<Referrals> getAllReferrals() {
        return referralsService.getAllReferrals();
    }

    @GetMapping("/{referralId}")
    public Referrals getReferralById(@PathVariable int referralId) {
        return referralsService.getReferralById(referralId);
    }

    @PostMapping
    public void addReferral(@RequestBody Referrals referrals) {
        referralsService.addReferral(referrals);
    }

    @PutMapping("/{referralId}")
    public void updateReferral(@PathVariable int referralId, @RequestBody Referrals referrals) {
        referrals.setReferralId(referralId);
        referralsService.updateReferral(referrals);
    }

    @DeleteMapping("/{referralId}")
    public void deleteReferral(@PathVariable int referralId) {
        referralsService.deleteReferral(referralId);
    }
}
