public enum MagicSchool{
    WITCHCRAFT("\u001B[35m"),
    ORDER("\u001B[34m"),
    NATURE("\u001B[32m");

    private final String colorCode;
    public static final String RESET_CODE="\u001B[0m";

    MagicSchool(String colorCode){
        this.colorCode=colorCode;
    }
    public String getColorCode() {
        return colorCode;
    }
}