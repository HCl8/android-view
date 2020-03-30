public class message {
    public String iv_avaPath;
    public boolean robot_notice;
    public String tv_tittle;
    public String tv_desc;
    public String tv_time;

    message(String isOfficial,String icon,String hashTag,String tittle,String time){
        robot_notice = isOfficial.equals("true");
        switch (icon)
        {
            case "TYPE_GAME":
                iv_avaPath = "drawable-xxhdpi/icon_micro_game_comment.png";
                break;
            case "TYPE_ROBOT":
                iv_avaPath = "drawable-xxhdpi/session_robot.png";
                break;
            case "TYPE_SYSTEM":
                iv_avaPath = "drawable-xxhdpi/session_system_notice.png";
                break;
            case "TYPE_STRANGER":
                iv_avaPath = "drawable-xxhdpi/session_stranger.png";
            case "TYPE_USER":
                iv_avaPath = "drawable-xxhdpi/icon_girl.png";
                break;
        }
        tv_desc = hashTag;
        tv_tittle = tittle;
        tv_time = time;
    }
}
