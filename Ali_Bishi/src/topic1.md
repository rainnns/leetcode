阿里Java笔试题1
给n张牌，每张牌有对应的数值，每次抽牌堆顶上的一张，如果这张牌是在其他剩余牌中最小的，把这张牌拿出，否则，把牌放到牌堆底，这两者都视为一次操作，求几次操作可以把牌抽完。
 1<=n<= 10 ^5
1=<a[i]<= 10 ^ 5（牌的数值）

例：
    输入：
        4
        6 4 1 2
    输出：
        7