package ms.kreations.researchnranking.model;

public class ModelDashboard {
    private String tileName;
    private String tileImage;
    private String tileDesc;

    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public String getTileImage() {
        return tileImage;
    }

    public void setTileImage(String tileImage) {
        this.tileImage = tileImage;
    }

    public String getTileDesc() {
        return tileDesc;
    }

    public void setTileDesc(String tileDesc) {
        this.tileDesc = tileDesc;
    }

    public ModelDashboard(String tileName, String tileImage, String tileDesc) {
        this.tileName=tileName;
        this.tileImage=tileImage;
        this.tileDesc=tileDesc;

    }
}
