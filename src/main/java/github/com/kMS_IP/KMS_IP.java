package github.com.kMS_IP;

import org.bukkit.plugin.java.JavaPlugin;

public final class KMS_IP extends JavaPlugin {
    private static KMS_IP Instance;

    /*===投票関連===*/
    private VoteManager voteManager;
    private VoteDisplayManager displayManager;
    private VoteNotificationManager notificationManager;
    private VoteTimerManager timerManager;

    @Override
    public  void onEnable() {
        instance = this;


        //設定ファイルの保存
        saveDefaultConfig();

        //各管理クラスの初期化
        initializeManagers();

        //イベントリスナーの登録
        registerEvents();

    }

    @Override
    public void onDisable() {

        //アクティブな投票の保存
        if (voteManager != null) {
            voteManager.saveActiveVotes();
        }

    }
}