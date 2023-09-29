public abstract class MobilePhone {
    private MusicPlayer musicPlayer;
    private WebBrowser webBrowser;

    public MobilePhone() {
        this.musicPlayer = new MusicPlayer();
        this.webBrowser = new WebBrowser();
    }

    public void makeCall(String number) {
        System.out.println("Calling." + number + "..");
    }

    public void answerPhoneCall() {
        System.out.println("Answering phone call...");
    }

    public void startVoiceMail() {
        System.out.println("Starting voice mail...");
    }

    public void openWebPage(String pageUrl) {
        this.webBrowser.showPage(pageUrl);
    }

    public void openNewWebBrowserTab() {
        this.webBrowser.addNewTab();
    }

    public void reloadWebPage() {
        this.webBrowser.updatePage();
    }

    public void selectMusic(int musicId) {
        this.musicPlayer.selectMusic(musicId);
    }

    public void playMusic() {
        this.musicPlayer.play();
    }

    public void pauseMusic() {
        this.musicPlayer.pause();
    }
}
