package com.m2018.may;

import java.util.*;

/**
 * for 郑力
 * Create by A-mdx at 2018-05-24 22:23
 */
public class PokerGame {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------- 开始游戏 --------------");
        List<Poker> pokerList = initPoker();
        List<Player> playerList = new ArrayList<>();
        System.out.println("--------------- 开始添加游戏角色 --------------------");
        do {
            System.out.println("输入玩家姓名（若想结束输入，再次回车）：");
            String name = scanner.nextLine();
            if (name == null || name.equals("")) {
                if (playerList.size() > 1) {
                    break;
                }
                System.out.println("玩家人数不够，请继续输入。");
                continue;
            }
            Player player = new Player(name);
            playerList.add(player);
        } while (playerList.size() < 27);

        // 发牌
        System.out.println("玩家手牌分别为：");
        int pokerIndex = 0;
        for (Player player : playerList) {
            player.setPokerList(Arrays.asList(pokerList.remove(pokerIndex++), pokerList.remove(pokerIndex++)));
            System.out.println("当前玩家：" + player);
        }

        // 比较 
        Player bigPlayer = playerList.get(0);
        for (int i = 1; i < playerList.size(); i++) {
            Player nowPlayer = playerList.get(i);
            if (bigPlayer.compareTo(nowPlayer) < 0) {
                // 说明小于
                bigPlayer = nowPlayer;
            }
        }
        // 上面的比较，因为实现了 比较器接口，还可以这样, 一步到位
//        Collections.sort(playerList);
//        bigPlayer = playerList.get(playerList.size()-1);

        System.out.println("获胜的玩家是：" + bigPlayer);
        System.out.println(String.format("获胜的玩家是：%s, 其id是 %d, 其手牌是 %s", bigPlayer.getName(), bigPlayer.getId(), bigPlayer.getPokerList()));

    }

    private static List<Poker> initPoker() {
        List<Poker> list = new ArrayList<>();
        List<String> num = new ArrayList<>();
        num.add("A");
        for (int i = 2; i < 11; i++) {
            num.add(i + "");
        }
        num.addAll(Arrays.asList("J", "Q", "K"));
        for (int i = 0; i < num.size(); i++) {
            for (HuaSe huaSe : HuaSe.values()) {
                Poker poker = new Poker();
                poker.setHuaSe(huaSe);
                poker.setNum(num.get(i));
                poker.setSize(i);
                list.add(poker);
            }
        }

        Collections.shuffle(list);
        return list;
    }

    private static class Player implements Comparable<Player> {
        // 自增id
        private static int ID_Gen = 1;
        private int id;
        private String name;
        private List<Poker> pokerList;

        @Override
        public int compareTo(Player o) {
            // 实现了比较方法，因此可以直接按照 数字花色排序 ，从小到大
            Collections.sort(pokerList);
            Poker thisPoker = pokerList.get(1);

            Collections.sort(o.getPokerList());
            Poker otherPoker = o.getPokerList().get(1);
            // 直接比较最大的
            return thisPoker.compareTo(otherPoker);
        }

        @Override
        public String toString() {
            return "Player{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", pokerList=" + pokerList +
                    '}';
        }

        private Player(String name) {
            this.name = name;
            this.id = ID_Gen++;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Poker> getPokerList() {
            return pokerList;
        }

        public void setPokerList(List<Poker> pokerList) {
            this.pokerList = pokerList;
        }

    }

    private static class Poker implements Comparable<Poker> {
        private HuaSe huaSe;
        private String Num;
        private int size;

        @Override
        public String toString() {
            return huaSe + Num;
        }

        public PokerGame.HuaSe getHuaSe() {
            return huaSe;
        }

        public void setHuaSe(PokerGame.HuaSe huaSe) {
            this.huaSe = huaSe;
        }

        public String getNum() {
            return Num;
        }

        public void setNum(String num) {
            Num = num;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(Poker o) {
            if (o.getSize() > size) {
                return -1;
            } else if (o.getSize() < size) {
                return 1;
            } else {
                // 相同数字，比较花色
                if (o.getHuaSe().getNum() > huaSe.getNum()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    // 花色
    private enum HuaSe {
        方片(0), 梅花(1), 红桃(2), 黑桃(3);
        private int num;

        HuaSe(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}
