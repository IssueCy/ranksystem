package de.merix.ranksystem.storage;


public enum Rank {

    ADMIN("§8[§cAdmin§8] ", new String[]{"perms.admin"}),
    SRDEV("§8[§bSrDev§8] ", new String[]{"perms.srdev"}),
    DEV("§8[§bDev§8] ", new String[]{"perms.dev"}),
    MOD("§8[§2Mod§8] ", new String[]{"perms.mod"}),
    CONTENT("§8[§eCon§8] ", new String[]{"perms.con"}),
    TTEAM("§8[§aT-Team§8] ", new String[]{"perms.tteam"}),
    MEMBER("§8[§7Member§8] ", new String[]{});

    private String prefix;
    private String[] permissions;

    Rank(String prefix, String[] permissions) {
        this.prefix = prefix;
        this.permissions = permissions;
    }

    public String getPrefix(){
        return prefix;
    }

    public String[] getPermissions() { return permissions; }

}
