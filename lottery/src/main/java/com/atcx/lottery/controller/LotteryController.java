package com.atcx.lottery.controller;


import com.atcx.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    // 抽奖接口
    @GetMapping("/draw")
    public String drawPrize() {
        return lotteryService.drawPrize();
    }

    // 检查奖池是否为空
    @GetMapping("/isEmpty")
    public boolean isPrizePoolEmpty() {
        return lotteryService.isPrizePoolEmpty();
    }
    @GetMapping("/prizes/remaining")
    public Map<String, Integer> getRemainingPrizes() {
        Map<String, Integer> remainingPrizes = new HashMap<>();
        remainingPrizes.put("firstPrize", lotteryService.getRemainingFirstPrize());
        remainingPrizes.put("secondPrize", lotteryService.getRemainingSecondPrize());
        remainingPrizes.put("thirdPrize", lotteryService.getRemainingThirdPrize());
        remainingPrizes.put("consolationPrize", lotteryService.getRemainingConsolationPrize());
        return remainingPrizes;
    }

}
