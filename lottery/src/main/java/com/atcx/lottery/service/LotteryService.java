package com.atcx.lottery.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;




@Service
public class LotteryService {

    private List<String> prizePool = new ArrayList<>();

    // 构造函数：初始化奖池
    public LotteryService() {
        // 一等奖 2 个
        prizePool.addAll(Collections.nCopies(2, "一等奖"));
        // 二等奖 10 个
        prizePool.addAll(Collections.nCopies(10, "二等奖"));
        // 三等奖 40 个
        prizePool.addAll(Collections.nCopies(40, "三等奖"));
        // 纪念奖 200 个
        prizePool.addAll(Collections.nCopies(200, "纪念奖"));

        // 将奖池打乱，确保抽奖时顺序随机
        Collections.shuffle(prizePool);
    }

    // 抽奖方法
    public String drawPrize() {
        if (!prizePool.isEmpty()) {
            // 随机抽取奖品
            return prizePool.remove(0);  // 抽中一个奖品后从奖池中移除
        } else {
            return "奖池已空";
        }
    }

    // 判断奖池是否为空
    public boolean isPrizePoolEmpty() {
        return prizePool.isEmpty();
    }

    // 获取各类奖品剩余数量
    public int getRemainingFirstPrize() {
        return (int) prizePool.stream().filter(prize -> prize.equals("一等奖")).count();
    }

    public int getRemainingSecondPrize() {
        return (int) prizePool.stream().filter(prize -> prize.equals("二等奖")).count();
    }

    public int getRemainingThirdPrize() {
        return (int) prizePool.stream().filter(prize -> prize.equals("三等奖")).count();
    }

    public int getRemainingConsolationPrize() {
        return (int) prizePool.stream().filter(prize -> prize.equals("纪念奖")).count();
    }
}
