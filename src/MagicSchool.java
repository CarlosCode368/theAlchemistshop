public enum MagicSchool{
    WITCHCRAFT("\u001B[35m"),
    ORDER("\u001B[34m"),
    NATURE("\u001B[32m");

    private final String colorCode;

    MagicSchool(String colorCode){
        this.colorCode=colorCode;
    }
    public String getColorCode() {
        return colorCode;
    }
}