package org.dawneye.xjrobot.unit;

import java.util.Date;

/**
 * Created by sandman on 14-3-11.
 */
public class GameScene {
    public static void main(String[] args){
        GameClient gameClient = new GameClient();
        GamePlayer gamePlayer = new GamePlayer();
        // 初始化GameClient
        gameClient.init();
        // 进入登录界面
        // GamePlayer输入登录信息
        gameClient.login(gamePlayer.sayLoginInfo());
        // GameClient进入游戏区选择界面
        // GamePlayer选择游戏区
        gameClient.choseRegin(gamePlayer.choseRegin());
        // GameClient初始化游戏资源
        do{
        // GameClient进入游戏状态等待接收指令
        // GamePlayer发送游戏指令
            gamePlayer.sayPlayGamesCMD();
            gameClient.bePlayed();
            System.out.println(new Date().getTime());
        }while (gamePlayer.sayExit());
        // GamePlayer发送退出指令
        // GameClient退出
        gameClient.exit();
    }
}
