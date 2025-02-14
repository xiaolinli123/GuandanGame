# Guandan
以“掼蛋”玩法为基础的扑克牌发牌程序  

本程序有两种模式：  
1. 普通模式  
2. 训练模式  

进入任一模式后设置级牌，运行程序自动保存所发到的手牌并渲染为 HTML 格式。  

---

### 掼蛋（Guandan）玩法规则 🃏

#### 1. 基本规则

- **人数**：4 人，分为两队，对家为队友。  
- **牌数**：使用两副扑克牌，共 108 张（包括大小王）。  
- **目标**：先出完手中所有牌，帮助搭档尽快清空手牌，赢得比赛。

---

#### 2. 牌型规则

掼蛋的牌型丰富，主要包括以下几种：

1. **单牌**：任意一张单独的牌。  
2. **对子**：两张点数相同的牌。  
3. **连对**：三对或以上连续点数的对子（如 33 44 55）。  
4. **三带一 / 三带二**：三张相同点数的牌，带一张或两张单牌 / 对子。  
5. **顺子（拖拉机）**：五张或以上连续点数的单牌（如 4 5 6 7 8）。  
6. **飞机带翅膀**：两个或以上连续的三张牌，带同数量的单牌或对子。  
7. **炸弹**：  
   - **普通炸弹**：四张或以上相同点数的牌（如 5 5 5 5）。  
   - **王炸**：四个大小王（最强炸弹）。

---

#### 3. 出牌规则

- **顺序**：逆时针方向轮流出牌，首轮由庄家或上局赢家先出牌。  
- **跟牌**：后手必须出相同牌型且更大的牌，否则选择“不要”。  
- **炸弹可炸任意牌型**，炸弹之间可以互相炸，牌数越多的炸弹越大。  
- **王炸最大**，无法被其他炸弹炸掉。

---

#### 4. 比赛机制

- **等级制度**：与“升级”类似，每局获胜提升一等级，等级从 2 开始，逐步晋升到 A、K、Q... 直至打完一轮。  
- **升级条件**：一方队伍的两名队员分别获得头游和二游，才能升级。  
- **逢人配**：若一方一局中两人同时出完牌（包揽前两名），称为“逢人配”，直接晋级。




